# AWS Toolkit for JetBrains - Repository Summary

## Repository Name and Purpose

**Repository Name:** `aws-toolkit-jetbrains`

**Purpose:** The AWS Toolkit for JetBrains is an open-source plugin suite for JetBrains IDEs that simplifies the development of applications built on Amazon Web Services (AWS). It provides developers with seamless integration between their IDE and various AWS services, enabling easier cloud application development, debugging, and deployment workflows.

The toolkit supports all JetBrains IDEs version 2023.3 and above, including IntelliJ IDEA (Community and Ultimate), PyCharm, WebStorm, Rider, and JetBrains Gateway.

### Key Features
- **AWS Resource Explorer** - Tree-view navigation of AWS resources in your selected account/region
- **Authentication** - Support for static credentials, credential process, AWS Builder ID, and AWS SSO
- **AWS Lambda** - Local run/debug, remote invocation, and deployment of Lambda functions
- **CloudFormation** - View events, resources, and outputs for CloudFormation stacks
- **CloudWatch Logs** - View and search CloudWatch log streams
- **Amazon S3** - View, manage, upload, and download from S3 buckets
- **Amazon RDS/Redshift** - Database connections using IAM/SecretsManager temporary credentials
- **Amazon Q Integration** - AI-powered coding assistant with chat, code suggestions, and code transformation capabilities

---

## Main Technologies Used

### Primary Languages
| Technology | Purpose |
|------------|---------|
| **Kotlin** | Primary development language for plugin logic (99%+ of codebase) |
| **TypeScript** | Web UI components (Mynah UI, webview components) |
| **Java** | Legacy code (minimal, being phased out) |

### Build System
| Tool | Version | Purpose |
|------|---------|---------|
| **Gradle** | - | Build automation and dependency management |
| **Gradle Kotlin DSL** | - | Build script configuration |
| **IntelliJ Platform Gradle Plugin** | 2.2.1 | JetBrains plugin development |

### Key Dependencies
| Category | Technology | Version |
|----------|------------|---------|
| **Language** | Kotlin | 2.0.0 |
| **AWS SDK** | AWS SDK for Java v2 | 2.26.25 |
| **Async** | Kotlin Coroutines | 1.8.0 |
| **Serialization** | Jackson | 2.17.2 |
| **Code Quality** | Detekt | 1.23.7 |
| **Testing** | JUnit 5 | 5.11.0 |
| **Testing** | MockK | 1.13.10 |
| **Testing** | AssertJ | 3.26.3 |
| **UI Testing** | IntelliJ Remote Robot | 0.11.22 |

### Frontend Technologies (Mynah UI)
- TypeScript 4.5.2
- Webpack 5.94.0
- SASS for styling
- ESLint for code quality

---

## Key Components

### 1. Plugin Core (`:plugin-core`)
The foundational plugin that provides shared functionality across all AWS Toolkit plugins.

**Submodules:**
- **`core/`** - Core utilities and base implementations
- **`jetbrains-community/`** - Code for community edition IDEs
- **`jetbrains-ultimate/`** - Extensions for paid/ultimate IDEs
- **`sdk-codegen/`** - AWS SDK code generation utilities
- **`resources/`** - Shared resources (icons, configurations)
- **`webview/`** - Web-based UI components

### 2. Plugin Toolkit (`:plugin-toolkit`)
The main AWS Toolkit plugin providing AWS service integrations.

**Submodules:**
- **`jetbrains-core/`** - Core toolkit functionality for all JetBrains IDEs
- **`jetbrains-ultimate/`** - Features requiring ultimate/paid IDE features
- **`jetbrains-rider/`** - .NET/Rider-specific implementations
- **`jetbrains-gateway/`** - JetBrains Gateway remote development support
- **`intellij-standalone/`** - Standalone IntelliJ configuration

### 3. Plugin Amazon Q (`:plugin-amazonq`)
Integration with Amazon Q, AWS's AI-powered coding assistant.

**Submodules:**
- **`chat/`** - Amazon Q chat interface implementation
- **`codewhisperer/`** - AI code suggestions (formerly CodeWhisperer)
- **`codetransform/`** - Code modernization and transformation features
- **`mynah-ui/`** - TypeScript-based chat UI component
- **`shared/`** - Shared Amazon Q utilities

### 4. UI Tests (`:ui-tests`)
Comprehensive UI testing framework using IntelliJ Remote Robot.

### 5. Detekt Rules (`:detekt-rules`)
Custom static analysis rules for code quality enforcement across the repository.

### 6. Build Source (`:buildSrc`)
Encapsulated Gradle build logic including:
- Custom Gradle plugins
- Version management
- Build configuration tasks
- Changelog generation

---

## Project Structure Overview

```
aws-toolkit-jetbrains/
├── build.gradle.kts              # Root build configuration
├── settings.gradle.kts           # Multi-project settings
├── gradle/
│   └── libs.versions.toml        # Centralized dependency versions
│
├── buildSrc/                     # Custom Gradle build logic
│   └── src/
│       ├── main/                 # Build plugins and utilities
│       └── test/                 # Build logic tests
│
├── plugins/                      # Main plugin modules
│   ├── core/                     # Core plugin (:plugin-core)
│   │   ├── core/                 # Base utilities
│   │   ├── jetbrains-community/  # Community IDE support
│   │   ├── jetbrains-ultimate/   # Ultimate IDE support
│   │   ├── resources/            # Shared resources
│   │   ├── sdk-codegen/          # AWS SDK generation
│   │   └── webview/              # Web UI components
│   │
│   ├── toolkit/                  # Toolkit plugin (:plugin-toolkit)
│   │   ├── jetbrains-core/       # Core functionality
│   │   ├── jetbrains-ultimate/   # Ultimate features
│   │   ├── jetbrains-rider/      # Rider/.NET support
│   │   ├── jetbrains-gateway/    # Gateway support
│   │   └── intellij-standalone/  # Standalone config
│   │
│   └── amazonq/                  # Amazon Q plugin (:plugin-amazonq)
│       ├── chat/                 # Chat interface
│       ├── codewhisperer/        # Code suggestions
│       ├── codetransform/        # Code transformation
│       ├── mynah-ui/             # TypeScript UI (npm)
│       └── shared/               # Shared utilities
│
├── detekt-rules/                 # Custom code quality rules
│   ├── src/                      # Rule implementations
│   ├── tst/                      # Rule tests
│   └── detekt.yml                # Detekt configuration
│
├── ui-tests/                     # UI test framework
│   ├── tst/                      # Test implementations
│   └── tst-resources/            # Test resources
│
├── ui-tests-starter/             # UI test bootstrap
│   ├── tst-241-242/              # Version-specific tests
│   └── tst-243+/                 # Newer version tests
│
├── testdata/                     # Shared test data
│   ├── samProjects/              # SAM project templates
│   └── testFiles/                # Test input files
│
├── buildspec/                    # CI/CD build specifications
├── designs/                      # Design documents
├── marketplaceGifs/              # JetBrains Marketplace assets
│
├── CHANGELOG.md                  # Release changelog
├── CONTRIBUTING.md               # Contribution guidelines
├── README.md                     # Main documentation
├── REPOLAYOUT.md                 # Repository structure docs
└── LICENSE                       # Apache 2.0 License
```

### Source Directory Conventions

The project uses non-standard source directories for better organization:

```
subproject/
├── src/                 # Main source code (Kotlin/Java)
├── tst/                 # Test source code
├── it/                  # Integration tests
├── resources/           # Runtime resources
├── tstFixtures/         # Test fixtures
├── tst-resources/       # Test-only resources
├── src-241-242/         # Version-specific code (IDE 2024.1-2024.2)
├── src-243+/            # Code for IDE 2024.3+
└── build.gradle.kts     # Module build config
```

---

## File Type Distribution Highlights

| File Type | Count | Description |
|-----------|-------|-------------|
| **Kotlin (`.kt`)** | ~1,907 | Primary source files |
| **JSON (`.json`)** | ~209 | Configuration, test data, package manifests |
| **XML (`.xml`)** | ~138 | Plugin descriptors, IDE configs, test resources |
| **Gradle (`.gradle.kts`)** | ~50 | Build configurations |
| **TypeScript (`.ts`)** | ~41 | Web UI components |
| **YAML (`.yml`)** | ~39 | CI/CD, configuration files |
| **Markdown (`.md`)** | ~18 | Documentation |
| **Java (`.java`)** | ~10 | Legacy code (minimal) |

### Key Observations

1. **Kotlin-First Approach**: The repository strongly favors Kotlin over Java, with new code exclusively written in Kotlin following standard [Kotlin coding conventions](https://kotlinlang.org/docs/coding-conventions.html).

2. **Multi-IDE Support**: The architecture supports multiple JetBrains IDEs through platform-specific sourcesets (community, ultimate, rider).

3. **Version Compatibility**: Source directories with version suffixes (e.g., `src-241-242`, `src-243+`) enable maintaining compatibility across multiple IDE major versions.

4. **Monorepo Structure**: Multiple discrete release artifacts (plugin-core.zip, plugin-toolkit.zip, plugin-amazonq.zip) are built from a single repository.

5. **TypeScript for UI**: Web-based UI components (especially Amazon Q chat) use TypeScript with webpack for bundling.

---

## Build and Development

### Prerequisites
- JDK 17 or higher
- Gradle (wrapper included)
- Node.js (for TypeScript components)
- AWS CLI, Docker, and SAM CLI (for full feature testing)

### Quick Start
```bash
# Build the project
./gradlew build

# Run specific plugin in IDE
./gradlew :plugin-toolkit:intellij-standalone:runIde

# Run tests
./gradlew test

# Run UI tests
./gradlew :ui-tests:test
```

### Release Artifacts
The build produces three main plugin artifacts:
- `plugin-core.zip` - Core functionality
- `plugin-toolkit.zip` - AWS Toolkit features
- `plugin-amazonq.zip` - Amazon Q integration

---

## Additional Resources

- **Documentation**: [AWS Toolkit for JetBrains User Guide](https://docs.aws.amazon.com/console/toolkit-for-jetbrains)
- **Contributing**: See [CONTRIBUTING.md](CONTRIBUTING.md)
- **Repository Layout**: See [REPOLAYOUT.md](REPOLAYOUT.md)
- **Changelog**: See [CHANGELOG.md](CHANGELOG.md)
- **License**: Apache 2.0 - See [LICENSE](LICENSE)

---

*This summary was generated based on the repository structure and documentation as of the current state of the codebase.*
