# AWS Toolkit for JetBrains - Developer Overview

## Project Overview and Purpose

The AWS Toolkit for JetBrains is a sophisticated plugin suite for JetBrains IDEs that provides comprehensive AWS integration and AI-powered development assistance. The project is structured as a monorepo containing multiple discrete plugins that work together to enhance the AWS development experience in JetBrains IDEs.

### Core Mission
- **AWS Integration**: Seamless integration with AWS services for resource management, deployment, and development
- **AI-Powered Development**: Advanced generative AI capabilities through Amazon Q for code generation, transformation, and assistance
- **Developer Productivity**: Tools for local Lambda development, SAM applications, CloudFormation management, and more

### Key Value Propositions
- Unified AWS development experience across all JetBrains IDEs
- Local development and debugging of serverless applications
- AI-powered code generation and transformation capabilities
- Direct IDE integration with AWS services (S3, Lambda, CloudWatch, etc.)
- Support for multiple programming languages and frameworks

## Architecture and Main Components

The project follows a **multi-plugin architecture** with three primary plugin distributions:

### 1. AWS Core (`plugin-core`)
**Purpose**: Foundation plugin providing shared AWS functionality and authentication
- **Location**: `plugins/core/`
- **Plugin ID**: `aws.toolkit.core`
- **Role**: Required dependency for other AWS plugins
- **Key Features**:
  - AWS authentication and credential management (SSO, Builder ID, static credentials)
  - Core AWS SDK integration and service clients
  - Shared utilities and telemetry infrastructure
  - Platform abstraction layer for different JetBrains IDEs

### 2. Amazon Q (`plugin-amazonq`) 
**Purpose**: AI-powered development assistant and code transformation
- **Location**: `plugins/amazonq/`
- **Plugin ID**: `amazon.q`
- **Key Components**:
  - **CodeWhisperer** (`codewhisperer/`): Real-time code suggestions and inline chat
  - **Code Transform** (`codetransform/`): Java application modernization and transformation
  - **Chat** (`chat/`): Interactive AI chat for development assistance
  - **Mynah UI** (`mynah-ui/`): Web-based chat interface components
  - **Shared** (`shared/`): Common Amazon Q functionality

### 3. AWS Toolkit (`plugin-toolkit`)
**Purpose**: Traditional AWS service integration and resource management
- **Location**: `plugins/toolkit/`
- **Plugin ID**: `aws.toolkit`
- **Key Features**:
  - AWS Resource Explorer for managing AWS resources
  - Lambda function development, debugging, and deployment
  - SAM (Serverless Application Model) application support
  - CloudFormation stack management
  - S3 bucket operations
  - CloudWatch Logs integration
  - RDS/Redshift database connections

## Technology Stack and Build System

### Programming Languages
- **Primary**: Kotlin (strongly preferred for all new code)
- **Legacy**: Java (discouraged, being migrated to Kotlin)
- **Frontend**: TypeScript/JavaScript (for Mynah UI components)
- **Build Configuration**: .NET 6+ (for Rider support)

### Build System
- **Primary**: Gradle with Kotlin DSL
- **Type**: Multi-project build with custom build plugins
- **Key Files**:
  - `build.gradle.kts` - Root build configuration
  - `settings.gradle.kts` - Project structure and submodule definitions
  - `gradle/libs.versions.toml` - Centralized dependency version management
  - `buildSrc/` - Custom Gradle plugins and build logic

### Key Dependencies
- **AWS SDK**: 2.26.25+ (comprehensive AWS service support)
- **IntelliJ Platform**: 2023.3+ (plugin framework)
- **Kotlin**: 2.0.0 (primary language)
- **Jackson**: 2.17.2+ (JSON processing)
- **Testing**: JUnit 5, Mockito, AssertJ

### IDE Platform Support
- **JetBrains IDEs**: All 2023.3+ versions
- **Platform Variants**:
  - Community Edition (IntelliJ IDEA, PyCharm Community)
  - Ultimate Edition (IntelliJ IDEA Ultimate, PyCharm Professional)
  - Rider (C#/.NET development)
  - Gateway (remote development)

## Key Directories and Structure

```
aws-toolkit-jetbrains/
├── plugins/                    # Main plugin modules
│   ├── core/                   # AWS Core plugin (foundation)
│   │   ├── jetbrains-community/    # Community IDE support
│   │   ├── jetbrains-ultimate/     # Ultimate IDE features
│   │   ├── resources/              # Plugin resources and icons
│   │   └── sdk-codegen/            # AWS SDK code generation
│   ├── amazonq/                # Amazon Q AI assistant
│   │   ├── codewhisperer/          # Code suggestions
│   │   ├── codetransform/          # Code transformation
│   │   ├── chat/                   # AI chat interface
│   │   ├── mynah-ui/               # Web UI components
│   │   └── shared/                 # Common Q functionality
│   └── toolkit/                # AWS Toolkit plugin
│       ├── jetbrains-core/         # Core toolkit functionality
│       ├── jetbrains-ultimate/     # Ultimate IDE features
│       ├── jetbrains-rider/        # Rider (.NET) support
│       └── jetbrains-gateway/      # Remote development support
├── buildSrc/                   # Custom Gradle build logic
├── detekt-rules/               # Code style and quality rules
├── ui-tests/                   # Automated UI testing
├── testdata/                   # Test fixtures and sample projects
├── designs/                    # Architecture documentation
│   ├── credentialManagement/       # Authentication design docs
│   ├── cloudWatch/                 # CloudWatch integration docs
│   └── commonResourceActions/      # Resource action patterns
└── buildspec/                  # AWS CodeBuild configurations
```

### Platform-Specific Organization
The project uses a **platform-based sourceset structure**:

- **`community/`**: Features for free JetBrains IDEs
- **`ultimate/`**: Features requiring paid JetBrains IDEs 
- **`rider/`**: .NET/C# specific functionality
- **IDE version folders** (e.g., `src-231-232/`): Version-specific compatibility code

## Project Organization Patterns

### 1. Multi-Project Gradle Structure
- **Root project**: Coordination and shared configuration
- **Plugin projects**: Individual distributable plugins
- **Shared modules**: Common code and utilities
- **Platform variants**: IDE-specific implementations

### 2. IDE Compatibility Strategy
- **Version targeting**: Support for multiple JetBrains IDE versions simultaneously
- **Conditional compilation**: Version-specific source folders
- **Platform abstraction**: Unified API across different IDE platforms

### 3. Code Organization Principles
- **Kotlin-first**: All new code written in Kotlin
- **Platform separation**: Clear boundaries between community/ultimate features
- **Service-oriented**: AWS services organized as discrete modules
- **Test co-location**: Tests alongside source code in `tst/` directories

### 4. Build and Release Strategy
- **Artifact separation**: Each plugin builds independently
- **Dependency management**: Core plugin as foundation for others
- **Platform targeting**: Different builds for different IDE versions
- **Quality gates**: Automated testing, linting, and code coverage

### 5. Development Workflow
- **Local development**: `runIde` tasks for testing in sandbox environments
- **Testing strategy**: Unit tests, integration tests, and UI tests
- **Code quality**: Detekt linting, code coverage tracking
- **Documentation**: Inline documentation and design documents

## Getting Started for Developers

### Prerequisites
- Java 21+
- Git
- .NET 6+ (for Rider support)

### Building and Running
```bash
# Build all plugins
./gradlew buildPlugin

# Build specific plugin
./gradlew :plugin-toolkit:intellij-standalone:buildPlugin

# Run in development mode
./gradlew :plugin-toolkit:intellij-standalone:runIde

# Run tests
./gradlew check
```

### Key Development Commands
- `./gradlew projects` - List all available subprojects
- `./gradlew :newChange --console plain` - Generate changelog entry
- `./gradlew generateChangeLog` - Generate full changelog

This architecture enables the AWS Toolkit for JetBrains to provide comprehensive AWS development support while maintaining clean separation of concerns, platform compatibility, and extensibility for future enhancements.