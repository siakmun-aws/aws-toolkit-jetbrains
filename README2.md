# AWS Toolkit for JetBrains - Repository Summary

## Project Overview and Purpose

The **AWS Toolkit for JetBrains** is an open-source plugin for JetBrains IDEs that makes it easier to develop, debug, and deploy applications built on Amazon Web Services (AWS). The toolkit brings AWS services and Amazon Q capabilities directly into your IDE, providing seamless integration with cloud development workflows.

The project is actively maintained by AWS and welcomes community contributions including issues, feature requests, pull requests, and code reviews.

## Key Features and Capabilities

### Amazon Q Integration

Amazon Q is an AI-powered assistant integrated into the toolkit with advanced capabilities:

- **AI-Powered Chat**: Conversational interface with `@workspace` context awareness for code-related questions
- **Inline Code Suggestions**: Real-time AI-powered code completions with configurable keyboard shortcuts
- **Code Review (`/review`)**: Automated code analysis that identifies issues grouped by severity or file location, with automatic code fix generation
- **Code Development (`/dev`)**: Interactive code generation and modification with executable code and test commands
- **Code Transformation (`/transform`)**: Automated code upgrades (Java 17, 21) and SQL database conversions (Oracle/SQL Server to PostgreSQL/MySQL)
- **Documentation Generation (`/doc`)**: Automatic README and architecture diagram updates based on project analysis
- **Test Generation (`/test`)**: Automated unit test creation with proper file identification and syntax highlighting
- **Custom AI Models**: Support for customization of AI behavior through AWS configuration

### AWS Service Integrations

#### AWS Lambda
- **Local Run/Debug**: Test and step-through debug Lambda functions locally using AWS SAM CLI
- **Remote Invocation**: Execute remote Lambda functions with shareable run configurations
- **Package & Deploy**: Create and deploy Lambda function packages
- **SAM Application Sync**: Track and sync SAM-based serverless applications
- **Language Support**: Java, Python, Node.js, and .NET Core

#### AWS CloudFormation
- View stack events, resources, and outputs
- Monitor stack operations directly from the IDE

#### Amazon CloudWatch Logs
- Browse and search log streams
- Real-time log viewing and analysis

#### Amazon S3
- Bucket management and browsing
- File upload/download operations
- Integrated S3 resource explorer

#### Amazon RDS & Redshift
- Database connections using temporary IAM credentials
- SecretsManager integration for secure credential management
- Available in paid JetBrains products with database support

#### Additional Services
- Amazon DynamoDB viewer
- Amazon EC2, ECS, ECR integration
- AWS App Runner support
- Amazon SNS, SQS messaging services

### General Features

- **AWS Resource Explorer**: Tree view of AWS resources filtered by selected account/region
- **Multi-Authentication Support**: 
  - Static credentials
  - Credential process
  - AWS Builder ID
  - AWS IAM Identity Center (AWS SSO)
- **Experimental Features**: Opt-in access to cutting-edge features under development

## Technology Stack

### Core Technologies

- **Primary Language**: Kotlin 2.0.0 (all new code must be written in Kotlin)
- **Build System**: Gradle multi-project build with Kotlin DSL
- **IDE Platform**: JetBrains IntelliJ Platform 2.1.0
- **AWS SDK**: AWS SDK for Java 2.26.25

### Key Dependencies

#### AWS Services Integration
- Comprehensive AWS service SDK libraries (CloudFormation, Lambda, S3, EC2, RDS, Redshift, DynamoDB, etc.)
- AWS Apache HTTP Client and Netty NIO Client

#### Kotlin & JVM
- Kotlin Standard Library and Reflection
- Kotlin Coroutines 1.8.0 for asynchronous programming
- Java compatibility (Java code discouraged, Kotlin preferred)

#### Testing Frameworks
- JUnit 5.11.0 (Jupiter)
- JUnit 4.13.2 (Vintage for legacy tests)
- Mockito 5.12.0 & MockK 1.13.10 for mocking
- AssertJ 3.26.3 for fluent assertions
- IntelliJ Remote Robot 0.11.22 for UI testing
- WireMock 3.9.1 for HTTP service mocking

#### Development Tools
- Detekt 1.23.7 for static code analysis
- JaCoCo 0.8.12 for code coverage
- Jackson 2.17.2 for JSON/XML/YAML processing
- JGit 6.5.0 for Git operations
- Apache Commons libraries (Collections, IO, Text)

#### Build & CI/CD
- Gradle IntelliJ Platform Plugin 2.2.1
- Gradle Develocity for build optimization
- S3 Build Cache for distributed caching
- AWS CodeBuild for continuous integration

## Repository Structure Highlights

The repository follows a Gradle multi-project build structure optimized for emitting multiple discrete release artifacts from a single monorepo:

### Top-Level Structure

```
aws-toolkit-jetbrains/
├── buildSrc/              # Encapsulated build logic and conventions
├── detekt-rules/          # Custom detekt rules and repository-wide configuration
├── ui-tests/              # UI testing framework for all artifacts
├── ui-tests-starter/      # UI test initialization (IDE 2024.2+)
├── designs/               # Architecture and design documentation
├── testdata/              # Test fixtures and sample SAM projects
├── marketplaceGifs/       # Marketing assets and product demos
└── plugins/               # Main plugin implementations
    ├── core/              # Core functionality shared across all plugins
    ├── toolkit/           # AWS Toolkit plugin implementation
    └── amazonq/           # Amazon Q plugin implementation
```

### Plugin Structure (plugins/ directory)

#### `:plugin-core` - Core Foundation
Contains shared AWS functionality used by all plugins:
- `community/` - Code for community (free) IDEs
- `ultimate/` - Code for ultimate (paid) IDEs  
- `rider/` - Rider-specific implementations
- `sdk-codegen/` - AWS SDK code generation utilities

#### `:plugin-toolkit` - AWS Toolkit Plugin
Main AWS services plugin:
- `community/` - IntelliJ IDEA Community, PyCharm Community
- `ultimate/` - IntelliJ IDEA Ultimate, PyCharm Professional
- `rider/` - JetBrains Rider integration
- `gateway/` - JetBrains Gateway support (IDE 2024.2+)
- `resources/` - Plugin resources and assets

#### `:plugin-amazonq` - Amazon Q Plugin
AI-powered development assistant:
- `shared/` - Common Amazon Q functionality across features
  - `community/` and `ultimate/` platform sourcesets
- `codewhisperer/` - AI code suggestions and completions
  - `community/` and `ultimate/` platform sourcesets
- `chat/` - Conversational AI interface
- `codetransform/` - Code transformation and modernization
- `mynah-ui/` - UI components for Amazon Q interface

### Source Set Organization

The repository uses a sophisticated source set structure to support multiple IDE versions and editions:

```
subproject/
├── src/                    # Always included (core functionality)
├── src-241-242/           # IDE versions 2024.1 to 2024.2 inclusive
├── src-243+/              # IDE version 2024.3 and later
├── tst/                   # Test sources
├── tst-241/               # Tests specific to IDE 2024.1
├── resources/             # Plugin resources
├── resources-241+/        # Resources for IDE 2024.1 and later
└── build.gradle.kts       # Subproject build configuration
```

This structure enables:
- Platform-specific code for different IDE editions (Community, Ultimate, Rider)
- Version-specific implementations for different IDE major versions
- Clean separation of concerns and code ownership
- Compilation-time error detection rather than runtime failures

### Build Configuration Files

- `build.gradle.kts` - Root build configuration with coverage aggregation
- `settings.gradle.kts` - Multi-project structure definition and repository configuration
- `gradle.properties` - Gradle and plugin version properties
- `gradle/libs.versions.toml` - Centralized dependency version catalog
- `buildspec/` - AWS CodeBuild pipeline specifications

## Supported JetBrains IDE Versions

**All JetBrains IDEs version 2023.3 and later** are supported, including:

- IntelliJ IDEA (Community & Ultimate)
- PyCharm (Community & Professional)
- WebStorm
- PhpStorm
- RubyMine
- CLion
- GoLand
- Rider
- DataGrip
- Android Studio
- JetBrains Gateway (2024.2+)

The plugin architecture supports:
- **Community IDEs**: Free versions with core AWS functionality
- **Ultimate IDEs**: Paid versions with additional features (e.g., database integrations)
- **Rider**: Special support for .NET development workflows

## Main Components

### 1. Core Plugin (`:plugin-core`)
**Purpose**: Foundation layer providing common AWS integration functionality

**Key Responsibilities**:
- AWS service client management
- Authentication and credential management (AWS Builder ID, IAM Identity Center, static credentials)
- AWS Resource Explorer implementation
- SDK code generation for AWS services
- Telemetry and analytics
- Common UI components and utilities
- Platform-specific abstractions for community, ultimate, and Rider editions

**Technologies**: Kotlin, AWS SDK 2.x, IntelliJ Platform APIs

### 2. AWS Toolkit Plugin (`:plugin-toolkit`)
**Purpose**: Full-featured AWS development toolkit for cloud application development

**Key Features**:
- AWS Lambda local run/debug with SAM CLI integration
- CloudFormation stack management
- CloudWatch Logs integration
- S3 bucket operations
- RDS/Redshift database connections
- Serverless application deployment
- Remote resource management

**Languages Supported**: Java, Python, Node.js, .NET Core

**Dependencies**: Requires `:plugin-core` for AWS integration layer

### 3. Amazon Q Plugin (`:plugin-amazonq`)
**Purpose**: AI-powered development assistant with advanced code intelligence

**Subcomponents**:

#### Shared Foundation (`shared/`)
- Common Amazon Q infrastructure
- Authentication and authorization
- Workspace indexing for context awareness
- Communication layer between IDE and AI services

#### CodeWhisperer (`codewhisperer/`)
- Real-time inline code suggestions
- Context-aware code completions
- Multi-language support with syntax-specific recommendations
- Security scanning integration
- Customization support for organization-specific patterns

#### Chat (`chat/`)
- Conversational AI interface powered by Mynah UI
- `@workspace` context for project-aware responses
- Code explanation and documentation
- Prompt history navigation
- Citation support for code references

#### Code Transform (`codetransform/`)
- Java version upgrades (8→17, 11→17, 17→21)
- SQL database migrations (Oracle/SQL Server → PostgreSQL/MySQL)
- Automated refactoring with build validation
- Pre-build error detection and reporting
- Progress tracking and rollback support

#### Mynah UI (`mynah-ui/`)
- Web-based UI components for Amazon Q interface
- React/TypeScript frontend (bundled via Node Gradle plugin)
- Rich markdown rendering with syntax highlighting
- Interactive code diff viewer
- File tree visualization

**Dependencies**: 
- Requires `:plugin-core` for AWS integration
- Node.js ecosystem for frontend components
- AWS AI/ML services for backend intelligence

### Cross-Cutting Concerns

#### UI Testing (`ui-tests/`)
- Remote Robot framework for automated UI testing
- Comprehensive test coverage for user workflows
- Platform-specific test configurations

#### Code Quality (`detekt-rules/`)
- Custom Detekt rules for Kotlin code quality
- Repository-wide coding standards enforcement
- Automated style checking in CI/CD pipeline

#### Build Infrastructure (`buildSrc/`)
- Custom Gradle plugins and tasks
- Convention plugins for consistent configuration
- Build optimization and caching strategies
- IDE version compatibility utilities

## Development Workflow

### Building from Source
The project uses Gradle with Kotlin DSL:
```bash
./gradlew buildPlugin
```

### Running the Plugin
Use project-specific runIde commands:
```bash
./gradlew :plugin-toolkit:intellij-standalone:runIde
./gradlew :plugin-amazonq:runIde
```

### Testing Strategy
- Unit tests with JUnit 5 and MockK
- Integration tests with AWS service mocks (WireMock)
- UI tests with Remote Robot framework
- Coverage reporting with JaCoCo

### Release Artifacts
The build produces three main distributable artifacts:
1. **`plugin-core.zip`** - Core AWS functionality (dependency for other plugins)
2. **`plugin-toolkit.zip`** - AWS Toolkit with service integrations
3. **`plugin-amazonq.zip`** - Amazon Q AI assistant plugin

### Code Organization Philosophy

The repository follows strict conventions:
- **All new code in Kotlin**: Java is discouraged, existing Java code is being migrated
- **CODEOWNERS-based review**: Pull requests automatically routed to appropriate teams
- **Modular architecture**: Clear boundaries between plugins enable independent development
- **Platform-specific source sets**: Compile-time safety for IDE API differences
- **Version-specific code**: Graceful degradation across IDE versions

## Documentation and Resources

- **Installation Guide**: [AWS Toolkit for JetBrains User Guide](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/install)
- **Contributing Guide**: [CONTRIBUTING.md](CONTRIBUTING.md)
- **Repository Layout**: [REPOLAYOUT.md](REPOLAYOUT.md) - Detailed build structure documentation
- **Changelog**: [CHANGELOG.md](CHANGELOG.md) - Version history and release notes
- **Design Documents**: `designs/` directory contains architectural decision records
- **JetBrains Plugin Marketplace**: [AWS Toolkit](https://plugins.jetbrains.com/plugin/11349-aws-toolkit)

## Community and Support

- **GitHub Issues**: [Feature requests, bug reports, questions](https://github.com/aws/aws-toolkit-jetbrains/issues)
- **Pull Requests**: Community contributions welcome
- **Code Reviews**: Participate in design discussions
- **Feature Voting**: Vote on feature requests to influence prioritization

## License

The AWS Toolkit for JetBrains is distributed under the Apache License 2.0. See [LICENSE](LICENSE) for full details.

---

**Note**: This repository represents a modern, modular approach to IDE plugin development with a strong emphasis on code quality, maintainability, and developer experience. The multi-project Gradle structure enables independent team ownership while maintaining cohesive release artifacts.
