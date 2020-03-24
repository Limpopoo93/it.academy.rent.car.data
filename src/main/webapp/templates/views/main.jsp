<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page</title>
</head>
<body>

<div class="banner">
    <div class="container">
        <div class="top-header">
        </div>
        <div class="banner-info">
            <div id="top" class="callbacks_container">
                <ul class="rslides" id="slider3">
                    <li>
                        <div class="banner-text">
                            <h3>Welcom to Arent Car</h3>
                            <p></p>
                            <a href="${pageContext.request.contextPath}/userComeIn" class="hvr-rectangle-out button">Come
                                In</a>
                            <a href="${pageContext.request.contextPath}/userRegistration"
                               class="hvr-rectangle-in button red">Registration</a>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<style type="text/css">

    body {

        font-family: 'Open Sans', sans-serif !important;
        margin: 0;
        padding: 0;
        background: #fff;
    }

    @media screen and (max-width: 600px) {
        .callbacks_nav {
            top: 47%;
        }
    }

    .callbacks_tabs a {
        visibility: hidden;
    }

    .callbacks_tabs a:after {
        content: "\f111";
        font-size: 0;
        font-family: FontAwesome;
        visibility: visible;
        display: block;
        height: 14px;
        width: 14px;
        display: inline-block;
        background: #000;
        border-radius: 30px;
        -webkit-border-radius: 30px;
        -moz-border-radius: 30px;
        -o-border-radius: 30px;
        -ms-border-radius: 30px;
    }

    .callbacks_here a:after {
        background: #03BEF0;
    }

    .banner-text h3 {
        font-size: 65px;
        font-weight: 300;
        color: #CC7200;
        text-align: center;
        font-family: 'Righteous', cursive;
    }

    .banner-text {
        text-align: center;
        margin-top: 210px;
    }

    .banner-text p {
        font-size: 30px;
        font-weight: 400;
        color: #fff;
        text-align: center;
        margin: 40px 0;
    }

    .banner-bottom p {
        font-size: 14px;
        line-height: 2em;
        color: #666;
        text-align: center;
        margin: 35px auto 0 auto;
        width: 75%;
    }

    .banner-text a {
        font-weight: 600;
        text-decoration: none;
        color: #ffffff;
        font-size: 14px;
        padding: 19px 42px;
    }

    .banner-text a.hvr-rectangle-in.button.red {
        background: #666;
        margin-left: 25px;
    }

    a.hvr-rectangle-in {
        display: inline-block;
        vertical-align: middle;
        -webkit-transform: translateZ(0);
        transform: translateZ(0);
        box-shadow: 0 0 1px rgba(0, 0, 0, 0);
        -webkit-backface-visibility: hidden;
        backface-visibility: hidden;
        -moz-osx-font-smoothing: grayscale;
        position: relative;
        background: #CC7200;
        -webkit-transition-property: color;
        transition-property: color;
        -webkit-transition-duration: 0.3s;
        transition-duration: 0.3s;
        color: #fff;
    }

    a.hvr-rectangle-in:before {
        content: "";
        position: absolute;
        z-index: -1;
        top: 0;
        left: 0;
        right: 0;
        bottom: 0;
        background: #CC7200;
        color: #fff;
        -webkit-transform: scale(1);
        transform: scale(1);
        -webkit-transition-property: transform;
        transition-property: transform;
        -webkit-transition-duration: 0.3s;
        transition-duration: 0.3s;
        -webkit-transition-timing-function: ease-out;
        transition-timing-function: ease-out;
    }

    a.hvr-rectangle-in:hover, a.hvr-rectangle-in:focus, a.hvr-rectangle-in:active {
        color: white;
    }

    a.hvr-rectangle-in:hover:before, a.hvr-rectangle-in:focus:before, a.hvr-rectangle-in:active:before {
        -webkit-transform: scale(0);
        transform: scale(0);
    }

    a.hvr-rectangle-out {
        display: inline-block;
        vertical-align: middle;
        -webkit-transform: translateZ(0);
        transform: translateZ(0);
        box-shadow: 0 0 1px rgba(0, 0, 0, 0);
        -webkit-backface-visibility: hidden;
        backface-visibility: hidden;
        -moz-osx-font-smoothing: grayscale;
        position: relative;
        background: #CC7200;
        -webkit-transition-property: color;
        transition-property: color;
        -webkit-transition-duration: 0.3s;
        transition-duration: 0.3s;
    }

    a.hvr-rectangle-out:before {
        content: "";
        position: absolute;
        z-index: -1;
        top: 0;
        left: 0;
        right: 0;
        bottom: 0;
        background: #666;
        -webkit-transform: scale(0);
        transform: scale(0);
        -webkit-transition-property: transform;
        transition-property: transform;
        -webkit-transition-duration: 0.3s;
        transition-duration: 0.3s;
        -webkit-transition-timing-function: ease-out;
        transition-timing-function: ease-out;
    }

    a.hvr-rectangle-out:hover, a.hvr-rectangle-out:focus, a.hvr-rectangle-out:active {
        color: #ffffff;
    }

    a.hvr-rectangle-out:hover:before, a.hvr-rectangle-out:focus:before, a.hvr-rectangle-out:active:before {
        -webkit-transform: scale(1);
        transform: scale(1);
    }

</style>