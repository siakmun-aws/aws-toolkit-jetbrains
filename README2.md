# AWS Toolkit for JetBrains — Repository Summary

## Project Overview

**AWS Toolkit for JetBrains** is an open-source plugin suite for JetBrains IDEs that simplifies building applications on [Amazon Web Services](https://aws.amazon.com/). It supports all JetBrains IDEs version 2023.3 and above, including IntelliJ IDEA (Community and Ultimate), PyCharm, Rider, WebStorm, and JetBrains Gateway.

The project is structured as a Gradle multi-project monorepo that emits multiple discrete plugin artifacts — allowing independent teams to develop, test, and release individual plugin modules from a single codebase. All new code is written in Kotlin, and the project is licensed under the [Apache License 2.0](LICENSE).

## Key Features and Plugin Modules

The repository produces three primary plugin distribution artifacts plus supporting modules:

### plugin-core (`plugins/core/`)

The foundational shared plugin that all other plugins depend on at runtime. It provides:

- **AWS Resource Explorer** — A tree-view of AWS resources in the selected account and region.
- **Authentication** — Connectivity via static credentials, credential process, AWS Builder ID, or AWS IAM Identity Center (SSO).
- **SDK Code Generation** — Auto-generated AWS SDK clients from service model definitions (e.g., CodeWhisperer, CodeWhisperer Runtime, CodeWhisperer Streaming, Telemetry).
- **Webview Framework** — A TypeScript/Webpack-based webview layer for rendering rich UI components within the IDE.
- **Telemetry** — Built-in telemetry generation and reporting infrastructure.

### plugin-toolkit (`plugins/toolkit/`)

The traditional AWS Toolkit plugin providing AWS service integrations:

- **AWS Lambda** — Run/debug local Lambda functions (via SAM CLI), invoke remote Lambda functions, and package and deploy Lambda functions. Supports Java, Python, Node.js, and .NET Core.
- **AWS CloudFormation** — View stack events, resources, and outputs.
- **Amazon CloudWatch Logs** — View and search log streams.
- **Amazon S3** — Browse, upload, and download from S3 buckets.
- **Amazon RDS / Redshift** — Connect to databases using temporary IAM/Secrets Manager credentials.
- **AWS SAM (Serverless Application Model)** — Sync and track SAM-based applications.
- **Amazon DynamoDB, Amazon SQS, Amazon SNS, AWS App Runner, Amazon EC2, AWS Secrets Manager, Amazon EventBridge Schemas** — Additional service integrations.
- **JetBrains Gateway** — Remote development support via JetBrains Gateway and Amazon CodeCatalyst Dev Environments.
- **Rider (.NET) Support** — Dedicated integration with JetBrains Rider and ReSharper for .NET AWS development.

### plugin-amazonq (`plugins/amazonq/`)

The Amazon Q plugin providing AI-powered developer tools:

- **Amazon Q Chat** (`chat/`) — An AI-powered conversational assistant integrated directly into the IDE through the Mynah UI chat interface.
- **Amazon CodeWhisperer** (`codewhisperer/`) — AI-powered code suggestions and completions with support for multiple programming languages. Includes community and ultimate IDE variants.
- **Code Transform (Amazon Q Code Transformation)** (`codetransform/`) — Automated code modernization and transformation capabilities (e.g., Java version upgrades).
- **Mynah UI** (`mynah-ui/`) — A TypeScript/Webpack-based chat UI component built on the `@aws/mynah-ui` library, providing the front-end for Amazon Q Chat and related features.
- **Shared** (`shared/`) — Common code and utilities shared across all Amazon Q sub-modules.

### Additional Modules

| Module | Path | Description |
|---|---|---|
| `buildSrc` | `buildSrc/` | Encapsulated Gradle build logic with custom convention plugins (e.g., `toolkit-kotlin-conventions`, `toolkit-testing`, `toolkit-intellij-subplugin`, `toolkit-publishing-conventions`). |
| `detekt-rules` | `detekt-rules/` | Custom [detekt](https://github.com/detekt/detekt) static analysis rules and configuration for the entire repository. |
| `ui-tests` | `ui-tests/` | End-to-end UI tests using the IntelliJ Remote Robot framework. |
| `ui-tests-starter` | `ui-tests-starter/` | UI test bootstrapping module (available for IDE versions 2024.2+). |
| `sandbox-all` | `sandbox-all/` | A convenience module for running all plugins together in a sandbox IDE instance. |
| `designs` | `designs/` | Design documents covering features like CloudWatch integration, credential management, error messaging, executable management, and resource caching. |

## Technology Stack

### Primary Languages

- **Kotlin** — The primary language for all plugin logic. Java usage is discouraged; all new code must be written in Kotlin following the official [Kotlin coding conventions](https://kotlinlang.org/docs/coding-conventions.html).
- **TypeScript** — Used for webview UI components (`plugins/core/webview/` and `plugins/amazonq/mynah-ui/`), bundled via Webpack.

### Build System

- **Gradle 8.10** — Multi-project build using Kotlin DSL (`build.gradle.kts`).
- **JetBrains IntelliJ Platform Gradle Plugin 2.2.1** — For building, packaging, and testing IntelliJ-based plugins.
- **Gradle Version Catalog** (`gradle/libs.versions.toml`) — Centralized dependency version management.
- **Custom Convention Plugins** (`buildSrc/`) — Shared build logic including Kotlin conventions, testing configuration, publishing, code instrumentation, and IDE profile management.
- **Java 21** — Required JDK for building the project.

### Key Dependencies

- **AWS SDK for Java v2** (2.26.25) — For all AWS service interactions (S3, Lambda, CloudFormation, DynamoDB, SQS, SNS, EC2, RDS, Redshift, etc.).
- **Kotlin 2.0.0** with Kotlin Coroutines 1.8.0 — For async and concurrent operations.
- **Jackson 2.17.2** — JSON/XML/YAML serialization.
- **JGit** — Git operations support.
- **Apache SSHD** — SSH connectivity for remote development features.
- **Webpack** — Bundling TypeScript webview assets.
- **.NET 6 / ReSharper SDK** — For Rider-specific plugin functionality.

### Testing

- **JUnit 5** (5.11.0) — Primary test framework.
- **MockK** / **Mockito** — Mocking frameworks for Kotlin and Java.
- **AssertJ** — Fluent assertions.
- **WireMock** — HTTP service stubbing for integration tests.
- **IntelliJ Remote Robot** (0.11.22) — UI test automation framework.
- **JaCoCo** — Code coverage reporting.

### Code Quality

- **detekt** (1.23.7) — Kotlin static analysis with custom project-specific rules.
- **Codecov** — Coverage reporting integration.
- **SonarCloud** — Continuous code quality inspection.

## Repository Structure Overview

```
aws-toolkit-jetbrains/
├── build.gradle.kts                 # Root build file with aggregation tasks
├── settings.gradle.kts              # Gradle settings with dynamic subproject discovery
├── gradle.properties                # Toolkit version, IDE profile, Gradle settings
├── gradle/
│   ├── libs.versions.toml           # Centralized dependency version catalog
│   └── wrapper/                     # Gradle wrapper (v8.10)
│
├── buildSrc/                        # Custom Gradle convention plugins
│   └── src/main/kotlin/             # toolkit-*, publishing, testing conventions
│
├── plugins/
│   ├── core/                        # :plugin-core — Shared foundation plugin
│   │   ├── core/                    # Core utilities and abstractions
│   │   ├── jetbrains-community/     # Community IDE platform code
│   │   ├── jetbrains-ultimate/      # Ultimate IDE platform code
│   │   ├── resources/               # Shared resources (icons, configs)
│   │   ├── sdk-codegen/             # AWS SDK client code generation
│   │   └── webview/                 # TypeScript webview components
│   │
│   ├── toolkit/                     # :plugin-toolkit — AWS service integrations
│   │   ├── intellij-standalone/     # Standalone IntelliJ distribution config
│   │   ├── jetbrains-core/          # Main toolkit feature code (Lambda, S3, etc.)
│   │   ├── jetbrains-ultimate/      # Ultimate-only features (e.g., database tools)
│   │   ├── jetbrains-rider/         # Rider/.NET specific integration
│   │   └── jetbrains-gateway/       # JetBrains Gateway remote dev support
│   │
│   └── amazonq/                     # :plugin-amazonq — Amazon Q AI features
│       ├── chat/                    # Amazon Q Chat interface
│       ├── codewhisperer/           # AI code completion (CodeWhisperer)
│       ├── codetransform/           # Code modernization/transformation
│       ├── mynah-ui/                # TypeScript chat UI (Mynah UI)
│       └── shared/                  # Shared Amazon Q utilities
│
├── detekt-rules/                    # Custom static analysis rules
├── ui-tests/                        # End-to-end UI tests
├── ui-tests-starter/                # UI test bootstrapping (2024.2+)
├── sandbox-all/                     # Run all plugins in sandbox IDE
├── designs/                         # Feature design documents
├── testdata/                        # Shared test data
├── buildspec/                       # CI/CD build specifications
├── CHANGELOG.md                     # Release changelog
├── CONTRIBUTING.md                  # Contribution guidelines
├── REPOLAYOUT.md                    # Detailed repository layout documentation
└── LICENSE                          # Apache License 2.0
```

### IDE Platform Sourceset Convention

Sub-projects are further segmented by IDE platform tier to ensure correct dependency scoping at compile time:

- **`community/`** or **`jetbrains-community/`** — Code targeting free/community JetBrains IDEs.
- **`ultimate/`** or **`jetbrains-ultimate/`** — Code targeting paid/ultimate JetBrains IDEs (superset of community).
- **`rider/`** or **`jetbrains-rider/`** — Code targeting JetBrains Rider (.NET IDE).

Version-specific source directories (e.g., `src-241+`, `src-241-242`, `src-243+`) enable conditional compilation across multiple IDE major versions where platform APIs differ.
