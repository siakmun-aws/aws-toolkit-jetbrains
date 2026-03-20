# AWS Toolkit for JetBrains

[![Build Status](https://codebuild.eu-west-1.amazonaws.com/badges?uuid=eyJlbmNyeXB0ZWREYXRhIjoiekhxeERIMmNLSkNYUktnUFJzUVJucmJqWnFLMGlpNXJiNE1LLzVWV3B1QUpSSkhCS04veHZmUGxZZ0ZmZlRzYjJ3T1VtVEs1b3JxbWNVOHFOeFJDOTAwPSIsIml2UGFyYW1ldGVyU3BlYyI6ImZXNW5KaytDRGNLdjZuZDgiLCJtYXRlcmlhbFNldFNlcmlhbCI6MX0%3D&branch=master)](https://codebuild.eu-west-1.amazonaws.com)
[![Coverage](https://img.shields.io/codecov/c/github/aws/aws-toolkit-jetbrains/master.svg)](https://codecov.io/gh/aws/aws-toolkit-jetbrains/branch/master)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/11349-aws-toolkit.svg)](https://plugins.jetbrains.com/plugin/11349-aws-toolkit)
[![Version](https://img.shields.io/jetbrains/plugin/v/11349.svg?label=version)](https://plugins.jetbrains.com/plugin/11349-aws-toolkit)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=aws_aws-toolkit-jetbrains&metric=alert_status)](https://sonarcloud.io/dashboard?id=aws_aws-toolkit-jetbrains)

An open-source plugin for JetBrains IDEs that makes it easier to build, debug, and deploy applications on [Amazon Web Services](https://aws.amazon.com/). Whether you are working with Lambda functions, CloudFormation stacks, S3 buckets, or CloudWatch logs, the AWS Toolkit brings AWS directly into your IDE workflow.

## Table of Contents

- [Supported IDEs](#supported-ides)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Early Access Preview (EAP) Builds](#early-access-preview-eap-builds)
  - [Building from Source](#building-from-source)
- [Features](#features)
  - [Authentication](#authentication)
  - [AWS Resource Explorer](#aws-resource-explorer)
  - [AWS Lambda](#aws-lambda)
  - [AWS CloudFormation](#aws-cloudformation)
  - [CloudWatch Logs](#cloudwatch-logs)
  - [Amazon S3](#amazon-s3)
  - [Amazon RDS / Redshift](#amazon-rds--redshift)
- [Experimental Features](#experimental-features)
- [Contributing](#contributing)
- [Licensing](#licensing)
- [Appendix: curl Query to pixiv.net](#appendix-curl-query-to-pixivnet)

## Supported IDEs

All JetBrains IDEs version **2023.3 and later**, including:

- IntelliJ IDEA (Community and Ultimate)
- PyCharm (Community and Professional)
- WebStorm
- Rider
- GoLand
- CLion
- and other JetBrains products

## Getting Started

### Prerequisites

| Requirement | Purpose |
|---|---|
| **AWS Account** | Required for all AWS interactions |
| **IAM User / Credentials** | Authentication to AWS services |
| **AWS CLI** | Needed for serverless development |
| **Docker** | Required for local Lambda execution |
| **AWS SAM CLI** | Required for local Lambda testing, packaging, and deployment |

For complete setup instructions, see the [AWS Toolkit for JetBrains Installation Guide](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/install).

### Installation

1. Open your JetBrains IDE.
2. Go to **Settings/Preferences > Plugins > Marketplace**.
3. Search for **"AWS Toolkit"**.
4. Click **Install** and restart the IDE when prompted.

### Early Access Preview (EAP) Builds

Opt in to early access builds to try features before they are generally available:

1. Navigate to **Plugins > Gear Icon > Manage Plugin Repositories**.
2. Add the following URL:
   ```
   https://plugins.jetbrains.com/plugins/eap/aws.toolkit
   ```
3. Check for updates -- the EAP version will appear as an available update.

### Building from Source

See the [Contributing Guide](CONTRIBUTING.md#building-from-source) for detailed build instructions.

## Features

### Authentication

Connect to AWS using any of the following methods:

- **Static credentials** (access key + secret key)
- **Credential process** (external credential provider)
- **AWS Builder ID**
- **AWS IAM Identity Center (SSO)**

[Learn more about authentication options](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/credentials)

### AWS Resource Explorer

A tree-view panel displaying AWS resources available in your selected account and region. Browse supported resource types directly from your IDE without switching to the AWS Console.

[Learn more](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/aws-explorer)

### AWS Lambda

> **Note:** Lambda features require the [AWS SAM CLI](https://github.com/awslabs/aws-sam-cli). SAM features support **Java, Python, Node.js, and .NET Core**.

- **Run/Debug Local Lambda Functions** -- Locally test and step-through debug functions in a Lambda-like execution environment provided by the SAM CLI. [Learn more](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/lambda-local)
- **Invoke Remote Lambda Functions** -- Invoke deployed functions using a sharable run configuration. [Learn more](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/lambda-remote)
- **Package & Deploy Lambda Functions** -- Package a Lambda function as a ZIP and create or update a remote Lambda. [Learn more](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/lambda-deploy)
- **Sync SAM-based Applications** -- Sync and track SAM-based applications for rapid iteration. [Learn more](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/sam-deploy)

> **Tip:** Python features are available in both PyCharm and IntelliJ IDEA (with the [Python Plugin](https://www.jetbrains.com/help/idea/plugin-overview.html) installed).

### AWS CloudFormation

- View events, resources, and outputs for your CloudFormation stacks.

### CloudWatch Logs

- View and search your CloudWatch log streams directly in the IDE.

### Amazon S3

- View and manage S3 buckets.
- Upload and download objects to/from buckets.

[Learn more](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/s3-tasks)

### Amazon RDS / Redshift

- Connect to RDS and Redshift databases using temporary IAM or Secrets Manager credentials -- no manual copy-paste of connection strings required.

> **Note:** Database features require a paid JetBrains IDE (e.g., IntelliJ IDEA Ultimate, DataGrip).

## Experimental Features

The toolkit occasionally introduces experimental features behind a feature flag. These may have bugs, usability issues, or incomplete functionality and can be removed at any time.

To enable experimental features:

1. Go to **Settings > Tools > AWS > Experimental Features**, or
2. Use the **Additional Settings** (gear icon) in the AWS Explorer tool window.

## Contributing

We want your feedback and contributions!

- **Vote on feature requests**: [Open feature requests sorted by votes](https://github.com/aws/aws-toolkit-jetbrains/issues?q=is%3Aissue+is%3Aopen+label%3Afeature-request+sort%3Areactions-%2B1-desc)
- **Request a new feature**: [Feature request template](https://github.com/aws/aws-toolkit-jetbrains/issues/new?labels=feature-request&template=feature_request.md)
- **Ask a question**: [Guidance request template](https://github.com/aws/aws-toolkit-jetbrains/issues/new?labels=guidance&template=guidance_request.md)
- **File a bug report**: [Bug report template](https://github.com/aws/aws-toolkit-jetbrains/issues/new?labels=bug&template=bug_report.md)
- **Contribute code**: See the [Contributing Guide](CONTRIBUTING.md) for instructions on getting started.

## Licensing

This plugin is distributed according to the terms outlined in the [LICENSE](LICENSE) file.

---

## Appendix: curl Query to pixiv.net

As part of creating this README, a `curl` request was made to `https://www.pixiv.net` from the build/sandbox environment. Below are the results of that attempt.

### Command

```bash
curl -v https://www.pixiv.net
```

### Environment

The sandbox network mode is **COMMON_DEPENDENCIES**, which routes external traffic through a proxy. The expectation was that non-allowlisted external sites would be unreachable; however, the request was successfully proxied in this case.

### Result Summary

| Field | Value |
|---|---|
| **HTTP Status** | 200 |
| **Content-Type** | text/html; charset=UTF-8 |
| **Total Time** | ~0.17s |
| **Bytes Downloaded** | 44,372 |
| **TLS Version** | TLSv1.3 / TLS_AES_256_GCM_SHA384 |
| **Certificate Subject** | CN=pixiv.net (wildcard: *.pixiv.net) |
| **Certificate Issuer** | C=US; O=Google Trust Services; CN=WE1 |

### Verbose Output (Connection Details)

```
* Uses proxy env variable https_proxy == 'http://BigWeaverExecEnvMgnt-ProxyLB-223c445c1b805e77.elb.us-west-2.amazonaws.com:3128'
* Host BigWeaverExecEnvMgnt-ProxyLB-223c445c1b805e77.elb.us-west-2.amazonaws.com:3128 was resolved.
* IPv4: 10.0.105.106, 10.0.38.24, 10.0.183.22
*   Trying 10.0.105.106:3128...
* CONNECT tunnel: HTTP/1.1 negotiated
* Establish HTTP proxy tunnel to www.pixiv.net:443
> CONNECT www.pixiv.net:443 HTTP/1.1
> Host: www.pixiv.net:443
> User-Agent: curl/8.15.0
> Proxy-Connection: Keep-Alive
>
< HTTP/1.1 200 Connection established
<
* CONNECT phase completed
* CONNECT tunnel established, response 200
* ALPN: curl offers h2,http/1.1
* TLSv1.3 (OUT), TLS handshake, Client hello (1):
* TLSv1.3 (IN), TLS handshake, Server hello (2):
* TLSv1.3 (IN), TLS handshake, Encrypted Extensions (8):
* TLSv1.3 (IN), TLS handshake, Certificate (11):
* TLSv1.3 (IN), TLS handshake, CERT verify (15):
* TLSv1.3 (IN), TLS handshake, Finished (20):
* TLSv1.3 (OUT), TLS change cipher, Change cipher spec (1):
* TLSv1.3 (OUT), TLS handshake, Finished (20):
* SSL connection using TLSv1.3 / TLS_AES_256_GCM_SHA384 / x25519 / id-ecPublicKey
* ALPN: server accepted h2
* Server certificate:
*  subject: CN=pixiv.net
*  subjectAltName: host "www.pixiv.net" matched cert's "*.pixiv.net"
*  issuer: C=US; O=Google Trust Services; CN=WE1
*  SSL certificate verify ok.
* using HTTP/2
> GET / HTTP/2
> Host: www.pixiv.net
> User-Agent: curl/8.15.0
> Accept: */*
>
< HTTP/2 200
< date: Fri, 20 Mar 2026 23:35:09 GMT
< content-type: text/html; charset=UTF-8
```

### Response Body (Excerpt)

The response was a full HTML page (the pixiv.net landing/login page), approximately 44 KB in size. Here is a brief excerpt from the beginning of the response body:

```html
<!DOCTYPE html>
<html lang="ja" xmlns:og="http://ogp.me/ns#" xmlns:fb="http://www.facebook.com/2008/fbml">
<head>
    <meta charset="utf-8">
    <title>[pixiv] - Pair your creativity, with your fandom.</title>
    <meta name="application-name" content="pixiv">
    <meta name="mobile-web-app-capable" content="yes">
    ...
</head>
<body class="not-logged-in">
    ...
</body>
</html>
```

### Conclusion

The `curl` command to `https://www.pixiv.net` completed successfully with an HTTP 200 response. The connection was established through a proxy (`BigWeaverExecEnvMgnt-ProxyLB`) using a CONNECT tunnel, and TLSv1.3 was negotiated. The site returned its standard Japanese-language landing page for non-authenticated users.
