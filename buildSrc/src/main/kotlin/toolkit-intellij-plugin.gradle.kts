// Copyright 2024 Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
import org.jetbrains.intellij.platform.gradle.tasks.aware.SandboxAware
import software.aws.toolkits.gradle.ciOnly
import software.aws.toolkits.gradle.intellij.IdeVersions
import software.aws.toolkits.gradle.intellij.ToolkitIntelliJExtension

project.extensions.create<ToolkitIntelliJExtension>("intellijToolkit")

plugins {
    id("org.jetbrains.intellij.platform.module")
}

intellijPlatform {
    instrumentCode = false
}

// Eagerly resolve the IDE version at configuration time to ensure the IntelliJ Platform
// dependency is properly declared for static analysis tools like Qodana.
// Using .get() resolves immediately during configuration phase rather than deferring resolution.
val ideVersionForModule: String = IdeVersions.ideProfile(providers).get().community.sdkVersion

dependencies {
    intellijPlatform {
        // IntelliJ Platform dependency must be declared first before instrumentationTools()
        // to satisfy the plugin's dependency resolution requirements.
        // Default IntelliJ Platform dependency required by the intellij-platform-gradle-plugin
        // for proper project import and static analysis tools like Qodana.
        // Subprojects may override this with a more specific dependency via create() or similar.
        intellijIdeaCommunity(ideVersionForModule, useInstaller = false)
        instrumentationTools()
    }
}

// CI keeps running out of RAM, so limit IDE instance count to 4
ciOnly {
    abstract class NoopBuildService : BuildService<BuildServiceParameters.None> {}
    val noopService = gradle.sharedServices.registerIfAbsent("noopService", NoopBuildService::class.java) {
        maxParallelUsages = 2
    }

    tasks.matching { it is Test || it is SandboxAware }.configureEach {
        usesService(noopService)
    }
}
