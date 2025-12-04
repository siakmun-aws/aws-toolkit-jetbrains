# AWS Toolkit for JetBrains - Comprehensive Repository Summary

## Project Overview and Purpose

The **AWS Toolkit for JetBrains** is an open-source plugin for JetBrains IDEs that simplifies the development of applications built on Amazon Web Services (AWS). This project aims to provide developers with seamless integration between their IDE and AWS services, enabling them to build, test, debug, and deploy cloud applications more efficiently.

The repository serves as a monorepo hosting multiple discrete release artifacts:
- **AWS Toolkit** - Traditional AWS service integration for JetBrains IDEs
- **Amazon Q** - AI-powered coding assistant with advanced features
- **Core Plugin** - Shared functionality and platform-specific implementations

The project is actively maintained and supports all JetBrains IDEs version 2023.3 and later, including IntelliJ IDEA, PyCharm, WebStorm, Rider, CLion, GoLand, and other JetBrains products.

## Key Features and Capabilities

### AWS Toolkit Features

#### Service Integrations
- **AWS Lambda**: Local run/debug, remote invocation, packaging, and deployment
- **CloudFormation**: View stack events, resources, and outputs
- **CloudWatch Logs**: View and search log streams
- **Amazon S3**: Bucket management, file upload/download
- **Amazon RDS/Redshift**: Connect using temporary credentials with IAM/SecretsManager
- **Amazon ECS**: Container service management
- **Amazon ECR**: Container registry integration

#### Core Capabilities
- **AWS Resource Explorer**: Tree-view of AWS resources in your account/region
- **Authentication**: Multiple auth methods including static credentials, credential process, AWS Builder ID, and AWS SSO
- **SAM Application Support**: Full support for AWS Serverless Application Model
  - Local Lambda function testing with step-through debugging
  - Package and deploy Lambda functions
  - Sync and track SAM-based applications

#### Language Support
The toolkit supports multiple programming languages for serverless development:
- **Java** (Java 8, 11, 17, 21)
- **Python** (3.8, 3.9, 3.10, 3.11, 3.12)
- **Node.js** (16.x, 18.x, 20.x)
- **.NET Core**
- **Go** (1.x)

### Amazon Q Functionality

Amazon Q is an AI-powered coding assistant integrated into the toolkit with advanced capabilities:

#### Code Generation and Assistance
- **Inline Code Suggestions**: Pre-fetch recommendations with reduced latency
- **Co-existence with JetBrains IntelliSense**: Configurable tab behavior
- **Customizable Shortcuts**: Configure actions for accepting and browsing suggestions
- **Context-Aware Assistance**: Uses workspace indexing for better recommendations

#### Specialized Commands
- **`/dev`**: Development assistance with optional code/test command execution
- **`/doc`**: Documentation generation and architecture diagram updates
- **`/test`**: Unit test generation with automatic test file identification
- **`/review`**: Code review with issue grouping by severity or file location
- **`/transform`**: Code modernization supporting transformations to Java 21
- **`/help`**: Interactive help including re:invent 2024 features

#### Advanced Features
- **Chat Interface**: Interactive Q&A with markdown formatting and syntax highlighting
- **Citation Support**: Proper attribution for generated code
- **Workspace Indexing**: Configurable workspace context for improved suggestions
- **Multi-IDE Support**: Consistent experience across all supported JetBrains IDEs

## Technology Stack and Main Components

### Core Technologies

#### Programming Languages
- **Primary**: Kotlin 2.0.0 (all new code written in Kotlin following standard conventions)
- **Legacy**: Java (minimal remaining, discouraged for new code)
- **.NET 6**: Required for Rider-specific functionality

#### Build System
- **Gradle** (Multi-project build with Gradle Platform Plugin)
- **Build Tools**:
  - Gradle Wrapper for consistent builds
  - IntelliJ Platform Gradle Plugin 2.2.1
  - Kotlin Gradle Plugin 2.0.0
  - Detekt for static code analysis
  - JaCoCo for code coverage

#### Key Dependencies

**AWS SDKs and Services** (v2.26.25)
- AWS SDK for Java 2.x
- Service clients: Lambda, S3, CloudFormation, CloudWatch, ECS, ECR, RDS, Redshift, DynamoDB, SNS, SQS, SSO, STS, IAM, Secrets Manager, and more

**IntelliJ Platform**
- Platform-specific implementations for community, ultimate, and Rider editions
- Remote Robot for UI testing (v0.11.22)
- IDE Extensions for enhanced IDE integration

**Supporting Libraries**
- **Kotlin Coroutines** (1.8.0): Asynchronous programming
- **Jackson** (2.17.2): JSON/XML/YAML processing
- **Apache Commons**: Collections, IO, Text utilities
- **JGit** (6.5.0): Git operations
- **Mockito/MockK**: Testing frameworks
- **JUnit 4 & 5**: Test execution
- **WireMock** (3.9.1): HTTP mocking for tests
- **SSH Daemon** (2.13.2): SSH protocol support

### Development Infrastructure

- **CI/CD**: AWS CodeBuild with multiple test configurations
- **Code Quality**: 
  - SonarCloud for quality metrics
  - Detekt with custom rules for Kotlin linting
  - CodeCov for coverage tracking
- **Build Caching**: AWS S3-based remote build cache for faster builds
- **Develocity**: Gradle build scanning (opt-in with `--scan`)

## Repository Structure Overview

The repository follows a Gradle multi-project build structure optimized for emitting multiple release artifacts from a single monorepo:

```
aws-toolkit-jetbrains/
├── plugins/              # Main plugin implementations
│   ├── core/            # Core functionality shared across plugins
│   ├── toolkit/         # AWS Toolkit plugin
│   └── amazonq/         # Amazon Q plugin
├── buildSrc/            # Encapsulated build logic
├── detekt-rules/        # Custom Kotlin linting rules
├── ui-tests/            # UI testing framework
├── testdata/            # Test data and fixtures
├── designs/             # Design documents and specifications
├── buildspec/           # AWS CodeBuild specifications
└── gradle/              # Gradle wrapper and version catalog
```

### Source Code Organization

The repository uses a non-standard but developer-friendly source layout:
```
subproject/
├── src/                 # Main source code (Kotlin/Java)
├── tst/                 # Test code
├── resources/           # Resources (META-INF, icons, etc.)
├── src-{version}/       # Version-specific source (e.g., src-231-232)
├── tst-{version}/       # Version-specific tests
└── build.gradle.kts     # Build configuration
```

## Key Directories and Their Purposes

### `/plugins` - Primary Plugin Implementations

#### `/plugins/core` (`:plugin-core`)
**Purpose**: Shared core functionality for all plugins

Key subdirectories:
- **`jetbrains-community/`**: Community edition implementations
- **`jetbrains-ultimate/`**: Ultimate (paid) edition features
- **`sdk-codegen/`**: AWS SDK code generation
- **`resources/`**: Shared resources, icons, and assets
- **`webview/`**: Web-based UI components
- **`core/`**: Platform-independent core logic

**Output**: `plugin-core.zip` containing instrumented JARs for all platforms

#### `/plugins/toolkit` (`:plugin-toolkit`)
**Purpose**: AWS Toolkit plugin implementation

Key subdirectories:
- **`jetbrains-core/`**: Core AWS Toolkit functionality
- **`jetbrains-ultimate/`**: Ultimate edition-specific features (database tools)
- **`jetbrains-rider/`**: .NET/Rider-specific implementations
- **`jetbrains-gateway/`**: JetBrains Gateway support (IDE 242+)
- **`intellij-standalone/`**: Standalone IntelliJ distribution

**Features**: Lambda management, S3 operations, CloudFormation, CloudWatch Logs, RDS/Redshift integration

**Output**: `plugin-toolkit.zip` with platform-specific implementations

#### `/plugins/amazonq` (`:plugin-amazonq`)
**Purpose**: Amazon Q AI assistant implementation

Key subdirectories:
- **`codewhisperer/`**: Code completion and suggestions
  - `community/`: Community edition implementation
  - `ultimate/`: Ultimate edition enhancements
- **`chat/`**: Interactive chat interface
- **`codetransform/`** (formerly `codemodernizer/`): Code transformation features
- **`mynah-ui/`**: Web-based chat UI components
- **`shared/`**: Shared Amazon Q functionality
- **`src/`**: Main Amazon Q orchestration logic

**Features**: AI-powered code completion, chat assistance, code transformation, test generation, documentation assistance

**Output**: `plugin-amazonq.zip` with all Q-related functionality

### `/buildSrc` - Build Logic
**Purpose**: Gradle convention plugins and build utilities

Contains:
- Custom Gradle plugins for the build system
- Version management utilities
- IDE profile handling (supporting multiple IDE versions)
- Folder pattern matching for version-specific sources
- Common build configurations

### `/detekt-rules` - Code Quality
**Purpose**: Custom Kotlin static analysis rules

Contains:
- Custom Detekt rules specific to the project
- Detekt configuration (`detekt.yml`)
- License header enforcement
- Project-specific coding standards

### `/ui-tests` - UI Testing
**Purpose**: Automated UI testing for all plugins

Contains:
- IntelliJ Remote Robot-based UI tests
- Test fixtures for UI components
- Version-specific test implementations (`tst-241-242/`, `tst-243+/`)
- Test data and resources

### `/testdata` - Test Fixtures
**Purpose**: Test data, sample projects, and fixtures

Key subdirectories:
- **`samProjects/`**: Sample SAM applications for testing
  - `image/`: Docker-based Lambda projects (Python, Java, Node.js, Go)
  - `zip/`: ZIP-based Lambda deployments
- **`testFiles/`**: Various test files for different scenarios

Example Lambda project structure (in `testdata/samProjects/image/`):
```
python3.11/
├── template.yaml        # SAM template
└── hello_world/
    ├── Dockerfile       # Lambda container image
    ├── app.py          # Lambda handler
    └── requirements.txt # Python dependencies
```

### `/designs` - Design Documentation
**Purpose**: Architecture and design specifications

Contains:
- **`cloudWatch/`**: CloudWatch integration designs
- **`credentialManagement/`**: Authentication and credential handling
- **`errorMessaging/`**: Error handling strategies
- **`executableManagement/`**: External executable management (SAM CLI, Docker)
- **`resourceCache/`**: AWS resource caching strategies
- **`commonResourceActions/`**: Shared resource operation patterns

### `/buildspec` - CI/CD Configurations
**Purpose**: AWS CodeBuild pipeline definitions

Contains:
- `linuxTests.yml`: Linux-based test execution
- `linuxTestsForCore.yml`: Core plugin tests
- `linuxTestsForToolkit.yml`: Toolkit plugin tests
- `linuxTestsForAmazonQ.yml`: Amazon Q plugin tests
- `windowsTests*.yml`: Windows-specific test configurations
- `linuxIntegrationTests.yml`: Integration testing
- `linuxUiTests.yml`: UI testing pipeline

### Root-Level Important Files

- **`build.gradle.kts`**: Root build configuration
- **`settings.gradle.kts`**: Multi-project setup and plugin discovery
- **`gradle.properties`**: Gradle build properties
- **`gradle/libs.versions.toml`**: Centralized dependency version management
- **`CHANGELOG.md`**: Release notes and version history
- **`CONTRIBUTING.md`**: Contribution guidelines and development setup
- **`REPOLAYOUT.md`**: Detailed repository structure documentation
- **`README.md`**: Quick start guide and overview
- **`codecov.yml`**: Code coverage configuration
- **`qodana.yaml`**: JetBrains Qodana code quality tool configuration

## Architecture Patterns

### Multi-Platform Support
The project uses a layered approach to support different JetBrains IDE editions:
1. **Community** sourceset: Features available in free IDEs
2. **Ultimate** sourceset: Premium features (depends on Community)
3. **Rider** sourceset: .NET-specific features (depends on both)

### Version-Specific Code
Source folders can be conditionally included based on IDE version:
- `src-231-232/`: Only for IDE versions 2023.1-2023.2
- `src-231+/`: For IDE versions 2023.1 and later
- `tst-241/`: Tests specific to IDE version 2024.1

### Dependency Flow
```
Common → Plugin Core → (Toolkit Plugin, Amazon Q Plugin)
```
- All plugins depend on `plugin-core` for shared functionality
- `plugin-core` provides platform abstractions and AWS service integrations
- Individual plugins extend core with specific features

## Development Workflow

### Building the Project
```bash
# Build all plugins
./gradlew buildPlugin

# Build specific plugin
./gradlew :plugin-toolkit:intellij-standalone:buildPlugin

# Build for specific IDE version
./gradlew :plugin-toolkit:intellij-standalone:buildPlugin -PideProfileName=2024.1
```

### Running the Plugin
```bash
# Run in IDE sandbox (use project-specific command)
./gradlew :plugin-toolkit:intellij-standalone:runIde
```

### Testing
```bash
# Run all tests
./gradlew test

# Run specific plugin tests
./gradlew :plugin-amazonq:test
```

## Distribution and Installation

### Official Distribution
- Available on [JetBrains Marketplace](https://plugins.jetbrains.com/plugin/11349-aws-toolkit)
- Automatic updates through IDE plugin manager

### Early Access Preview (EAP)
- Add custom repository: `https://plugins.jetbrains.com/plugins/eap/aws.toolkit`
- Receive pre-release builds with latest features

### From Source
- Build using Gradle (see CONTRIBUTING.md)
- Install via IDE: `Plugins → Install Plugin from Disk...`

## Documentation and Resources

- **User Guide**: [AWS Toolkit for JetBrains Documentation](https://docs.aws.amazon.com/console/toolkit-for-jetbrains)
- **Issue Tracker**: [GitHub Issues](https://github.com/aws/aws-toolkit-jetbrains/issues)
- **Contributing Guide**: See CONTRIBUTING.md
- **License**: Apache 2.0 (see LICENSE)

## Project Metrics and Quality

- **Build Status**: Monitored via AWS CodeBuild
- **Code Coverage**: Tracked with CodeCov (available on GitHub)
- **Quality Gate**: SonarCloud analysis for code quality metrics
- **Download Statistics**: Available on JetBrains Marketplace
- **Version Tracking**: Semantic versioning with detailed changelogs

## Summary

The AWS Toolkit for JetBrains repository is a comprehensive, well-structured monorepo that delivers two major plugin products: the traditional AWS Toolkit for AWS service integration and Amazon Q for AI-powered development assistance. Built primarily in Kotlin using modern development practices, the project leverages a sophisticated multi-project Gradle build system to support multiple JetBrains IDE editions and versions. The repository demonstrates professional software engineering practices with extensive test coverage, continuous integration, detailed documentation, and active community engagement.
