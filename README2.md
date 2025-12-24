# AWS Toolkit for JetBrains - Comprehensive Overview

[![Build Status](https://codebuild.eu-west-1.amazonaws.com/badges?uuid=eyJlbmNyeXB0ZWREYXRhIjoiekhxeERIMmNLSkNYUktnUFJzUVJucmJqWnFLMGlpNXJiNE1LLzVWV3B1QUpSSkhCS04veHZmUGxZZ0ZmZlRzYjJ3T1VtVEs1b3JxbWNVOHFOeFJDOTAwPSIsIml2UGFyYW1ldGVyU3BlYyI6ImZXNW5KaytDRGNLdjZuZDgiLCJtYXRlcmlhbFNldFNlcmlhbCI6MX0%3D&bra<TRUNCATED>
[![Coverage](https://img.shields.io/codecov/c/github/aws/aws-toolkit-jetbrains/master.svg)](https://codecov.io/gh/aws/aws-toolkit-jetbrains/branch/master)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/11349-aws-toolkit.svg)](https://plugins.jetbrains.com/plugin/11349-aws-toolkit)
[![Version](https://img.shields.io/jetbrains/plugin/v/11349.svg?label=version)](https://plugins.jetbrains.com/plugin/11349-aws-toolkit)

## Overview

The **AWS Toolkit for JetBrains** is a comprehensive plugin ecosystem that brings Amazon Web Services (AWS) functionality directly into JetBrains IDEs. This open-source project makes it easier for developers to build, debug, deploy, and manage applications on AWS without leaving their familiar development environment.

The project consists of multiple integrated plugins that provide both traditional AWS development tools and cutting-edge AI-powered development assistance through Amazon Q and CodeWhisperer.

## Purpose and Mission

The AWS Toolkit for JetBrains aims to:

- **Streamline AWS Development**: Provide seamless integration between JetBrains IDEs and AWS services
- **Enhance Developer Productivity**: Offer AI-powered code assistance and intelligent development features
- **Simplify Cloud Operations**: Enable developers to manage AWS resources directly from their IDE
- **Support Modern Development Workflows**: Facilitate serverless development, containerization, and cloud-native architectures

## Supported JetBrains IDEs

The toolkit supports **all JetBrains IDEs 2023.3+**, including:

### Community and Professional IDEs
- **IntelliJ IDEA** (Community and Ultimate)
- **PyCharm** (Community and Professional)
- **WebStorm**
- **PhpStorm**
- **RubyMine**
- **CLion**
- **GoLand**
- **DataGrip**
- **AppCode**

### Enterprise and Specialized IDEs
- **JetBrains Rider** (.NET development)
- **JetBrains Gateway** (remote development)

### Language and Framework Support
The toolkit provides extensive language support including:
- Java, Kotlin, Scala
- Python
- JavaScript, TypeScript, Node.js, Vue.js
- C#, .NET Core
- Go, Rust, Swift
- PHP, Ruby
- Shell scripting, PowerShell
- Lua, R
- SystemVerilog
- Infrastructure as Code (CloudFormation, Terraform)

## Key Features and Capabilities

### 🤖 Amazon Q Integration

**Amazon Q** is the most capable generative AI-powered assistant for software development, offering:

#### Agent Capabilities
- **`/dev`** - Implement new features across entire projects
- **`/doc`** - Generate API documentation, technical designs, and onboarding materials
- **`/review`** - Automated code reviews with security pattern detection and risk assessment
- **`/test`** - Generate comprehensive unit tests with improved code coverage
- **`/transform`** - Modernize Java applications and upgrade workloads efficiently

#### Core AI Features
- **Inline Code Suggestions**: Real-time code completions from snippets to full functions
- **Interactive Chat**: Get answers about software development and generate code explanations
- **Inline Chat**: Context-aware assistance directly in the editor for code optimization and enhancement
- **Code Reference Logging**: Attribution system for code similar to training data

### ⚡ CodeWhisperer Features

CodeWhisperer (now part of Amazon Q) provides:
- **Intelligent Code Completions**: Context-aware suggestions in 15+ programming languages
- **Security Scanning**: Automatic detection of security vulnerabilities and coding issues
- **Reference Tracking**: Transparency for code suggestions similar to open-source training data

### 🛠️ AWS Development Tools

#### Authentication & Access Management
- **Multiple Authentication Methods**: 
  - AWS Builder ID (personal profiles)
  - AWS Single Sign-On (SSO)
  - Static credentials and credential processes
  - IAM roles and temporary credentials

#### AWS Lambda Development
- **Local Testing & Debugging**: Step-through debugging in Lambda-like environments using AWS SAM CLI
- **Remote Function Invocation**: Test deployed functions with shareable run configurations
- **Package & Deploy**: Direct deployment of Lambda functions from the IDE
- **Multi-Language Support**: Java, Python, Node.js, .NET Core

#### Serverless Application Model (SAM) Integration
- **SAM Application Deployment**: Package, deploy, and track SAM-based applications
- **Local SAM Development**: Full local development and testing capabilities
- **Template Management**: Create and modify SAM templates directly in the IDE

#### AWS Service Integration
- **AWS Resource Explorer**: Tree-view navigation of AWS resources by account/region
- **CloudFormation**: View stack events, resources, and outputs
- **CloudWatch Logs**: Stream viewing and log searching capabilities
- **Amazon S3**: Bucket management with upload/download functionality
- **Amazon RDS/Redshift**: Database connectivity using temporary IAM credentials
- **Amazon CodeCatalyst**: Unified software development service integration

## Main Components and Architecture

The repository follows a sophisticated multi-project Gradle build structure designed for modularity and maintainability:

### Core Plugin Architecture

```
aws-toolkit-jetbrains/
├── plugins/
│   ├── core/           # :plugin-core - Shared foundation
│   ├── toolkit/        # :plugin-toolkit - AWS development tools
│   └── amazonq/        # :plugin-amazonq - AI-powered features
├── buildSrc/           # Gradle build logic and conventions
├── detekt-rules/       # Code quality and style enforcement
├── ui-tests/          # Comprehensive UI testing framework
└── testdata/          # Testing resources and sample projects
```

### Plugin Components Breakdown

#### 1. **Core Plugin** (`:plugin-core`)
- **Foundation Layer**: Shared utilities and common functionality
- **SDK Code Generation**: AWS SDK integration and code generation tools
- **Multi-Platform Support**: Community, Ultimate, and Rider platform compatibility
- **Resource Management**: Icon resources and shared assets

#### 2. **Toolkit Plugin** (`:plugin-toolkit`)
- **AWS Service Integration**: Core AWS development tools
- **Platform-Specific Implementations**:
  - `community/` - Community IDE features
  - `ultimate/` - Ultimate IDE enhanced features  
  - `rider/` - .NET/Rider specific functionality
  - `gateway/` - Remote development support
- **Traditional AWS Development**: Lambda, S3, CloudFormation, etc.

#### 3. **Amazon Q Plugin** (`:plugin-amazonq`)
- **AI-Powered Development**: Modern generative AI features
- **Component Architecture**:
  - `codewhisperer/` - Code completion and suggestions
  - `chat/` - Interactive AI conversation interface
  - `codetransform/` - Code modernization and transformation
  - `mynah-ui/` - User interface components for AI features
  - `shared/` - Common AI functionality across features

### Development Infrastructure

#### Build System (Gradle with Kotlin DSL)
- **Multi-Project Build**: Sophisticated Gradle configuration supporting multiple discrete release artifacts
- **Kotlin DSL**: Modern, type-safe build configuration
- **Version Management**: Centralized dependency and version management via `libs.versions.toml`
- **IDE Profile Support**: Build targeting for specific JetBrains IDE versions

#### Code Quality & Standards
- **Detekt Integration**: Kotlin-specific static analysis with custom rules
- **Comprehensive Testing**: Unit tests, integration tests, and UI automation
- **CI/CD Pipeline**: Automated builds for Linux and Windows platforms
- **Code Coverage**: Comprehensive coverage tracking with Codecov integration

## Testing Capabilities

### Multi-Layered Testing Strategy

#### 1. **Unit Testing**
- **Comprehensive Coverage**: Individual component and function testing
- **Platform-Specific Tests**: Separate test suites for different IDE platforms
- **Mock Integration**: Extensive AWS service mocking for isolated testing

#### 2. **Integration Testing**
- **AWS Service Integration**: Real AWS service interaction testing
- **Cross-Platform Validation**: Testing across multiple JetBrains IDE versions
- **Authentication Flow Testing**: Complete authentication scenario validation

#### 3. **UI Testing**
- **Automated UI Tests**: Full user interaction simulation
- **Multi-IDE Compatibility**: Testing across different JetBrains products
- **Visual Regression Testing**: Ensuring UI consistency across updates

#### 4. **Test Data and Samples**
- **Sample Projects**: Complete sample applications in `testdata/samProjects/`
- **Docker Integration**: Container-based testing environments
- **Language-Specific Samples**: Testing resources for Java, Python, Node.js, .NET

### Testing Infrastructure
- **BuildSpec Configuration**: Separate CI/CD configurations for different testing scenarios
- **Platform-Specific Builds**: Linux and Windows testing pipelines
- **Performance Testing**: Load and performance validation for AI features
- **Security Testing**: Automated security scanning and vulnerability assessment

## Installation and Usage Information

### For End Users

#### Installation Methods
1. **JetBrains Marketplace**: Direct installation from the official plugin repository
2. **Early Access Preview (EAP)**: Opt-in beta builds via custom repository URL
3. **Manual Installation**: Build from source for development and testing

#### Prerequisites
- **JetBrains IDE**: Any supported IDE version 2023.3+
- **AWS Account**: Required for AWS service access
- **Local Development Tools** (for serverless development):
  - AWS CLI
  - Docker
  - AWS SAM CLI

#### Getting Started
1. Install the plugin from JetBrains Marketplace
2. Configure AWS credentials using one of the supported authentication methods
3. Access AWS features through the AWS Explorer tool window
4. Enable Amazon Q features for AI-powered development assistance

### For Contributors and Developers

#### Development Prerequisites
- **Java 21**: Amazon Corretto or equivalent JDK
- **Git**: Version control system
- **.NET 6**: Required for Rider plugin development
- **Gradle**: Build automation (included via wrapper)

#### Development Setup
1. **Clone Repository**: `git clone https://github.com/aws/aws-toolkit-jetbrains.git`
2. **Build All Plugins**: `./gradlew buildPlugin`
3. **Build Specific Plugin**: `./gradlew :plugin-toolkit:intellij-standalone:buildPlugin`
4. **Run Development IDE**: Use plugin-specific `runIde` tasks
5. **Run Tests**: `./gradlew check`

#### Development Workflow
- **Code Standards**: Kotlin-first development with established coding conventions
- **Testing Requirements**: All changes must include automated tests
- **Change Log**: Generate change log entries for user-visible changes
- **Pull Request Process**: Follow established contribution guidelines

#### IDE-Specific Development
- **IntelliJ/PyCharm/WebStorm**: Use `intellij-standalone` project
- **Rider Development**: Additional .NET SDK requirements and RdGen protocol integration
- **Gateway Support**: Remote development environment configuration

## Project Structure Deep Dive

### Source Code Organization
```
plugins/
├── core/
│   ├── jetbrains-community/    # Community IDE core functionality
│   ├── jetbrains-ultimate/     # Ultimate IDE enhanced features
│   ├── jetbrains-rider/        # Rider-specific core features
│   └── resources/              # Shared resources and icons
├── toolkit/
│   ├── intellij-standalone/    # Standalone IntelliJ/PyCharm/WebStorm
│   ├── jetbrains-ultimate/     # Ultimate IDE toolkit features
│   ├── jetbrains-rider/        # Rider toolkit features
│   ├── jetbrains-gateway/      # Gateway remote development
│   └── jetbrains-core/         # Core toolkit functionality
└── amazonq/
    ├── shared/                 # Common AI functionality
    ├── codewhisperer/          # Code completion engine
    ├── chat/                   # Conversational AI interface
    ├── codetransform/          # Code modernization tools
    └── mynah-ui/              # AI user interface components
```

### Build Configuration Highlights
- **Modular Architecture**: Independent plugin development and release cycles
- **Platform Abstraction**: Shared code with platform-specific extensions
- **Version Compatibility**: Support for multiple IDE major versions simultaneously
- **Dependency Management**: Centralized version catalogs and dependency resolution

## Community and Ecosystem

### Open Source Commitment
- **GitHub Repository**: Fully open source with active community involvement
- **Issue Tracking**: Public issue tracking and feature request system
- **Pull Request Welcome**: Community contributions encouraged and supported
- **Transparent Development**: Open development process with public roadmaps

### Support and Resources
- **Documentation**: Comprehensive user guides and developer documentation
- **Community Feedback**: Active engagement with user feedback and feature requests
- **Professional Support**: Enterprise support options available through AWS
- **Regular Updates**: Frequent releases with new features and improvements

---

*The AWS Toolkit for JetBrains represents a comprehensive solution for modern cloud-native development, combining traditional AWS development tools with cutting-edge AI capabilities to enhance developer productivity and streamline the software development lifecycle.*