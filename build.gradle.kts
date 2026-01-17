// Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
import org.jetbrains.gradle.ext.ProjectSettings
import org.jetbrains.gradle.ext.TaskTriggersConfig
import software.aws.toolkits.gradle.changelog.tasks.GenerateGithubChangeLog
import software.aws.toolkits.gradle.intellij.IdeVersions

plugins {
    id("base")
    id("toolkit-changelog")
    id("toolkit-git-secrets")
    id("toolkit-jacoco-report")
    id("org.jetbrains.gradle.plugin.idea-ext")
    id("org.jetbrains.intellij.platform.module")
}

// Required by Qodana and other static analysis tools that need an IntelliJ Platform dependency
// to be defined at the root project level for proper project import.
intellijPlatform {
    instrumentCode = false
}

dependencies {
    intellijPlatform {
        instrumentationTools()

        val ideProfile = IdeVersions.ideProfile(providers)
        val version = ideProfile.map { it.community.sdkVersion }
        intellijIdeaCommunity(version, useInstaller = false)
    }
}

/**
 * Determines if a configuration should be skipped from custom dependency resolution.
 * This prevents circular dependency resolution issues with the Kotlin Gradle plugin's
 * internal configurations. The plugin's KotlinDependenciesManagement.allNonProjectDependencies()
 * and maybeAddTestDependencyCapability() iterate over all dependencies during configuration,
 * which can trigger resolution if we're modifying the configuration simultaneously.
 */
fun shouldSkipConfiguration(configName: String): Boolean {
    // Skip detekt configurations
    if (configName.startsWith("detekt")) {
        return true
    }

    // Skip internal Kotlin plugin configurations to avoid circular resolution during
    // KotlinDependenciesManagement.allNonProjectDependencies() calls.
    // These include: kotlinCompilerPluginClasspath*, kotlinScriptDef*, kotlinNative*, etc.
    if (configName.startsWith("kotlin") && !configName.startsWith("kotlinx")) {
        return true
    }

    // Skip IntelliJ platform plugin internal configurations
    if (configName.startsWith("intellijPlatform")) {
        return true
    }

    return false
}

allprojects {
    configurations.configureEach {
        // Skip configurations that should not have our custom resolution strategy applied.
        if (shouldSkipConfiguration(name)) {
            return@configureEach
        }

        resolutionStrategy {
            // need to figure out how to fail only on non-platform dependencies
//            failOnNonReproducibleResolution()
        }
    }
}

val generateChangeLog = tasks.register<GenerateGithubChangeLog>("generateChangeLog") {
    mustRunAfter(tasks.createRelease)
    changeLogFile.set(project.file("CHANGELOG.md"))
}

tasks.createRelease.configure {
    releaseVersion.set(providers.gradleProperty("toolkitVersion"))
}

dependencies {
    aggregateCoverage(project(":plugin-toolkit:intellij-standalone"))
    aggregateCoverage(project(":plugin-core"))
    aggregateCoverage(project(":plugin-amazonq"))

    project.findProject(":plugin-toolkit:jetbrains-gateway")?.let {
        aggregateCoverage(it)
    }

    aggregateCoverage(project(":ui-tests"))
}

tasks.register("runIde") {
    doFirst {
        throw GradleException("Use project specific runIde command, i.e. :plugin-toolkit:intellij-standalone:runIde")
    }
}

if (idea.project != null) { // may be null during script compilation
    idea {
        project {
            settings {
                taskTriggers {
                    afterSync(":plugin-core:sdk-codegen:generateSdks")
                    afterSync(":plugin-core:jetbrains-community:generateTelemetry")
                }
            }
        }
    }
}

fun org.gradle.plugins.ide.idea.model.IdeaProject.settings(configuration: ProjectSettings.() -> Unit) = (this as ExtensionAware).configure(configuration)
fun ProjectSettings.taskTriggers(action: TaskTriggersConfig.() -> Unit, ) = (this as ExtensionAware).extensions.configure("taskTriggers", action)

// is there a better way to do this?
// coverageReport has implicit dependency on 'test' outputs since the task outputs the test.exec file
tasks.coverageReport {
    mustRunAfter(rootProject.subprojects.map { it.tasks.withType<AbstractTestTask>() })
}

allprojects {
    tasks.configureEach {
        if (this is JavaForkOptions) {
            jvmArgs("-XX:ErrorFile=${rootProject.file("build/reports").absolutePath}/hs_err_pid%p.log")
            if (System.getProperty("os.name").contains("Windows")) {
                jvmArgs("-XX:OnError=powershell.exe ${rootProject.file("dump.ps1")}")
            } else {
                jvmArgs("-XX:OnError=ps auxww")
            }
        }
    }
}
