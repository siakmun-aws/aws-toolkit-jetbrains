# AWS Toolkit for JetBrains - Comprehensive Repository Overview

## Table of Contents
- [Project Overview](#project-overview)
- [Main Features and Capabilities](#main-features-and-capabilities)
- [Repository Structure](#repository-structure)
- [Plugin Architecture](#plugin-architecture)
- [Key Technologies and Languages](#key-technologies-and-languages)
- [Supported IDEs](#supported-ides)
- [Development and Build System](#development-and-build-system)
- [Getting Started](#getting-started)

## Project Overview

The **AWS Toolkit for JetBrains** is an open-source, multi-plugin development toolkit that enhances JetBrains IDEs with AWS integration capabilities and AI-powered development tools. This repository serves as a monorepo that produces three distinct but interconnected IntelliJ-based plugins designed to streamline cloud application development, AWS resource management, and AI-assisted coding.

### Purpose

The primary purpose of this project is to:
- **Simplify AWS Development**: Provide seamless integration between JetBrains IDEs and Amazon Web Services
- **Enable Local Testing**: Allow developers to run and debug AWS Lambda functions locally
- **Manage Cloud Resources**: Offer intuitive interfaces for viewing and managing AWS resources
- **Accelerate Development**: Integrate Amazon Q, an AI-powered assistant for code generation, chat, and transformations
- **Support Multiple Platforms**: Maintain compatibility across various JetBrains IDEs and versions

## Main Features and Capabilities

### AWS Core Plugin (plugin-core)
The foundational plugin that provides shared functionality required by both AWS Toolkit and Amazon Q plugins:
- **Core Services**: Common utilities, authentication mechanisms, and AWS SDK integration
- **Telemetry and Metrics**: Usage tracking and performance monitoring
- **Credential Management**: Unified authentication system supporting AWS Builder ID, SSO, static credentials, and credential processes
- **Platform Abstraction**: Handles differences between JetBrains IDE variants (Community, Ultimate, Rider)

### AWS Toolkit Plugin (plugin-toolkit)
Comprehensive AWS resource management and development tools:

#### Authentication & Connection
- Support for multiple authentication methods: AWS Builder ID, IAM credentials, AWS SSO, and credential processes
- Region selection and account management
- Secure credential storage

#### AWS Resource Explorer
- Tree-view interface for AWS resources
- Resource browsing and management across services
- Context-aware actions for supported resource types

#### Lambda Development
- **Local Run/Debug**: Test and debug Lambda functions locally using AWS SAM CLI
- **Remote Invocation**: Invoke deployed Lambda functions with configurable payloads
- **Package & Deploy**: Build and deploy Lambda functions directly from the IDE
- **Language Support**: Java, Python, Node.js, and .NET Core

#### SAM Application Support
- Create, package, and deploy SAM-based serverless applications
- Sync and track SAM application deployments
- Integration with CloudFormation stacks

#### CloudWatch Logs
- View and search log streams in real-time
- Filter and analyze application logs
- Direct integration with Lambda function logs

#### Amazon S3
- Browse S3 buckets and objects
- Upload and download files
- Manage bucket configurations

#### Database Integration (RDS/Redshift)
- Connect to RDS and Redshift databases using temporary credentials
- IAM and SecretsManager authentication
- Available in paid JetBrains products with database support

#### CloudFormation
- View stack events, resources, and outputs
- Monitor stack deployment status
- Template management

### Amazon Q Plugin (plugin-amazonq)
AI-powered development assistance with multiple specialized capabilities:

#### Agent Capabilities
- **`/dev`** - Implement new features: Generate code across entire projects to implement features
- **`/doc`** - Generate documentation: Create API docs, technical design documents, and onboarding guides
- **`/review`** - Automate code reviews: Flag suspicious patterns and assess deployment risks
- **`/test`** - Generate unit tests: Automatically create tests to improve code quality
- **`/transform`** - Transform workloads: Upgrade Java applications in minutes

#### Core Features
- **Inline Chat**: Request code optimizations, comments, or tests directly in the editor
- **Chat Interface**: Get answers about software development, generate code, and explain existing code
- **Inline Suggestions**: Real-time code completions from snippets to full functions
- **Code Reference Log**: Track and attribute code suggestions similar to training data
- **Language Support**: 15+ languages including Python, TypeScript, Rust, Terraform, CloudFormation, and more

#### Code Transformation (CodeModernizer)
- Java application modernization and upgrades
- Automated refactoring and transformation workflows
- Dependency updates and compatibility improvements

#### CodeWhisperer Integration
- Real-time AI-powered code suggestions
- Context-aware completions based on comments and existing code
- Support for multiple programming languages and frameworks

#### Mynah UI
- Modern web-based chat interface
- Rich interactive components for code suggestions
- Seamless integration with IDE workflows

## Repository Structure

The repository follows a **Gradle multi-project build** structure designed to support multiple release artifacts from a single monorepo:

```
aws-toolkit-jetbrains/
├── buildSrc/                    # Custom Gradle build logic and plugins
│   ├── src/                     # Build script sources
│   └── build.gradle.kts        # Build configuration for build scripts
│
├── plugins/                     # Main plugin implementations
│   ├── core/                   # AWS Core Plugin (:plugin-core)
│   │   ├── jetbrains-community/ # Community edition compatible code
│   │   ├── jetbrains-ultimate/  # Ultimate edition specific code
│   │   ├── sdk-codegen/        # AWS SDK code generation
│   │   ├── resources/          # Plugin resources and configuration
│   │   └── webview/            # Web view components
│   │
│   ├── toolkit/                # AWS Toolkit Plugin (:plugin-toolkit)
│   │   ├── intellij-standalone/ # Standalone IntelliJ plugin variant
│   │   ├── jetbrains-core/     # Core toolkit functionality
│   │   ├── jetbrains-gateway/  # JetBrains Gateway integration
│   │   ├── jetbrains-rider/    # Rider-specific implementations (.NET)
│   │   └── jetbrains-ultimate/ # Ultimate edition features
│   │
│   └── amazonq/                # Amazon Q Plugin (:plugin-amazonq)
│       ├── shared/             # Shared Amazon Q components
│       ├── codewhisperer/      # CodeWhisperer integration
│       ├── chat/               # Chat functionality
│       ├── codetransform/      # Code transformation features
│       └── mynah-ui/           # Mynah UI components
│
├── detekt-rules/               # Custom code quality rules
│   └── src/                    # Detekt rule implementations
│
├── ui-tests/                   # UI automation tests
│   └── tst/                    # Test implementations
│
├── testdata/                   # Test fixtures and sample projects
│   └── samProjects/            # Sample SAM applications
│
├── designs/                    # Design documents and specifications
│   ├── credentialManagement/   # Authentication design docs
│   ├── cloudWatch/             # CloudWatch integration specs
│   └── resourceCache/          # Resource caching architecture
│
├── buildspec/                  # AWS CodeBuild specifications
│   ├── linuxTests.yml          # Linux test configurations
│   └── windowsTests.yml        # Windows test configurations
│
├── gradle/                     # Gradle wrapper and dependencies
│   └── libs.versions.toml      # Centralized dependency versions
│
├── build.gradle.kts            # Root build configuration
├── settings.gradle.kts         # Project structure definition
├── README.md                   # Main repository documentation
├── REPOLAYOUT.md               # Detailed repository layout guide
├── CONTRIBUTING.md             # Contribution guidelines
├── CHANGELOG.md                # Version history and changes
└── LICENSE                     # Apache 2.0 license

```

### Directory Organization Patterns

The repository uses several organizational patterns:

1. **Platform-Specific Sourcesets**: Code is separated by IDE platform compatibility:
   - `jetbrains-community/`: Code for Community IDEs (IntelliJ IDEA Community, PyCharm Community)
   - `jetbrains-ultimate/`: Code requiring Ultimate edition features
   - `jetbrains-rider/`: Rider-specific code (.NET development support)
   - `jetbrains-gateway/`: JetBrains Gateway integration

2. **Version-Specific Sources**: Support for multiple IDE versions:
   - `src/`: Always included source code
   - `src-231-232/`: Code for IDE versions 2023.1 to 2023.2
   - `tst-231/`: Tests specific to version 2023.1
   - `resources-231+/`: Resources for versions 2023.1 and later

3. **Feature Modules**: Logical separation by functionality:
   - Each major feature (codewhisperer, chat, codetransform) has its own module
   - Enables independent development and testing
   - Facilitates code ownership and CODEOWNERS configuration

## Plugin Architecture

The plugin architecture consists of three layers with clear dependency relationships:

### Architecture Overview

```
┌─────────────────────────────────────────────────────────────┐
│                     JetBrains IDE Platform                   │
├─────────────────────────────────────────────────────────────┤
│                                                              │
│  ┌────────────────┐         ┌──────────────────┐           │
│  │  AWS Toolkit   │         │   Amazon Q       │           │
│  │  Plugin        │         │   Plugin         │           │
│  │                │         │                  │           │
│  │  - Resources   │         │  - CodeWhisperer │           │
│  │  - Lambda      │         │  - Chat          │           │
│  │  - S3          │         │  - Transform     │           │
│  │  - CloudWatch  │         │  - Mynah UI      │           │
│  │  - RDS/Redshift│         │  - /dev, /doc    │           │
│  └───────┬────────┘         └────────┬─────────┘           │
│          │                           │                      │
│          └───────────┬───────────────┘                      │
│                      ▼                                      │
│         ┌────────────────────────┐                         │
│         │   AWS Core Plugin      │                         │
│         │                        │                         │
│         │  - Authentication      │                         │
│         │  - Credentials         │                         │
│         │  - AWS SDK             │                         │
│         │  - Telemetry           │                         │
│         │  - Common Utilities    │                         │
│         └────────────────────────┘                         │
│                                                              │
└─────────────────────────────────────────────────────────────┘
```

### Plugin Dependencies

1. **AWS Core Plugin** (`aws.toolkit.core`):
   - **Purpose**: Foundation layer providing shared services
   - **Dependencies**: Only depends on JetBrains Platform APIs
   - **Provides**: Authentication, credentials, AWS SDK integration, telemetry
   - **Installation**: Automatically installed when either AWS Toolkit or Amazon Q is installed

2. **AWS Toolkit Plugin** (`aws.toolkit`):
   - **Purpose**: AWS resource management and development tools
   - **Dependencies**: Requires AWS Core Plugin
   - **Provides**: Resource explorer, Lambda tools, S3 management, CloudWatch, database integration
   - **Installation**: Can be installed independently (will auto-install Core)

3. **Amazon Q Plugin** (`amazon.q`):
   - **Purpose**: AI-powered development assistance
   - **Dependencies**: Requires AWS Core Plugin
   - **Provides**: Code generation, chat, transformations, inline suggestions
   - **Installation**: Can be installed independently (will auto-install Core)

### Build Artifact Flow

Each plugin is built as a separate distributable artifact:

```
plugin-core.zip
├── instrumented-community.jar    # Community edition code
├── instrumented-ultimate.jar     # Ultimate edition code
├── instrumented-rider.jar        # Rider-specific code
├── resources.jar                 # Resources and configurations
└── sdk-codegen.jar              # AWS SDK generated code

plugin-toolkit.zip
├── instrumented-community.jar    # Toolkit Community code
├── instrumented-ultimate.jar     # Toolkit Ultimate code
├── instrumented-rider.jar        # Toolkit Rider code
├── resources.jar                 # Toolkit resources
└── [runtime dependency on plugin-core.zip API]

plugin-amazonq.zip
├── mynah-ui.jar                     # Mynah UI components
├── instrumented-amazonqshared-*.jar # Shared Amazon Q code
├── instrumented-codewhisperer-*.jar # CodeWhisperer implementation
├── instrumented-chat-*.jar          # Chat functionality
├── instrumented-codemodernizer-*.jar # Code transformation
└── [runtime dependency on plugin-core.zip API]
```

### Key Architectural Patterns

1. **Instrumentation**: All JetBrains Platform code undergoes instrumentation for Swing UI components
2. **Multi-Platform Support**: Code separation allows selective compilation based on target IDE
3. **Shared Dependencies**: Common code is packaged in the Core plugin to avoid duplication
4. **Version Flexibility**: Supports multiple IDE major versions through conditional source inclusion

## Key Technologies and Languages

### Programming Languages

| Language | Files | Primary Use |
|----------|-------|-------------|
| **Kotlin** | ~1,907 | Primary development language for all plugin code |
| **C#** | ~80 | Rider plugin support for .NET development |
| **TypeScript/JavaScript** | ~49 | Mynah UI and web components |
| **Java** | ~10 | Legacy code (being migrated to Kotlin) |

### Core Technologies

#### Development Framework
- **JetBrains Platform SDK**: IntelliJ Platform APIs for plugin development
- **Gradle 8.x**: Build automation with Kotlin DSL
- **IntelliJ Gradle Plugin 2.2.1**: Plugin packaging and testing
- **Kotlin 2.0.0**: Modern Kotlin language features and coroutines

#### AWS Integration
- **AWS SDK for Java 2.26.25**: Complete AWS service integration
- **AWS SAM CLI**: Local Lambda testing and SAM application deployment
- **AWS Services Supported**:
  - Lambda, CloudFormation, CloudWatch Logs
  - S3, RDS, Redshift, AppRunner
  - Cognito, CodeCatalyst, STS, SSO
  - Cloud Control API

#### Testing & Quality
- **JUnit 5.11.0**: Unit testing framework
- **Mockito 5.12.0 / MockK 1.13.10**: Mocking frameworks
- **AssertJ 3.26.3**: Fluent assertions
- **Remote Robot 0.11.22**: UI automation testing
- **Detekt 1.23.7**: Kotlin static analysis
- **JaCoCo 0.8.12**: Code coverage reporting

#### Supporting Libraries
- **Kotlin Coroutines 1.8.0**: Asynchronous programming
- **Jackson 2.17.2**: JSON parsing and serialization
- **Apache Commons**: Utilities for collections, IO, and text
- **JGit 6.5.0**: Git operations
- **Nimbus JOSE JWT 9.40**: JWT authentication
- **Apache SSHD 2.13.2**: SSH functionality
- **Commonmark 0.22.0**: Markdown processing

### Build Tools and Plugins

- **Gradle Wrapper**: Ensures consistent Gradle versions
- **Custom Gradle Plugins** (in buildSrc):
  - `toolkit-changelog`: Changelog generation
  - `toolkit-git-secrets`: Security scanning
  - `toolkit-jacoco-report`: Coverage reporting
  - `toolkit-intellij-subplugin`: Plugin build configuration
- **Node Gradle Plugin 7.0.2**: Node.js integration for web components
- **S3 Build Cache**: Distributed build caching
- **Gradle Develocity**: Build performance monitoring

## Supported IDEs

The AWS Toolkit for JetBrains supports all JetBrains IDEs version **2023.3 and later**:

### Officially Supported IDEs

| IDE | Community | Ultimate/Pro | Notes |
|-----|-----------|--------------|-------|
| **IntelliJ IDEA** | ✅ | ✅ | Full feature support |
| **PyCharm** | ✅ | ✅ | Python Lambda support |
| **WebStorm** | ✅ | N/A | Node.js Lambda support |
| **PhpStorm** | N/A | ✅ | Limited AWS feature support |
| **Rider** | N/A | ✅ | .NET Lambda support, C# integration |
| **GoLand** | N/A | ✅ | Go development support |
| **RubyMine** | N/A | ✅ | Ruby development support |
| **CLion** | N/A | ✅ | C/C++ development support |
| **DataGrip** | N/A | ✅ | Database features (RDS/Redshift) |
| **JetBrains Gateway** | N/A | ✅ | Remote development support |

### Platform Variants

The codebase supports three platform variants:
1. **Community Edition**: Free, open-source IDEs
2. **Ultimate Edition**: Paid, professional IDEs with additional features
3. **Rider**: Special handling for .NET development

### Version Support Strategy

- **Current Support**: IDE versions 2023.3+
- **Version-Specific Code**: Conditional compilation for API differences
- **Build Profiles**: `-PideProfileName` flag to target specific versions
- **Example**: `./gradlew buildPlugin -PideProfileName=2024.1`

## Development and Build System

### Prerequisites

To build and develop the AWS Toolkit for JetBrains, you need:

| Requirement | Version | Purpose |
|-------------|---------|---------|
| **Java** | 21 (Corretto recommended) | Build and runtime |
| **Git** | Latest | Version control |
| **.NET SDK** | 6.0 | Rider plugin support |
| **Docker** | Latest (optional) | Local Lambda testing |
| **AWS SAM CLI** | Latest (optional) | SAM application development |
| **AWS Credentials** | N/A (optional) | Testing with real AWS services |

### Build Commands

```bash
# Build all plugins
./gradlew buildPlugin

# Build specific plugins
./gradlew :plugin-toolkit:intellij-standalone:buildPlugin
./gradlew :plugin-core:buildPlugin
./gradlew :plugin-amazonq:buildPlugin

# Build for specific IDE version
./gradlew buildPlugin -PideProfileName=2024.1

# Run tests
./gradlew check                    # All tests except integration
./gradlew test                     # Unit tests only
./gradlew integrationTest          # Integration tests (requires AWS)

# Run IDE with plugin
./gradlew :plugin-toolkit:intellij-standalone:runIde -PrunIdeVariant=IC
./gradlew :plugin-amazonq:runIde -PrunIdeVariant=IU
./gradlew :sandbox-all:runIde      # Run with all plugins

# Code quality checks
./gradlew detekt                   # Kotlin static analysis
./gradlew jacocoAggregatedReport   # Generate coverage report

# Generate changelog entry
./gradlew :newChange --console plain
```

### Project Structure in Gradle

The build system uses Gradle's multi-project capabilities:

```kotlin
// Root project configuration
settings.gradle.kts  // Defines all subprojects
build.gradle.kts     // Root build logic and aggregation

// Plugin projects
:plugin-core                           // AWS Core Plugin
:plugin-core:sdk-codegen              // SDK code generation
:plugin-toolkit:intellij-standalone   // AWS Toolkit standalone
:plugin-amazonq                       // Amazon Q Plugin
:plugin-amazonq:codewhisperer        // CodeWhisperer module
:plugin-amazonq:chat                 // Chat module
:plugin-amazonq:codetransform        // Code transformation module

// Supporting projects
:buildSrc                             // Custom build logic
:detekt-rules                         // Custom Detekt rules
:ui-tests                             // UI automation tests
:sandbox-all                          # Development sandbox
```

### Development Workflow

1. **Import Project**: Open in IntelliJ IDEA as a Gradle project
2. **Sync Gradle**: Let IDE download dependencies and configure project
3. **Use Run Configurations**: Pre-configured launchers for running and debugging
4. **Make Changes**: Edit code with full IDE support
5. **Run Tests**: Use Gradle tasks or IDE test runners
6. **Debug**: Launch sandbox IDE with debugger attached
7. **Build Plugin**: Generate distributable zip files
8. **Test Installation**: Install in real IDE using "Install Plugin from Disk"

### Testing Strategy

```bash
# Unit tests (no external dependencies)
./gradlew test

# Integration tests (requires AWS credentials)
./gradlew integrationTest

# UI tests (requires AWS and opens IDE)
./gradlew :ui-tests:uiTestCore

# Test specific module
./gradlew :plugin-amazonq:test
./gradlew :plugin-toolkit:intellij-standalone:test
```

### CI/CD Integration

The repository includes AWS CodeBuild specifications:
- `buildspec/linuxTests.yml`: Linux test execution
- `buildspec/windowsTests.yml`: Windows test execution
- `buildspec/linuxTestsForAmazonQ.yml`: Amazon Q specific tests
- `buildspec/linuxTestsForToolkit.yml`: Toolkit specific tests
- `buildspec/linuxUiTests.yml`: UI automation tests

### Code Quality Tools

1. **Detekt**: Kotlin static analysis with custom rules
   - Configuration: `detekt-rules/detekt.yml`
   - Custom rules for AWS Toolkit specific patterns

2. **JaCoCo**: Code coverage reporting
   - Aggregated reports across all modules
   - Coverage requirements enforced in CI

3. **Git Secrets**: Prevents committing AWS credentials
   - Custom Gradle plugin for security scanning

## Getting Started

### For Users

1. **Install from JetBrains Marketplace**:
   - Open your JetBrains IDE
   - Go to Settings → Plugins → Marketplace
   - Search for "AWS Toolkit" or "Amazon Q"
   - Click Install and restart IDE

2. **Configure Authentication**:
   - Open AWS Explorer tool window
   - Choose authentication method:
     - **AWS Builder ID**: Free tier, personal profile
     - **IAM Credentials**: Access key and secret key
     - **AWS SSO**: Organization single sign-on
     - **Credential Process**: Custom credential provider

3. **Select Region**: Choose your AWS region from the toolbar

4. **Start Developing**: Access AWS features from tool windows and context menus

### For Contributors

1. **Clone Repository**:
   ```bash
   git clone https://github.com/aws/aws-toolkit-jetbrains.git
   cd aws-toolkit-jetbrains
   ```

2. **Open in IntelliJ IDEA**:
   - File → Open → Select `aws-toolkit-jetbrains` directory
   - Wait for Gradle sync to complete

3. **Build the Project**:
   ```bash
   ./gradlew buildPlugin
   ```

4. **Run in Development Mode**:
   ```bash
   # Use pre-configured run configurations in IDE, or:
   ./gradlew :plugin-toolkit:intellij-standalone:runIde
   ```

5. **Make Changes**:
   - Follow existing code conventions (see `CONTRIBUTING.md`)
   - Write tests for all changes
   - Run `./gradlew check` before committing

6. **Submit Pull Request**:
   - Create feature branch
   - Generate changelog entry: `./gradlew :newChange --console plain`
   - Commit changes with clear messages
   - Open PR with filled-out template

### Useful Resources

- **User Guide**: https://docs.aws.amazon.com/console/toolkit-for-jetbrains/
- **Contributing Guide**: See `CONTRIBUTING.md` in repository
- **Repository Layout**: See `REPOLAYOUT.md` for detailed structure
- **Issue Tracker**: https://github.com/aws/aws-toolkit-jetbrains/issues
- **IntelliJ Platform SDK**: https://plugins.jetbrains.com/docs/intellij/
- **AWS Documentation**: https://aws.amazon.com/documentation/

### Getting Help

- **File a Bug**: [Create a bug report](https://github.com/aws/aws-toolkit-jetbrains/issues/new?labels=bug&template=bug_report.md)
- **Request a Feature**: [Submit feature request](https://github.com/aws/aws-toolkit-jetbrains/issues/new?labels=feature-request&template=feature_request.md)
- **Ask Questions**: [Open a guidance request](https://github.com/aws/aws-toolkit-jetbrains/issues/new?labels=guidance&template=guidance_request.md)
- **View Documentation**: Check the `designs/` folder for architectural decisions

---

## License

This project is licensed under the Apache License 2.0. See the [LICENSE](LICENSE) file for full details.

## Maintainers

This project is maintained by AWS and welcomes contributions from the community. For major changes, please open an issue first to discuss what you would like to change.

**Vendor**: AWS  
**Email**: aws-toolkit-jetbrains@amazon.com  
**GitHub**: https://github.com/aws/aws-toolkit-jetbrains
