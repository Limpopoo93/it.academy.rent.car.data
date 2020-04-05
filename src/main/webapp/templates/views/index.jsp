<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Index</title>
    <link href="../../../resources/static/bootstrap.min.css" rel="stylesheet">
</head>
<body class="loader-active">
<header id="header-area" class="fixed-top">
    <div id="header-top" class="d-none d-xl-block">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 text-center">
                    <i class="fa fa-mobile"></i> +1 800 345 678
                </div>
                <div class="col-lg-3 text-center">
                    <i class="fa fa-clock-o"></i> Mon-Fri 09.00 - 17.00
                </div>
            </div>
        </div>
    </div>
    <div id="header-bottom">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 d-none d-xl-block">
                    <nav class="mainmenu alignright">
                        <ul>
                            <li><a href="#">Home</a></li>
                            <li><a href="#">User</a>
                                <ul>
                                    <li><a href="${pageContext.request.contextPath}/adminCreate">Create Admin</a></li>
                                    <li><a href="${pageContext.request.contextPath}/companyRegistration">Create User Company</a></li>
                                    <li><a href="${pageContext.request.contextPath}/userDelete">Delete User</a></li>
                                    <li><a href="${pageContext.request.contextPath}/userUpdate">Update User</a></li>
                                    <li><a href="${pageContext.request.contextPath}/users">List User</a></li>
                                    <li><a href="${pageContext.request.contextPath}/letterAdminList">List Letter to Admin</a></li>
                                    <li><a href="${pageContext.request.contextPath}/userBlockList">List Block User</a></li>
                                </ul>
                            </li>

                            <li><a>Car</a>
                                <ul>
                                    <li><a href="${pageContext.request.contextPath}/createCar">Create Car</a></li>
                                    <li><a href="${pageContext.request.contextPath}/listCar">List Car</a></li>
                                </ul>
                            </li>
                            <li><a>Credit Car</a>
                                <ul>
                                    <li><a href="${pageContext.request.contextPath}/createCreditCard">Create Credit Card</a></li>
                                    <li><a href="${pageContext.request.contextPath}/cardDelete">Card Delete</a></li>public
                                </ul>
                            </li>
                            <li><a>Company</a>
                                <ul>
                                    <li><a href="${pageContext.request.contextPath}/createCompany">Create Company</a></li>
                                    <li><a href="${pageContext.request.contextPath}/listCompany">List Company</a></li>
                                    <li><a href="${pageContext.request.contextPath}/deleteCompany">Delete Company</a></li>
                                </ul>
                            </li>
                            <li><a>Country</a>
                                <ul>
                                    <li><a href="${pageContext.request.contextPath}/countryRegistration">Create Country</a></li>
                                    <li><a href="${pageContext.request.contextPath}/listCountry">List Country</a></li>
                                </ul>
                            </li>
                            <li><a>Town</a>
                                <ul>
                                    <li><a href="${pageContext.request.contextPath}/createTown">Create Town</a></li>
                                    <li><a href="${pageContext.request.contextPath}/searchListTown">List Town</a></li>
                                </ul>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</header>
<section id="home-slider-area">
    <div class="home-slider-item slider-bg-1 overlay">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                </div>
            </div>
        </div>
    </div>

</section>
<div id="book-a-car">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="booka-car-content">
<%--@elvariable id="carSearch" type="it.academy.rent.car.bean.CarSearch"--%>
<form:form class="register-form" name="address" action="${pageContext.request.contextPath}/searchFormCountry"
           method="post" modelAttribute="carSearch">
                        <div class="pick-location bookinput-item">
    <select class="custom-select" name="country" onChange="MkHouseValues(this.selectedIndex)">
    <option value="Russia" >Russia</option>
    <option value="England">England</option>
    <option value="Italy">Italy</option>
    <option value="France">France</option>
    <option value="Ukraine">Ukraine</option>
    <option value="Finland" >Finland</option>
    <option value="Sweden">Sweden</option>
    <option value="Norway">Norway</option>
    <option value="Denmark">Denmark</option>
    <option value="Poland" >Poland</option>
    <option value="Germany">Germany</option>
    <option value="Spain">Spain</option>
    <option value="Portugal">Portugal</option>
    <option value="Austria">Austria</option>
    <option value="Czech Republic" >Czech Republic</option>
    <option value="Slovakia">Slovakia</option>
    <option value="Bulgaria">Bulgaria</option>
    <option value="Turkey">Turkey</option>
    </select>
                        </div>

                        <div class="pick-date bookinput-item">
    <form:input path="dateCheck" type="date" value="2017-06-01"/>
                        </div>

                        <div class="retern-date bookinput-item">
    <form:input path="dateReturn" type="date" value="2017-06-01"/>
                        </div>
                        <div class="car-choose bookinput-item">
                            <select class="custom-select" name="town">
    <option value="N/A">N/A</option>
                            </select>
                        </div>

                        <div class="bookcar-btn bookinput-item">
                            <button type="submit">Book Car</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
<section id="what-do-area" class="section-padding">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
            </div>
        </div>
    </div>
</section>
<div id="partner-area">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="partner-content-wrap">
                </div>
            </div>
        </div>
    </div>
</div>
<section id="service-area" class="section-padding">
    <div class="container">
        <div class="row">
            <!-- Section Title Start -->
            <div class="col-lg-12">
                <div class="section-title  text-center">
                    <h2>Our Services</h2>
                    <span class="title-line"><i class="fa fa-car"></i></span>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-lg-4 col-md-6">
                <div class="single-service">
                    <div class="media">
                        <div class="service-icon">
                            <span></span>

                        </div>
                        <div class="media-body">
                            <h4>RENTAL CAR</h4>
                            <p>You can be a celebrity for a full night and half days with a nice one of our amazing Limousines, Hummers.</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="single-service">
                    <div class="media">
                        <div class="service-icon">
                            <span></span>

                        </div>
                        <div class="media-body">
                            <h4>CAR REPAIR</h4>
                            <p>You can be a celebrity for a full night and half days with a nice one of our amazing Limousines, Hummers.</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="single-service">
                    <div class="media">
                        <div class="service-icon">
                            <span></span>

                        </div>
                        <div class="media-body">
                            <h4>TAXI SERVICE</h4>
                            <p>You can be a celebrity for a full night and half days with a nice one of our amazing Limousines, Hummers.</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="single-service">
                    <div class="media">
                        <div class="service-icon">
                            <span></span>

                        </div>
                        <div class="media-body">
                            <h4>life insurance</h4>
                            <p>You can be a celebrity for a full night and half days with a nice one of our amazing Limousines, Hummers.</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="single-service">
                    <div class="media">
                        <div class="service-icon">
                            <span></span>

                        </div>
                        <div class="media-body">
                            <h4>car wash</h4>
                            <p>You can be a celebrity for a full night and half days with a nice one of our amazing Limousines, Hummers.</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="single-service">
                    <div class="media">
                        <div class="service-icon">
                            <span></span>

                        </div>
                        <div class="media-body">
                            <h4>call driver</h4>
                            <p>You can be a celebrity for a full night and half days with a nice one of our amazing Limousines, Hummers.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<section id="footer-area">
    <div class="footer-widget-area">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-6">
                    <div class="single-footer-widget">

                    </div>
                </div>
            </div>

            <div class="footer-bottom-area">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12 text-center">
                            <p>
                                Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by Colorlib</a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>



</body>

</html>
<script type="application/javascript">
    var aHouseValues = new Array(
        "Moscow, Peter, Samara",
        "London, Manchester",
        "Roma, Torino, Milano, Bari",
        "Lyon", "Paris, Toulouse",
        "Kiev, Lions",
        "Helsinki, Tampere",
        "Stockholm, Goterborg",
        "Oslo, Bergen",
        "Kopenhavn, Malmo",
        "Warszawa, Lublin",
        "Berlin, Koln, Hamburg",
        "Madrid, Sevilla, Barselona",
        "Lisboa, Porto",
        "Wien, Graz",
        "Praha, Brno",
        "Bratislava, Kosice",
        "Sofia, Warna",
        "Ankara, Kayseri, Antalya"
    );

    function getHouseValuesByStreet(index){
        var sHouseValues = aHouseValues[index];
        return sHouseValues.split(",");
    }

    function MkHouseValues(index){
        var aCurrHouseValues = getHouseValuesByStreet(index);
        var nCurrHouseValuesCnt = aCurrHouseValues.length;
        var oHouseList = document.forms["address"].elements["town"];
        var oHouseListOptionsCnt = oHouseList.options.length;
        oHouseList.length = 0;
        for (i = 0; i < nCurrHouseValuesCnt; i++){
            if (document.createElement){
                var newHouseListOption = document.createElement("OPTION");
                newHouseListOption.text = aCurrHouseValues[i];
                newHouseListOption.value = aCurrHouseValues[i];
                (oHouseList.options.add) ? oHouseList.options.add(newHouseListOption) : oHouseList.add(newHouseListOption, null);
            }else{
                oHouseList.options[i] = new Option(aCurrHouseValues[i], aCurrHouseValues[i], false, false);
            }
        }
    }

    MkHouseValues(document.forms["address"].elements["country"].selectedIndex);
    //-->
</script>
<style type="text/css">


    .pagination-lg .page-item:first-child .page-link {
        border-top-left-radius: .3rem;
        border-bottom-left-radius: .3rem
    }

    .pagination-lg .page-item:last-child .page-link {
        border-top-right-radius: .3rem;
        border-bottom-right-radius: .3rem
    }

    .pagination-sm .page-link {
        padding: .25rem .5rem;
        font-size: .875rem;
        line-height: 1.5
    }

    .pagination-sm .page-item:first-child .page-link {
        border-top-left-radius: .2rem;
        border-bottom-left-radius: .2rem
    }

    .pagination-sm .page-item:last-child .page-link {
        border-top-right-radius: .2rem;
        border-bottom-right-radius: .2rem
    }

    .btn .badge {
        position: relative;
        top: -1px
    }

    @media (min-width: 576px) {
        .jumbotron {
            padding: 4rem 2rem
        }
    }

    .alert-dismissible .close {
        position: absolute;
        top: 0;
        right: 0;
        padding: .75rem 1.25rem;
        color: inherit
    }

    .alert-primary hr {
        border-top-color: #9fcdff
    }

    .alert-primary .alert-link {
        color: #002752
    }

    .alert-secondary hr {
        border-top-color: #cfd2d6
    }

    .alert-secondary .alert-link {
        color: #2e3133
    }

    .alert-success hr {
        border-top-color: #b1dfbb
    }

    .alert-success .alert-link {
        color: #0b2e13
    }

    .alert-info hr {
        border-top-color: #abdde5
    }

    .alert-info .alert-link {
        color: #062c33
    }

    .alert-warning hr {
        border-top-color: #ffe8a1
    }

    .alert-warning .alert-link {
        color: #533f03
    }

    .alert-danger hr {
        border-top-color: #f1b0b7
    }

    .alert-danger .alert-link {
        color: #491217
    }

    .alert-light hr {
        border-top-color: #ececf6
    }

    .alert-light .alert-link {
        color: #686868
    }

    .alert-dark hr {
        border-top-color: #b9bbbe
    }

    .alert-dark .alert-link {
        color: #040505
    }

    @-webkit-keyframes progress-bar-stripes {
        from {
            background-position: 1rem 0
        }
        to {
            background-position: 0 0
        }
    }

    @keyframes progress-bar-stripes {
        from {
            background-position: 1rem 0
        }
        to {
            background-position: 0 0
        }
    }

    .list-group-flush .list-group-item {
        border-right: 0;
        border-left: 0;
        border-radius: 0
    }

    .list-group-flush:first-child .list-group-item:first-child {
        border-top: 0
    }

    .list-group-flush:last-child .list-group-item:last-child {
        border-bottom: 0
    }

    a.list-group-item-primary, button.list-group-item-primary {
        color: #004085
    }

    a.list-group-item-primary:focus, a.list-group-item-primary:hover, button.list-group-item-primary:focus, button.list-group-item-primary:hover {
        color: #004085;
        background-color: #9fcdff
    }

    a.list-group-item-primary.active, button.list-group-item-primary.active {
        color: #fff;
        background-color: #004085;
        border-color: #004085
    }

    a.list-group-item-secondary, button.list-group-item-secondary {
        color: #464a4e
    }

    a.list-group-item-secondary:focus, a.list-group-item-secondary:hover, button.list-group-item-secondary:focus, button.list-group-item-secondary:hover {
        color: #464a4e;
        background-color: #cfd2d6
    }

    a.list-group-item-secondary.active, button.list-group-item-secondary.active {
        color: #fff;
        background-color: #464a4e;
        border-color: #464a4e
    }

    a.list-group-item-success, button.list-group-item-success {
        color: #155724
    }

    a.list-group-item-success:focus, a.list-group-item-success:hover, button.list-group-item-success:focus, button.list-group-item-success:hover {
        color: #155724;
        background-color: #b1dfbb
    }

    a.list-group-item-success.active, button.list-group-item-success.active {
        color: #fff;
        background-color: #155724;
        border-color: #155724
    }

    a.list-group-item-info, button.list-group-item-info {
        color: #0c5460
    }

    a.list-group-item-info:focus, a.list-group-item-info:hover, button.list-group-item-info:focus, button.list-group-item-info:hover {
        color: #0c5460;
        background-color: #abdde5
    }

    a.list-group-item-info.active, button.list-group-item-info.active {
        color: #fff;
        background-color: #0c5460;
        border-color: #0c5460
    }

    a.list-group-item-warning, button.list-group-item-warning {
        color: #856404
    }

    a.list-group-item-warning:focus, a.list-group-item-warning:hover, button.list-group-item-warning:focus, button.list-group-item-warning:hover {
        color: #856404;
        background-color: #ffe8a1
    }

    a.list-group-item-warning.active, button.list-group-item-warning.active {
        color: #fff;
        background-color: #856404;
        border-color: #856404
    }

    a.list-group-item-danger, button.list-group-item-danger {
        color: #721c24
    }

    a.list-group-item-danger:focus, a.list-group-item-danger:hover, button.list-group-item-danger:focus, button.list-group-item-danger:hover {
        color: #721c24;
        background-color: #f1b0b7
    }

    a.list-group-item-danger.active, button.list-group-item-danger.active {
        color: #fff;
        background-color: #721c24;
        border-color: #721c24
    }

    a.list-group-item-light, button.list-group-item-light {
        color: #818182
    }

    a.list-group-item-light:focus, a.list-group-item-light:hover, button.list-group-item-light:focus, button.list-group-item-light:hover {
        color: #818182;
        background-color: #ececf6
    }

    a.list-group-item-light.active, button.list-group-item-light.active {
        color: #fff;
        background-color: #818182;
        border-color: #818182
    }

    a.list-group-item-dark, button.list-group-item-dark {
        color: #1b1e21
    }

    a.list-group-item-dark:focus, a.list-group-item-dark:hover, button.list-group-item-dark:focus, button.list-group-item-dark:hover {
        color: #1b1e21;
        background-color: #b9bbbe
    }

    a.list-group-item-dark.active, button.list-group-item-dark.active {
        color: #fff;
        background-color: #1b1e21;
        border-color: #1b1e21
    }

    button.close {
        padding: 0;
        background: 0 0;
        border: 0;
        -webkit-appearance: none
    }

    .modal.fade .modal-dialog {
        transition: -webkit-transform .3s ease-out;
        transition: transform .3s ease-out;
        transition: transform .3s ease-out, -webkit-transform .3s ease-out;
        -webkit-transform: translate(0, -25%);
        transform: translate(0, -25%)
    }

    .modal.show .modal-dialog {
        -webkit-transform: translate(0, 0);
        transform: translate(0, 0)
    }

    .modal-open .modal {
        overflow-x: hidden;
        overflow-y: auto
    }

    .modal-header .close {
        padding: 15px;
        margin: -15px -15px -15px auto
    }

    .modal-footer > :not(:first-child) {
        margin-left: .25rem
    }

    .modal-footer > :not(:last-child) {
        margin-right: .25rem
    }


    .tooltip .arrow {
        position: absolute;
        display: block;
        width: 5px;
        height: 5px
    }

    .tooltip .arrow::before {
        position: absolute;
        border-color: transparent;
        border-style: solid
    }

    .tooltip.bs-tooltip-auto[x-placement^=top] .arrow, .tooltip.bs-tooltip-top .arrow {
        bottom: 0
    }

    .tooltip.bs-tooltip-auto[x-placement^=top] .arrow::before, .tooltip.bs-tooltip-top .arrow::before {
        margin-left: -3px;
        content: "";
        border-width: 5px 5px 0;
        border-top-color: #000
    }

    .tooltip.bs-tooltip-auto[x-placement^=right] .arrow, .tooltip.bs-tooltip-right .arrow {
        left: 0
    }

    .tooltip.bs-tooltip-auto[x-placement^=right] .arrow::before, .tooltip.bs-tooltip-right .arrow::before {
        margin-top: -3px;
        content: "";
        border-width: 5px 5px 5px 0;
        border-right-color: #000
    }


    .tooltip.bs-tooltip-auto[x-placement^=bottom] .arrow, .tooltip.bs-tooltip-bottom .arrow {
        top: 0
    }

    .tooltip.bs-tooltip-auto[x-placement^=bottom] .arrow::before, .tooltip.bs-tooltip-bottom .arrow::before {
        margin-left: -3px;
        content: "";
        border-width: 0 5px 5px;
        border-bottom-color: #000
    }


    .tooltip.bs-tooltip-auto[x-placement^=left] .arrow, .tooltip.bs-tooltip-left .arrow {
        right: 0
    }

    .tooltip.bs-tooltip-auto[x-placement^=left] .arrow::before, .tooltip.bs-tooltip-left .arrow::before {
        right: 0;
        margin-top: -3px;
        content: "";
        border-width: 5px 0 5px 5px;
        border-left-color: #000
    }

    .popover .arrow {
        position: absolute;
        display: block;
        width: .8rem;
        height: .4rem
    }

    .popover .arrow::after, .popover .arrow::before {
        position: absolute;
        display: block;
        border-color: transparent;
        border-style: solid
    }

    .popover .arrow::before {
        content: "";
        border-width: .8rem
    }

    .popover .arrow::after {
        content: "";
        border-width: .8rem
    }


    .popover.bs-popover-auto[x-placement^=top] .arrow, .popover.bs-popover-top .arrow {
        bottom: 0
    }

    .popover.bs-popover-auto[x-placement^=top] .arrow::after, .popover.bs-popover-auto[x-placement^=top] .arrow::before, .popover.bs-popover-top .arrow::after, .popover.bs-popover-top .arrow::before {
        border-bottom-width: 0
    }

    .popover.bs-popover-auto[x-placement^=top] .arrow::before, .popover.bs-popover-top .arrow::before {
        bottom: -.8rem;
        margin-left: -.8rem;
        border-top-color: rgba(0, 0, 0, .25)
    }

    .popover.bs-popover-auto[x-placement^=top] .arrow::after, .popover.bs-popover-top .arrow::after {
        bottom: calc((.8rem - 1px) * -1);
        margin-left: -.8rem;
        border-top-color: #fff
    }

    .popover.bs-popover-auto[x-placement^=right] .arrow, .popover.bs-popover-right .arrow {
        left: 0
    }

    .popover.bs-popover-auto[x-placement^=right] .arrow::after, .popover.bs-popover-auto[x-placement^=right] .arrow::before, .popover.bs-popover-right .arrow::after, .popover.bs-popover-right .arrow::before {
        margin-top: -.8rem;
        border-left-width: 0
    }

    .popover.bs-popover-auto[x-placement^=right] .arrow::before, .popover.bs-popover-right .arrow::before {
        left: -.8rem;
        border-right-color: rgba(0, 0, 0, .25)
    }

    .popover.bs-popover-auto[x-placement^=right] .arrow::after, .popover.bs-popover-right .arrow::after {
        left: calc((.8rem - 1px) * -1);
        border-right-color: #fff
    }

    .popover.bs-popover-auto[x-placement^=bottom], .popover.bs-popover-bottom {
        margin-top: .8rem
    }

    .popover.bs-popover-auto[x-placement^=bottom] .arrow, .popover.bs-popover-bottom .arrow {
        top: 0
    }

    .popover.bs-popover-auto[x-placement^=bottom] .arrow::after, .popover.bs-popover-auto[x-placement^=bottom] .arrow::before, .popover.bs-popover-bottom .arrow::after, .popover.bs-popover-bottom .arrow::before {
        margin-left: -.8rem;
        border-top-width: 0
    }

    .popover.bs-popover-auto[x-placement^=bottom] .arrow::before, .popover.bs-popover-bottom .arrow::before {
        top: -.8rem;
        border-bottom-color: rgba(0, 0, 0, .25)
    }

    .popover.bs-popover-auto[x-placement^=bottom] .arrow::after, .popover.bs-popover-bottom .arrow::after {
        top: calc((.8rem - 1px) * -1);
        border-bottom-color: #fff
    }

    .popover.bs-popover-auto[x-placement^=bottom] .popover-header::before, .popover.bs-popover-bottom .popover-header::before {
        position: absolute;
        top: 0;
        left: 50%;
        display: block;
        width: 20px;
        margin-left: -10px;
        content: "";
        border-bottom: 1px solid #f7f7f7
    }

    .popover.bs-popover-auto[x-placement^=left] .arrow, .popover.bs-popover-left .arrow {
        right: 0
    }

    .popover.bs-popover-auto[x-placement^=left] .arrow::after, .popover.bs-popover-auto[x-placement^=left] .arrow::before, .popover.bs-popover-left .arrow::after, .popover.bs-popover-left .arrow::before {
        margin-top: -.8rem;
        border-right-width: 0
    }

    .popover.bs-popover-auto[x-placement^=left] .arrow::before, .popover.bs-popover-left .arrow::before {
        right: -.8rem;
        border-left-color: rgba(0, 0, 0, .25)
    }

    .popover.bs-popover-auto[x-placement^=left] .arrow::after, .popover.bs-popover-left .arrow::after {
        right: calc((.8rem - 1px) * -1);
        border-left-color: #fff
    }


    .carousel-indicators li {
        position: relative;
        -ms-flex: 0 1 auto;
        flex: 0 1 auto;
        width: 30px;
        height: 3px;
        margin-right: 3px;
        margin-left: 3px;
        text-indent: -999px;
        background-color: rgba(255, 255, 255, .5)
    }

    .carousel-indicators li::before {
        position: absolute;
        top: -10px;
        left: 0;
        display: inline-block;
        width: 100%;
        height: 10px;
        content: ""
    }

    .carousel-indicators li::after {
        position: absolute;
        bottom: -10px;
        left: 0;
        display: inline-block;
        width: 100%;
        height: 10px;
        content: ""
    }

    .carousel-indicators .active {
        background-color: #fff
    }

    a.bg-primary:focus, a.bg-primary:hover {
        background-color: #0062cc !important
    }

    a.bg-secondary:focus, a.bg-secondary:hover {
        background-color: #6c757d !important
    }

    a.bg-success:focus, a.bg-success:hover {
        background-color: #1e7e34 !important
    }

    a.bg-info:focus, a.bg-info:hover {
        background-color: #117a8b !important
    }

    a.bg-warning:focus, a.bg-warning:hover {
        background-color: #d39e00 !important
    }

    a.bg-danger:focus, a.bg-danger:hover {
        background-color: #bd2130 !important
    }

    a.bg-light:focus, a.bg-light:hover {
        background-color: #dae0e5 !important
    }
    a.bg-dark:focus, a.bg-dark:hover {
        background-color: #1d2124 !important
    }

    @media print {
        .d-print-block {
            display: block !important
        }
    }


    @media print {
        .d-print-inline {
            display: inline !important
        }
    }

    @media print {
        .d-print-inline-block {
            display: inline-block !important
        }
    }

    @media print {
        .d-print-none {
            display: none !important
        }
    }



    .embed-responsive .embed-responsive-item, .embed-responsive embed, .embed-responsive iframe, .embed-responsive object, .embed-responsive video {
        position: absolute;
        top: 0;
        bottom: 0;
        left: 0;
        width: 100%;
        height: 100%;
        border: 0
    }

    .float-left {
        float: left !important
    }

    .float-right {
        float: right !important
    }

    .float-none {
        float: none !important
    }

    @media (min-width: 576px) {
        .float-sm-left {
            float: left !important
        }

        .float-sm-right {
            float: right !important
        }

        .float-sm-none {
            float: none !important
        }
    }

    @media (min-width: 768px) {
        .float-md-left {
            float: left !important
        }

        .float-md-right {
            float: right !important
        }

        .float-md-none {
            float: none !important
        }
    }

    @media (min-width: 992px) {
        .float-lg-left {
            float: left !important
        }

        .float-lg-right {
            float: right !important
        }

        .float-lg-none {
            float: none !important
        }
    }

    @media (min-width: 1200px) {
        .float-xl-left {
            float: left !important
        }

        .float-xl-right {
            float: right !important
        }

        .float-xl-none {
            float: none !important
        }
    }

    .position-static {
        position: static !important
    }

    .position-relative {
        position: relative !important
    }

    .position-absolute {
        position: absolute !important
    }

    .position-fixed {
        position: fixed !important
    }

    .position-sticky {
        position: -webkit-sticky !important;
        position: sticky !important
    }

    .fixed-top {
        position: fixed;
        top: 0;
        right: 0;
        left: 0;
        z-index: 1030
    }

    .fixed-bottom {
        position: fixed;
        right: 0;
        bottom: 0;
        left: 0;
        z-index: 1030
    }

    .text-justify {
        text-align: justify !important
    }

    .text-nowrap {
        white-space: nowrap !important
    }

    .text-truncate {
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap
    }

    .text-left {
        text-align: left !important
    }

    .text-right {
        text-align: right !important
    }

    .text-center {
        text-align: center !important
    }

    @media (min-width: 576px) {
        .text-sm-left {
            text-align: left !important
        }

        .text-sm-right {
            text-align: right !important
        }

        .text-sm-center {
            text-align: center !important
        }
    }

    @media (min-width: 768px) {
        .text-md-left {
            text-align: left !important
        }

        .text-md-right {
            text-align: right !important
        }

        .text-md-center {
            text-align: center !important
        }
    }

    @media (min-width: 992px) {
        .text-lg-left {
            text-align: left !important
        }

        .text-lg-right {
            text-align: right !important
        }

        .text-lg-center {
            text-align: center !important
        }
    }

    @media (min-width: 1200px) {
        .text-xl-left {
            text-align: left !important
        }

        .text-xl-right {
            text-align: right !important
        }

        .text-xl-center {
            text-align: center !important
        }
    }

    a.text-primary:focus, a.text-primary:hover {
        color: #0062cc !important
    }


    a.text-secondary:focus, a.text-secondary:hover {
        color: #6c757d !important
    }


    a.text-success:focus, a.text-success:hover {
        color: #1e7e34 !important
    }

    a.text-info:focus, a.text-info:hover {
        color: #117a8b !important
    }

    a.text-warning:focus, a.text-warning:hover {
        color: #d39e00 !important
    }


    a.text-danger:focus, a.text-danger:hover {
        color: #bd2130 !important
    }


    a.text-light:focus, a.text-light:hover {
        color: #dae0e5 !important
    }


    a.text-dark:focus, a.text-dark:hover {
        color: #1d2124 !important
    }

    ol, ul {
        list-style: none;
    }

    blockquote, q {
        quotes: none;
    }

    blockquote:before, blockquote:after,
    q:before, q:after {
        content: '';
        content: none;
    }

    nav {
        height: 34px;
        border-bottom: 5px solid white;
        -webkit-box-shadow: inset 0 -2px 1px rgba(0, 0, 0, 0.03);
        box-shadow: inset 0 -2px 1px rgba(0, 0, 0, 0.03);
    }

    .nav {
        margin: 0 auto;
        width: 680px;
    }
    .nav a {
        display: block;
        text-decoration: none;
    }
    .nav > li {
        float: left;
        margin-right: 3px;
    }
    .nav > li > a {
        height: 34px;
        line-height: 34px;
        padding: 0 20px;
        font-weight: bold;
        color: white;
        text-decoration: none;
        text-shadow: 0 -1px rgba(0, 0, 0, 0.3);
        background: #759aaf;
        border-radius: 3px 3px 0 0;
        background-image: -webkit-linear-gradient(top, #9cb6c5, #759aaf);
        background-image: -moz-linear-gradient(top, #9cb6c5, #759aaf);
        background-image: -o-linear-gradient(top, #9cb6c5, #759aaf);
        background-image: linear-gradient(to bottom, #9cb6c5, #759aaf);
        -webkit-box-shadow: inset 0 1px rgba(255, 255, 255, 0.3), inset 0 -2px 2px rgba(0, 0, 0, 0.03), 0 2px white, 0 0 2px rgba(0, 0, 0, 0.2);
        box-shadow: inset 0 1px rgba(255, 255, 255, 0.3), inset 0 -2px 2px rgba(0, 0, 0, 0.03), 0 2px white, 0 0 2px rgba(0, 0, 0, 0.2);
    }
    .nav > li > a:hover {
        text-decoration: none;
        background: #85a6b8;
        background-image: -webkit-linear-gradient(top, #afc5d1, #85a6b8);
        background-image: -moz-linear-gradient(top, #afc5d1, #85a6b8);
        background-image: -o-linear-gradient(top, #afc5d1, #85a6b8);
        background-image: linear-gradient(to bottom, #afc5d1, #85a6b8);
    }
    .nav > li.active > a, .nav > li > a:active, .nav > .dropdown:hover > a {
        background: white;
        color: #404040;
        text-shadow: none;
        -webkit-box-shadow: 0 2px white, 0 0 2px rgba(0, 0, 0, 0.2);
        box-shadow: 0 2px white, 0 0 2px rgba(0, 0, 0, 0.2);
    }
    .nav a.icon {
        position: relative;
        width: 40.8px;
        padding: 0;
    }
    .nav a.icon > span {
        display: block;
        position: absolute;
        top: 9px;
        left: 12px;
        height: 16px;
        width: 16px;
        background-repeat: no-repeat;
        background-position: 0 0;
        font: 0/0 serif;
        text-shadow: none;
        color: transparent;
    }
    .nav .active a.icon > span, .nav a.icon:active > span {
        background-position: 0 -16px;
    }

    .dropdown {
        position: relative;
        border-bottom: 5px solid white;
    }
    .dropdown:hover ul {
        display: block;
    }
    .dropdown ul {
        display: none;
        position: absolute;
        top: 39px;
        left: -1px;
        min-width: 160px;
        padding: 0 0 5px;
        background: white;
        border: 1px solid #dadada;
        border-top: 0;
        border-radius: 0 0 3px 3px;
        -webkit-box-shadow: 0 0 1px rgba(0, 0, 0, 0.04);
        box-shadow: 0 0 1px rgba(0, 0, 0, 0.04);
    }
    .dropdown ul.large {
        min-width: 200px;
    }
    .dropdown li {
        display: block;
        margin: 0 18px;
        overflow: visible;
    }
    .dropdown li + li {
        border-top: 1px solid #eee;
    }
    .dropdown li a {
        color: #555;
        padding: 8px 18px;
        margin: 0 -18px;
    }
    .dropdown li a:hover {
        color: black;
    }

    .footer-bottom-area{
        background: lime;
    }
    .overlay {
        position: relative;
        z-index: 1;
    }

    .overlay:after {
        background-color: rgba(0, 0, 0, 0.8);
        content: "";
        left: 0;
        position: absolute;
        top: 0;
        height: 100%;
        width: 100%;
        z-index: -1;
    }

    .section-padding {
        padding: 100px 0;
    }

    .section-title {
        font-size: 15px;
        font-weight: 300;
        margin-bottom: 80px;
    }

    .section-title h2 {
        margin-bottom: 10px;
        position: relative;
        text-transform: uppercase;
    }

    .section-title p {
        margin-top: 10px;
    }

    .section-title .title-line {
        color: #ffd000;
        position: relative;
    }

    .section-title .title-line::after {
        background-color: #333;
        content: "";
        height: 2px;
        left: -60px;
        position: absolute;
        top: 10px;
        width: 50px;
    }

    .section-title .title-line::before {
        background-color: #333;
        content: "";
        height: 2px;
        position: absolute;
        right: -60px;
        top: 10px;
        width: 50px;
    }

    .overlay .section-title h2,
    .overlay .section-title p {
        color: #fff;
    }

    .overlay .section-title .title-line::after,
    .overlay .section-title .title-line::before {
        background-color: #fff;
    }


    #header-area,
    #header-area a {
        color: #fff;
    }

    #header-top {
        background-color: #1e2228;
        padding: 8px 0;
    }

    #header-top i {
        color: #ffd000;
        font-size: 15px;
        margin-right: 2px;
    }

    #header-area .header-social-icons a i.fa {
        color: #fff;
        font-size: 15px;
        margin-left: 10px;
        -webkit-transition: 0.4s;
        transition: 0.4s;
    }

    #header-area .header-social-icons a:hover i.fa,
    #header-area .mainmenu ul li.active a,
    #header-area .mainmenu ul li:hover a {
        color: #ffd000;
    }

    header.fixTotop #header-top {
        display: none !important;
    }

    #header-bottom {
        background-color: rgba(0, 0, 0, 0.3);
        padding: 15px 0;
        -webkit-transition: all 0.4s ease 0s;
        transition: all 0.4s ease 0s;
    }

    header.fixTotop #header-bottom {
        background-color: rgba(0, 0, 0, 1);
        -webkit-transition: all 0.4s ease 0s;
        transition: all 0.4s ease 0s;
    }

    .mainmenu ul li {
        float: left;
        position: relative;
    }

    .mainmenu ul li a {
        display: block;
        font-weight: 700;
        margin-left: 25px;
        padding: 15px 0;
        text-transform: uppercase;
        -webkit-transition: all 0.4s ease 0s;
        transition: all 0.4s ease 0s;
    }

    .mainmenu ul li ul {
        background-color: #fff;
        -webkit-box-shadow: 1px 2px 2px rgba(0, 0, 0, 0.3);
        box-shadow: 1px 2px 2px rgba(0, 0, 0, 0.3);
        left: 0;
        opacity: 0;
        position: absolute;
        top: 52px;
        -webkit-transition: all 0.4s ease 0s;
        transition: all 0.4s ease 0s;
        visibility: hidden;
        width: 220px;
        z-index: 9999;
    }

    .mainmenu ul li ul::after {
        border-bottom: 10px solid #fff;
        border-left: 8px solid transparent;
        border-right: 8px solid transparent;
        content: "";
        left: 25px;
        position: absolute;
        top: -10px;
    }

    .mainmenu ul li:hover ul {
        opacity: 1;
        visibility: visible;
    }

    .mainmenu ul li ul li {
        float: none;
    }

    .mainmenu ul li ul li a {
        color: #000 !important;
        font-size: 12px;
        font-weight: 600;
        margin: 0;
        padding: 10px 25px;
    }

    .mainmenu ul li ul li.active a,
    .mainmenu ul li ul li a:hover {
        background-color: #ffd000;
    }

    #header-bottom .container {
        position: relative;
    }


    .slicknav_nav ul,
    .slicknav_nav ul li a,
    .slicknav_nav ul li.slicknav_parent a {
        margin: 0;
        -webkit-transition: 0.4s;
        transition: 0.4s;
        text-transform: uppercase;
    }

    .slicknav_nav ul li.slicknav_parent a:hover,
    .slicknav_nav ul li a:hover {
        background-color: #ffd000;
        border-radius: 0px;
    }

    .slicknav_parent ul {
        font-size: 13px;
        margin-left: 15px;
    }

    .slicknav_parent ul li.slicknav_parent:hover ul a {
        background-color: transparent !important;
    }

    .single-service {
        margin-bottom: 50px;
        line-height: 2;
    }

    .service-icon {
        height: 60px;
        line-height: 60px;
        position: relative;
        text-align: center;
        margin-right: 10px;
        width: 60px;
        -webkit-transition: 0.4s;
        transition: 0.4s;
    }

    .service-icon:after {
        border-left: 1px solid #ffd000;
        content: "";
        height: 0%;
        left: 0;
        position: absolute;
        top: 0;
        -webkit-transition: 0.4s;
        transition: 0.4s;
    }

    .service-icon:before {
        border-bottom: 1px solid #ffd000;
        content: "";
        height: 0%;
        right: 0;
        position: absolute;
        bottom: 0;
        width: 0%;
        -webkit-transition: 0.4s;
        transition: 0.4s;
    }

    .service-icon span {
        display: block;
        height: 100%;
        left: 0;
        position: absolute;
        top: 0;
        -webkit-transition: 0.4s;
        transition: 0.4s;
        width: 100%;
    }

    .service-icon span::after {
        border-top: 1px solid #ffd000;
        content: "";
        left: 0;
        position: absolute;
        top: 0;
        -webkit-transition: 0.4s;
        transition: 0.4s;
        width: 0%;
    }

    .service-icon span::before {
        border-right: 1px solid #ffd000;
        content: "";
        height: 0%;
        position: absolute;
        right: 0;
        bottom: 0;
        -webkit-transition: 0.4s;
        transition: 0.4s;
    }

    .single-service:hover .service-icon:after {
        height: 100%;
    }

    .single-service:hover .service-icon:before {
        width: 100%;
    }

    .single-service:hover .service-icon span::after {
        width: 100%;
    }

    .single-service:hover .service-icon span::before {
        height: 100%;
    }

    .single-service h4 {
        font-size: 20px;
        text-transform: uppercase;
        font-weight: 600;
    }

    .single-service p {
        font-size: 13px;
        margin-top: 10px;
    }



    .bookinput-item {
        border: 1px solid #fff;
        display: block;
        float: left;
        margin-right: 1%;
        width: 19.2%;
        -webkit-transition: 0.4s;
        transition: 0.4s;
    }

    .bookinput-item:last-child {
        margin-right: 0;
    }

    .book-ur-car select,
    .book-ur-car input,
    .book-ur-car button {
        background-color: transparent;
        border: none;
        border-radius: 0;
        color: #fff;
        font-size: 14px;
        font-weight: 600;
        padding: 10px;
        text-align: center;
        text-transform: uppercase;
        width: 100%;
    }

    .book-ur-car select:focus,
    .book-ur-car input:focus,
    .book-ur-car button:focus {
        border-color: #fff;
        background-color: transparent;
    }

    .bookcar-btn button {
        padding: 7px;
        cursor: pointer;
        -webkit-transition: 0.4s;
        transition: 0.4s;
    }

    .bookcar-btn:hover {
        background-color: #ffd000;
        border-color: #ffd000;
    }


    .book-ur-car .input-group-append i.fa {
        font-size: 15px !important;
        line-height: 30px;
        color: #ffd000;
    }

    .book-ur-car select option {
        color: #000;
        font-weight: 400;
        background: #fff;
        text-transform: capitalize;
    }

    .book-ur-car select.custom-select {
        background-position: right 12px center;
        background-size: 12px auto;
    }

    .slider-bg-1 {
        background-image: url("slider-img-4.jpg");
    }

    .home-slider-item {
        background-position: center center;
        background-size: cover;
        padding: 200px 0 220px;
    }

    #book-a-car {
        padding-top: 100px;
    }

    .booka-car-content {
        background-color: #fff;
        border-radius: 3px;
        -webkit-box-shadow: 0 0 5px rgba(0, 0, 0, 0.5);
        box-shadow: 0 0 5px rgba(0, 0, 0, 0.5);
        overflow: hidden;
        padding: 100px 40px;
        position: relative;
        z-index: 1;
    }

    .booka-car-content input,
    .booka-car-content select {
        border: 1px solid #ffd000;
        width: 100%;
    }

    .booka-car-content input:focus,
    .booka-car-content select:focus {
        border-color: #ffd000;
    }

    .booka-car-content .input-group-append {
        border: 1px solid #ffd000;
        border-radius: 2px;
    }

    .booka-car-content .input-group-append {
        border-left: 0 none;
    }

    .booka-car-content input {
        border-right: 0 none;
    }

    .booka-car-content .bookcar-btn button {
        background-color: #fff;
        border: 1px solid #ffd000;
        border-radius: 2px;
        padding: 8px 0;
        width: 100%;
    }

    .booka-car-content .bookcar-btn button:hover {
        background-color: #ffd000;
    }

    .booka-car-content .bookcar-btn {
        border: medium none;
    }

    .booka-car-content .bookcar-btn:hover {
        border: medium none;
    }
    @media only screen and (min-width: 992px) {

        .slider-right-text h1 {
            font-size: 45px;
        }
        .about-btn a {
            padding: 6px 30px;
        }

        .service-content .col-lg-6:nth-child(5) .single-service,
        .service-content .col-lg-6:last-child .single-service {
            margin-bottom: 0;
        }

        .choose-content-wrap ul.nav-tabs .nav-item {
            margin-bottom: 0 !important;
        }

        .single-footer-widget {
            margin-bottom: 0;
        }

        .mobile-app-content h2 {
            font-size: 70px;
        }
        .app-btns a {
            font-size: 16px;
            margin-right: 40px;
            padding: 10px 20px;
        }
        .single-article .article-thumb {
            margin-right: 0;
        }
        .single-article.middle .article-thumb {
            margin-left: 0;
        }

        .single-article.middle .article-date {
            left: auto;
            right: -58px;
            z-index: 1;
        }

        .single-testimonial p {
            font-size: 13px;
            margin-bottom: 0;
        }
        .single-testimonial p,
        .single-testimonial h3 {
            text-align: left;
        }


        .slideshowcontent h1 {
            font-size: 70px;
        }

        #book-a-car {
            padding-top: 0;
        }
        .booka-car-content {
            margin-top: -120px;
        }



        .car-list-content .col-lg-6:nth-child(3)  {
            margin-bottom: 0;
        }
        .pricing-details-content .col-lg-6:nth-child(3)

    }

    @media only screen and (min-width: 768px) and (max-width: 991px) {

        .slider-right-text h1,
        .slideshowcontent h1 {
            font-size: 45px;
        }
        .about-btn a {
            padding: 6px 30px;
        }

        .funfact-content-wrap .col-lg-4:last-child .single-funfact {
            margin-bottom: 0;
        }
        .choose-content-wrap ul.nav-tabs .nav-item {
            margin-bottom: 0 !important;
        }

        .single-footer-widget {
            margin-bottom: 50px;
        }
        #footer-area .col-lg-4:last-child .single-footer-widget,
        #pricing-area .col-lg-4:last-child .single-pricing-table {
            margin-bottom: 0;
        }

        .mobile-app-content h2 {
            font-size: 40px;
        }
        .app-btns a {
            font-size: 16px;
            margin-right: 40px;
            padding: 10px 20px;
        }
        .app-btns a i {
            font-size: 20px;
        }


        .single-article.middle .article-date {
            left: 50%;
            top: 9px;
            -webkit-transform: translateX(-50%);
            -ms-transform: translateX(-50%);
            transform: translateX(-50%);
        }

        .single-testimonial p {
            font-size: 13px;
            margin-bottom: 0;
        }
        .single-testimonial p,
        .single-testimonial h3 {
            text-align: left;
        }


        .bookinput-item {
            margin-bottom: 15px;
            width: 49.5%;
        }
        .bookinput-item:nth-child(2) {
            margin-right: 0
        }
        .bookinput-item:nth-child(4) {
            margin-right: 0
        }
        .bookinput-item:last-child {
            margin-bottom: 0
        }

        .service-content .col-lg-6:nth-child(5) .single-service {
            margin-bottom: 0;
        }



        .car-list-content .col-lg-6:nth-child(3) .single-car-wrap {
            margin-bottom: 0;
        }


        #our-facility .col-lg-3:nth-child(3) .single-our-facility,
        #our-facility .col-lg-3:last-child .single-our-facility {
            margin-bottom: 0;
        }

        .pricing-details-content .col-lg-6:nth-child(3) .single-pricing-table {
            margin-bottom: 0;
        }

    }

    @media only screen and (max-width: 767px) {

        .slider-right-text h1,
        .slideshowcontent h1 {
            font-size: 30px;
        }
        .about-btn a {
            padding: 5px 25px;
        }

        .funfact-content-wrap .col-lg-4:last-child .single-funfact {
            margin-bottom: 0;
        }
        .choose-content-wrap ul.nav-tabs li.nav-item {
            margin-bottom: 10px !important;
        }

        .single-footer-widget {
            margin-bottom: 50px;
        }
        #footer-area .col-lg-4:last-child .single-footer-widget,
        #pricing-area .col-lg-4:last-child .single-pricing-table {
            margin-bottom: 0;
        }

        .mobile-app-content h2 {
            font-size: 26px;
        }
        .app-btns a {
            font-size: 13px;
            margin-right: 10px;
            padding: 8px 15px;
        }
        .app-btns a i {
            font-size: 13px;
        }


        .single-article.middle .article-date {
            left: 50%;
            top: 9px;
            -webkit-transform: translateX(-50%);
            -ms-transform: translateX(-50%);
            transform: translateX(-50%);
        }

        .single-testimonial p {
            font-size: 12px;
            margin-bottom: 150px;
        }
        .single-testimonial p,
        .single-testimonial h3 {
            text-align: center;
        }

        .bookinput-item {
            margin-bottom: 15px;
            width: 100%;
        }

        .car-details-content h2 {
            font-size: 20px;
        }

        #our-facility .col-lg-3:last-child .single-our-facility {
            margin-bottom: 0;
        }


    }
    @import url('https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700');
    @import url('https://fonts.googleapis.com/css?family=Monoton');


    * {
        margin: 0;
        padding: 0;
    }

    * {
        outline: none!important
    }

    .alignright {
    }

    a:hover,
    a:focus,
    a:active {
        color: inherit;
    }

    a:focus {
        outline-offset: -2px;
    }

    img {
        max-width: 100%;
        height: auto;
    }

    h1,
    h2,
    h3,
    h4,
    h5,
    h6 {
        font-family: 'Open Sans', sans-serif;
        font-weight: 700;
        margin: 0;
        padding: 0;
        line-height: 1.2em;
        color: #222;
    }

    body {
        font-family: 'Open Sans', sans-serif;
        font-size: 14px;
        font-weight: 400;
        line-height: 1.6;
        color: #333;
        letter-spacing: 0.8px;
    }

    a:hover {
        text-decoration: none
    }
    input:-webkit-autofill,
    input:-webkit-autofill:hover,
    input:-webkit-autofill:focus {
        -webkit-box-shadow: 0 0 0px 1000px white inset !important;
    }

    p,
    ul {
        margin: 0;
        padding: 0;
    }

    ul li {
        list-style-type: none;
    }

    ::-moz-selection {
        background-color: #fff;
        color: #fab702;
    }

    ::selection {
        background-color: #fff;
        color: #fab702;
    }
    @font-face {
        font-family: 'FontAwesome';
        font-weight: normal;
        font-style: normal;
    }
    .fa {
        display: inline-block;
        font: normal normal normal 14px/1 FontAwesome;
        font-size: inherit;
        text-rendering: auto;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
    }

    .gj-calendar table tr[role="month-manager"] th {
        cursor: pointer;
    }

    .gj-calendar table tr[role="month-manager"] th div[role="month"] {
        width: 100%;
        text-align: center;
    }
    .gj-datepicker-md [role="right-icon"] {
        cursor: pointer;
        position: absolute;
        right: 0px;
        top: 0px;
    }

    .gj-calendar-md table tr[role="month-manager"] th div i.gj-icon,
    .gj-calendar-md table tr[role="month-manager"] th div i.material-icons {
        position: absolute;
        top: 8px;
        left: 8px;
    }

    .gj-calendar-md table tr td div,
    .gj-calendar-md table tr th div {
        display: block;
        width: 40px;
        height: 40px;
        line-height: 40px;
        font-size: 13px;
        text-align: center;
        vertical-align: middle;
        position: relative;
    }

    .gj-calendar-md table tr td.gj-cursor-pointer div:hover {
        background: #EEEEEE;
        border-radius: 50%;
    }

    .gj-calendar-md table tr td.today div {
        color: #1976D2;
    }

    .gj-calendar-md table tr td.selected div {
        color: #FFFFFF;
        background: #1976D2; /* Blue 700 */
        border-radius: 50%;
    }

    .gj-calendar-md table tr td.focused div {
        background: #E0E0E0; /* Gray 300 */
        border-radius: 50%;
    }

    .gj-calendar-md table tr td.other-month div,
    .gj-calendar-md table tr td.disabled div {
        color: #fff; /* Gray 400 */
    }

    .gj-datepicker-bootstrap input:focus {
        -webkit-box-shadow: none;
        box-shadow: none;
    }
    .gj-calendar-bootstrap table tr td div,
    .gj-calendar-bootstrap table tr th div {
        display: block;
        width: 30px;
        height: 30px;
        line-height: 30px;
        text-align: center;
        vertical-align: middle;
        position: relative;
    }

    .gj-calendar-bootstrap table tr th div i,
    .gj-calendar-bootstrap table tr th div span {
        line-height: 30px;
    }

    .gj-calendar-bootstrap table tr[role="month-manager"] th div .gj-icon,
    .gj-calendar-bootstrap table tr[role="month-manager"] th div .material-icons {
        margin: 3px;
    }

    .gj-calendar-bootstrap table tr td.focused div,
    .gj-calendar-bootstrap table tr td.gj-cursor-pointer div:hover {
        background: #fff;
        border-radius: 4px;
    }

    .gj-calendar-bootstrap table tr td.today div {
        color: #fff;
        font-weight: bold;
    }

    .gj-calendar-bootstrap table tr td.selected div  {
        color: #fff;
        background-color: #204d74;
        border-color: #122b40;
        border-radius: 4px;
    }

    .gj-calendar-bootstrap table tr td.other-month div,
    .gj-calendar-bootstrap table tr td.disabled div {
        color: #777;
    }
    .gj-datepicker-bootstrap span[role="right-icon"].input-group-addon {
        border-top-left-radius: 0px;
        border-bottom-left-radius: 0px;
        border-top-right-radius: 4px;
        border-bottom-right-radius: 4px;
        border-left: 0px;
        position: relative;
        width: 38px;
    }

    .gj-datepicker-bootstrap span[role="right-icon"].input-group-addon .gj-icon,
    .gj-datepicker-bootstrap span[role="right-icon"].input-group-addon .material-icons {
        position: absolute;
        top: 7px;
        left: 7px;
    }
    .gj-datepicker-bootstrap span[role="right-icon"].input-group-append,
    .gj-datepicker-bootstrap span[role="right-icon"].input-group-prepend {
        width: 38px;
    }

    .gj-datepicker-bootstrap span[role="right-icon"] .input-group-text {
        padding: 7px 8px 8px 30px;
        border-left: 0px;
    }

    .gj-datepicker-bootstrap span[role="right-icon"] .input-group-text .gj-icon,
    .gj-datepicker-bootstrap span[role="right-icon"] .input-group-text .material-icons {
        position: absolute;
        right: 8px;
        top: 8px;
    }

    .gj-datepicker-bootstrap span[role="right-icon"] .input-group-text .fa {
        position: absolute;
        right: 10px;
        top: 7px;
        font-size: 21px;
    }
    .owl-carousel .owl-stage {
        position: relative;
        -ms-touch-action: pan-Y;
    }
    .owl-carousel .owl-stage:after {
        content: ".";
        display: block;
        clear: both;
        visibility: hidden;
        line-height: 0;
        height: 0;
    }
    .owl-carousel .owl-refresh .owl-item {
        display: none;
    }
    .owl-carousel .owl-item {
        position: relative;
        min-height: 1px;
        float: left;
        -webkit-backface-visibility: hidden;
        -webkit-tap-highlight-color: transparent;
        -webkit-touch-callout: none;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
    }

</style>