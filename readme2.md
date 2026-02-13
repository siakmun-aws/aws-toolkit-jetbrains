# AWS Toolkit for JetBrains - Comprehensive Guide

[![Build Status](https://codebuild.eu-west-1.amazonaws.com/badges?uuid=eyJlbmNyeXB0ZWREYXRhIjoiekhxeERIMmNLSkNYUktnUFJzUVJucmJqWnFLMGlpNXJiNE1LLzVWV3B1QUpSSkhCS04veHZmUGxZZ0ZmZlRzYjJ3T1VtVEs1b3JxbWNVOHFOeFJDOTAwPSIsIml2UGFyYW1ldGVyU3BlYyI6ImZXNW5KaytDRGNLdjZuZDgiLCJtYXRlcmlhbFNldFNlcmlhbCI6MX0%3D&branch=master)](https://codebuild.eu-west-1.amazonaws.com)
[![Coverage](https://img.shields.io/codecov/c/github/aws/aws-toolkit-jetbrains/master.svg)](https://codecov.io/gh/aws/aws-toolkit-jetbrains/branch/master)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/11349-aws-toolkit.svg)](https://plugins.jetbrains.com/plugin/11349-aws-toolkit)
[![Version](https://img.shields.io/jetbrains/plugin/v/11349.svg?label=version)](https://plugins.jetbrains.com/plugin/11349-aws-toolkit)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=aws_aws-toolkit-jetbrains&metric=alert_status)](https://sonarcloud.io/dashboard?id=aws_aws-toolkit-jetbrains)

---

## Table of Contents

1. [Overview](#overview)
2. [Supported IDEs and Requirements](#supported-ides-and-requirements)
3. [Installation](#installation)
4. [Authentication](#authentication)
5. [Features](#features)
6. [Repository Structure](#repository-structure)
7. [Building from Source](#building-from-source)
8. [Running and Debugging Locally](#running-and-debugging-locally)
9. [Testing](#testing)
10. [Contributing](#contributing)
11. [Troubleshooting](#troubleshooting)
12. [Licensing](#licensing)

---

## Overview

AWS Toolkit for JetBrains is an open-source plugin that makes it easier to build applications on [Amazon Web Services](https://aws.amazon.com/) directly from your JetBrains IDE. It provides deep integration with AWS services including Lambda, S3, CloudFormation, CloudWatch Logs, Amazon Q, and more.

The plugin is distributed as multiple artifacts from a single monorepo:
- **plugin-core** - Shared core functionality used by all plugins
- **plugin-toolkit** - The AWS Toolkit plugin (resource explorer, Lambda, S3, etc.)
- **plugin-amazonq** - The Amazon Q plugin (AI assistant, inline suggestions, code transform, etc.)

---

## Supported IDEs and Requirements

### IDE Compatibility
All JetBrains IDEs **2024.1+** are supported, including:

| IDE | Edition | Notes |
|-----|---------|-------|
| IntelliJ IDEA | Community & Ultimate | Full support |
| PyCharm | Community & Professional | Python Lambda support in both editions |
| WebStorm | - | Requires `ALTERNATIVE_IDE` for local dev |
| Rider | - | .NET Lambda support |
| GoLand | - | Go Lambda support |
| CLion | - | Basic AWS Explorer support |
| RubyMine | - | Basic AWS Explorer support |
| PhpStorm | - | Basic AWS Explorer support |
| DataGrip | - | RDS/Redshift integration |
| JetBrains Gateway | - | Remote development support |

### Prerequisites
- **AWS Account** with IAM credentials configured
- **Java 21** (for building from source)
- **AWS SAM CLI** (for serverless features) - [Install Guide](https://github.com/awslabs/aws-sam-cli)
- **Docker** (for local Lambda execution)
- **.NET 6** (for building Rider-specific components)

---

## Installation

### From JetBrains Marketplace (Recommended)
1. Open your JetBrains IDE
2. Navigate to **Settings/Preferences > Plugins > Marketplace**
3. Search for "AWS Toolkit"
4. Click **Install** and restart the IDE

See the [official installation guide](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/install) for detailed instructions.

### Early Access Preview (EAP) Builds
1. Go to **Plugins > Gear Icon > Manage Plugin Repositories**
2. Add: `https://plugins.jetbrains.com/plugins/eap/aws.toolkit`
3. Check for updates to get the latest EAP build

### Installing from Source
See [Building from Source](#building-from-source) below.

---

## Authentication

The toolkit supports multiple authentication methods:

| Method | Use Case |
|--------|----------|
| **AWS Builder ID** | Free tier access to Amazon Q and CodeWhisperer |
| **IAM Identity Center (SSO)** | Enterprise access with organization policies |
| **Static Credentials** | Traditional access key + secret key pairs |
| **Credential Process** | External credential provider programs |
| **IAM Profiles** | Shared credential/config file profiles |

Configure authentication via the **AWS Explorer** panel or **Amazon Q** status bar menu. The toolkit supports `sso_session`, `source_profile`, `credential_source`, and `credential_process` profile keys.

[Learn more about authentication options](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/credentials)

---

## Features

### AWS Resource Explorer
Browse AWS resources in a tree view for your selected account/region. Supports a subset of resource types available in your account.
[Learn More](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/aws-explorer)

### Amazon Q (AI Assistant)
- **Chat** - Ask questions, get code suggestions, use `@workspace` for project-aware context
- **Inline Suggestions** - AI-powered code completions as you type (supports 15+ languages)
- **Inline Chat** - Select code and press `Cmd+I` (Mac) / `Ctrl+I` (Windows) for contextual edits
- **/dev** - Generate code changes from natural language descriptions
- **/transform** - Upgrade Java projects (e.g., Java 8/11/17 to Java 17/21), including SQL conversions
- **/review** - Scan code for vulnerabilities and quality issues with auto-fix
- **/test** - Generate unit tests for Java and Python
- **/doc** - Generate and update project documentation

### AWS Lambda
Requires [AWS SAM CLI](https://github.com/awslabs/aws-sam-cli). Supports **Java, Python, Node.js, .NET Core, Go, and TypeScript**.

- **Run/Debug Local Functions** - Test and step-through debug in a Lambda-like environment ([Learn More](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/lambda-local))
- **Invoke Remote Functions** - Invoke deployed functions with sharable run configs ([Learn More](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/lambda-remote))
- **Package & Deploy** - Package and create remote Lambda functions ([Learn More](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/lambda-deploy))
- **Sync SAM Applications** - Sync & track SAM-based applications ([Learn More](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/sam-deploy))

### AWS CloudFormation
- View stack events, resources, and outputs
- Deploy SAM templates directly from the IDE
- Color-coded stack status indicators

### CloudWatch Logs
- View and search log streams
- Filter and stream logs in real time
- Quick access to logs from Lambda and ECS containers

### Amazon S3
- Browse buckets and objects in a tree view
- Upload/download files (including drag-and-drop)
- Copy S3 URIs and object URLs
- View object versions
- [Learn More](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/s3-tasks)

### Amazon RDS / Redshift
Connect to databases using temporary IAM or Secrets Manager credentials (requires paid JetBrains IDE).
Supports RDS MySQL, PostgreSQL, MariaDB, Aurora, and Redshift.

### Amazon DynamoDB
- View table data in an interactive viewer

### Amazon ECR
- Browse repositories
- Build and push local Docker images

### Amazon SQS
- Browse queues
- Send and poll messages

### Amazon EventBridge
- Discover schemas in the EventBridge Schema Registry
- Generate code bindings (Java, Python, TypeScript, Go)

### AWS App Runner
- Create, delete, pause, resume, and deploy services
- View service logs

### Experimental Features
Enable via **Settings > Tools > AWS > Experimental Features** or the gear icon in the AWS Explorer. These features may have bugs and can be removed at any time.

---

## Repository Structure

This is a Gradle multi-project build. Key directories:

```
aws-toolkit-jetbrains/
  buildSrc/              # Encapsulated build logic and custom Gradle plugins
  common/                # Shared utilities across all artifacts
  detekt-rules/          # Custom detekt linting rules
  ui-tests/              # UI tests for all artifacts
  plugins/
    core/                # plugin-core: shared IDE integration layer
      sdk-codegen/       # Auto-generated AWS SDK clients
      community/         # Code for community (free) IDEs
      ultimate/          # Code for ultimate (paid) IDEs
      rider/             # Rider-specific code
    toolkit/             # plugin-toolkit: AWS resource management
      community/
      ultimate/
      rider/
      gateway/           # JetBrains Gateway support
    amazonq/             # plugin-amazonq: AI assistant features
      codewhisperer/     # Inline suggestion engine
      codemodernizer/    # /transform feature
      mynah-ui/          # Chat UI component
    toolbox/             # JetBrains Toolbox plugin
  designs/               # Architecture design documents
```

All new code must be written in **Kotlin** following [Kotlin coding conventions](https://kotlinlang.org/docs/coding-conventions.html). Java is discouraged.

Source directories use a non-standard layout (`src/`, `tst/`, `resources/`) instead of the Gradle default. Version-specific source sets (e.g., `src-241+`) are included conditionally based on the target IDE version.

See [REPOLAYOUT.md](REPOLAYOUT.md) for the full layout and dependency graph.

---

## Building from Source

### Requirements
- [Java 21](https://docs.aws.amazon.com/corretto/latest/corretto-21-ug/downloads-list.html) (Amazon Corretto recommended)
- [Git](https://git-scm.com/)
- .NET 6 (for Rider components; `brew install dotnet@6` on macOS)

### Build Steps
```bash
# Clone the repository
git clone https://github.com/aws/aws-toolkit-jetbrains.git
cd aws-toolkit-jetbrains

# Build all plugins
./gradlew buildPlugin

# Build a specific plugin
./gradlew :plugin-toolkit:intellij-standalone:buildPlugin
./gradlew :plugin-core:buildPlugin
./gradlew :plugin-amazonq:buildPlugin

# Build for a specific IDE version
./gradlew :plugin-toolkit:intellij-standalone:buildPlugin -PideProfileName=2024.1
```

Output ZIPs are under `plugins/<name>/build/distributions/`. Install via **Plugins > Install Plugin from Disk** in your IDE.

---

## Running and Debugging Locally

### IDE Approach (Recommended)
Use the provided IntelliJ run configurations. Running with Debug mode auto-attaches a debugger to the sandbox IDE.

### Command Line
```bash
# IntelliJ IDEA Community
./gradlew :plugin-toolkit:intellij-standalone:runIde -PrunIdeVariant=IC
./gradlew :plugin-amazonq:runIde -PrunIdeVariant=IC
./gradlew :sandbox-all:runIde -PrunIdeVariant=IC

# IntelliJ IDEA Ultimate
./gradlew :plugin-toolkit:intellij-standalone:runIde -PrunIdeVariant=IU

# Rider
./gradlew :plugin-toolkit:intellij-standalone:runIde -PrunIdeVariant=RD

# Gateway
./gradlew :plugin-toolkit:jetbrains-gateway:runIde

# PyCharm/WebStorm (requires local installation)
ALTERNATIVE_IDE=/path/to/ide ./gradlew :plugin-toolkit:intellij-standalone:runIde
```

### Logging
Logs are written to `plugins/toolkit/intellij/build/idea-sandbox/system/log/idea.log`. Enable DEBUG logging by adding `software.aws.toolkits` in **Help > Debug Log Settings** in the sandbox IDE.

> **Warning**: Debug logs may contain sensitive information. Do not share them publicly.

---

## Testing

### Unit Tests
No network calls required, safe for all contributors:
```bash
./gradlew check
```

### Integration Tests
**Not recommended for external contributors** - these create and mutate real AWS resources.
```bash
# Requires valid AWS credentials and SAM CLI on $PATH
./gradlew integrationTest
```

### UI Tests
**Not recommended for external contributors** - same caveats as integration tests.
```bash
./gradlew :ui-tests:uiTestCore
```

The sandbox IDE runs with debug port `5005` open. Create a Java Remote Debug configuration to attach. Set `suspend.set(true)` in `RunIdeForUiTestTask` to pause until debugger connects.

---

## Contributing

We welcome contributions! Please read [CONTRIBUTING.md](CONTRIBUTING.md) for full details.

### Quick Start
1. Fork the repository and work against the **main** branch
2. Check [existing issues](https://github.com/aws/aws-toolkit-jetbrains/issues) before opening new ones
3. All changes must include automated tests
4. Run `./gradlew check` before submitting
5. Generate a changelog entry: `./gradlew :newChange --console plain`
6. Submit a pull request using the provided template

### Guidelines
- AWS Explorer must not require external dependencies (e.g., SAM CLI, Docker)
- Dependencies should be fetched lazily when the user interacts with a feature
- All new code must be Kotlin (no new Java code)

### Finding Work
Look for issues labeled [help wanted](https://github.com/aws/aws-toolkit-jetbrains/issues?q=is%3Aissue+is%3Aopen+label%3A%22help+wanted%22).

---

## Troubleshooting

| Problem | Solution |
|---------|----------|
| Gradle can't find `dotnet` | Run `./gradlew --stop && ./gradlew projects` to reload the daemon |
| SAM CLI not detected | Ensure `sam` is on your `$PATH` and version >= 1.0.0 |
| Plugin not loading in IDE | Verify IDE version is 2024.1+ |
| SSO login 404 errors | Avoid multiple rapid login attempts |
| `@workspace` high CPU | The index auto-pauses when OS CPU load is high |
| Builder ID re-auth loop | Update to latest plugin version |

For more help:
- [File a bug report](https://github.com/aws/aws-toolkit-jetbrains/issues/new?labels=bug&template=bug_report.md)
- [Request a feature](https://github.com/aws/aws-toolkit-jetbrains/issues/new?labels=feature-request&template=feature_request.md)
- [Ask a question](https://github.com/aws/aws-toolkit-jetbrains/issues/new?labels=guidance&template=guidance_request.md)

---

## Additional References

- [IntelliJ Platform SDK Documentation](https://plugins.jetbrains.com/docs/intellij/welcome.html)
- [Kotlin in IntelliJ Plugins](https://plugins.jetbrains.com/docs/intellij/kotlin.html#kotlin-standard-library)
- [JetBrains UI Guidelines](https://jetbrains.design/intellij/)
- [Rider SDK Documentation](https://www.jetbrains.com/help/resharper/sdk/Rider.html)
- [IDE Directories Reference](https://intellij-support.jetbrains.com/hc/en-us/articles/206544519)

---

## Code of Conduct

This project follows the [Amazon Open Source Code of Conduct](https://aws.github.io/code-of-conduct). Contact [opensource-codeofconduct@amazon.com](mailto:opensource-codeofconduct@amazon.com) with questions.

## Licensing

Licensed under the [Apache License 2.0](LICENSE). Contributors may be asked to sign a [CLA](http://en.wikipedia.org/wiki/Contributor_License_Agreement) for larger changes.
