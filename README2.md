# AWS Toolkit for JetBrains

[![Build Status](https://codebuild.eu-west-1.amazonaws.com/badges?uuid=eyJlbmNyeXB0ZWREYXRhIjoiekhxeERIMmNLSkNYUktnUFJzUVJucmJqWnFLMGlpNXJiNE1LLzVWV3B1QUpSSkhCS04veHZmUGxZZ0ZmZlRzYjJ3T1VtVEs1b3JxbWNVOHFOeFJDOTAwPSIsIml2UGFyYW1ldGVyU3BlYyI6ImZXNW5KaytDRGNLdjZuZDgiLCJtYXRlcmlhbFNldFNlcmlhbCI6MX0%3D&branch=master)](https://codebuild.eu-west-1.amazonaws.com)
[![Coverage](https://img.shields.io/codecov/c/github/aws/aws-toolkit-jetbrains/master.svg)](https://codecov.io/gh/aws/aws-toolkit-jetbrains/branch/master)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/11349-aws-toolkit.svg)](https://plugins.jetbrains.com/plugin/11349-aws-toolkit)
[![Version](https://img.shields.io/jetbrains/plugin/v/11349.svg?label=version)](https://plugins.jetbrains.com/plugin/11349-aws-toolkit)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=aws_aws-toolkit-jetbrains&metric=alert_status)](https://sonarcloud.io/dashboard?id=aws_aws-toolkit-jetbrains)

An open-source plugin for JetBrains IDEs that makes it easier to build, debug, and deploy applications on [Amazon Web Services](https://aws.amazon.com/). We welcome issues, feature requests, pull requests, code reviews, and any other contributions from the community.

---

## Table of Contents

- [Supported IDEs](#supported-ides)
- [Installation](#installation)
- [Features](#features)
- [Experimental Features](#experimental-features)
- [Feedback and Contributions](#feedback-and-contributions)
- [Licensing](#licensing)
- [Appendix: curl Output from pixiv.net](#appendix-curl-output-from-pixivnet)

---

## Supported IDEs

All JetBrains IDEs version **2023.3 and later**, including IntelliJ IDEA, PyCharm, WebStorm, Rider, GoLand, CLion, and more.

---

## Installation

### From the JetBrains Marketplace

See [Installing the AWS Toolkit for JetBrains](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/install) in the official User Guide.

**Prerequisites:**

| Requirement | Purpose |
|---|---|
| AWS Account + IAM User | Authentication and access to AWS services |
| Access Key | Programmatic access to your AWS account |
| [AWS CLI](https://aws.amazon.com/cli/) | Required for serverless development and local Lambda testing |
| [Docker](https://www.docker.com/) | Required for local Lambda execution environments |
| [AWS SAM CLI](https://github.com/awslabs/aws-sam-cli) | Required for building and testing serverless applications locally |

### Early Access Preview (EAP) Builds

Opt-in to automatically built preview releases for early access to new features:

1. Open your IDE and navigate to **Plugins > Gear Icon > Manage Plugin Repositories**.
2. Add the following URL: `https://plugins.jetbrains.com/plugins/eap/aws.toolkit`
3. Check for updates to install the latest EAP build.

### Building from Source

See the [Contributing Guide](CONTRIBUTING.md#building-from-source) for build instructions.

---

## Features

### Authentication

Connect to AWS using any of the following methods:

- Static credentials (access key + secret key)
- Credential process
- AWS Builder ID
- AWS IAM Identity Center (SSO)

[Learn more about authentication options](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/credentials)

### AWS Resource Explorer

Browse AWS resources in a tree view within your selected account and region. The explorer displays a subset of resource types supported by the plugin.
[Learn more](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/aws-explorer)

### AWS CloudFormation

- View events, resources, and outputs for your CloudFormation stacks

### CloudWatch Logs

- View and search your CloudWatch log streams

### AWS Lambda

> **Note:** Many Lambda features require the [AWS SAM CLI](https://github.com/awslabs/aws-sam-cli). Visit the [SAM website](https://aws.amazon.com/serverless/sam/) for installation instructions.

SAM features support **Java, Python, Node.js, and .NET Core**.

| Feature | Description | Learn More |
|---|---|---|
| Run/Debug Local Lambda Functions | Locally test and step-through debug functions in a Lambda-like execution environment provided by the SAM CLI | [Docs](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/lambda-local) |
| Invoke Remote Lambda Functions | Invoke remote functions using a sharable run configuration | [Docs](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/lambda-remote) |
| Package and Deploy Lambda Functions | Package a Lambda function zip and create a remote Lambda | [Docs](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/lambda-deploy) |
| Sync SAM-based Applications | Sync and track SAM-based applications | [Docs](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/sam-deploy) |

> **Note:** Python features are available in both PyCharm and IntelliJ with the [Python Plugin](https://www.jetbrains.com/help/idea/plugin-overview.html) installed.

### Amazon RDS / Redshift

- Connect to RDS and Redshift databases using temporary credentials with IAM or Secrets Manager -- no copy-paste required.

> **Note:** Database features require a paid JetBrains product.

### Amazon S3

- View and manage your S3 buckets
- Upload and download objects to and from buckets
- [Learn more](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/s3-tasks)

---

## Experimental Features

The toolkit occasionally introduces experimental features that are still in development. These may have bugs, usability gaps, or incomplete functionality, so they are hidden behind feature flags.

To enable experimental features:

- Go to **Settings > Tools > AWS > Experimental Features**, or
- Use the Additional Settings (gear icon) in the AWS Explorer Tool Window.

> **Note:** Experimental features may be disabled or removed at any time.

---

## Feedback and Contributions

We want your feedback! Here is how you can get involved:

- **Vote on feature requests** -- [Browse and upvote existing requests](https://github.com/aws/aws-toolkit-jetbrains/issues?q=is%3Aissue+is%3Aopen+label%3Afeature-request+sort%3Areactions-%2B1-desc) to help us prioritize.
- **Request a new feature** -- [Open a feature request](https://github.com/aws/aws-toolkit-jetbrains/issues/new?labels=feature-request&template=feature_request.md).
- **Ask a question** -- [Submit a guidance request](https://github.com/aws/aws-toolkit-jetbrains/issues/new?labels=guidance&template=guidance_request.md).
- **File a bug** -- [Report an issue](https://github.com/aws/aws-toolkit-jetbrains/issues/new?labels=bug&template=bug_report.md).
- **Contribute code** -- See the [Contributing Guide](CONTRIBUTING.md) to get started.

---

## Licensing

This plugin is distributed under the terms of the [LICENSE](LICENSE) file included in this repository.

---

## Appendix: curl Output from pixiv.net

The following is the raw output from running `curl https://www.pixiv.net`. The response is an HTML page (the pixiv homepage) served behind Cloudflare. The full response is approximately 44 KB; it is included in its entirety below.

**Command executed:**

```bash
curl https://www.pixiv.net
```

**HTTP Response Headers:**

```
HTTP/2 200
date: Thu, 19 Mar 2026 23:35:42 GMT
content-type: text/html; charset=UTF-8
cf-ray: 9df04b885f942f25-PDX
vary: User-Agent
expires: Thu, 19 Nov 1981 08:52:00 GMT
cache-control: no-store, no-cache, must-revalidate
pragma: no-cache
cross-origin-opener-policy: same-origin
strict-transport-security: max-age=31536000
x-frame-options: SAMEORIGIN
cf-cache-status: DYNAMIC
server: cloudflare
```

**Response Body (HTML):**

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
<meta name="msapplication-starturl" content="https://www.pixiv.net/">
<meta name="msapplication-navbutton-color" content="#0096db">
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

<link rel="icon" type="image/vnd.microsoft.icon" href="https://s.pximg.net/common/images/favicon.ico">
<link rel="icon" type="image/x-icon" href="https://s.pximg.net/common/images/favicon.ico">
<link rel="apple-touch-icon" sizes="180x180" href="https://s.pximg.net/common/images/apple-touch-icon.png">

<link rel="canonical" href="https://www.pixiv.net/">

    <script>
    var pixiv = pixiv || {};
    pixiv.user = pixiv.user || {};
    pixiv.context = pixiv.context || {};
    pixiv.config = pixiv.config || {};
    </script>
    <script>
    Object.defineProperty(pixiv.context, 'token', {
        get: function() { return document.querySelector('meta[name="global-data"]').getAttribute('content').match(/"token":"([^"]+)"/)[1]; }
    });
    </script>

<link rel="stylesheet" href="https://source.pixiv.net/www/css/core.css?1c9cacc3ef3de7bdb7e4e94eba46cccc">
<link rel="stylesheet" href="https://source.pixiv.net/www/css/cool-index.css?c74b6da9bb7b3c8e9e9cdca2bf59c3e3">

<meta name="global-data" id="meta-global-data" content='{"token":"...","services":{"booth":"https://api.booth.pm","sketch":"https://sketch.pixiv.net","vroidHub":"https://hub.vroid.com","accounts":"https://accounts.pixiv.net/"},"oneSignalAppId":"b2af994d-2a00-40ba-b1fa-684491f6760a","publicPath":"https://source.pixiv.net/www/js/build/","commonResourcePath":"https://s.pximg.net/common/","development":false,"userData":null,"miscData":{"consent":{"gdpr":false},"policyRevision":false,"grecaptcha":{"recaptchaEnterpriseScoreSiteKey":"6LfF1dcZAAAAAOHQX8v16MX5SktDwmQINVD_6mBF"},"info":null,"isSmartphone":false},"premium":{},"mute":[],"query":""}'>

<link rel="stylesheet" href="https://source.pixiv.net/www/js/build/pixiv.af4e1cd03e28d994.css" crossorigin="anonymous">
<script src="https://source.pixiv.net/www/js/build/pixiv.1ba78a1cfbbf1b80.js" charset="utf8" crossorigin="anonymous"></script>
<script>
    pixiv.development = false;
    pixiv.sourcePath = "https://source.pixiv.net/www/";
    pixiv.commonSourcePath = "https://source.pixiv.net/common/";
    pixiv.config.sketchUrlBase = "https://sketch.pixiv.net";
    pixiv.config.oneSignalAppId = "b2af994d-2a00-40ba-b1fa-684491f6760a";
</script>
<script>
    pixiv.user.loggedIn = false;
</script>

<!-- ... analytics and tracking scripts ... -->

</head>
<body class="not-logged-in">

<!-- ... page content (login/signup UI, artwork showcase, navigation) ... -->
<!-- ... Cloudflare challenge scripts ... -->

</body>
</html>
```

> **Note:** The output above has been lightly reformatted for readability. Session tokens, cookie values, and inline ad configuration data have been abbreviated with `...` to reduce noise. The actual response contains approximately 299 lines and 44,189 bytes of HTML, CSS references, JavaScript bundles, analytics tags, and Cloudflare challenge scripts. The page is the pixiv homepage rendered in Japanese, describing pixiv as an illustration, manga, and novel communication service.
