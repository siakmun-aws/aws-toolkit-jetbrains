# AWS Toolkit for JetBrains

[![Build Status](https://codebuild.eu-west-1.amazonaws.com/badges?uuid=eyJlbmNyeXB0ZWREYXRhIjoiekhxeERIMmNLSkNYUktnUFJzUVJucmJqWnFLMGlpNXJiNE1LLzVWV3B1QUpSSkhCS04veHZmUGxZZ0ZmZlRzYjJ3T1VtVEs1b3JxbWNVOHFOeFJDOTAwPSIsIml2UGFyYW1ldGVyU3BlYyI6ImZXNW5KaStDRGNLdjZuZDgiLCJtYXRlcmlhbFNldFNlcmlhbCI6MX0%3D&branch=master)](https://codebuild.eu-west-1.amazonaws.com) [![Coverage](https://img.shields.io/codecov/c/github/aws/aws-toolkit-jetbrains/master.svg)](https://codecov.io/gh/aws/aws-toolkit-jetbrains/branch/master) [![Downloads](https://img.shields.io/jetbrains/plugin/d/11349-aws-toolkit.svg)](https://plugins.jetbrains.com/plugin/11349-aws-toolkit) [![Version](https://img.shields.io/jetbrains/plugin/v/11349.svg?label=version)](https://plugins.jetbrains.com/plugin/11349-aws-toolkit) [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=aws_aws-toolkit-jetbrains&metric=alert_status)](https://sonarcloud.io/dashboard?id=aws_aws-toolkit-jetbrains)

## Overview

AWS Toolkit for JetBrains is an open-source plugin for JetBrains IDEs (version 2023.3 and later) that simplifies building applications on [Amazon Web Services](https://aws.amazon.com/). It provides integrated access to AWS services directly from your IDE, enabling you to explore resources, manage Lambda functions, work with S3 buckets, connect to databases, and more -- all without leaving your editor.

## Table of Contents

- [Supported IDEs](#supported-ides)
- [Installation](#installation)
- [Features](#features)
- [Experimental Features](#experimental-features)
- [Contributing and Feedback](#contributing-and-feedback)
- [Licensing](#licensing)
- [AWS Documentation Reference](#aws-documentation-reference-curl-results)

## Supported IDEs

All JetBrains IDEs version **2023.3 and later**, including:

- IntelliJ IDEA (Community and Ultimate)
- PyCharm (Community and Professional)
- WebStorm
- Rider
- GoLand
- CLion
- And other JetBrains IDEs

## Installation

### From the JetBrains Marketplace

See [Installing the AWS Toolkit for JetBrains](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/install) in the official AWS Toolkit for JetBrains User Guide.

### Prerequisites

To use this plugin, you will need:

1. **An AWS account** with a user and access key configured.
2. **AWS CLI** -- required for serverless application development.
3. **Docker** -- required for local Lambda function execution.
4. **AWS SAM CLI** -- required for running and debugging Lambda functions locally.

The [installation guide](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/install) covers setting up all of these prerequisites in detail.

### Early Access Preview (EAP) Builds

Opt-in EAP builds are available and built automatically. To use them:

1. Open your IDE and navigate to **Plugins > Gear Icon > Manage Plugin Repositories**.
2. Add the following URL to the list:
   ```
   https://plugins.jetbrains.com/plugins/eap/aws.toolkit
   ```
3. Check for updates.

### Building from Source

See the [Contributing Guide](CONTRIBUTING.md#building-from-source) for build instructions.

## Features

### General

| Feature | Description | Learn More |
|---------|-------------|------------|
| **AWS Resource Explorer** | Tree-view of AWS resources available in your selected account and region. Displays a subset of resource types supported by the plugin. | [Docs](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/aws-explorer) |
| **Authentication** | Connect to AWS using static credentials, credential process, AWS Builder ID, or AWS SSO. | [Docs](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/credentials) |

### AWS Services

#### AWS CloudFormation

- View events, resources, and outputs for your CloudFormation stacks.

#### CloudWatch Logs

- View and search your CloudWatch log streams.

#### AWS Lambda

> **Note:** Many Lambda features require the [AWS SAM CLI](https://github.com/awslabs/aws-sam-cli). See the [SAM website](https://aws.amazon.com/serverless/sam/) for installation instructions. SAM features support **Java, Python, Node.js, and .NET Core**.

| Feature | Description | Learn More |
|---------|-------------|------------|
| **Run/Debug Local Lambda Functions** | Locally test and step-through debug functions in a Lambda-like execution environment provided by the SAM CLI. | [Docs](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/lambda-local) |
| **Invoke Remote Lambda Functions** | Invoke remote functions using a sharable run configuration. | [Docs](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/lambda-remote) |
| **Package & Deploy Lambda Functions** | Package a Lambda function zip and create a remote Lambda. | [Docs](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/lambda-deploy) |
| **Sync SAM-based Applications** | Sync and track SAM-based applications. | [Docs](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/sam-deploy) |

> **Note:** Python features are available in both PyCharm and IntelliJ with the [Python Plugin](https://www.jetbrains.com/help/idea/plugin-overview.html) installed.

#### Amazon RDS / Redshift

- Connect to RDS/Redshift databases using temporary credentials with IAM or SecretsManager -- no copy-paste required.

> **Note:** Database features require a paid JetBrains product.

#### Amazon S3

- View and manage your S3 buckets.
- Upload and download files to and from buckets.
- [Learn more](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/s3-tasks)

## Experimental Features

The toolkit occasionally introduces experimental features that are still being evaluated. These may have bugs, usability issues, or incomplete functionality. Because they are not yet production-ready, they are hidden behind a feature flag.

To enable experimental features:

- Go to **Settings > Tools > AWS > Experimental Features**, or
- Use the Additional Settings (gear icon) in the AWS Explorer Tool Window.

> **Note:** Experimental features may be disabled or removed at any time.

## Contributing and Feedback

This project is open source because community involvement matters. We welcome:

- **Feature requests** -- [Vote on existing requests](https://github.com/aws/aws-toolkit-jetbrains/issues?q=is%3Aissue+is%3Aopen+label%3Afeature-request+sort%3Areactions-%2B1-desc) or [submit a new one](https://github.com/aws/aws-toolkit-jetbrains/issues/new?labels=feature-request&template=feature_request.md).
- **Questions** -- [Ask a question](https://github.com/aws/aws-toolkit-jetbrains/issues/new?labels=guidance&template=guidance_request.md).
- **Bug reports** -- [File an issue](https://github.com/aws/aws-toolkit-jetbrains/issues/new?labels=bug&template=bug_report.md).
- **Code contributions** -- See the [Contributing Guide](CONTRIBUTING.md) for how to get started.

## Licensing

This plugin is distributed according to the terms outlined in the [LICENSE](LICENSE) file.

## AWS Documentation Reference (curl Results)

The following section documents the result of running `curl https://docs.aws.amazon.com` to query the AWS Documentation landing page.

### Command Executed

```bash
curl -s -m 10 https://docs.aws.amazon.com
```

### Result: Success (HTTP 200)

The curl command completed successfully and returned the AWS Documentation main landing page as an HTML document. Below is a truncated excerpt of the response (first ~1500 characters):

```html
<!DOCTYPE html>
<html lang="en-us">
  <head>
    <meta charset="UTF-8">
    <meta name=viewport content="width=device-width,initial-scale=1">
    <meta name="service-name" content="Main Landing Page" />
    <meta name="guide-name" content="Landing Page" />
    <link rel='canonical' href='https://docs.aws.amazon.com/'/>
    <meta name="landing-page-locale" content="en_us" />
    <link rel="icon" type="image/ico" href="/assets/r/images/favicon.ico" />
    <link rel="shortcut icon" type="image/ico" href="/assets/r/images/favicon.ico" />
    <script defer src="/assets/r/awsdocs-main-landing-page.2.0.0.js"></script>
    <script id="awsc-panorama-bundle" type="text/javascript"
      src="https://prod.pa.cdn.uis.awsstatic.com/panorama-nav-init.js"
      data-config="{'appEntity':'aws-documentation','region':'us-east-1', 'service':'docs-home'}"
      defer></script>
  </head>
  <body class="awsdocs awsui">
    ...
  </body>
</html>
```

### Summary

The response is the AWS Documentation homepage (`https://docs.aws.amazon.com/`). It is a single-page application shell that loads its content dynamically via JavaScript. The page metadata indicates:

- **Service name:** Main Landing Page
- **Guide name:** Landing Page
- **Locale:** en_us
- **Canonical URL:** `https://docs.aws.amazon.com/`

The bulk of the page content is URL-encoded XML embedded in a hidden input field (`#landing-page-xml`), which contains structured data about AWS service documentation categories including Compute, Storage, Database, Networking, Security, Machine Learning, and more. This XML data is decoded and rendered client-side by the `awsdocs-main-landing-page.2.0.0.js` script.

The decoded XML content begins with:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<main-landing-page version="2.1">
   <title>Welcome to AWS Documentation</title>
   <abstract>Find user guides, code samples, SDKs &amp; toolkits, tutorials, API &amp; CLI references, and more.</abstract>
   ...
</main-landing-page>
```

This confirms that `https://docs.aws.amazon.com` serves as the central hub for all AWS service documentation and is fully accessible.
