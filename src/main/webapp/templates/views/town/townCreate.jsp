<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Town Create</title>
</head>
<body>
<header>
    <div class="full-width header">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="navigation">
                        <nav>
                            <span class="fa fa-times close-menu"></span>
                            <div class="link">
                                <a href="${pageContext.request.contextPath}/index">Home</a>
                                <div class="line"></div>
                            </div>
                            <div class="link">
                                <a href="${pageContext.request.contextPath}/logout">Out</a>
                                <div class="line"></div>
                            </div>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>
<div class="full-width main-baner">
    <div class="layer-main-baner"></div>
    <div class="container">
        <div class="row">
            <div class="col-md-7 col-md-offset-5 col-sm-12">
                <div class="home-contact-form">
                    <div class="home-contact-form-wrap">
                        <h1>Welcome to <br>rent <span class="blue-color">a car</span></h1>
                        <div class="contact-form">
                            <div class="form-header">
                                <h3>Registration Form</h3>
                            </div>
                            <%--@elvariable id="town" type="it.academy.rent.bean.Town"--%>
                            <form:form class="register-form" action="${pageContext.request.contextPath}createTown"
                                       modelAttribute="town" method="post">
                                <div class="form">
                                    <form:errors path="nameTown" cssStyle="color: red"/>
                                    <form:input path="nameTown" type="text" placeholder="nameTown"/>

                                    <form:errors path="country.nameCountry" cssStyle="color: red"/>
                                    <form:input path="country.nameCountry" type="text" placeholder="nameCountry"/>
                                    <div class="send-button">
                                        <input type="submit" value="Registration">
                                    </div>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="swiper-container home-baner">
        <div class="swiper-wrapper">
            <div class="swiper-slide">
                <div class="home-img">
                    <div class="bg-bg" >
                    </div>
                </div>
            </div>
            <div class="swiper-slide">
                <div class="home-img">
                    <div class="bg-bg" >
                    </div>
                </div>
            </div>

        </div>
    </div>

</div>


</body>
</html>
<style type="text/css">
    html {
        margin: 0px;
        padding: 0px;
        height: 100%;
    }

    body {
        margin: 0px;
        padding: 0px;
        font-size: 100%;
        height: 100%;
        width: 100%;
        font-family: 'Roboto Condensed', sans-serif;
        color: #363636;
        background-color: #fff;
    }

    .onload {
        opacity: 0;
        -webkit-transition: All 300ms ease-in;
        -moz-transition: All 300ms ease-in;
        -o-transition: All 300ms ease-in;
        -ms-transition: All 300ms ease-in;
        transition: All 300ms ease-in;
    }

    .onload.loaded {
        opacity: 1;
    }

    a {
        text-decoration: none;
        outline: none;
        cursor: pointer;
        transition: all 0.3s ease-in;
        -moz-transition: all 0.3s ease-in;
        -o-transition: all 0.3s ease-in;
        -webkit-transition: all 0.3s ease-in;
        -ms-transition: all 0.3s ease-in;
    }

    a:hover {
        text-decoration: none;
    }

    a img {
        border: 0px none;
    }

    a:hover {
        outline: none;
    }

    a:active {
        outline: none;
        text-decoration: none;
    }

    a:focus {
        outline: none;
        outline-offset: 0px;
        text-decoration: none;
        color: #fff;
    }

    .clear {
        clear: both;
        overflow: hidden;
        height: 0px;
        font-size: 0px;
    }

    .clear_l {
        clear: both;
    }

    ul {
        padding: 0px;
        margin: 0px;
        list-style: none;
    }

    input:focus, select:focus, textarea:focus, button:focus {
        outline: none;
    }

    .bg {
        position: absolute;
        left: 0px;
        top: 0px;
        width: 100%;
        height: 100%;
        overflow: hidden;
    }

    .bg img {
        position: absolute;
        top: 0px;
        width: 100%;
        height: 100%;
    }

    .bg video {
        position: absolute;
    }

    .bg-bg {
        background-position: 50% 0px;
        background-repeat: no-repeat;
        -webkit-background-size: cover;
        -moz-background-size: cover;
        -o-background-size: cover;
        background-size: cover;
    }

    .bg-bg-bag {
        background-attachment: scroll;
        background-origin: initial;
        background-clip: initial;
        background-size: cover;
        background-repeat: no-repeat;
        background-position: 50% 0;
        position: relative;
    }

    .bg-bg-chrome {
        background-position: 50% 0px;
        background-repeat: no-repeat;
        background-attachment: scroll;
        -webkit-background-size: cover;
        -moz-background-size: cover;
        -o-background-size: cover;
        -ms-background-size: cover;
        background-size: cover;
        position: fixed;
    }

    .bg-bg-chrome.act {
        position: absolute;
    }

    .clip {
        clip: rect(auto, auto, auto, auto);
        height: 100%;
        position: absolute;
        width: 100%;
    }

    .drop {
        position: absolute;
        display: block;
        height: 40px;
        z-index: 3000;
        width: 100%;
        max-width: 270px;
        right: 0px;
        top: 40px;
    }

    .drop b {
        position: relative;
        float: left;
        width: 100%;
        height: 40px;
        background: #fff;
        padding-left: 15px;
        border: 1px solid #d8d8d8;
        font-size: 14px;
        cursor: pointer;
        text-transform: capitalize;
        font-weight: 400;
        padding-top: 8px;
        color: #9a9a9b;
    }

    .drop .drop-list {
        position: absolute;
        right: 16px;
        top: 9px;
        font-size: 16px;
        color: #9a9a9b;
    }

    .drop span {
        position: absolute;
        left: 0px;
        top: 0px;
        width: 100%;
        display: none;
        z-index: 5000;
        background: #fff;
        border: 1px solid #9a9a9b;
    }

    .drop-list.act {
        transform: rotate(180deg);
        z-index: 6000;
        margin-top: 4px;
    }

    .drop span a {
        color: #9a9a9b;
        background: #fff;
        font-size: 14px;
        font-weight: 400;
        float: left;
        position: relative;
        width: 100%;
        height: 40px;
        text-decoration: none;
        text-align: left;
        padding: 8px 0 0 15px;
        transition: all 0.3s ease-in;
        -webkit-transition: all 0.3s ease-in;
        -moz-transition: all 0.3s ease-in;
        -o-transition: all 0.3s ease-in;
        -ms-transition: all 0.3s ease-in;
        z-index: 4000;
        text-transform: capitalize;
    }

    .drop span a:hover {
        background: #30303a;
        color: #fff;
    }

    .header {
        position: relative;
        float: left;
        width: 100%;
        height: 112px;
        background: #fff;
        border-bottom: 6px solid #2d5ba9;
        top: 1px;
        margin-top: -1px;
    }

    .menu-hide {
        display: none;
    }

    .logo-wrapper {
        position: relative;
        float: left;
        height: 112px;
    }

    .logo-wrapper a {
        max-width: 323px;
        float: right;
        position: relative;
        padding-top: 16px;
        padding-right: 40px;
    }

    nav {
        position: relative;
        float: right;
        height: 112px;
        padding-left: 24px;
    }

    nav .fa {
        display: none;
    }

    .logo-wrapper img {
        width: 100%;
        height: auto;
    }

    .menu-mobile-icon {
        position: absolute;
        right: 50px;
        top: 50px;
        width: 30px;
        height: 20px;
        z-index: 50;
        cursor: pointer
    }

    .menu-mobile-icon img {
        width: 30px;
        height: 20px;
    }

    .line {
        position: absolute;
        bottom: 40px;
        background: #fff;
        width: 20%;
        height: 3px;
        left: 30px;
    }

    nav a {
        position: relative;
        float: left;
        font-size: 14px;
        line-height: 26px;
        text-transform: uppercase;
        padding: 42px 30px;
        color: #363636;
        height: 112px;
        font-weight: 400;
    }

    nav a.active {
        color: #fff;
        background: #2d5ba9;
    }

    nav a:focus {
        color: #363636;
    }

    .navigation {
        position: relative;
        float: left;
        width: 100%;
        min-height: 500px;
        overflow: hidden;
    }

    .link {
        position: relative;
        float: left;
        transition: all 0.3s ease-in;
        -webkit-transition: all 0.3s ease-in;
        -moz-transition: all 0.3s ease-in;
        -o-transition: all 0.3s ease-in;
        -ms-transition: all 0.3s ease-in;
    }

    .link .drop-down {
        position: absolute;
        top: 110px;
        left: 0px;
        background: #2d5ba9;
        width: 300px;
        z-index: 100;
        padding: 23px 40px;
        visibility: hidden;
        opacity: 0;
        z-index: 6000;
    }

    .link .drop-down a {
        border: none;
        position: relative;
        float: left;
        width: 100%;
        line-height: 26px;
        border-bottom: 1px solid #1e4a94;
        padding: 8px 0px 10px;
        margin: 0px;
        height: auto;
        color: #fff;
        box-shadow: 0px 1px 0px #3c6cbc;
    }

    .link .drop-down a:last-child {
        border-bottom: 0px none;
        box-shadow: none;
    }

    .link .drop-down a:hover {
        color: #fae900;
    }

    .link .drop-down.slide {
        display: inline-block;
        visibility: visible;
        opacity: 1;
    }

    .link:hover {
        background: #2d5ba9;
    }

    .link:hover a {
        color: #fff;
    }

    .main-baner {
        width: 100%;
        position: relative;
        float: left;
        overflow: hidden;
    }

    .home-baner {
        position: relative;
        float: left;
        width: 100%;
        height: 800px;
    }

    .home-img {
        position: relative;
        float: left;
        width: 100%;
    }

    .home-contact-form {
        position: relative;
        float: left;
        width: 100%;
    }

    .home-contact-form-wrap {
        position: absolute;
        right: 0px;
        top: 0px;
        z-index: 5000;
    }

    .home-img .bg-bg {
        height: 800px;
    }

    .contact-form {
        position: relative;
        float: right;
        width: 500px;
        box-shadow: 0px 0px 0px 5px rgba(255, 255, 255, 0.07);
        background: #f0f0f0;
        margin: 25px 0px 65px;
    }

    .main-baner h1 {
        color: #fff;
        float: none;
        padding-top: 60px;
        text-align: center;
    }

    .contact-form .drop {
        position: relative;
        float: left;
        max-width: 100%;
        top: 0px;
    }

    .contact-form .drop input[type="text"] {
        border: 2px solid #dddddd;
        font-size: 14px;
        padding-top: 0px;
    }

    .contact-form .drop .drop-list {
        top: 14px;
    }

    .contact-form .drop span {
        border: 2px solid #dddddd;
        top: 5px;
    }

    .contact-form .drop span a {
        color: #808080;
        padding: 6px 0px 0px 14px;
        font-size: 14px;
        line-height: 26px;
    }

    .form-header {
        position: relative;
        width: 100%;
        background: #FFF;
        text-align: center;
        border-bottom: 1px solid #dddddd;
    }

    .form-header h3 {
        padding: 30px 0px 25px;
        text-transform: uppercase;
        color: #363636;
    }

    .form {
        position: relative;
        float: left;
        width: 100%;
    }

    .form .drop b {
        color: #808080;
        padding: 6px 0px 0px 15px;
        font-size: 14px;
        line-height: 26px;
        border: 2px solid #D8D8D8;
        margin-top: 5px;
    }

    .contact-form .form {
        padding: 15px 30px;
    }

    .contact-form .form input {
        float: none;
        position: relative;
        height: 40px;
        border: 2px solid #dddddd;
        display: inline-block;
        width: 100%;
        background: #fff;
        margin: 6px 0px;
        padding: 0px 0px 0px 18px;
        font-weight: 400;
    }

    .contact-form .form input[type="checkbox"] {
        position: relative;
        float: left;
        width: 15px;
        margin-top: 14px;
    }

    .contact-form .form .agree {
        position: relative;
        float: left;
        font-size: 15px;
        line-height: 25px;
        color: #aeaeae;
        padding: 20px 0px 25px 10px;
    }

    form {
        position: relative;
        float: left;
        width: 100%;
        font-weight: 400;
    }

    .date-wrap {
        position: relative;
        float: left;
        width: 100%;
    }

    .date-wrap img {
        position: absolute;
        right: 12px;
        top: 17px;
        z-index: 5000;
    }

    .datepicker {
        position: relative;
        float: left;
        z-index: 5000;
    }

    .ui-datepicker {
        width: 220px;
        padding: 0px;
        margin: 0px;
    }

    .ui-state-highlight, .ui-widget-content .ui-state-highlight, .ui-widget-header .ui-state-highlight {
        border: 1px solid #e6e6e6;
        background: #f2f2f2;
    }

    .ui-datepicker td {
        padding: 0px;
    }

    .ui-datepicker th {
        text-transform: uppercase;
        font-size: 10px;
        font-family: 'Roboto', sans-serif;
    }

    .ui-datepicker .ui-datepicker-header {
        border-radius: 0px;
        border-top-left-radius: 4px;
        border-top-right-radius: 4px;
    }

    .ui-widget-header {
        font-size: 14px;
    }

    .ui-datepicker td span, .ui-datepicker td a {
        text-align: center;
        padding: 7px;
    }

    .ui-datepicker .ui-datepicker-next span {
        background: no-repeat;
        margin-left: -3px;
        margin-top: -7px;
    }

    .ui-datepicker .ui-datepicker-prev span {
        background: no-repeat;
        margin-left: -3px;
        margin-top: -7px;
    }

    .ui-datepicker .ui-datepicker-next {
        width: 30px;
        height: 33px;
        background: #363636;
        border-radius: 0px;
        right: 5px;
        margin-right: -7px;
        margin-top: -3px;
        border-top-right-radius: 4px;
    }

    .ui-datepicker .ui-datepicker-next:hover {
        background: #454545;
        border-left: 2px solid #4e4e4e;
        top: 2px;
    }

    .ui-datepicker .ui-datepicker-prev {
        width: 30px;
        height: 33px;
        background: #363636;
        border-radius: 0px;
        left: 5px;
        border-top-left-radius: 4px;
        margin-left: -7px;
        margin-top: -3px;
    }

    .ui-datepicker .ui-datepicker-prev:hover {
        background: #454545;
        border-right: 2px solid #4e4e4e;
        top: 2px;
    }

    .ui-corner-all {
        border-radius: 0px;
    }

    .send-button {
        position: relative;
        float: left;
        width: 100%;
        background: #fff;
        height: 100px;
    }

    .send-button input[type="submit"] {
        background: none;
        height: 60px;
        border: 2px solid #2d5ba9;
        text-align: center;
        width: 240px;
        position: absolute;
        bottom: 20px;
        left: 50%;
        margin-left: -120px;
        z-index: 5;
        color: #2d5ba9;
        font-size: 22px;
        line-height: 24px;
        padding-bottom: 0px;
    }

    .layer-main-baner {
        position: absolute;
        width: 100%;
        height: 100%;
        background: rgba(25, 25, 25, 0.8);
        right: -47%;
        top: 1px;
        transform: skewX(15deg);
        -webkit-transform: skewX(15deg);
        -moz-transform: skewX(15deg);
        -o-transform: skewX(15deg);
        -ms-transform: skewX(15deg);
        z-index: 50;
    }

    .full-width {
        position: relative;
        float: left;
        width: 100%;
    }

    .full-height {
        height: 80vmin;
        position: relative;
        float: left;
    }

    .vertical-center {
        -webkit-transform: translateY(-50%);
        -moz-transform: translateY(-50%);
        -o-transform: translateY(-50%);
        -ms-transform: translateY(-50%);
        transform: translateY(-50%);
    }

    .vertical-align {
        -webkit-transform: translateY(-50%);
        -moz-transform: translateY(-50%);
        -o-transform: translateY(-50%);
        -ms-transform: translateY(-50%);
        transform: translateY(-50%);
        top: 50%;
    }

    .center_img {
        position: absolute;
    }

    .swiper-container {
        margin: 0 auto;
        position: relative;
        -webkit-backface-visibility: hidden;
        -moz-backface-visibility: hidden;
        -ms-backface-visibility: hidden;
        -o-backface-visibility: hidden;
        backface-visibility: hidden;
        overflow: hidden;
    }

    .swiper-wrapper {
        position: relative;
        width: 100%;
        -webkit-transition-property: -webkit-transform, left, top;
        -webkit-transition-duration: 0s;
        -webkit-transform: translate3d(0px, 0, 0);
        -webkit-transition-timing-function: ease;
        -moz-transition-property: -moz-transform, left, top;
        -moz-transition-duration: 0s;
        -moz-transform: translate3d(0px, 0, 0);
        -moz-transition-timing-function: ease;
        -o-transition-property: -o-transform, left, top;
        -o-transition-duration: 0s;
        -o-transform: translate3d(0px, 0, 0);
        -o-transition-timing-function: ease;
        -o-transform: translate(0px, 0px);
        -ms-transition-property: -ms-transform, left, top;
        -ms-transition-duration: 0s;
        -ms-transform: translate3d(0px, 0, 0);
        -ms-transition-timing-function: ease;
        transition-property: transform, left, top;
        transition-duration: 0s;
        transform: translate3d(0px, 0, 0);
        transition-timing-function: ease;
    }

    .swiper-free-mode > .swiper-wrapper {
        -webkit-transition-timing-function: ease-out;
        -moz-transition-timing-function: ease-out;
        -ms-transition-timing-function: ease-out;
        -o-transition-timing-function: ease-out;
        transition-timing-function: ease-out;
        margin: 0 auto;
    }

    .swiper-wp8-horizontal {
        -ms-touch-action: pan-y;
    }

    .swiper-wp8-vertical {
        -ms-touch-action: pan-x;
    }

    .swiper-container {
        height: 100%;
    }

    .swiper-slide {
        position: relative;
        float: left;
        overflow: hidden;
    }

    .send-button input[type="submit"]:hover {
        background: #2d5ba9;
        color: #fff;
    }

    html {
        font-family: sans-serif;
        -webkit-text-size-adjust: 100%;
        -ms-text-size-adjust: 100%
    }

    body {
        margin: 0
    }

    .glyphicon {
        position: relative;
        top: 1px;
        display: inline-block;
        font-family: 'Glyphicons Halflings';
        font-style: normal;
        font-weight: 400;
        line-height: 1;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale
    }


    * {
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        box-sizing: border-box
    }

    :before, :after {
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        box-sizing: border-box
    }

    html {
        font-size: 10px;
        -webkit-tap-highlight-color: rgba(0, 0, 0, 0)
    }

    body {
        font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
        font-size: 14px;
        line-height: 1.42857143;
        color: #333;
        background-color: #fff
    }

    input, button, select, textarea {
        font-family: inherit;
        font-size: inherit;
        line-height: inherit
    }


    h1, h2, h3, h4, h5, h6, .h1, .h2, .h3, .h4, .h5, .h6 {
        font-family: inherit;
        font-weight: 500;
        line-height: 1.1;
        color: inherit
    }

    h1 small, h2 small, h3 small, h4 small, h5 small, h6 small, .h1 small, .h2 small, .h3 small, .h4 small, .h5 small, .h6 small, h1 .small, h2 .small, h3 .small, h4 .small, h5 .small, h6 .small, .h1 .small, .h2 .small, .h3 .small, .h4 .small, .h5 .small, .h6 .small {
        font-weight: 400;
        line-height: 1;
        color: #777
    }

    h1, .h1, h2, .h2, h3, .h3 {
        margin-top: 20px;
        margin-bottom: 10px
    }

    h1 small, .h1 small, h2 small, .h2 small, h3 small, .h3 small, h1 .small, .h1 .small, h2 .small, .h2 .small, h3 .small, .h3 .small {
        font-size: 65%
    }

    h4, .h4, h5, .h5, h6, .h6 {
        margin-top: 10px;
        margin-bottom: 10px
    }

    h4 small, .h4 small, h5 small, .h5 small, h6 small, .h6 small, h4 .small, .h4 .small, h5 .small, .h5 .small, h6 .small, .h6 .small {
        font-size: 75%
    }

    h1, .h1 {
        font-size: 36px
    }

    h2, .h2 {
        font-size: 30px
    }

    h3, .h3 {
        font-size: 24px
    }

    h4, .h4 {
        font-size: 18px
    }

    h5, .h5 {
        font-size: 14px
    }

    h6, .h6 {
        font-size: 12px
    }

    p {
        margin: 0 0 10px
    }


    kbd kbd {
        padding: 0;
        font-size: 100%;
        -webkit-box-shadow: none;
        box-shadow: none
    }

    pre {
        display: block;
        padding: 9.5px;
        margin: 0 0 10px;
        font-size: 13px;
        line-height: 1.42857143;
        color: #333;
        word-break: break-all;
        word-wrap: break-word;
        background-color: #f5f5f5;
        border: 1px solid #ccc;
        border-radius: 4px
    }

    pre code {
        padding: 0;
        font-size: inherit;
        color: inherit;
        white-space: pre-wrap;
        background-color: transparent;
        border-radius: 0
    }

    .pre-scrollable {
        max-height: 340px;
        overflow-y: scroll
    }

    .container {
        padding-right: 15px;
        padding-left: 15px;
        margin-right: auto;
        margin-left: auto
    }

    @media (min-width: 768px) {
        .container {
            width: 750px
        }
    }

    @media (min-width: 992px) {
        .container {
            width: 970px
        }
    }

    @media (min-width: 1200px) {
        .container {
            width: 1170px
        }
    }

    body {
        margin: 20px;
    }

    table {
        width: 100%;
        margin-bottom: 18px;
        padding: 0;
        font-size: 13px;
        border: 1px solid #141415;
        border-spacing: 0;
        border-collapse: separate;
        -webkit-border-radius: 5px;
        -moz-border-radius: 5px;
        border-radius: 5px;
        background-color: #37393c;
        font-family: Helvetica, Arial;
        font-size: 12px;
        color: white;
    }

    table th, table td {
        padding: 10px 10px 9px;
        line-height: 18px;
        text-align: left;
    }

    table th {
        padding-top: 9px;
        font-weight: bold;
        vertical-align: middle;
        color: #b6daff;
    }

    table td {
        vertical-align: top;
        border-top: 1px solid #ddd;
    }

    table th+th,table td+td,table th+td {
        border-left: 1px solid #ddd;
    }

    table thead tr:first-child th:first-child, table tbody tr:first-child td:first-child {
        -webkit-border-radius: 5px 0 0 0;
        -moz-border-radius: 5px 0 0 0;
        border-radius: 5px 0 0 0;
    }

    table thead tr:first-child th:last-child, table tbody tr:first-child td:last-child {
        -webkit-border-radius: 0 5px 0 0;
        -moz-border-radius: 0 5px 0 0;
        border-radius: 0 5px 0 0;
    }

    table tbody tr:last-child td:first-child {
        -webkit-border-radius: 0 0 0 5px;
        -moz-border-radius: 0 0 0 5px;
        border-radius: 0 0 0 5px;
    }

    table tbody tr:last-child td:last-child {
        -webkit-border-radius: 0 0 5px 0;
        -moz-border-radius: 0 0 5px 0;
        border-radius: 0 0 5px 0;
    }

    table tbody tr:nth-child(odd) td {
        background-color: #323841;
    }

    table tbody tr:hover td {
        background-color: #202223;
        cursor: pointer;
    }
</style>