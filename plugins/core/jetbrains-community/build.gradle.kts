// Copyright 2024 Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektCreateBaselineTask
import software.aws.toolkits.gradle.intellij.IdeFlavor
import software.aws.toolkits.telemetry.generator.gradle.GenerateTelemetry

plugins {
    id("java-library")
    id("toolkit-testing")
    id("toolkit-intellij-subplugin")
}

buildscript {
    dependencies {
        classpath(libs.telemetryGenerator)
    }
}

private val generatedSrcDir = project.layout.buildDirectory.dir("generated-src")
sourceSets {
    main {
        java.srcDir(generatedSrcDir)
    }
}

idea {
    module {
        generatedSourceDirs = generatedSourceDirs.toMutableSet() + generatedSrcDir.get().asFile
    }
}

val generateTelemetry = tasks.register<GenerateTelemetry>("generateTelemetry") {
    inputFiles.setFrom(file("${project.projectDir}/resources/telemetryOverride.json"))
    outputDirectory.set(generatedSrcDir)

    doFirst {
        outputDirectory.get().asFile.deleteRecursively()
    }
}

tasks.compileKotlin {
    dependsOn(generateTelemetry)
}

intellijToolkit {
    ideFlavor.set(IdeFlavor.IC)
}

// Note: We intentionally do NOT use extendsFrom(configurations.intellijPlatformTestDependencies.get()) here
// as it causes circular dependency issues with Kotlin's test dependency management during configuration phase.
// This pattern triggers infinite recursion in DefaultConfiguration.initAllDependencies() when the Kotlin plugin's
// maybeAddTestDependencyCapability() tries to resolve the configuration, leading to StackOverflowError.
// See: toolkit-testing.gradle.kts for similar documentation about this pattern.
// Instead, we add the test dependencies explicitly through the intellijPlatform block below.

// intellij java-test-framework pollutes test classpath with extracted java plugins
configurations.testFixturesApi {
    exclude("com.jetbrains.intellij.java", "java")
    exclude("com.jetbrains.intellij.java", "java-impl")
}

dependencies {
    compileOnlyApi(project(":plugin-core:core"))
    compileOnlyApi(libs.aws.apacheClient)
    compileOnlyApi(libs.aws.nettyClient)

    api(libs.aws.iam)

    testFixturesApi(project(path = ":plugin-core:core", configuration = "testArtifacts"))
    testFixturesApi(project(":plugin-core:resources"))
    testFixturesApi(libs.wiremock) {
        // conflicts with transitive inclusion from docker plugin
        exclude(group = "org.apache.httpcomponents.client5")
        // provided by IDE
        exclude(group = "commons-io")
    }

    testImplementation(project(":plugin-core:core"))
    testRuntimeOnly(project(":plugin-core:sdk-codegen"))
}

// fix implicit dependency on generated source
tasks.withType<Detekt>().configureEach {
    dependsOn(generateTelemetry)
}

tasks.withType<DetektCreateBaselineTask>().configureEach {
    dependsOn(generateTelemetry)
}

// hack because our test structure currently doesn't make complete sense
tasks.prepareTestSandbox {
    val pluginXmlJar = project(":plugin-core").tasks.jar

    dependsOn(pluginXmlJar)
    intoChild(intellijPlatform.projectName.map { "$it/lib" })
        .from(pluginXmlJar)
}
