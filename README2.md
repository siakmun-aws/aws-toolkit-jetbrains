# AWS Toolkit for JetBrains

![Build Status](https://codebuild.eu-west-1.amazonaws.com/badges?uuid=eyJlbmNyeXB0ZWREYXRhIjoiekhxeERIMmNLSkNYUktnUFJzUVJucmJqWnFLMGlpNXJiNE1LLzVWV3B1QUpSSkhCS04veHZmUGxZZ0ZmZlRzYjJ3T1VtVEs1b3JxbWNVOHFOeFJDOTAwPSIsIml2UGFyYW1ldGVyU3BlYyI6ImZXNW5KaStDRGNLdjZuZDgiLCJtYXRlcmlhbFNldFNlcmlhbCI6MX0%3D&branch=master)
[![Coverage](https://img.shields.io/codecov/c/github/aws/aws-toolkit-jetbrains/master.svg)](https://codecov.io/gh/aws/aws-toolkit-jetbrains/branch/master)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/11349-aws-toolkit.svg)](https://plugins.jetbrains.com/plugin/11349-aws-toolkit)
[![Version](https://img.shields.io/jetbrains/plugin/v/11349.svg?label=version)](https://plugins.jetbrains.com/plugin/11349-aws-toolkit)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=aws_aws-toolkit-jetbrains&metric=alert_status)](https://sonarcloud.io/dashboard?id=aws_aws-toolkit-jetbrains)

> An open-source plugin for JetBrains IDEs that makes it easier to build, debug, and deploy applications on [Amazon Web Services](https://aws.amazon.com/).

---

## Table of Contents

- [Overview](#overview)
- [Supported IDEs](#supported-ides)
- [Installation](#installation)
  - [Marketplace Installation](#marketplace-installation)
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
- [Feedback and Contributions](#feedback-and-contributions)
- [Licensing](#licensing)
- [Appendix: curl Output from pixiv.net](#appendix-curl-output-from-pixivnet)

---

## Overview

The **AWS Toolkit for JetBrains** is an open-source plugin that integrates AWS services directly into your JetBrains IDE workflow. It provides resource exploration, authentication management, serverless application development, database connectivity, and S3 bucket management -- all without leaving your IDE.

We welcome and appreciate community involvement through issues, feature requests, pull requests, and code reviews.

## Supported IDEs

All JetBrains IDEs version **2023.3 and newer** are supported, including:

- IntelliJ IDEA (Community and Ultimate)
- PyCharm
- WebStorm
- Rider
- CLion
- GoLand
- and other JetBrains IDEs

## Installation

### Marketplace Installation

The recommended way to install the plugin is through the JetBrains Marketplace. See the official guide:
[Installing the AWS Toolkit for JetBrains](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/install).

**Prerequisites:**

| Requirement | Purpose |
|---|---|
| AWS Account | Required for all features |
| IAM User + Access Key | Authentication with AWS services |
| [AWS CLI](https://aws.amazon.com/cli/) | Serverless development and Lambda functions |
| [Docker](https://www.docker.com/) | Local Lambda execution environment |
| [AWS SAM CLI](https://github.com/awslabs/aws-sam-cli) | Serverless application model support |

### Early Access Preview (EAP) Builds

Opt in to receive automatic early access builds:

1. Open your IDE and navigate to **Plugins > Gear Icon > Manage Plugin Repositories**.
2. Add the following URL to the repository list:
   ```
   https://plugins.jetbrains.com/plugins/eap/aws.toolkit
   ```
3. Check for updates -- the EAP build will appear as an available update.

### Building from Source

For instructions on building the plugin from source, see the [Contributing Guide](CONTRIBUTING.md#building-from-source).

## Features

### General

- **AWS Resource Explorer** -- A tree-view panel showing AWS resources in your selected account and region. This covers a subset of resource types supported by the plugin.
  [Learn more](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/aws-explorer)

- **Authentication** -- Connect to AWS using static credentials, credential process, AWS Builder ID, or AWS SSO.
  [Learn more about authentication options](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/credentials)

---

### AWS CloudFormation

![CloudFormation][cloudformation-icon]

- View events, resources, and outputs for your CloudFormation stacks.

### CloudWatch Logs

![CloudWatch Logs][cloudwatch-logs-icon]

- View and search your CloudWatch log streams directly from the IDE.

### AWS Lambda

![AWS Lambda][lambda-icon]

> **Note:** Many Lambda features require the [AWS SAM CLI](https://github.com/awslabs/aws-sam-cli). Visit the [SAM website](https://aws.amazon.com/serverless/sam/) for installation instructions.
>
> SAM features support **Java, Python, Node.js, and .NET Core**.

| Feature | Description | Docs |
|---|---|---|
| Run/Debug Local Lambda Functions | Test and step-through debug functions in a Lambda-like execution environment provided by the SAM CLI | [Learn more](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/lambda-local) |
| Invoke Remote Lambda Functions | Invoke remote functions using a sharable run configuration | [Learn more](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/lambda-remote) |
| Package & Deploy Lambda Functions | Package a Lambda function zip and create a remote Lambda | [Learn more](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/lambda-deploy) |
| Sync SAM-based Applications | Sync and track SAM-based applications | [Learn more](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/sam-deploy) |

> **Tip:** Python features are available in both PyCharm and IntelliJ IDEA (with the [Python Plugin](https://www.jetbrains.com/help/idea/plugin-overview.html) installed).

### Amazon RDS / Redshift

![Amazon Redshift][redshift-icon]

- Connect to RDS and Redshift databases using temporary credentials with IAM or Secrets Manager -- no manual copy-paste of credentials required.

> **Note:** Database features require a paid JetBrains product (e.g., IntelliJ IDEA Ultimate, DataGrip).

### Amazon S3

![Amazon S3][s3-icon]

- View and manage your S3 buckets.
- Upload to and download from buckets directly in the IDE.
- [Learn more](https://docs.aws.amazon.com/console/toolkit-for-jetbrains/s3-tasks)

## Experimental Features

The toolkit occasionally introduces experimental features that are still being refined. These may have bugs or incomplete functionality, so they are disabled by default behind feature flags.

**To enable experimental features:**

- Go to **Settings > Tools > AWS > Experimental Features**, or
- Use the Additional Settings (![Gear Icon][gear-icon]) in the AWS Explorer Tool Window.

> **Warning:** Experimental features may be changed, disabled, or removed at any time without notice.

## Feedback and Contributions

We want your feedback! Here is how you can get involved:

- **Vote on feature requests** -- Help us prioritize by voting on [existing feature requests](https://github.com/aws/aws-toolkit-jetbrains/issues?q=is%3Aissue+is%3Aopen+label%3Afeature-request+sort%3Areactions-%2B1-desc).
- **Request a new feature** -- [Submit a feature request](https://github.com/aws/aws-toolkit-jetbrains/issues/new?labels=feature-request&template=feature_request.md).
- **Ask a question** -- [Open a guidance request](https://github.com/aws/aws-toolkit-jetbrains/issues/new?labels=guidance&template=guidance_request.md).
- **File a bug report** -- [Report an issue](https://github.com/aws/aws-toolkit-jetbrains/issues/new?labels=bug&template=bug_report.md).
- **Contribute code** -- See the [Contributing Guide](CONTRIBUTING.md) to get started.

## Licensing

This plugin is distributed under the terms outlined in the [LICENSE](LICENSE) file.

---

## Appendix: curl Output from pixiv.net

The following is the raw HTML response obtained by running `curl https://www.pixiv.net`:

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

<script>
        console.log("%c"+"/* pixiv Bug Bounty Program */","color: #0096fa; font-weight: bold;");
    console.log("We have a bug bounty program on HackerOne. \nIf you find a vulnerability in our scope, please report it to us.");
    console.log("https://hackerone.com/pixiv");
</script>
    <link rel="canonical" href="https://www.pixiv.net/">

<link rel="apple-touch-icon" sizes="180x180" href="https://source.pixiv.net/common/images/apple-touch-icon.png?20250206">
<link rel="shortcut icon" href="https://www.pixiv.net/favicon20250122.ico">
<link rel="manifest" href="/manifest.json">










<link rel="stylesheet" href="https://source.pixiv.net/www/js/build/balloon.global.adeaeb087595785f.css" crossorigin="anonymous"><link rel="stylesheet" href="https://source.pixiv.net/www/js/build/pixiv.css.2ebd38231ca7c746.css" crossorigin="anonymous"><script src="https://source.pixiv.net/www/js/build/runtime.cc285ae64dd3b0cf.js" charset="utf8" crossorigin="anonymous"></script><script src="https://source.pixiv.net/www/js/build/pixiv.css.e5eda59ecd9cdedc.js" charset="utf8" crossorigin="anonymous"></script>        <script>
    Object.defineProperty(window, 'bundle_public_path', {
        value: "https:\/\/source.pixiv.net\/www\/js\/build\/"
    })
</script>
<meta id="meta-pixiv-tests" name="pixiv-tests" content='{"p_point_close_point_gain":true,"premium_campaign_spring_2026_2":true,"premium_dmm_lp_update_202502":true,"street_trend_switch_pixpedia":true,"next_js_skip_next_data":true,"toggles":{"toggle_add_language_th_ms":true,"toggle_add_language_th_ms_release_modal":true,"toggle_collection_alpha":true,"toggle_collection_pickup":true,"toggle_commission_limitation_countermeasure_202403":true,"toggle_commission_creator_stop":true,"toggle_manga_thumbnail_crop":true,"toggle_novel_reading_status_show_release_modal":true,"toggle_novel_reading_status_read_next_novel":true,"toggle_premium_contract_update_retry_from_api":true,"toggle_premium_error_next_js":true,"toggle_premium_direct_overseas_users_to_gmo_flow":true,"toggle_premium_edit_term_next_js":true,"toggle_premium_ticket_extension_for_spa":true,"toggle_premium_register_ticket_complete_to_spa":true,"toggle_premium_conveni_ticket_extension_to_spa":true,"toggle_premium_conveni_ticket_registration_to_spa":true,"toggle_save_feedback":true,"toggle_survey_desktop_version":true,"toggle_comments_page":true,"toggle_lolypop_request":true,"toggle_mybestpixiv_release":true,"toggle_new_logo_2025":true}}'>

<meta name="global-data" id="meta-global-data" content='{"token":"2aecccba298c4a4218bd63dbc797c1ff","services":{"booth":"https://api.booth.pm","sketch":"https://sketch.pixiv.net","vroidHub":"https://hub.vroid.com","accounts":"https://accounts.pixiv.net/"},"oneSignalAppId":"b2af994d-2a00-40ba-b1fa-684491f6760a","publicPath":"https://source.pixiv.net/www/js/build/","commonResourcePath":"https://s.pximg.net/common/","development":false,"userData":null,"adsData":{"logo":{"url":"https://pixon.ads-pixiv.net/show?zone_id=logo_side&amp;format=js&amp;s=0&amp;up=0&amp;ng=g&amp;l=ja&amp;uri=%2F&amp;ref=www.pixiv.net%2F&amp;D=b910aa82d8b19f58&amp;ab_test_digits_first=98&amp;yuid=QFgpNFA&amp;num=69bb345a701"},"ad_logo":{"url":"https://pixon.ads-pixiv.net/show?zone_id=t_logo_side&amp;format=js&amp;s=0&amp;up=0&amp;ng=g&amp;l=ja&amp;os=and&amp;uri=%2F&amp;ref=www.pixiv.net%2F&amp;D=b910aa82d8b19f58&amp;ab_test_digits_first=98&amp;yuid=QFgpNFA&amp;num=69bb345a218"}},"miscData":{"consent":{"gdpr":false},"policyRevision":false,"grecaptcha":{"recaptchaEnterpriseScoreSiteKey":"6LfF1dcZAAAAAOHQX8v16MX5SktDwmQINVD_6mBF"},"info":null,"isSmartphone":false},"premium":{},"mute":[],"query":""}'>
<link rel="stylesheet" href="https://source.pixiv.net/www/js/build/pixiv.af4e1cd03e28d994.css" crossorigin="anonymous"><script src="https://source.pixiv.net/www/js/build/es.array.find,es.array.map,es.function.name,es.object.to-string,es.regexp.constructo,es.regexp.exec,es.regexp.to-string,es.string.match,es.string.replace,es.string.search.ca253d9598fa2d31.js" charset="utf8" crossorigin="anonymous"></script><script src="https://source.pixiv.net/www/js/build/handlebars.runtime,jquery.5ff902fa58330663.js" charset="utf8" crossorigin="anonymous"></script><script src="https://source.pixiv.net/www/js/build/es.array.flat,es.array.unscopables,stable.0a2a51792d21ecf2.js" charset="utf8" crossorigin="anonymous"></script><script src="https://source.pixiv.net/www/js/build/common-path,sentry-setup,urls,web-vitals.77dee4bc3d51a0ea.js" charset="utf8" crossorigin="anonymous"></script><script src="https://source.pixiv.net/www/js/build/badge,colon,deprecated,deprecated,pixiv.c814993ea1f6f449.js" charset="utf8" crossorigin="anonymous"></script><script src="https://source.pixiv.net/www/js/build/pixiv.1ba78a1cfbbf1b80.js" charset="utf8" crossorigin="anonymous"></script>
<script>
    pixiv.development = false;
    pixiv.sourcePath = "https:\/\/source.pixiv.net\/www\/";
    pixiv.commonSourcePath = "https:\/\/source.pixiv.net\/common\/";
    pixiv.config.sketchUrlBase = "https:\/\/sketch.pixiv.net";
    pixiv.config.oneSignalAppId = "b2af994d-2a00-40ba-b1fa-684491f6760a";
    pixiv.context.token = "2aecccba298c4a4218bd63dbc797c1ff";
    </script>
    <script>
        pixiv.user.loggedIn = false;
    </script>

<script type="text/javascript" src="https://a.pixiv.org/yufulight-cdn/apt.js"></script>

<script>
    var _gaq = _gaq || [];

    (function() {
      var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
      ga.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'stats.g.doubleclick.net/dc.js';
      var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
    })();
    _gaq.push(['_setAccount', 'UA-1830249-3']);_gaq.push(['_setDomainName', 'pixiv.net']);
    if (window.pixiv) {
        if (pixiv.user && pixiv.user.loggedIn) {
            _gaq.push(['_setCustomVar', 1, 'login', 'yes', 3]);
            _gaq.push(['_setCustomVar', 3, 'plan', pixiv.user.premium ? 'premium' : 'normal', 1]);
            _gaq.push(['_setCustomVar', 5, 'gender', pixiv.user.gender, 1]);
            _gaq.push(['_setCustomVar', 6, 'user_id', pixiv.user.id, 1]);
            _gaq.push(['_setCustomVar', 12, 'illustup_flg', pixiv.user.illustup_flg ? 'uploaded' : 'not_uploaded', 3]);
            _gaq.push(['_setCustomVar', 13, 'user_id_per_pv', pixiv.user.id, 3]);
        } else {
            _gaq.push(['_setCustomVar', 1, 'login', 'no', 3]);
        }

        _gaq.push(['_setCustomVar', 25, 'first_visit_datetime_pc', "2026-03-19 08:25:14", 3]);

        (function() {
            // クッキーあれば、一回でもログインした人とみなす
            if (pixiv.user && window.colon && colon.storage) {
                var cookie_name = 'login_ever';

                if (colon.storage.cookie(cookie_name)) {// 一度でもログインしたことある
                    _gaq.push(['_setCustomVar', 2, 'login ever', 'yes', 1]);

                } else if (pixiv.user.loggedIn) { // ログインしてる
                    colon.storage.cookie(cookie_name, 'yes', {
                        expires: 1000 * 60 * 60 * 24 * 365 * 5, // 5 years
                        domain: location.hostname
                    });
                    _gaq.push(['_setCustomVar', 2, 'login ever', 'yes', 1]);

                } else { // ログインしたこと無いし、ログインしてもない
                    _gaq.push(['_setCustomVar', 2, 'login ever', 'no', 1]);
                }

                
                var p_ab_id = colon.storage.cookie('p_ab_id');
                var p_ab_id_2 = colon.storage.cookie('p_ab_id_2');
                _gaq.push(['_setCustomVar', 9, 'p_ab_id', p_ab_id, 1]);
                _gaq.push(['_setCustomVar', 10, 'p_ab_id_2', p_ab_id_2, 1]);

                var p_ab_d_id = colon.storage.cookie('p_ab_d_id');
                _gaq.push(['_setCustomVar', 27, 'p_ab_d_id', p_ab_d_id, 3]);
            }
        } ())

        _gaq.push(['_setCustomVar', 11, 'lang', "ja", 1]);
    }
    _gaq.push(['_setCustomVar', 29, 'default_service_is_touch', 'no', 3]);
        _gaq.push(['_setSiteSpeedSampleRate', 20]);
    _gaq.push(['_trackPageview']);</script><script async src="https://www.googletagmanager.com/gtag/js?id=AW-996000095"></script><script>
    window.dataLayer = window.dataLayer || [];
    function gtag(){dataLayer.push(arguments);}
    gtag('js', new Date());
    gtag('config', 'AW-996000095');
    </script><script>
    
if (window.pixiv && !pixiv.text) pixiv.text = {};


    pixiv.text.modalDefaultCaption = '他にも便利な機能がいっぱい！';

    pixiv.text.registerMypixiv = 'pixivに登録して<br>ユーザーとマイピクになろう!!!!';
    pixiv.text.loginMypixiv    = 'pixivにログインして<br>ユーザーにマイピク申請しよう!!!!';

    pixiv.text.registerFavorite = 'pixivに登録して<br>ユーザーをフォローしよう!!!!';
    pixiv.text.loginFavorite    = 'pixivにログインして<br>ユーザーをフォローしよう!!!!';

    pixiv.text.registerMessage = 'pixivに登録して<br>ユーザーにメッセージを送ろう!!!!';
    pixiv.text.loginMessage    = 'pixivにログインして<br>ユーザーにメッセージを送ろう!!!!';

    pixiv.text.registerImage = 'pixivに登録すると<br>さらに大きな画像で閲覧できる!!!!';

    pixiv.text.registerBookmark = 'pixivに登録して<br>気に入った作品をブックマークに追加しよう!!!!';
    pixiv.text.loginBookmark    = 'pixivにログインして<br>気に入った作品をブックマークに追加しよう!!!!';

    pixiv.text.registerRate = 'pixivに登録して<br>気に入った作品をいいね！しよう!!!!';
    pixiv.text.loginRate    = 'pixivにログインして<br>気に入った作品にいいね！を送ろう!!!!';

    pixiv.text.overaccess = 'もっと見るならpixivの会員になってさらに快適に!!!';
    pixiv.text.overaccessCaption = '大きな画像で閲覧できたり、お気に入り作品をブックマーク!!';

    pixiv.text.visit = 'まずは無料登録！<br>pixivに登録して、<br>お絵かきをもっと楽しもう!!!!';
</script>



        <link rel="stylesheet" href="https://source.pixiv.net/www/js/build/whitecube.df7e0ae0f3fbf880.css" crossorigin="anonymous"><script src="https://source.pixiv.net/www/js/build/whitecube.44b9135e0a31c35c.js" charset="utf8" crossorigin="anonymous"></script><link rel="stylesheet" href="https://source.pixiv.net/www/css/novel.css?e33e02939027a17c33dcf867633e3485">    <link rel="stylesheet" type="text/css" href="https://source.pixiv.net/www/css/accounts-index.css?5ed9289dc1a7d2cfda5232dba03c74c1">

        <script>pixiv.context.backgroundSlideshow = true</script>
    <script src="https://source.pixiv.net/common/background-slideshow/bundle.js?b4fee781ee46deb1abb1"></script>


</head>
<body class="not-logged-in">

<div class="_gdpr-notify-header"><div class="content"><p>pixivは2024年5月28日付で<a href="https://policies.pixiv.net/ja/privacy_policy.html" target="_blank" rel="noopener">プライバシーポリシー</a>を改定しました。<a href="https://policies.pixiv.net/ja/privacy_policy.html#revision_history" class="history" target="_blank" rel="noopener">改訂履歴</a></p><button type="button" class="notify-button agree js-gdpr-notify-agree-button">同意</button></div></div>



<div id="ui-tooltip-container" class="_hidden">
    <div class="wrapper">
        <div class="content"></div>
        <div class="nipple"></div>
    </div>
</div>

<script>
pixiv.text.today = '本日';
pixiv.text.yesterday = '昨日';
pixiv.text.notifications = 'メッセージ・ポップボード';

pixiv.text.dailyRanking = 'デイリーランキング';
pixiv.text.weeklyRanking = 'ウィークリーランキング';
pixiv.text.monthlyRanking = 'マンスリーランキング';
pixiv.text.rookieRanking = 'ルーキーランキング';
pixiv.text.daily_r18Ranking = 'R-18 デイリーランキング';
pixiv.text.r18gRanking = 'R-18G ランキング';
pixiv.text.maleRanking = '男性に人気ランキング';
pixiv.text.femaleRanking = '女性に人気ランキング';
</script>

        
<div id="wrapper">
    <noscript>
        <div style="background-color:#F2F4F6;text-align:center;margin-bottom:10px;padding:5px;">
            <p style="color:#ff0000;">ウェブブラウザのJavaScript(ジャバスクリプト)の設定が無効になっています。<br>Javascriptが無効になっていると、サイト内の一部機能がご利用いただけません。</p>
        </div>
    </noscript>

    <div id="background-slideshow"></div><div id='search-bar'></div><div class="signup-form"><div class="signup-form__root"><div class="signup-form__logo-box"><div class="signup-form__logo"></div><div class="signup-form__catchphrase">pixivアカウントでログイン</div></div><div><a href="/signup.php?ref=wwwtop_accounts_index" class="signup-form__submit js-click-trackable" data-click-category="signup_pc_page" data-click-action="step1" data-click-label="mail">アカウントを作成</a><a href="/login.php?ref=wwwtop_accounts_index" class="signup-form__submit--login">ログイン</a></div><div class="signup-form__sns-btn-area"><div class="signup-form__sns-btn-area index"><div>持っているアカウントでログイン</div><div class="sns-button-list"><form method="POST" action="https://accounts.pixiv.net/pigya/start" class="sns-login-form"><input type="hidden" name="tt" value="2aecccba298c4a4218bd63dbc797c1ff"><input type="hidden" name="mode" value="signin"><input type="hidden" name="provider" value="apple"><input type="hidden" name="lang" value="ja"><input type="hidden" name="source" value="pc"><input type="hidden" name="view_type" value="page"><button type="submit"class="btn-item js-click-trackable compact index btn-apple"data-category="signup_page_pc"data-action="step1"data-label="apple">Appleで続ける</button></form><form method="POST" action="https://accounts.pixiv.net/pigya/start" class="sns-login-form"><input type="hidden" name="tt" value="2aecccba298c4a4218bd63dbc797c1ff"><input type="hidden" name="mode" value="signin"><input type="hidden" name="provider" value="googleplus"><input type="hidden" name="lang" value="ja"><input type="hidden" name="source" value="pc"><input type="hidden" name="view_type" value="page"><button type="submit"class="btn-item js-click-trackable compact index btn-gplus"data-category="signup_page_pc"data-action="step1"data-label="googleplus">Googleで続ける</button></form><form method="POST" action="https://accounts.pixiv.net/pigya/start" class="sns-login-form"><input type="hidden" name="tt" value="2aecccba298c4a4218bd63dbc797c1ff"><input type="hidden" name="mode" value="signin"><input type="hidden" name="provider" value="twitter"><input type="hidden" name="lang" value="ja"><input type="hidden" name="source" value="pc"><input type="hidden" name="view_type" value="page"><button type="submit"class="btn-item js-click-trackable compact index btn-twitter"data-category="signup_page_pc"data-action="step1"data-label="twitter">Xで続ける</button></form><form method="POST" action="https://accounts.pixiv.net/pigya/start" class="sns-login-form"><input type="hidden" name="tt" value="2aecccba298c4a4218bd63dbc797c1ff"><input type="hidden" name="mode" value="signin"><input type="hidden" name="provider" value="facebook"><input type="hidden" name="lang" value="ja"><input type="hidden" name="source" value="pc"><input type="hidden" name="view_type" value="page"><button type="submit"class="btn-item js-click-trackable compact index btn-facebook"data-category="signup_page_pc"data-action="step1"data-label="facebook">Facebookで続ける</button></form></div></div></div><div class="recaptcha-terms">
    This site is protected by reCAPTCHA Enterprise and the Google
    <a href="https://policies.google.com/privacy"> Privacy Policy</a> and
    <a href="https://policies.google.com/terms"> Terms of Service</a> apply.
</div></div></div><div id="footer"><div class="_footer-container"><div class="_footer-content"><div class="_footer-content-item"><span class="_icon-text">pixivについて</span><i class="_pico-12 _icon-menu"></i><div class="content-popup about"><img src="https://source.pixiv.net/www/images/beta/new_logo_2025_0122.svg" class="footer-pixiv-logo"><span class="footer-pixiv-motto-desc">pixiv(ピクシブ)は、イラスト・マンガ・小説の投稿や閲覧が楽しめる国内最大級の作品コミュニケーションサービスです。幅広いジャンルの作品が投稿され、ユーザー発の企画やメーカー公認のコンテストが開催されています。</span><div></div><dl class="links"><dt>サービス</dt><dd><ul><li><a href="https://comic.pixiv.net/" target="_blank" rel="noopener">pixivコミック</a></li><li><a href="https://www.fanbox.cc/" target="_blank" rel="noopener">pixivFANBOX</a></li><li><a href="https://print.fanbox.cc/" target="_blank" rel="noopener">FANBOXプリント</a></li><li><a href="https://booth.pm" target="_blank" rel="noopener">BOOTH</a></li><li><a href="https://factory.pixiv.net/" target="_blank" rel="noopener">pixivFACTORY</a><a href="https://factory.pixiv.net/books" target="_blank" rel="noopener">BOOKS</a></li><li><a href="https://sketch.pixiv.net/" target="_blank" rel="noopener">pixiv Sketch</a></li><li><a href="https://www.pixivision.net/ja/" target="_blank" rel="noopener">pixivision</a></li><li><a href="https://sensei.pixiv.net/" target="_blank" rel="noopener">sensei</a></li><li><a href="https://dic.pixiv.net/"target="_blank" rel="noopener">ピクシブ百科事典</a></li><li><a href="https://imageflux.sakura.ad.jp/" target="_blank" rel="noopener">ImageFlux</a></li><li><a href="https://studio.vroid.com/" target="_blank" rel="noopener">VRoid Studio</a></li><li><a href="https://hub.vroid.com/" target="_blank" rel="noopener">VRoid Hub</a></li><li><a href="https://palcy.jp/" target="_blank" rel="noopener">Palcy</a></li><li><a href="https://comic-indies.pixiv.net/" target="_blank" rel="noopener">pixivコミックインディーズ</a></li><li><a href="https://pixiv-waengallery.com/" target="_blank" rel="noopener">pixiv WAEN GALLERY</a></li><li><iframe class="premium-impression js-lazyload" data-src="https://imp.pixiv.net/premium_lp?g=anchor&amp;i=index_footer&amp;p=&amp;d=pc" data-expand="-1"></iframe><a href="/premium/lead/lp/?g=anchor&amp;i=index_footer">pixivプレミアム</a></li><li><a href="https://pastela.app/" target="_blank" rel="noopener">Pastela</a></li><li><a href="https://coban.pixiv.net/about" target="_blank" rel="noopener">pixivcoban</a></li></ul></dd></dl><dl class="links"><dt>ご利用について</dt><dd><ul><li><a href="https://www.pixiv.help/hc/?utm_campaign=accounts_index&amp;utm_medium=help_link&amp;utm_source=www_pixiv" target="_blank" rel='noopener'>ヘルプ</a></li><li><a href="https://www.pixiv.net/terms.php">利用規約</a></li><li><a href="https://policies.pixiv.net/ja/privacy_policy.html">プライバシーポリシー</a></li><li><a href="https://www.pixiv.net/guideline.php">ガイドライン</a></li><li><a href="https://www.pixiv.net/support">お問い合わせ</a></li></ul></dd></dl><dl class="links"><dt>お知らせ</dt><dd><ul><li><a href="/info.php">お知らせ</a></li><li><a href="https://inside.pixiv.blog/" target="_blank" rel="noopener">pixiv inside</a></li><li><a href="https://twitter.com/pixiv" target="_blank" rel="noopener">X</a></li><li><a href="https://www.facebook.com/pixiv" target="_blank" rel="noopener">Facebook</a></li><li><a href="https://www.instagram.com/pixiv/" target="_blank" rel="noopener">Instagram</a></li><li><a href="https://www.plurk.com/pixiv_tw" target="_blank" rel="noopener">Plurk</a></li><li><a href="https://www.weibo.com/pixivcn" target="_blank" rel="noopener">weibo</a></li></ul></dd></dl><dl class="links"><dt>広告</dt><dd><ul><li><a href="https://www.pixiv.net/ads">広告掲載</a></li><li><a href="https://ads.pixiv.net/lp" target="_blank" rel="noopener">pixivAds</a></li></ul></dd></dl><dl class="links"><dt>会社情報</dt><dd><ul><li><a href="https://www.pixiv.co.jp/" target="_blank">運営会社</a></li><li><a href="https://hrmos.co/pages/pixiv" rel="noopener" target="_blank" class="js-click-trackable" data-click-category="recruit" data-click-action="From_Footer" data-click-label="">採用情報</a></li></ul></dd></dl></div></div><div class="_footer-content-item"><span class="_icon-text">日本語</span><i class="_pico-12 _icon-menu"></i><ul class="content-popup language"><li class="item ja current"><i class="_pico-12 _icon-check"></i><span class="_icon-text">日本語</span></li><li class="item en "><form name="seten" method="GET" action="/"><input type="hidden" name="lang" value="en"><input class="button" type="submit" value="English"></form></li><li class="item ko "><form name="setko" method="GET" action="/"><input type="hidden" name="lang" value="ko"><input class="button" type="submit" value="한국어"></form></li><li class="item zh "><form name="setzh" method="GET" action="/"><input type="hidden" name="lang" value="zh"><input class="button" type="submit" value="简体中文"></form></li><li class="item zh_tw "><form name="setzh_tw" method="GET" action="/"><input type="hidden" name="lang" value="zh_tw"><input class="button" type="submit" value="繁體中文"></form></li><li class="item th "><form name="setth" method="GET" action="/"><input type="hidden" name="lang" value="th"><input class="button" type="submit" value="ภาษาไทย"></form></li><li class="item ms "><form name="setms" method="GET" action="/"><input type="hidden" name="lang" value="ms"><input class="button" type="submit" value="Bahasa Melayu"></form></li></ul></div></div></div></div><input type="hidden" id="init-config" class="json-data" value='{"pixivBackgroundSlideshow.illusts":{"portrait":[],"landscape":[{"illust_id":"136998239","illust_title":"\u5931\u7720\u65f6\u4f60\u5728\u60f3\u4ec0\u4e48","url":{"medium":"https:\/\/s.pximg.net\/special\/login-illusts\/136998239.jpg","1200x1200":"https:\/\/s.pximg.net\/special\/login-illusts\/136998239.jpg"},"user_name":"\u70ad\u70e4\u5357\u74dcZiora","profile_img":{"main_s":"https:\/\/i.pximg.net\/user-profile\/img\/2025\/07\/13\/14\/38\/22\/27605379_001513b1ac3e644456759ecdfdb01293_50.jpg"},"www_member_illust_medium_url":"https:\/\/www.pixiv.net\/artworks\/136998239","www_user_url":"https:\/\/www.pixiv.net\/users\/117926310","credit":{"title":"VISIONS2026\u63b2\u8f09\u30af\u30ea\u30a8\u30a4\u30bf\u30fc","url":"https:\/\/visions.pr-pixiv.net\/2026\/about\/"}},{"illust_id":"136775103","illust_title":"jumelle","url":{"medium":"https:\/\/s.pximg.net\/special\/login-illusts\/136775103.jpg","1200x1200":"https:\/\/s.pximg.net\/special\/login-illusts\/136775103.jpg"},"user_name":"\u305f\u3089","profile_img":{"main_s":"https:\/\/i.pximg.net\/user-profile\/img\/2018\/04\/28\/22\/32\/20\/14153011_68d64ca946c40fc05f63473f7e43cc81_50.png"},"www_member_illust_medium_url":"https:\/\/www.pixiv.net\/artworks\/136775103","www_user_url":"https:\/\/www.pixiv.net\/users\/77003","credit":{"title":"VISIONS2026\u63b2\u8f09\u30af\u30ea\u30a8\u30a4\u30bf\u30fc","url":"https:\/\/visions.pr-pixiv.net\/2026\/about\/"}},{"illust_id":"136466766","illust_title":"\u5c0f\u5ddd","url":{"medium":"https:\/\/s.pximg.net\/special\/login-illusts\/136466766.jpg","1200x1200":"https:\/\/s.pximg.net\/special\/login-illusts\/136466766.jpg"},"user_name":"\u307e\u3041","profile_img":{"main_s":"https:\/\/i.pximg.net\/user-profile\/img\/2022\/04\/11\/15\/31\/08\/22534551_6a02d89f053d8ba7308ee9543da3b3af_50.jpg"},"www_member_illust_medium_url":"https:\/\/www.pixiv.net\/artworks\/136466766","www_user_url":"https:\/\/www.pixiv.net\/users\/6093768","credit":{"title":"VISIONS2026\u63b2\u8f09\u30af\u30ea\u30a8\u30a4\u30bf\u30fc","url":"https:\/\/visions.pr-pixiv.net\/2026\/about\/"}},{"illust_id":"111293416","illust_title":"OC","url":{"medium":"https:\/\/s.pximg.net\/special\/login-illusts\/111293416.jpg","1200x1200":"https:\/\/s.pximg.net\/special\/login-illusts\/111293416.jpg"},"user_name":"NAKDI","profile_img":{"main_s":"https:\/\/i.pximg.net\/user-profile\/img\/2020\/04\/29\/16\/09\/41\/18439136_b8983e9a4c185217cee17de1011871cb_50.jpg"},"www_member_illust_medium_url":"https:\/\/www.pixiv.net\/artworks\/111293416","www_user_url":"https:\/\/www.pixiv.net\/users\/20259505","credit":{"title":"VISIONS2026\u63b2\u8f09\u30af\u30ea\u30a8\u30a4\u30bf\u30fc","url":"https:\/\/visions.pr-pixiv.net\/2026\/about\/"}},{"illust_id":"136996553","illust_title":"\u307b\u306e\u304a","url":{"medium":"https:\/\/s.pximg.net\/special\/login-illusts\/136996553.jpg","1200x1200":"https:\/\/s.pximg.net\/special\/login-illusts\/136996553.jpg"},"user_name":"\u70ad\u70e4\u5357\u74dcZiora","profile_img":{"main_s":"https:\/\/i.pximg.net\/user-profile\/img\/2025\/07\/13\/14\/38\/22\/27605379_001513b1ac3e644456759ecdfdb01293_50.jpg"},"www_member_illust_medium_url":"https:\/\/www.pixiv.net\/artworks\/136996553","www_user_url":"https:\/\/www.pixiv.net\/users\/117926310","credit":{"title":"VISIONS2026\u63b2\u8f09\u30af\u30ea\u30a8\u30a4\u30bf\u30fc","url":"https:\/\/visions.pr-pixiv.net\/2026\/about\/"}},{"illust_id":"136802794","illust_title":"It\u0027s eating time!","url":{"medium":"https:\/\/s.pximg.net\/special\/login-illusts\/136802794.jpg","1200x1200":"https:\/\/s.pximg.net\/special\/login-illusts\/136802794.jpg"},"user_name":"HAGU","profile_img":{"main_s":"https:\/\/i.pximg.net\/user-profile\/img\/2025\/07\/17\/00\/31\/29\/27621236_d7153faf2158f8030a78b50247dc4b79_50.jpg"},"www_member_illust_medium_url":"https:\/\/www.pixiv.net\/artworks\/136802794","www_user_url":"https:\/\/www.pixiv.net\/users\/9545319","credit":{"title":"VISIONS2026\u63b2\u8f09\u30af\u30ea\u30a8\u30a4\u30bf\u30fc","url":"https:\/\/visions.pr-pixiv.net\/2026\/about\/"}},{"illust_id":"115692291","illust_title":"\u30b1\u30fc\u30ad\u00d7\u7740\u7269","url":{"medium":"https:\/\/s.pximg.net\/special\/login-illusts\/115692291.jpg","1200x1200":"https:\/\/s.pximg.net\/special\/login-illusts\/115692291.jpg"},"user_name":"\u82b1\u6708","profile_img":{"main_s":"https:\/\/i.pximg.net\/user-profile\/img\/2020\/02\/08\/08\/37\/37\/17880268_a7367ab7d527951043cb736cb75c4d2f_50.jpg"},"www_member_illust_medium_url":"https:\/\/www.pixiv.net\/artworks\/115692291","www_user_url":"https:\/\/www.pixiv.net\/users\/34037353","credit":{"title":"VISIONS2026\u63b2\u8f09\u30af\u30ea\u30a8\u30a4\u30bf\u30fc","url":"https:\/\/visions.pr-pixiv.net\/2026\/about\/"}},{"illust_id":"135446827","illust_title":"\u6a4b","url":{"medium":"https:\/\/s.pximg.net\/special\/login-illusts\/135446827.jpg","1200x1200":"https:\/\/s.pximg.net\/special\/login-illusts\/135446827.jpg"},"user_name":"\u3084\u305f\u3089","profile_img":{"main_s":"https:\/\/i.pximg.net\/user-profile\/img\/2025\/06\/24\/06\/24\/14\/27528668_d5f97077c8aefc3c4ab31a8ad0841c30_50.jpg"},"www_member_illust_medium_url":"https:\/\/www.pixiv.net\/artworks\/135446827","www_user_url":"https:\/\/www.pixiv.net\/users\/117424981","credit":{"title":"VISIONS2026\u63b2\u8f09\u30af\u30ea\u30a8\u30a4\u30bf\u30fc","url":"https:\/\/visions.pr-pixiv.net\/2026\/about\/"}},{"illust_id":"136467354","illust_title":"\u304a\u83d3\u5b50\u3065\u304f\u308a","url":{"medium":"https:\/\/s.pximg.net\/special\/login-illusts\/136467354.jpg","1200x1200":"https:\/\/s.pximg.net\/special\/login-illusts\/136467354.jpg"},"user_name":"\u307e\u3041","profile_img":{"main_s":"https:\/\/i.pximg.net\/user-profile\/img\/2022\/04\/11\/15\/31\/08\/22534551_6a02d89f053d8ba7308ee9543da3b3af_50.jpg"},"www_member_illust_medium_url":"https:\/\/www.pixiv.net\/artworks\/136467354","www_user_url":"https:\/\/www.pixiv.net\/users\/6093768","credit":{"title":"VISIONS2026\u63b2\u8f09\u30af\u30ea\u30a8\u30a4\u30bf\u30fc","url":"https:\/\/visions.pr-pixiv.net\/2026\/about\/"}},{"illust_id":"136694194","illust_title":"Viola Howl","url":{"medium":"https:\/\/s.pximg.net\/special\/login-illusts\/136694194.jpg","1200x1200":"https:\/\/s.pximg.net\/special\/login-illusts\/136694194.jpg"},"user_name":"\u98ce\u76ee\u826e\u5f61","profile_img":{"main_s":"https:\/\/i.pximg.net\/user-profile\/img\/2025\/06\/08\/22\/20\/13\/27466397_ee18fdcccc64144469f467cfad24d7bf_50.jpg"},"www_member_illust_medium_url":"https:\/\/www.pixiv.net\/artworks\/136694194","www_user_url":"https:\/\/www.pixiv.net\/users\/4801085","credit":{"title":"VISIONS2026\u63b2\u8f09\u30af\u30ea\u30a8\u30a4\u30bf\u30fc","url":"https:\/\/visions.pr-pixiv.net\/2026\/about\/"}},{"illust_id":"130770845","illust_title":"oc","url":{"medium":"https:\/\/s.pximg.net\/special\/login-illusts\/130770845.jpg","1200x1200":"https:\/\/s.pximg.net\/special\/login-illusts\/130770845.jpg"},"user_name":"NAKDI","profile_img":{"main_s":"https:\/\/i.pximg.net\/user-profile\/img\/2020\/04\/29\/16\/09\/41\/18439136_b8983e9a4c185217cee17de1011871cb_50.jpg"},"www_member_illust_medium_url":"https:\/\/www.pixiv.net\/artworks\/130770845","www_user_url":"https:\/\/www.pixiv.net\/users\/20259505","credit":{"title":"VISIONS2026\u63b2\u8f09\u30af\u30ea\u30a8\u30a4\u30bf\u30fc","url":"https:\/\/visions.pr-pixiv.net\/2026\/about\/"}},{"illust_id":"136802978","illust_title":"Gravitation of souls","url":{"medium":"https:\/\/s.pximg.net\/special\/login-illusts\/136802978.jpg","1200x1200":"https:\/\/s.pximg.net\/special\/login-illusts\/136802978.jpg"},"user_name":"HAGU","profile_img":{"main_s":"https:\/\/i.pximg.net\/user-profile\/img\/2025\/07\/17\/00\/31\/29\/27621236_d7153faf2158f8030a78b50247dc4b79_50.jpg"},"www_member_illust_medium_url":"https:\/\/www.pixiv.net\/artworks\/136802978","www_user_url":"https:\/\/www.pixiv.net\/users\/9545319","credit":{"title":"VISIONS2026\u63b2\u8f09\u30af\u30ea\u30a8\u30a4\u30bf\u30fc","url":"https:\/\/visions.pr-pixiv.net\/2026\/about\/"}},{"illust_id":"136757170","illust_title":"Kamakura","url":{"medium":"https:\/\/s.pximg.net\/special\/login-illusts\/136757170.jpg","1200x1200":"https:\/\/s.pximg.net\/special\/login-illusts\/136757170.jpg"},"user_name":"Omorphia Visual","profile_img":{"main_s":"https:\/\/i.pximg.net\/user-profile\/img\/2025\/07\/09\/12\/31\/41\/27588919_b775b3be485951e0794886168b4d5c0e_50.png"},"www_member_illust_medium_url":"https:\/\/www.pixiv.net\/artworks\/136757170","www_user_url":"https:\/\/www.pixiv.net\/users\/83022490","credit":{"title":"VISIONS2026\u63b2\u8f09\u30af\u30ea\u30a8\u30a4\u30bf\u30fc","url":"https:\/\/visions.pr-pixiv.net\/2026\/about\/"}},{"illust_id":"136793210","illust_title":"\u53e4\u751f\u7269\u6bd4\u8f03\u30a4\u30e9\u30b9\u30c8","url":{"medium":"https:\/\/s.pximg.net\/special\/login-illusts\/136793210.jpg","1200x1200":"https:\/\/s.pximg.net\/special\/login-illusts\/136793210.jpg"},"user_name":"nao70shark","profile_img":{"main_s":"https:\/\/i.pximg.net\/user-profile\/img\/2023\/01\/10\/19\/27\/29\/23866554_ddf11cb327ff1a125396c73889d4df73_50.png"},"www_member_illust_medium_url":"https:\/\/www.pixiv.net\/artworks\/136793210","www_user_url":"https:\/\/www.pixiv.net\/users\/90010952","credit":{"title":"VISIONS2026\u63b2\u8f09\u30af\u30ea\u30a8\u30a4\u30bf\u30fc","url":"https:\/\/visions.pr-pixiv.net\/2026\/about\/"}},{"illust_id":"111129768","illust_title":"\u756b\u6708","url":{"medium":"https:\/\/s.pximg.net\/special\/login-illusts\/111129768.jpg","1200x1200":"https:\/\/s.pximg.net\/special\/login-illusts\/111129768.jpg"},"user_name":"Say HANa","profile_img":{"main_s":"https:\/\/i.pximg.net\/user-profile\/img\/2020\/11\/10\/18\/01\/26\/19648130_851f256b592686a9d4585a0e90a412b7_50.png"},"www_member_illust_medium_url":"https:\/\/www.pixiv.net\/artworks\/111129768","www_user_url":"https:\/\/www.pixiv.net\/users\/1443093","credit":{"title":"VISIONS2026\u63b2\u8f09\u30af\u30ea\u30a8\u30a4\u30bf\u30fc","url":"https:\/\/visions.pr-pixiv.net\/2026\/about\/"}},{"illust_id":"78243967","illust_title":"Forgotten Castle","url":{"medium":"https:\/\/s.pximg.net\/special\/login-illusts\/78243967.jpg","1200x1200":"https:\/\/s.pximg.net\/special\/login-illusts\/78243967.jpg"},"user_name":"Masashi\u30fbK","profile_img":{"main_s":"https:\/\/i.pximg.net\/user-profile\/img\/2017\/01\/28\/13\/39\/21\/12066460_7cc4c2b848a72ec76c0f17ba397e4af9_50.jpg"},"www_member_illust_medium_url":"https:\/\/www.pixiv.net\/artworks\/78243967","www_user_url":"https:\/\/www.pixiv.net\/users\/13214612","credit":{"title":"VISIONS2026\u63b2\u8f09\u30af\u30ea\u30a8\u30a4\u30bf\u30fc","url":"https:\/\/visions.pr-pixiv.net\/2026\/about\/"}},{"illust_id":"135952908","illust_title":"tartan","url":{"medium":"https:\/\/s.pximg.net\/special\/login-illusts\/135952908.jpg","1200x1200":"https:\/\/s.pximg.net\/special\/login-illusts\/135952908.jpg"},"user_name":"koh","profile_img":{"main_s":"https:\/\/i.pximg.net\/user-profile\/img\/2025\/05\/07\/00\/48\/26\/27328452_cabfa4adce708ec2095e8b8eae1f8c9e_50.jpg"},"www_member_illust_medium_url":"https:\/\/www.pixiv.net\/artworks\/135952908","www_user_url":"https:\/\/www.pixiv.net\/users\/24321993","credit":{"title":"VISIONS2026\u63b2\u8f09\u30af\u30ea\u30a8\u30a4\u30bf\u30fc","url":"https:\/\/visions.pr-pixiv.net\/2026\/about\/"}},{"illust_id":"123613042","illust_title":"\u843d\u65e5\u8eca\u624b","url":{"medium":"https:\/\/s.pximg.net\/special\/login-illusts\/123613042.jpg","1200x1200":"https:\/\/s.pximg.net\/special\/login-illusts\/123613042.jpg"},"user_name":"Eli Lin \u4f9d\u840a","profile_img":{"main_s":"https:\/\/i.pximg.net\/user-profile\/img\/2022\/11\/06\/13\/47\/07\/23564787_f953f173ebca9299319433886e446916_50.jpg"},"www_member_illust_medium_url":"https:\/\/www.pixiv.net\/artworks\/123613042","www_user_url":"https:\/\/www.pixiv.net\/users\/3595083","credit":{"title":"VISIONS2026\u63b2\u8f09\u30af\u30ea\u30a8\u30a4\u30bf\u30fc","url":"https:\/\/visions.pr-pixiv.net\/2026\/about\/"}},{"illust_id":"136938152","illust_title":"Slow days ,Full heart.","url":{"medium":"https:\/\/s.pximg.net\/special\/login-illusts\/136938152.jpg","1200x1200":"https:\/\/s.pximg.net\/special\/login-illusts\/136938152.jpg"},"user_name":"\u3072\u3057\u3060\u3088\u3046\u3053","profile_img":{"main_s":"https:\/\/i.pximg.net\/user-profile\/img\/2024\/12\/04\/20\/40\/30\/26680513_4ca0928a1f079761d3f816ef9e198e99_50.jpg"},"www_member_illust_medium_url":"https:\/\/www.pixiv.net\/artworks\/136938152","www_user_url":"https:\/\/www.pixiv.net\/users\/292817","credit":{"title":"VISIONS2026\u63b2\u8f09\u30af\u30ea\u30a8\u30a4\u30bf\u30fc","url":"https:\/\/visions.pr-pixiv.net\/2026\/about\/"}},{"illust_id":"118178097","illust_title":"Leaving Breeze","url":{"medium":"https:\/\/s.pximg.net\/special\/login-illusts\/118178097.jpg","1200x1200":"https:\/\/s.pximg.net\/special\/login-illusts\/118178097.jpg"},"user_name":"airfish \u7a7a\u6c14\u9c7c","profile_img":{"main_s":"https:\/\/i.pximg.net\/user-profile\/img\/2024\/04\/26\/20\/53\/35\/25810643_8583621b7510025946c0c9c41e20c7c5_50.jpg"},"www_member_illust_medium_url":"https:\/\/www.pixiv.net\/artworks\/118178097","www_user_url":"https:\/\/www.pixiv.net\/users\/67512705","credit":{"title":"VISIONS2026\u63b2\u8f09\u30af\u30ea\u30a8\u30a4\u30bf\u30fc","url":"https:\/\/visions.pr-pixiv.net\/2026\/about\/"}}]}}'>

    </div>


<script>'use strict';var dataLayer = [{login: 'no',gender: "",user_id: "",lang: "ja",illustup_flg: 'not_uploaded',premium: 'no',default_service_is_touch: 'no',}];</script>
<!-- Google Tag Manager -->
<noscript><iframe src="//www.googletagmanager.com/ns.html?id=GTM-55FG"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'//www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-55FG');</script>
<!-- End Google Tag Manager -->
<script async src="https://www.googletagmanager.com/gtag/js?id=G-75BBYNYN9J"></script><script>window.dataLayer = window.dataLayer || [];function gtag(){dataLayer.push(arguments);}gtag('js', new Date());
    let event_params = {};
    let user_properties = {};
    if (window.pixiv) {
        if (pixiv.user && pixiv.user.loggedIn) {
            event_params['login'] = 'yes';
            user_properties['plan'] =  pixiv.user.premium ? 'premium' : 'normal';
            user_properties['gender'] = pixiv.user.gender;
            user_properties['user_id'] = pixiv.user.id;
            user_properties['illustup_flg'] = pixiv.user.illustup_flg ? 'uploaded' : 'not_uploaded';
        } else {
            event_params['login'] = 'no';
        }

    event_params['first_visit_datetime_pc'] = "2026-03-19 08:25:14";
        (function() {
            // クッキーあれば、一回でもログインした人とみなす
            if (pixiv.user && window.colon && colon.storage) {
                var cookie_name = 'login_ever';

                if (colon.storage.cookie(cookie_name)) {// 一度でもログインしたことある
                    event_params['login ever'] = 'yes'

                } else if (pixiv.user.loggedIn) { // ログインしてる
                    colon.storage.cookie(cookie_name, 'yes', {
                        expires: 1000 * 60 * 60 * 24 * 365 * 5, // 5 years
                        domain: location.hostname
                    });
                    event_params['login ever'] = 'yes';
                } else { // ログインしたこと無いし、ログインしてもない
                    event_params['login ever'] = 'no';
                }

                
                var p_ab_id = colon.storage.cookie('p_ab_id');
                var p_ab_id_2 = colon.storage.cookie('p_ab_id_2');
                event_params['p_ab_id'] = p_ab_id;
                event_params['p_ab_id_2'] = p_ab_id_2;

                var p_ab_d_id = colon.storage.cookie('p_ab_d_id');
                event_params['p_ab_d_id'] = p_ab_d_id;
            }
        } ())

        event_params['lang'] = "ja";
    }
    event_params['default_service_is_touch'] = 'no';gtag('set', 'user_properties', {...user_properties});gtag('config', 'G-75BBYNYN9J', {...event_params});</script>
<script id="capybara-status-check" data-t-code="0ec06063442619c76e42d6ebed9fa6dd" data-m-code="5276059c3a4531f3da239d1ea8771242"></script>

<script>(function(){function c(){var b=a.contentDocument||a.contentWindow.document;if(b){var d=b.createElement('script');d.innerHTML="window.__CF$cv$params={r:'9de7fed55e6c31df',t:'MTc3Mzg3NjMxNC4wMDAwMDA='};var a=document.createElement('script');a.nonce='';a.src='/cdn-cgi/challenge-platform/scripts/jsd/main.js';document.getElementsByTagName('head')[0].appendChild(a);";b.getElementsByTagName('head')[0].appendChild(d)}}if(document.body){var a=document.createElement('iframe');a.height=1;a.width=1;a.style.position='absolute';a.style.top=0;a.style.left=0;a.style.border='none';a.style.visibility='hidden';document.body.appendChild(a);if('loading'!==document.readyState)c();else if(window.addEventListener)document.addEventListener('DOMContentLoaded',c);else{var e=document.onreadystatechange||function(){};document.onreadystatechange=function(b){e(b);'loading'!==document.readyState&&(document.onreadystatechange=e,c())}}}})();</script></body>
</html>```

<!-- Reference-style image links -->
[lambda-icon]: plugins/core/jetbrains-community/resources/icons/resources/LambdaFunction.svg
[s3-icon]: plugins/core/jetbrains-community/resources/icons/resources/S3Bucket.svg
[cloudwatch-logs-icon]: plugins/core/jetbrains-community/resources/icons/resources/cloudwatchlogs/CloudWatchLogs.svg
[cloudformation-icon]: plugins/core/jetbrains-community/resources/icons/resources/CloudFormationStack.svg
[redshift-icon]: plugins/core/jetbrains-community/resources/icons/resources/Redshift.svg
[gear-icon]: https://raw.githubusercontent.com/JetBrains/intellij-community/master/platform/icons/src/general/gear.svg
