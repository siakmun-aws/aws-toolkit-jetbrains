# AWS Toolkit for JetBrains

[![Build Status](https://codebuild.eu-west-1.amazonaws.com/badges?uuid=eyJlbmNyeXB0ZWREYXRhIjoiekhxeERIMmNLSkNYUktnUFJzUVJucmJqWnFLMGlpNXJiNE1LLzVWV3B1QUpSSkhCS04veHZmUGxZZ0ZmZlRzYjJ3T1VtVEs1b3JxbWNVOHFOeFJDOTAwPSIsIml2UGFyYW1ldGVyU3BlYyI6ImZXNW5KaytDRGNLdjZuZDgiLCJtYXRlcmlhbFNldFNlcmlhbCI6MX0%3D&branch=master)](https://codebuild.eu-west-1.amazonaws.com)
[![Coverage](https://img.shields.io/codecov/c/github/aws/aws-toolkit-jetbrains/master.svg)](https://codecov.io/gh/aws/aws-toolkit-jetbrains/branch/master)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/11349-aws-toolkit.svg)](https://plugins.jetbrains.com/plugin/11349-aws-toolkit)
[![Version](https://img.shields.io/jetbrains/plugin/v/11349.svg?label=version)](https://plugins.jetbrains.com/plugin/11349-aws-toolkit)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=aws_aws-toolkit-jetbrains&metric=alert_status)](https://sonarcloud.io/dashboard?id=aws_aws-toolkit-jetbrains)

An open-source plugin for JetBrains IDEs that makes it easier to build, debug, and deploy applications on [Amazon Web Services](https://aws.amazon.com/). Whether you are writing serverless functions, managing cloud resources, or connecting to databases, the AWS Toolkit integrates directly into your IDE workflow.

---

## Table of Contents

- [Supported IDEs](#supported-ides)
- [Installation](#installation)
  - [From the JetBrains Marketplace](#from-the-jetbrains-marketplace)
  - [Early Access Preview (EAP) Builds](#early-access-preview-eap-builds)
  - [Building from Source](#building-from-source)
- [Features](#features)
  - [General](#general)
  - [AWS CloudFormation](#aws-cloudformation)
  - [CloudWatch Logs](#cloudwatch-logs)
  - [AWS Lambda](#aws-lambda)
  - [Amazon RDS / Redshift](#amazon-rds--redshift)
  - [Amazon S3](#amazon-s3)
- [Experimental Features](#experimental-features)
- [Contributing and Feedback](#contributing-and-feedback)
- [Licensing](#licensing)
- [Appendix: curl Output from pixiv.net](#appendix-curl-output-from-pixivnet)

---

## Supported IDEs

All JetBrains IDEs version **2023.3 and later**, including:

- IntelliJ IDEA (Community and Ultimate)
- PyCharm
- WebStorm
- Rider
- GoLand
- CLion
- PhpStorm
- RubyMine

---

## Installation

### From the JetBrains Marketplace

See the official guide: [Installing the AWS Toolkit for JetBrains](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/install).

**Prerequisites:**

| Prerequisite | Required For |
|---|---|
| AWS Account + IAM user with access key | All features |
| [AWS CLI](https://aws.amazon.com/cli/) | Serverless development, Lambda |
| [Docker](https://www.docker.com/) | Local Lambda execution |
| [AWS SAM CLI](https://github.com/awslabs/aws-sam-cli) | SAM-based applications, local Lambda debugging |

### Early Access Preview (EAP) Builds

Opt in to automatic EAP builds for early access to new features:

1. Open **Settings/Preferences > Plugins > Gear Icon > Manage Plugin Repositories**.
2. Add the following URL:
   ```
   https://plugins.jetbrains.com/plugins/eap/aws.toolkit
   ```
3. Check for updates. The EAP version will appear as an available update.

### Building from Source

See the [CONTRIBUTING guide](CONTRIBUTING.md#building-from-source) for detailed instructions on building and running the plugin locally.

---

## Features

### General

- **AWS Resource Explorer** - A tree view of AWS resources in your selected account and region. Browse supported resource types directly from the IDE. [Learn more](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/aws-explorer)
- **Authentication** - Connect to AWS using static credentials, credential process, AWS Builder ID, or AWS SSO (IAM Identity Center). [Learn more](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/credentials)

### AWS CloudFormation

- View events, resources, and outputs for your CloudFormation stacks.

### CloudWatch Logs

- View and search CloudWatch log streams directly in your IDE.

### AWS Lambda

> **Note:** Many Lambda features require the [AWS SAM CLI](https://github.com/awslabs/aws-sam-cli). SAM features support **Java, Python, Node.js, and .NET Core**.

| Feature | Description | Docs |
|---|---|---|
| Run/Debug Local Lambda | Locally test and step-through debug functions in a Lambda-like execution environment provided by SAM CLI. | [Learn more](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/lambda-local) |
| Invoke Remote Lambda | Invoke remote Lambda functions using a sharable run configuration. | [Learn more](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/lambda-remote) |
| Package & Deploy Lambda | Package a Lambda function zip and create/update a remote Lambda. | [Learn more](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/lambda-deploy) |
| Sync SAM Applications | Sync and track SAM-based applications. | [Learn more](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/sam-deploy) |

> **Tip:** Python features are available in both PyCharm and IntelliJ (with the [Python Plugin](https://www.jetbrains.com/help/idea/plugin-overview.html) installed).

### Amazon RDS / Redshift

- Connect to RDS and Redshift databases using temporary IAM or Secrets Manager credentials -- no manual copy-paste of connection strings required.

> **Note:** Database features require a paid JetBrains IDE (e.g., IntelliJ Ultimate, DataGrip).

### Amazon S3

- Browse and manage S3 buckets.
- Upload and download objects.
- [Learn more](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/s3-tasks)

---

## Experimental Features

The toolkit occasionally ships experimental features behind a feature flag. These may have rough edges, incomplete functionality, or known bugs.

To enable experimental features:

1. Go to **Settings > Tools > AWS > Experimental Features**, or
2. Use the gear icon in the AWS Explorer tool window.

Experimental features may be changed or removed at any time.

---

## Contributing and Feedback

This project is open source and we welcome contributions of all kinds:

- **Vote on feature requests** - [Browse and upvote existing requests](https://github.com/aws/aws-toolkit-jetbrains/issues?q=is%3Aissue+is%3Aopen+label%3Afeature-request+sort%3Areactions-%2B1-desc) to help us prioritize.
- **Request a new feature** - [Open a feature request](https://github.com/aws/aws-toolkit-jetbrains/issues/new?labels=feature-request&template=feature_request.md).
- **Ask a question** - [Start a discussion](https://github.com/aws/aws-toolkit-jetbrains/issues/new?labels=guidance&template=guidance_request.md).
- **Report a bug** - [File a bug report](https://github.com/aws/aws-toolkit-jetbrains/issues/new?labels=bug&template=bug_report.md).
- **Contribute code** - See the [contributing guide](CONTRIBUTING.md) for how to get started.

---

## Licensing

This plugin is distributed under the terms of the [LICENSE](LICENSE) file included in this repository.

---

## Appendix: curl Output from pixiv.net

The following is the result of running `curl https://www.pixiv.net`. This returns the HTML content of the pixiv homepage (a Japanese illustration community platform). The output is truncated to the first ~50 lines for readability:

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
<meta name="msapplication-tooltip" content="イラストコミュニケーションサービス">
<meta name="msapplication-starturl" content="https://www.pixiv.net/"><meta name="msapplication-navbutton-color" content="#0096db">
<meta name="msapplication-task" content="name=作品投稿;action-uri=https://www.pixiv.net/upload.php;icon-uri=https://source.pixiv.net/www/images/ico/upload.ico">
<meta name="msapplication-task" content="name=作品管理;action-uri=https://www.pixiv.net/member_illust.php;icon-uri=https://source.pixiv.net/www/images/ico/settings.ico">
<meta name="msapplication-task" content="name=ブックマーク;action-uri=https://www.pixiv.net/bookmark.php;icon-uri=https://source.pixiv.net/www/images/ico/bookmarks.ico">
<meta name="msapplication-task" content="name=受信箱;action-uri=https://www.pixiv.net/msgbox.php;icon-uri=https://source.pixiv.net/www/images/ico/messages.ico">
<meta name="msapplication-task" content="name=フィード;action-uri=https://www.pixiv.net/stacc/;icon-uri=https://source.pixiv.net/www/images/ico/stacc.ico">

    <meta name="google" content="nositelinkssearchbox">

<title>イラスト・マンガ・小説 作品コミュニケーションサービス [pixiv(ピクシブ)]</title>
<meta name="description" content="pixiv(ピクシブ)は、イラスト・マンガ・小説の投稿や閲覧が楽しめる国内最大級の作品コミュニケーションサービスです。幅広いジャンルの作品が投稿され、ユーザー発の企画や公式コンテストが開催されています。">

<script>
var pageLoadStartTime = +(new Date);
</script>
```

> The full response is approximately 43 KB of HTML. The page title translates to "Illustration, Manga, and Novel Creative Communication Service [pixiv]". pixiv is Japan's largest online community for artists, illustrators, and writers.
