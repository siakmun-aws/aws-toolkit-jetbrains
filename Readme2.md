# AWS Toolkit for JetBrains - Supplementary Overview

## Project Summary

The AWS Toolkit for JetBrains is an open-source plugin that integrates Amazon Web Services into JetBrains IDEs (version 2023.3 and later). It provides developers with a seamless experience for building, testing, debugging, and deploying AWS-based applications directly from their IDE, without needing to switch between the IDE and the AWS Management Console.

## Tech Stack

- **Language**: Kotlin (all new code is written in Kotlin; Java usage is discouraged)
- **Build System**: Gradle, configured as a multi-project build with `build.gradle.kts` and `settings.gradle.kts` at the root
- **Build Logic**: Encapsulated in `buildSrc/` following standard Gradle conventions
- **Plugin Ecosystem**: Built on the JetBrains IntelliJ Platform SDK using the Gradle IntelliJ Plugin for packaging, sandboxing, and distribution
- **Static Analysis**: Custom detekt rules for Kotlin linting
- **Runtime Requirements**: Java 21, .NET 6 (for Rider support), and optionally the AWS SAM CLI and Docker for serverless features
- **IDE Compatibility**: Supports multiple IDE variants (Community, Ultimate, Rider, Gateway) through platform-specific sourcesets

## Repository Structure

| Directory | Purpose |
|-----------|---------|
| `buildSrc/` | Encapsulated Gradle build logic, custom plugins, and shared build conventions |
| `plugins/core/` | Core plugin module providing foundational APIs, SDK code generation, and shared resources used by other plugin artifacts |
| `plugins/toolkit/` | The AWS Toolkit plugin artifact with support for CloudFormation, Lambda, S3, RDS/Redshift, and other AWS services |
| `plugins/amazonq/` | The Amazon Q plugin artifact, including CodeWhisperer, Code Modernizer (Transform), and the Mynah UI chat component |
| `common/` | Common utilities shared across all release artifacts |
| `detekt-rules/` | Custom detekt static analysis rules and configuration for the entire repository |
| `ui-tests/` | UI-level tests for all release artifacts |
| `testdata/` | Shared test fixtures and data files |
| `designs/` | Design documents and proposals |
| `buildspec/` | Build specification files (for CI/CD) |
| `gradle/` | Gradle wrapper files and version catalog |
| `sandbox-all/` | Aggregated sandbox configuration for running all plugins together in a single IDE instance |

Each plugin directory is further divided into platform-specific sub-projects (`community/`, `ultimate/`, `rider/`) to segment code based on IDE-level dependencies. Version-specific source folders (e.g., `src-231-232/`) allow conditional compilation for different IDE major versions.

## Key Features

### General
- **AWS Resource Explorer** - A tree view of AWS resources in the selected account and region
- **Authentication** - Connect to AWS using static credentials, credential process, AWS Builder ID, or AWS SSO

### AWS Services
- **AWS CloudFormation** - View events, resources, and outputs for CloudFormation stacks
- **CloudWatch Logs** - View and search log streams
- **AWS Lambda** - Run and debug functions locally (via SAM CLI), invoke remote functions, package and deploy Lambda functions, and sync SAM-based applications. Supports Java, Python, Node.js, and .NET Core
- **Amazon RDS/Redshift** - Connect to databases using temporary IAM or Secrets Manager credentials (requires a paid JetBrains IDE)
- **Amazon S3** - View, manage, upload to, and download from S3 buckets

### Amazon Q Integration
- **CodeWhisperer** - AI-powered code suggestions and completions
- **Code Transform** - Automated code modernization (e.g., Java version upgrades)
- **Code Review** - AI-assisted code review with issue detection
- **Doc Generation** - Generate and update documentation, including architecture diagrams
- **Unit Test Generation** - AI-powered test generation for source files

### Experimental Features
Some features are available behind feature flags and can be enabled via `Settings -> Tools -> AWS -> Experimental Features`. These may be incomplete or removed at any time.

## Getting Started

### Installation
Install the plugin from the [JetBrains Marketplace](https://plugins.jetbrains.com/plugin/11349-aws-toolkit) or through your IDE's plugin manager. Early Access Preview (EAP) builds are also available by adding the EAP plugin repository URL to your IDE.

### Building from Source
Building requires Java 21, Git, and .NET 6. Clone the repository and run:

```bash
./gradlew buildPlugin
```

For a specific plugin artifact:

```bash
./gradlew :plugin-toolkit:intellij-standalone:buildPlugin
```

See [CONTRIBUTING.md](CONTRIBUTING.md#building-from-source) for full build instructions, including how to target specific IDE versions.

### Running and Debugging
Use the provided IntelliJ run configurations or invoke Gradle directly:

```bash
./gradlew :sandbox-all:runIde -PrunIdeVariant=IC
```

### Running Tests
```bash
./gradlew check
```

For more details on contributing, running integration tests, UI tests, and debugging, see [CONTRIBUTING.md](CONTRIBUTING.md).

## Related Documentation

- [README.md](README.md) - Primary project README with feature overview and installation instructions
- [CONTRIBUTING.md](CONTRIBUTING.md) - Contributing guidelines, build instructions, and development workflow
- [CHANGELOG.md](CHANGELOG.md) - Release history and change log for all versions
- [REPOLAYOUT.md](REPOLAYOUT.md) - Detailed repository layout documentation with dependency diagrams
- [LICENSE](LICENSE) - Apache License 2.0
