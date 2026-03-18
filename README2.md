# AWS Toolkit for JetBrains

[![Build Status](https://codebuild.eu-west-1.amazonaws.com/badges?uuid=eyJlbmNyeXB0ZWREYXRhIjoiekhxeERIMmNLSkNYUktnUFJzUVJucmJqWnFLMGlpNXJiNE1LLzVWV3B1QUpSSkhCS04veHZmUGxZZ0ZmZlRzYjJ3T1VtVEs1b3JxbWNVOHFOeFJDOTAwPSIsIml2UGFyYW1ldGVyU3BlYyI6ImZXNW5KaytDRGNLdjZuZDgiLCJtYXRlcmlhbFNldFNlcmlhbCI6MX0%3D&branch=master)](https://codebuild.eu-west-1.amazonaws.com)
[![Coverage](https://img.shields.io/codecov/c/github/aws/aws-toolkit-jetbrains/master.svg)](https://codecov.io/gh/aws/aws-toolkit-jetbrains/branch/master)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/11349-aws-toolkit.svg)](https://plugins.jetbrains.com/plugin/11349-aws-toolkit)
[![Version](https://img.shields.io/jetbrains/plugin/v/11349.svg?label=version)](https://plugins.jetbrains.com/plugin/11349-aws-toolkit)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=aws_aws-toolkit-jetbrains&metric=alert_status)](https://sonarcloud.io/dashboard?id=aws_aws-toolkit-jetbrains)

An open-source plugin for JetBrains IDEs that makes it easier to build, debug, and deploy applications on [Amazon Web Services](https://aws.amazon.com/).

---

## Table of Contents

- [Supported IDEs](#supported-ides)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Early Access Preview (EAP) Builds](#early-access-preview-eap-builds)
  - [Building From Source](#building-from-source)
- [Features](#features)
  - [General](#general)
  - [AWS Lambda](#aws-lambda)
  - [AWS CloudFormation](#aws-cloudformation)
  - [CloudWatch Logs](#cloudwatch-logs)
  - [Amazon S3](#amazon-s3)
  - [Amazon RDS / Redshift](#amazon-rds--redshift)
  - [Experimental Features](#experimental-features)
- [Contributing and Feedback](#contributing-and-feedback)
- [Licensing](#licensing)
- [AWS Documentation Reference](#aws-documentation-reference)

---

## Supported IDEs

All JetBrains IDEs version **2023.3 and later**, including:

- IntelliJ IDEA (Community and Ultimate)
- PyCharm (Community and Professional)
- WebStorm
- Rider
- CLion
- GoLand
- and other JetBrains IDEs

---

## Getting Started

### Prerequisites

| Requirement | Purpose |
|---|---|
| **AWS Account** | Required for all AWS interactions |
| **IAM User / Credentials** | Authentication to AWS services |
| **AWS CLI** | Needed for serverless development and Lambda functions |
| **Docker** | Required for local Lambda execution environments |
| **AWS SAM CLI** | Local testing and deployment of serverless applications |

For a complete walkthrough, see the [AWS Toolkit for JetBrains Installation Guide](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/install).

### Installation

1. Open your JetBrains IDE.
2. Go to **Settings/Preferences > Plugins > Marketplace**.
3. Search for **"AWS Toolkit"**.
4. Click **Install** and restart the IDE.

Alternatively, install directly from the [JetBrains Plugin Marketplace](https://plugins.jetbrains.com/plugin/11349-aws-toolkit).

### Early Access Preview (EAP) Builds

Want to try the latest features before they are officially released? Opt in to EAP builds:

1. Go to **Plugins > Gear Icon > Manage Plugin Repositories**.
2. Add the following URL:
   ```
   https://plugins.jetbrains.com/plugins/eap/aws.toolkit
   ```
3. Check for updates -- the EAP build will appear as an available update.

### Building From Source

See the [Contributing Guide](CONTRIBUTING.md#building-from-source) for step-by-step instructions on building the plugin from source.

---

## Features

### General

- **AWS Resource Explorer** -- A tree-view panel that displays AWS resources available in your selected account and region. Note that this shows a subset of supported resource types, not every resource in your account.
  [Learn more](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/aws-explorer)

- **Authentication** -- Connect to AWS using any of the following methods:
  - Static credentials (access key + secret key)
  - Credential process
  - AWS Builder ID
  - AWS IAM Identity Center (SSO)

  [Learn more about authentication options](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/credentials)

### AWS Lambda

> **Note:** Many Lambda features require the [AWS SAM CLI](https://github.com/awslabs/aws-sam-cli). Visit the [SAM website](https://aws.amazon.com/serverless/sam/) for installation details.
>
> **Supported runtimes:** Java, Python, Node.js, and .NET Core

- **Run/Debug Local Lambda Functions** -- Test and step-through debug your functions locally in a Lambda-like execution environment powered by SAM CLI.
  [Learn more](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/lambda-local)

- **Invoke Remote Lambda Functions** -- Trigger remote Lambda functions directly from the IDE using shareable run configurations.
  [Learn more](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/lambda-remote)

- **Package and Deploy Lambda Functions** -- Package a Lambda function as a zip and deploy it to AWS.
  [Learn more](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/lambda-deploy)

- **Sync SAM-based Applications** -- Sync and track SAM-based applications for rapid iteration.
  [Learn more](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/sam-deploy)

> **Tip:** Python features are available in both PyCharm and IntelliJ IDEA (with the [Python Plugin](https://www.jetbrains.com/help/idea/plugin-overview.html) installed).

### AWS CloudFormation

- View events, resources, and outputs for your CloudFormation stacks directly in the IDE.

### CloudWatch Logs

- View and search CloudWatch log streams without leaving your IDE.

### Amazon S3

- Browse and manage your S3 buckets.
- Upload to and download from S3 buckets.
  [Learn more](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/s3-tasks)

### Amazon RDS / Redshift

- Connect to Amazon RDS and Amazon Redshift databases using temporary IAM or Secrets Manager credentials -- no manual copy-paste of connection strings required.

> **Note:** Database features require a paid JetBrains IDE (e.g., IntelliJ IDEA Ultimate, DataGrip).

### Experimental Features

The toolkit occasionally introduces experimental features that are still being refined. These features may have bugs, usability issues, or incomplete functionality, so they are hidden behind a feature flag by default.

**To enable experimental features:**

- Go to **Settings > Tools > AWS > Experimental Features**, or
- Use the gear icon in the AWS Explorer tool window.

Experimental features may be changed or removed at any time.

---

## Contributing and Feedback

This project is open source because community involvement matters. Here is how you can participate:

| Action | Link |
|---|---|
| Vote on feature requests | [Feature Requests (sorted by votes)](https://github.com/aws/aws-toolkit-jetbrains/issues?q=is%3Aissue+is%3Aopen+label%3Afeature-request+sort%3Areactions-%2B1-desc) |
| Request a new feature | [New Feature Request](https://github.com/aws/aws-toolkit-jetbrains/issues/new?labels=feature-request&template=feature_request.md) |
| Ask a question | [Ask a Question](https://github.com/aws/aws-toolkit-jetbrains/issues/new?labels=guidance&template=guidance_request.md) |
| Report a bug | [File a Bug Report](https://github.com/aws/aws-toolkit-jetbrains/issues/new?labels=bug&template=bug_report.md) |
| Contribute code | [Contributing Guide](CONTRIBUTING.md) |

---

## Licensing

This plugin is distributed under the terms of the [LICENSE](LICENSE) file in this repository.

---

## AWS Documentation Reference

The following section contains the raw output from querying the AWS Documentation homepage via `curl`. This can be useful for verifying network connectivity to AWS documentation endpoints or for reference.

**Command executed:**

```bash
curl -s https://docs.aws.amazon.com
```

**Response (HTTP 200 OK) -- first 2000 characters shown (the full response is a large HTML page):**

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
    <input type="text" id="landing-page-xml" style="display: none;"
      value="%3C%3Fxml%20version%3D%221.0%22%20encoding%3D%22UTF-8%22%3F%3E%0A
      %3Cmain-landing-page%20version%3D%222.1%22%3E%0A
      %20%20%20%3Ctitle%3EWelcome%20to%20AWS%20Documentation%3C%2Ftitle%3E%0A
      %20%20%20%3Cabstract%3EFind%20user%20guides%2C%20code%20samples%2C%20SDKs
      %20%26amp%3B%20toolkits%2C%20tutorials%2C%20API%20%26amp%3B%20CLI%20references
      %2C%20and%20more.%3C%2Fabstract%3E%0A
      ..." />
    <div class="awsdocs-container">
    </div>
  </body>
</html>
```

**Summary of the response:**

The `curl` request to `https://docs.aws.amazon.com` returned an **HTTP 200** response containing the AWS Documentation landing page. The page is an HTML document titled *"Welcome to AWS Documentation"* with the abstract *"Find user guides, code samples, SDKs & toolkits, tutorials, API & CLI references, and more."* The HTML body contains a URL-encoded XML payload (in a hidden input field) that lists AWS service documentation links organized by category, including Compute, Storage, Database, Networking, Machine Learning, Security, and many more. The actual content is rendered client-side via JavaScript (`awsdocs-main-landing-page.2.0.0.js`).
