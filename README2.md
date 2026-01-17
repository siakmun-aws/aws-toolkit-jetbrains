# AWS Toolkit for JetBrains - Repository Summary

## Project Overview

The **AWS Toolkit for JetBrains** is an open-source plugin for JetBrains IDEs that makes it easier to develop applications built on [Amazon Web Services (AWS)](https://aws.amazon.com/). This toolkit provides seamless integration between your local development environment and AWS services, enabling developers to build, test, debug, and deploy AWS applications directly from their favorite JetBrains IDE.

### Supported IDEs

All JetBrains IDEs version 2023.3 and later, including:
- IntelliJ IDEA (Community & Ultimate)
- PyCharm (Community & Professional)
- WebStorm
- Rider
- GoLand
- CLion
- JetBrains Gateway

## Main Features and Plugins

This repository produces three main plugin artifacts:

### 1. Core Plugin (`plugin-core`)

The foundational plugin that provides shared functionality across all AWS Toolkit offerings:
- **AWS Resource Explorer** - Tree-view navigation of AWS resources in your selected account/region
- **Authentication** - Support for multiple authentication methods:
  - Static credentials
  - Credential process
  - AWS Builder ID
  - AWS SSO (IAM Identity Center)
- **SDK Code Generation** - Auto-generated AWS SDK client code
- **Webview Components** - Shared UI components for web-based interfaces
- **Telemetry Infrastructure** - Usage metrics and analytics

### 2. Toolkit Plugin (`plugin-toolkit`)

The primary AWS Toolkit plugin providing comprehensive AWS service integrations:

#### AWS Service Integrations
- **AWS Lambda** - Run/debug local Lambda functions, invoke remote functions, package & deploy Lambda functions
- **AWS SAM** - Sync & track SAM-based serverless applications
- **AWS CloudFormation** - View events, resources, and outputs for CloudFormation stacks
- **CloudWatch Logs** - View and search CloudWatch log streams
- **Amazon S3** - View, manage, upload/download from S3 buckets
- **Amazon RDS/Redshift** - Connect to databases using temporary credentials with IAM/SecretsManager
- **Amazon ECS** - Container service integration
- **Amazon ECR** - Container registry integration
- **AWS App Runner** - Application deployment service integration
- **CodeCatalyst** - Amazon CodeCatalyst integration

#### IDE-Specific Modules
- `jetbrains-core` - Core functionality for all IDEs
- `jetbrains-ultimate` - Features for Ultimate/paid IDEs (database connectivity)
- `jetbrains-rider` - Rider-specific features (.NET/C# support)
- `jetbrains-gateway` - JetBrains Gateway remote development support

### 3. Amazon Q Plugin (`plugin-amazonq`)

AI-powered developer assistant integration featuring:

- **CodeWhisperer** - AI-powered code suggestions and completions
- **Chat** - Interactive AI chat interface for coding assistance
- **Code Transform** - AI-assisted code modernization and transformation
- **Feature Development** - AI-guided feature implementation
- **Mynah UI** - Custom UI components for Amazon Q chat interface

## Technology Stack

### Primary Languages & Frameworks
| Technology | Version | Purpose |
|------------|---------|---------|
| **Kotlin** | 2.0.0 | Primary development language |
| **Java** | 21 | Runtime and legacy code |
| **Gradle** | Kotlin DSL | Build system |
| **TypeScript** | - | Webview and Mynah UI components |

### Key Dependencies
| Library | Purpose |
|---------|---------|
| AWS SDK for Java 2.x (v2.26.25) | AWS service integration |
| Kotlin Coroutines (v1.8.0) | Asynchronous programming |
| Jackson (v2.17.2) | JSON/YAML/XML serialization |
| JUnit 5 (v5.11.0) | Testing framework |
| Detekt (v1.23.7) | Kotlin static analysis |
| IntelliJ Platform Gradle Plugin (v2.2.1) | IDE plugin development |

### Build Requirements
- Java 21 (Amazon Corretto recommended)
- Git
- .NET 6 (for Rider plugin)
- Node.js (for webview components)

## Repository Structure Overview

```
aws-toolkit-jetbrains/
├── buildSrc/                    # Custom Gradle build logic and plugins
├── detekt-rules/                # Custom Detekt rules for code quality
├── designs/                     # Design documents and architectural decisions
├── gradle/                      # Gradle wrapper and version catalog
├── plugins/                     # Main plugin source code
│   ├── core/                    # Core plugin (:plugin-core)
│   ├── toolkit/                 # AWS Toolkit plugin (:plugin-toolkit)
│   └── amazonq/                 # Amazon Q plugin (:plugin-amazonq)
├── testdata/                    # Shared test fixtures and SAM projects
├── ui-tests/                    # UI automation tests
├── ui-tests-starter/            # UI test infrastructure
├── sandbox-all/                 # Development sandbox for running all plugins
├── buildspec/                   # CI/CD build specifications
├── marketplaceGifs/             # Marketing assets for JetBrains Marketplace
├── build.gradle.kts             # Root build configuration
├── settings.gradle.kts          # Gradle settings and module definitions
├── CHANGELOG.md                 # Release changelog
├── CONTRIBUTING.md              # Contribution guidelines
└── REPOLAYOUT.md                # Detailed repository layout documentation
```

## Key Directories and Their Purposes

### `/plugins/core/`
Core functionality shared across all plugins:
- `core/` - Platform-agnostic core utilities
- `jetbrains-community/` - Community IDE platform integration
- `jetbrains-ultimate/` - Ultimate IDE features
- `resources/` - Shared resources (icons, messages, etc.)
- `sdk-codegen/` - AWS SDK code generation
- `webview/` - Web-based UI components

### `/plugins/toolkit/`
AWS service integrations and toolkit features:
- `jetbrains-core/` - Main toolkit functionality
- `jetbrains-ultimate/` - Database and premium features
- `jetbrains-rider/` - .NET/Rider-specific features
- `jetbrains-gateway/` - Remote development support
- `intellij-standalone/` - Standalone plugin packaging

### `/plugins/amazonq/`
Amazon Q AI assistant features:
- `codewhisperer/` - AI code completion
- `chat/` - AI chat interface
- `codetransform/` - Code modernization tools
- `shared/` - Shared Amazon Q utilities
- `mynah-ui/` - Custom chat UI (TypeScript/Node.js)

### `/buildSrc/`
Custom Gradle plugins and build infrastructure:
- Custom plugin conventions
- IDE version management
- Code generation tasks
- Changelog management
- Test configuration

### `/detekt-rules/`
Custom static analysis rules for maintaining code quality:
- License header enforcement
- Coding convention validation
- Custom lint rules

### `/designs/`
Design documents covering architectural decisions:
- CloudWatch integration
- Credential management
- Error messaging patterns
- Executable management
- Resource caching

### `/ui-tests/`
Automated UI testing using IntelliJ Remote Robot:
- End-to-end plugin testing
- Cross-IDE compatibility verification

### `/testdata/`
Test fixtures and sample projects:
- SAM project templates
- Test file resources

## Build Commands

```bash
# Build all plugins
./gradlew buildPlugin

# Build specific plugin
./gradlew :plugin-toolkit:intellij-standalone:buildPlugin
./gradlew :plugin-core:buildPlugin
./gradlew :plugin-amazonq:buildPlugin

# Run IDE with plugins (for development)
./gradlew :plugin-toolkit:intellij-standalone:runIde -PrunIdeVariant=IC  # Community
./gradlew :plugin-toolkit:intellij-standalone:runIde -PrunIdeVariant=IU  # Ultimate

# Run tests
./gradlew check              # Unit tests & static analysis
./gradlew integrationTest    # Integration tests (requires AWS credentials)
./gradlew :ui-tests:uiTestCore  # UI tests

# Generate changelog entry
./gradlew :newChange --console plain
```

## Multi-IDE Version Support

The repository supports multiple JetBrains IDE versions through conditional source sets:
- `src/` - Always included
- `src-231-232/` - Only for IDE versions 2023.1 to 2023.2
- `src-241+/` - Included for IDE versions 2024.1 and later
- `resources-231+/` - Resources for versions 2023.1+

## License

This project is licensed under the Apache License 2.0. See the [LICENSE](LICENSE) file for details.

## Contributing

Contributions are welcome! Please see [CONTRIBUTING.md](CONTRIBUTING.md) for guidelines on:
- Reporting bugs and feature requests
- Building from source
- Submitting pull requests
- Running tests

## Additional Resources

- [Official Documentation](https://docs.aws.amazon.com/toolkit-for-jetbrains/)
- [JetBrains Marketplace](https://plugins.jetbrains.com/plugin/11349-aws-toolkit)
- [IntelliJ Platform SDK Documentation](https://plugins.jetbrains.com/docs/intellij/welcome.html)
- [Repository Layout Details](REPOLAYOUT.md)
