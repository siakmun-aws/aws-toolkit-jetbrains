<p align="center">
  <strong>AWS Toolkit for JetBrains</strong>
</p>

<p align="center">
  <a href="https://codebuild.eu-west-1.amazonaws.com"><img src="https://codebuild.eu-west-1.amazonaws.com/badges?uuid=eyJlbmNyeXB0ZWREYXRhIjoiekhxeERIMmNLSkNYUktnUFJzUVJucmJqWnFLMGlpNXJiNE1LLzVWV3B1QUpSSkhCS04veHZmUGxZZ0ZmZlRzYjJ3T1VtVEs1b3JxbWNVOHFOeFJDOTAwPSIsIml2UGFyYW1ldGVyU3BlYyI6ImZXNW5KaStDRGNLdjZuZDgiLCJtYXRlcmlhbFNldFNlcmlhbCI6MX0%3D&branch=master" alt="Build Status"></a>
  <a href="https://codecov.io/gh/aws/aws-toolkit-jetbrains/branch/master"><img src="https://img.shields.io/codecov/c/github/aws/aws-toolkit-jetbrains/master.svg" alt="Coverage"></a>
  <a href="https://plugins.jetbrains.com/plugin/11349-aws-toolkit"><img src="https://img.shields.io/jetbrains/plugin/d/11349-aws-toolkit.svg" alt="Downloads"></a>
  <a href="https://plugins.jetbrains.com/plugin/11349-aws-toolkit"><img src="https://img.shields.io/jetbrains/plugin/v/11349.svg?label=version" alt="Version"></a>
  <a href="https://sonarcloud.io/dashboard?id=aws_aws-toolkit-jetbrains"><img src="https://sonarcloud.io/api/project_badges/measure?project=aws_aws-toolkit-jetbrains&metric=alert_status" alt="Quality Gate Status"></a>
</p>

---

# AWS Toolkit for JetBrains

The **AWS Toolkit for JetBrains** is an open-source plugin for JetBrains IDEs that makes it easier to build, debug, and deploy applications on [Amazon Web Services](https://aws.amazon.com/). It brings AWS service integrations directly into your IDE so you can stay focused on your code.

We build in the open because we value community involvement. Issues, feature requests, pull requests, code reviews, and any other contributions are always welcome.

## Table of Contents

- [Supported IDEs](#supported-ides)
- [Installation](#installation)
- [Features](#features)
- [Experimental Features](#experimental-features)
- [Feedback](#feedback)
- [Contributing](#contributing)
- [Licensing](#licensing)
- [Appendix: curl Query to pixiv.net](#appendix-curl-query-to-pixivnet)

## Supported IDEs

All JetBrains IDEs version **2023.3 and later**, including IntelliJ IDEA, PyCharm, WebStorm, Rider, GoLand, and more.

## Installation

See the official guide: [Installing the AWS Toolkit for JetBrains](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/install).

### Prerequisites

| Requirement | Purpose |
|---|---|
| AWS Account + IAM user with access key | Required for all features |
| [AWS CLI](https://aws.amazon.com/cli/) | Serverless development |
| [Docker](https://www.docker.com/) | Local Lambda execution environment |
| [AWS SAM CLI](https://github.com/awslabs/aws-sam-cli) | Serverless application model support |

### EAP (Early Access Preview) Builds

Opt in to preview builds that ship automatically:

1. In your IDE, go to **Plugins > Gear Icon > Manage Plugin Repositories**.
2. Add the URL: `https://plugins.jetbrains.com/plugins/eap/aws.toolkit`
3. Check for updates.

### Building From Source

See [CONTRIBUTING.md - Building from Source](CONTRIBUTING.md#building-from-source) for instructions.

## Features

### General

| Feature | Description | Docs |
|---|---|---|
| **AWS Resource Explorer** | Tree-view of AWS resources in your selected account and region (subset of supported resource types). | [Learn more](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/aws-explorer) |
| **Authentication** | Connect via static credentials, credential process, AWS Builder ID, or AWS SSO. | [Learn more](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/credentials) |

### AWS Lambda

> Many Lambda features require the [AWS SAM CLI](https://github.com/awslabs/aws-sam-cli). Visit the [SAM website](https://aws.amazon.com/serverless/sam/) for installation details.
>
> SAM features support **Java, Python, Node.js, and .NET Core**.

| Feature | Description | Docs |
|---|---|---|
| **Run/Debug Local Lambda Functions** | Locally test and step-through debug functions in a Lambda-like execution environment provided by SAM CLI. | [Learn more](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/lambda-local) |
| **Invoke Remote Lambda Functions** | Invoke remote functions using a shareable run configuration. | [Learn more](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/lambda-remote) |
| **Package & Deploy Lambda Functions** | Package a Lambda function zip and create a remote Lambda. | [Learn more](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/lambda-deploy) |
| **Sync SAM-based Applications** | Sync and track SAM-based applications. | [Learn more](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/sam-deploy) |

> **Note:** Python features are available in both PyCharm and IntelliJ with the [Python Plugin](https://www.jetbrains.com/help/idea/plugin-overview.html) installed.

### AWS CloudFormation

- View events, resources, and outputs for your CloudFormation stacks.

### CloudWatch Logs

- View and search your CloudWatch log streams.

### Amazon RDS / Redshift

- Connect to RDS and Redshift databases using temporary credentials with IAM or Secrets Manager -- no manual copy-paste required.

> **Note:** Database features require a paid JetBrains product.

### Amazon S3

- View and manage your S3 buckets.
- Upload to and download from buckets.
- [Learn more](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/s3-tasks)

## Experimental Features

We occasionally introduce experimental features that are still under development. These may have bugs, usability issues, or incomplete functionality, so they are hidden behind a feature flag.

To enable experimental features:

- Go to **Settings > Tools > AWS > Experimental Features**, or
- Use the **Additional Settings** (gear icon) in the AWS Explorer tool window.

> Experimental features may be disabled or removed at any time.

## Feedback

We want your feedback!

- **Vote** on [feature requests](https://github.com/aws/aws-toolkit-jetbrains/issues?q=is%3Aissue+is%3Aopen+label%3Afeature-request+sort%3Areactions-%2B1-desc) -- votes help us prioritize.
- [**Request a feature**](https://github.com/aws/aws-toolkit-jetbrains/issues/new?labels=feature-request&template=feature_request.md)
- [**Ask a question**](https://github.com/aws/aws-toolkit-jetbrains/issues/new?labels=guidance&template=guidance_request.md)
- [**File an issue**](https://github.com/aws/aws-toolkit-jetbrains/issues/new?labels=bug&template=bug_report.md)

## Contributing

Code contributions are welcome! See our [Contributing Guide](CONTRIBUTING.md) for how to get started.

## Licensing

This plugin is distributed according to the terms outlined in our [LICENSE](LICENSE).

---

## Appendix: curl Query to pixiv.net

The following is the result of running `curl https://www.pixiv.net` captured at the time this file was generated.

**Command:**

```bash
curl -sS -L https://www.pixiv.net
```

**Response (first 3000 bytes, truncated for readability):**

```html
<!DOCTYPE html>
<html lang="ja" class=" page-cool-index" xmlns:wb="http://open.weibo.com/wb">
<head>

<meta charset="utf-8">
    <meta name="viewport" content="width=1160">


<meta http-equiv="origin-trial" content="AjuasZzx/5iLvACWfnrQGAVPj6NUqkLNcfGCnd5CvAkztnMtmi2gbl1na8vmOFtI/jFkYsXs12INWlxppvk+KgQAAABfeyJvcmlnaW4iOiJodHRwczovL3d3dy5waXhpdi5uZXQ6NDQzIiwiZmVhdHVyZSI6IlNvZnROYXZpZ2F0aW9uSGV1cmlzdGljcyIsImV4cGlyeSI6MTcwOTY4MzE5OX0=">

<meta http-equiv="origin-trial" content="AuIwYivsJj3bUhOVdavByZUu2WyKoHOJudNtmdkrPDGXkZ7MWLmO85jeYn1INHJmtZwezzfQZ9yhwKXJ1WjhDgcAAABfeyJvcmlnaW4iOiJodHRwczovL3d3dy5waXhpdi5uZXQ6NDQzIiwiZmVhdHVyZSI6IkxvbmdBbmltYXRpb25GcmFtZVRpbWluZyIsImV4cGlyeSI6MTcwOTY4MzE5OX0=">

<meta http-equiv="origin-trial" content="Aig/6hQZFb/Mnf2+ENyCl/Oam4RzpVdFdDrQDwOFInobbMgfIVJ17iCt6v+RkIfmbKV10wSTYLJ2ipSpmG76aQUAAABVeyJvcmlnaW4iOiJodHRwczovL3d3dy5waXhpdi5uZXQ6NDQzIiwiZmVhdHVyZSI6IlNjaGVkdWxlcllpZWxkIiwiZXhwaXJ5IjoxNzA5NjgzMTk5fQ==">

<meta name="format-detection" content="telephone=no">
<meta property="og:site_name" content="pixiv">
<meta property="fb:app_id" content="140810032656374">
<meta property="wb:webmaster" content="4fd391fccdb49500" />
                        <meta property="twitter:card" content="summary_large_image">
                                <meta property="twitter:site" content="@pixiv">
                                <meta property="twitter:title" content="イラスト・マンガ・小説 作品コミュニケーションサービス [pixiv(ピクシブ)]">
                                <meta property="twitter:description" content="pixiv(ピクシブ)は、イラスト・マンガ・小説の投稿や閲覧が楽しめる国内最大級の作品コミュニケーションサービスです。幅広いジャンルの作品が投稿され、ユーザー発の企画や公式コンテストが開催されています。">
                                <meta property="twitter:image" content="https://s.pximg.net/www/images/pixiv_logo20250128.png">

            <link rel="alternate" hreflang="ja" href="https://www.pixiv.net/">
            <link rel="alternate" hreflang="en" href="https://www.pixiv.net/en/">

                            <meta property="og:title" content="イラスト・マンガ・小説 作品コミュニケーションサービス [pixiv(ピクシブ)]">
                                <meta property="og:type" content="website">
                                <meta property="og:description" content="pixiv(ピクシブ)は、イラスト・マンガ・小説の投稿や閲覧が楽しめる国内最大級の作品コミュニケーションサービスです。幅広いジャンルの作品が投稿され、ユーザー発の企画や公式コンテストが開催されています。">
                                <meta property="og:image" content="https://s.pximg.net/www/images/pixiv_logo20250128.png">

<meta name="application-name" content="pixiv">
<!-- ... truncated ... -->
```

> The full response was approximately 43,727 bytes of HTML. The page is the Japanese-language landing page for [pixiv](https://www.pixiv.net), an illustration, manga, and novel community platform.
