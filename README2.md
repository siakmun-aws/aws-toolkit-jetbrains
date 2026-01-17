# AWS Toolkit for JetBrains - Repository Summary

## Overview

AWS Toolkit for JetBrains is an open-source plugin for JetBrains IDEs that simplifies building applications on [Amazon Web Services](https://aws.amazon.com/). The toolkit provides seamless integration with AWS services, enabling developers to interact with AWS resources directly from their IDE.

Key capabilities include:
- **AWS Resource Explorer** - Browse and manage AWS resources within the IDE
- **Authentication** - Connect using static credentials, credential process, AWS Builder ID, or AWS SSO
- **AWS Lambda** - Run, debug, and deploy Lambda functions locally and remotely
- **CloudFormation** - View stack events, resources, and outputs
- **CloudWatch Logs** - View and search log streams
- **Amazon S3** - Manage buckets and upload/download files
- **Amazon RDS/Redshift** - Connect to databases using temporary credentials

The toolkit supports all JetBrains IDEs version 2023.3 and above.

## Main Technologies

### Primary Languages
- **Kotlin** - Primary development language for the plugin codebase (version 2.0.0)
- **TypeScript** - Used for the mynah-ui chat interface component

### Build & Tooling
- **Gradle** - Build system with multi-project configuration
- **JetBrains IntelliJ Platform Gradle Plugin** - For plugin development
- **Webpack** - Bundling TypeScript/UI assets
- **Node.js** - For frontend asset compilation

### Key Dependencies
- **AWS SDK for Java v2** (2.26.25) - AWS service integrations
- **Kotlin Coroutines** (1.8.0) - Asynchronous programming
- **Jackson** - JSON/XML/YAML serialization
- **JUnit 5** - Testing framework
- **Detekt** - Kotlin static analysis

## Key Plugins

The repository produces three main plugin artifacts:

### 1. Core (`plugin-core`)
The foundational plugin providing shared functionality:
- SDK code generation
- Common utilities and resources
- JetBrains platform integrations (community, ultimate, rider)
- Webview components

### 2. Toolkit (`plugin-toolkit`)
The main AWS Toolkit plugin providing:
- AWS service integrations (Lambda, S3, CloudFormation, etc.)
- Resource explorer functionality
- Authentication and credential management
- Support for IntelliJ standalone, JetBrains Gateway, Ultimate, and Rider editions

### 3. Amazon Q (`plugin-amazonq`)
AI-powered developer assistant features:
- **CodeWhisperer** - AI code suggestions and completions
- **Code Transform** - Automated code modernization
- **Chat** - Interactive AI chat interface
- **Mynah UI** - TypeScript-based chat user interface

## Project Structure

```
aws-toolkit-jetbrains/
├── buildSrc/                 # Gradle build logic and custom plugins
├── detekt-rules/             # Custom Detekt static analysis rules
├── gradle/                   # Gradle wrapper and version catalog
├── plugins/
│   ├── core/                 # Core plugin module
│   │   ├── core/             # Core utilities
│   │   ├── jetbrains-community/  # Community IDE support
│   │   ├── jetbrains-ultimate/   # Ultimate IDE support
│   │   ├── resources/        # Shared resources
│   │   ├── sdk-codegen/      # AWS SDK code generation
│   │   └── webview/          # Webview components
│   │
│   ├── toolkit/              # AWS Toolkit plugin module
│   │   ├── intellij-standalone/  # Standalone IntelliJ build
│   │   ├── jetbrains-core/   # Core toolkit functionality
│   │   ├── jetbrains-gateway/    # JetBrains Gateway support
│   │   ├── jetbrains-rider/  # Rider IDE support
│   │   └── jetbrains-ultimate/   # Ultimate IDE support
│   │
│   └── amazonq/              # Amazon Q plugin module
│       ├── chat/             # Chat functionality
│       ├── codetransform/    # Code transformation features
│       ├── codewhisperer/    # CodeWhisperer AI suggestions
│       ├── mynah-ui/         # TypeScript chat UI
│       └── shared/           # Shared Amazon Q components
│
├── ui-tests/                 # UI test suite
├── ui-tests-starter/         # UI test utilities
├── testdata/                 # Test fixtures and sample projects
├── designs/                  # Design documentation
├── buildspec/                # CI/CD build specifications
└── marketplaceGifs/          # Plugin marketplace assets
```

### Source Code Organization

Each subproject follows a non-standard but consistent directory structure:
- `src/` - Main source code (Kotlin/Java)
- `tst/` - Test source code
- `resources/` - Resource files
- `build.gradle.kts` - Project build configuration

Platform-specific code is organized by IDE edition:
- `community/` - IntelliJ Community and PyCharm Community
- `ultimate/` - Paid JetBrains IDEs
- `rider/` - JetBrains Rider (C#/.NET)
- `gateway/` - JetBrains Gateway (remote development)

Version-specific code uses suffixed directories (e.g., `src-231-232/` for IDE versions 2023.1-2023.2).
