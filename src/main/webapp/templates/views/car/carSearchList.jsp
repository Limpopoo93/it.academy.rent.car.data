<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Catalog</title>
</head>
<body class="catalog catalog-list">
<!--BEGIN HEADER-->
<div id="header">
    <div class="top_info">
        <div class="logo">
            <a href="#">Auto<span>Dealer</span></a>
        </div>
        <div class="header_contacts">
            <div class="phone">+1 (800) 455-55-95</div>
            <div>WinterJuice, LLC, 1875 South Grant Street, Suite 680, San Mateo, CA 94402</div>
        </div>

    </div>
    <div class="bg_navigation">
        <div class="navigation_wrapper">
            <div id="navigation">
                <span>Home</span>
                <ul>
                    <li class="current"><a href="#">Home</a></li>
                    <li><a href="#">About Us</a></li>
                    <li><a href="#">Blog</a></li>
                    <li><a href="#">News</a></li>
                    <li><a href="#">For Salers</a></li>
                    <li><a href="#">Contacts</a></li>
                </ul>
            </div>

        </div>
    </div>
</div>
<!--EOF HEADER-->
<!--BEGIN CONTENT-->
<div id="content">
    <div class="content">

        <div class="main_wrapper">

            <h1><strong>Cars</strong></h1>
            <div class="catalog_sidebar">
                <div class="search_auto">
                    <h3><strong>Search</strong> auto</h3>
                    <div class="clear"></div>
                    <label><strong>Manufacturer:</strong></label>
                    <div class="select_box_1">
                        <select class="select_3">
                            <option value="0">Any</option>
                            <option value="1">Audi</option>
                            <option value="2">Mercedes-Benz</option>
                            <option value="3">BMW</option>
                            <option value="4">Lexus</option>
                            <option value="5">Lincoln</option>
                            <option value="6">Ford</option>
                            <option value="7">Fiat</option>
                            <option value="8">Dodge</option>
                        </select>
                    </div>
                    <label><strong>Model:</strong></label>
                    <div class="select_box_1">
                        <select class="select_3">
                            <option value="0">Any</option>
                            <option value="1">R8</option>
                            <option value="2">S500</option>
                            <option value="3">540i</option>
                            <option value="4">RX300</option>
                            <option value="5">Navigator</option>
                            <option value="6">Taurus</option>
                            <option value="7">Doblo</option>
                            <option value="8">Viper</option>
                        </select>
                    </div>
                    <label><strong>Year:</strong></label>
                    <div class="select_box_2">
                        <select class="select_4">
                            <option value="0">From</option>
                            <option value="1">2013</option>
                            <option value="2">2012</option>
                            <option value="3">2011</option>
                            <option value="4">2010</option>
                            <option value="5">2009</option>
                            <option value="6">2008</option>
                            <option value="7">2007</option>
                            <option value="8">2006</option>
                        </select>
                        <select class="select_4">
                            <option value="0">To</option>
                            <option value="1">2013</option>
                            <option value="2">2012</option>
                            <option value="3">2011</option>
                            <option value="4">2010</option>
                            <option value="5">2009</option>
                            <option value="6">2008</option>
                            <option value="7">2007</option>
                            <option value="8">2006</option>
                        </select>
                        <div class="clear"></div>
                    </div>
                    <label><strong>Price:</strong></label>
                    <div class="select_box_2">
                        <select class="select_4">
                            <option value="0">From</option>
                            <option value="1">1000</option>
                            <option value="2">2000</option>
                            <option value="3">3000</option>
                            <option value="4">4000</option>
                            <option value="5">5000</option>
                            <option value="6">6000</option>
                            <option value="7">7000</option>
                            <option value="8">8000</option>
                        </select>
                        <select class="select_4">
                            <option value="0">To</option>
                            <option value="1">1000</option>
                            <option value="2">2000</option>
                            <option value="3">3000</option>
                            <option value="4">4000</option>
                            <option value="5">5000</option>
                            <option value="6">6000</option>
                            <option value="7">7000</option>
                            <option value="8">8000</option>
                        </select>
                        <div class="clear"></div>
                    </div>
                    <label><strong>Mileage:</strong></label>
                    <div class="select_box_2">
                        <select class="select_4">
                            <option value="0">From</option>
                            <option value="1">1000</option>
                            <option value="2">2000</option>
                            <option value="3">3000</option>
                            <option value="4">4000</option>
                            <option value="5">5000</option>
                            <option value="6">6000</option>
                            <option value="7">7000</option>
                            <option value="8">8000</option>
                        </select>
                        <select class="select_4">
                            <option value="0">To</option>
                            <option value="1">1000</option>
                            <option value="2">2000</option>
                            <option value="3">3000</option>
                            <option value="4">4000</option>
                            <option value="5">5000</option>
                            <option value="6">6000</option>
                            <option value="7">7000</option>
                            <option value="8">8000</option>
                        </select>
                        <div class="clear"></div>
                    </div>

                    <input type="submit" value="Search" class="btn_search"/>
                    <div class="clear"></div>
                </div>

            </div>
            <div class="main_catalog">
                <div class="top_catalog_box">

                    <div class="clear"></div>
                </div>
                <c:forEach items="${cars}" var="car">
                    <ul class="catalog_table">
                        <li>
                            <a class="thumb"><img src="../../../resources/static/165x119.gif" alt=""/></a>
                            <div class="catalog_desc">
                                <div class="location">Company: ${car.getCompany().getNameCompany()}</div>
                                <div class="title_box">
                                    <h4><a href="#">${car.getMakeCar()}, ${car.getNameCar()}</a></h4>
                                    <div class="price">${car.getPrice()} EURO</div>
                                </div>
                                <div class="clear"></div>
                                <div class="grey_area">
                                    <span>Fuel:${car.getTypeFuel()}</span>
                                    <span>Doors:${car.getColDoors()}</span>
                                    <span>People:${car.getColPeople()}</span>
                                    <span>Mileage:${car.getMileage()}</span>
                                    <span>Type:${car.getTypeCar()}</span>
                                </div>
                                <form action="<c:url value="/bookCarId/${car.getId()}"/>" method="get">
                                    <button class="more markered"><i>Book Car</i></button>
                                </form>
                            </div>
                        </li>
                    </ul>
                </c:forEach>




                <div class="bottom_catalog_box">
                    <div class="pagination">
                        <ul>
                            <li class="active"><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li class="space">...</li>
                            <li><a href="#">8</a></li>
                            <li class="next"><a href="#"><img src="../../../resources/static/page_next.gif" alt=""/></a></li>
                        </ul>
                    </div>
                    <div class="clear"></div>
                </div>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</div>
<!--EOF CONTENT-->
<!--BEGIN FOOTER-->
<div id="footer">
    <div class="bg_top_footer">
        <div class="top_footer">
            <div class="f_widget first">
                <h3><strong>About</strong> us</h3>
                <a class="footer_logo">AutoDealer</a>
                <p>Lorem ipsum dolor sit amet, cons ectetur adipisicing elit, sed do eiusmod tempor.
                    Lorem ipsum dolor sit amet, con sectetur adipisicing elit, sed do eius mod tempor incididunt ut.</p>
            </div>

        </div>
    </div>
    <div class="bottom_footer">

    </div>

</div>
<!--EOF FOOTER-->
</body>
</html>
<style type="text/css">
    @font-face {
        font-family: 'PTSansBold';
        src: url('../fonts/PTS75F-webfont.eot');
        src: url('../fonts/PTS75F-webfont.eot?#iefix') format('embedded-opentype'),
        url('../fonts/PTS75F-webfont.woff') format('woff'),
        url('../fonts/PTS75F-webfont.ttf') format('truetype'),
        url('../fonts/PTS75F-webfont.svg#PTSansBold') format('svg');
        font-weight: bold;
        font-style: normal;
    }

    body, form, img, h1, h2, h3, h4, h5, p, a, div, ul, li {
        padding: 0;
        margin: 0;
        border: 0;
    }

    input, textarea, a {
        outline: 0;
    }

    body {
        font-family: 'PTSansRegular', Arial, sans-serif;
        font-size: 13px;
        color: #607586;
        background: #FFFFFF;
        overflow-x: hidden;
    }

    a {
        font-family: 'PTSansRegular', Arial, sans-serif;
        font-size: 13px;
        color: #607586;
        text-decoration: none;
    }

    a:hover {
        text-decoration: underline;
    }

    strong {
        font-family: 'PTSansBold', Arial, sans-serif;
        font-weight: bold;
    }

    p {
        line-height: 20px;
    }

    h1 {
        font-weight: normal;
        font-size: 32px;
        line-height: 40px;
        color: #293848;
        text-shadow: 0 0 0 #293848;
        border-bottom: 1px solid #D1D5DC;
        padding: 0 0 32px 0;
        margin: 0 0 20px 0
    }

    h2 {
        font-weight: normal;
        font-family: 'PTSansRegular', Arial, sans-serif;
        font-size: 24px;
        line-height: 30px;
        color: #293848;
        text-shadow: 0 0 0 #293848;
        border-bottom: 1px solid #D1D5DC;
        padding: 0 0 7px 0;
        margin: 0 0 20px 0
    }

    h3 {
        font-weight: normal;
        font-family: 'PTSansRegular', Arial, sans-serif;
        font-size: 21px;
        line-height: 28px;
        color: #293848;
        text-shadow: 0 0 0 #293848;
    }

    h4 {
        font-weight: bold;
        font-family: 'PTSansBold', Arial, sans-serif;
        font-size: 18px;
        line-height: 24px;
        color: #293848;
        padding: 0 0 15px 0;
    }

    h4 a {
        font-weight: bold;
        font-family: 'PTSansBold', Arial, sans-serif;
        font-size: 18px;
        line-height: 24px;
        color: #293848;
        text-decoration: none;
    }

    h4 a:hover {
        text-decoration: underline;
    }
    ul{
        list-style-type: none;
    }

    li:last-child{
        border:0;
        padding: 7px 0 0px 13px;
    }
    cite{
        font-style: normal;
        line-height: 24px;
        font-size: 20px;
        color: #293848;
        width: 292px;
        border-left: 5px solid #EAEAEA;
        padding: 0 0 0 15px;
        margin-top: 4px;
    }
    .fL{
        float:left;
    }
    .fR{
        float:right;
    }
    .clear{
        clear:both;
    }
    .ovh{
        overflow: hidden;
    }
    /*
    ================================================================================
    |                                     HEADER                                   |
    ================================================================================
    */
    #header{
        min-width:980px;
        width: 100%;
        margin: 0 auto;
        text-align:left;
        background: url(bg_header.jpg) repeat center 0;
        position: relative;
        z-index: 100;
    }
    #header .top_info{
        width: 940px;
        margin: 0 auto;
        overflow: hidden;
        padding: 15px 20px 25px;
    }
    #header .top_info .logo{
        width: 319px;
        float: left;
        padding: 0px 0 0 1px;
    }
    #header .top_info .logo a{
        font-family: 'PTSansBold',Arial,sans-serif;
        font-size: 48px;
        color: #FFFFFF;
        line-height: 60px;
        font-weight: bold;
        text-decoration: none;
    }
    #header .top_info .logo a span{
        color: #FFB01F;
    }
    #header .top_info .header_contacts{
        width: 455px;
        float: left;
        font-family: 'PTSansRegular',Arial,sans-serif;
        color: #B6BFC9;
        font-size: 12px;
        line-height: 18px;
        padding: 8px 0 0 5px;
    }
    #header .top_info .header_contacts .phone{
        font-family: 'PTSansBold',Arial,sans-serif;
        font-weight: bold;
        font-size: 18px;
        line-height: 24px;
        color: #FFFFFF;
        word-spacing: 1px;
        padding: 0 0 2px 0;
    }
    #header .top_info .socials{
        float: left;
        width: 160px;
        text-align: right;
        padding: 14px 0 0 0;
    }
    #header .top_info .socials a{
        display: inline-block;
        width: 24px;
        height: 24px;
        margin: 0 0 0 2px;
    }
    #search_form{
        float: left;
        width: 320px;
        text-align: right;
        padding: 10px 0 0 0;
    }
    #search_form .txb_search{
        border: 1px solid #D0D0D0;
        display: inline-block;
        vertical-align: top;
        background: #FFFFFF;
        border-radius: 4px;
        width: 197px;
        height: 26px;
        margin: 0;
        padding: 0;
        padding: 1px 10px 0 10px;
        line-height: 26px;
        font-family: 'PTSansRegular',Arial,sans-serif;
        color: #798FA1;
        box-shadow: 0 1px 0 0 #FFFFFF;
    }
    #search_form .btn_search{
        vertical-align: top;
        width: 71px;

        text-transform: uppercase;
        height: 34px;
        border:0;
        margin: 0 0 0 7px;
        padding: 0 0 5px 0;
        display: inline-block;
        font-family: 'PTSansBold',Arial,sans-serif;
        font-weight: bold;
        text-align: center;
        font-size: 11px;
        cursor: pointer;
        color: #3B424A;
        text-shadow:0 0 0 #3B424A;
    }
    /*
    ================================================================================
    |                                     NAVIGATION                               |
    ================================================================================
    */
    .bg_navigation{
        width: 100%;
        min-width: 980px;
        background: url(bg_navigation.jpg) repeat-x 0 0 #DBDCDC;
        margin: 0 auto;
    }
    .navigation_wrapper{
        width: 940px;
        overflow: hidden;
        padding: 0 20px;
        margin: 0 auto;
    }
    #navigation{
        width: 620px;
        float: left;
        padding: 0 0 0 0;
    }
    #navigation span{
        height: 29px;
        display: none;
        font-family: 'PTSansBold',Arial,sans-serif;
        font-weight: bold;
        color: #FFFFFF;
        font-size: 15px;
        line-height: 28px;
        cursor: pointer;
        text-decoration: none;
        padding: 0px 23px 0 15px;

    }
    #navigation ul{

    }
    #navigation ul li{
        display: inline-block;
        height: 49px;
        margin: 0 7px 0 0;
        border:0;
        background: none;
        padding: 0;
        line-height: 20px;
    }
    #navigation ul li a{
        display: inline-block;
        height: 49px;
        padding: 0 0 0 0;
        font-family: 'PTSansBold',Arial,sans-serif;
        font-weight: bold;
        color: #3B424A;
        text-shadow:0 1px 0 #FFFFFF;
        font-size: 15px;
        line-height: 25px;
        text-decoration: none;
        padding: 11px 23px 0 23px;
    }
    #navigation ul li.current a,
    #navigation ul li:hover a{
        background: url(bg_menu.jpg) repeat-x 0 0;
        color: #FFFFFF;
        text-shadow:0 -1px 0 #00369F;
    }
    /*
    ================================================================================
    |                                     CONTENT                                  |
    ================================================================================
    */
    #content{
        width:100%;

        text-align:left;
        min-width: 980px;
        margin: 0 auto;
    }
    .content{
        width: 940px;
        margin: 0 auto;
        padding: 15px 20px 0;
    }
    .line_1{
        overflow: hidden;
    }
    .slider_wrapper{
        float: left;
        width: 620px;
        padding: 0 0px 0 0;
        margin: 0 20px 0 0;
    }
    .search_auto_wrapper{
        width: 300px;
        float: left;
    }
    .wrapper_1{
        padding: 6px 0 33px 0;
    }
    .wrapper_2{
        padding: 0 0 40px 0;
    }
    .wrapper_3{
        padding: 0 0 13px 0;
    }
    .wrapper_2 .left,
    .wrapper_3 .left{
        width: 700px;
        float: left;
        padding-top:13px;
    }
    .wrapper_4 .left{
        float: left;
        padding-top:13px;
    }

    .wrapper_2 .right,
    .wrapper_3 .right {
        width: 220px;
        float: left;
        padding: 0 0 0 20px;
    }
    .main_wrapper{
        position:relative;
    }
    .markered{

        padding-right: 17px;
    }
    .grey_area{
        background: #F8F8F8;
        line-height: 18px;
        padding: 7px 15px 8px 15px;
    }
    .spaced{
        letter-spacing: 0.5px;
    }
    .mb1{
        padding-bottom: 40px;
    }
    img.alignright {
        float:right;
        margin-left: 29px;
        margin-bottom: 20px;
    }
    img.alignleft {
        float:left;
        margin-right: 29px;
        margin-bottom: 20px;
    }
    img.aligncenter {
        display: block;
        margin-left: auto;
        margin-right: auto;
    }
    .alignright {
        float:right;
        margin-left: 29px;
        margin-bottom: 16px;
    }
    .alignleft {
        float:left;
        margin-right: 29px;
        margin-bottom: 16px;
    }
    .aligncenter {
        display: block;
        margin-left: auto;
        margin-right: auto
    }
    .chb_devider{
        display: none;
    }
    .widget_divider{
        display: none;
    }
    /*
    ================================================================================
    |                                     SERVICES                                 |
    ================================================================================
    */
    .services{
        border:1px solid #EBEBEB;
        background: #F8F8F8;
        padding: 19px;
        overflow: hidden;
        margin-bottom: 20px;
    }
    .services .service{
        width: 247px;
        float: left;
        border:1px solid #EBEBEB;
        background: #FFFFFF;
        padding: 19px 19px 14px 19px;
        height: 174px;
        overflow: hidden;
    }
    .services .service.center{
        margin: 0 19px 0 20px;
    }
    .services .service h2{
        border:0;
        margin: 0;
        min-height: 39px;
        font-size: 26px;
        line-height: 32px;
        padding: 3px 0 11px 53px;
    }

    .services p{
        color: #798FA1;
        padding-bottom: 15px;
    }
    .services .more{

        border: 0;
        border-radius: 0;
        color: #FFFFFF;
        text-shadow:0 -1px 0 #000000;
        display: block;
        font-family: 'PTSansBold',Arial,sans-serif;
        height: 46px;
        text-align: center;
        font-size: 14px;
        cursor: pointer;
        margin: 0 0 0px;
        float: right;
        padding: 0px 0px 0px;
        width: 75px;
        line-height: 38px;
        text-transform: uppercase;
        text-decoration: none;
    }

    /*
    ================================================================================
    |                                     SEARCH AUTO                              |
    ================================================================================
    */
    .search_auto{
        width: 260px;
        border:1px solid #EBEBEB;
        padding: 11px 19px 13px;
        background: #F8F8F8;
    }
    .catalog_sidebar .search_auto{
        width: 180px;
        margin-bottom: 20px;
    }
    .search_auto h3{
        padding: 0 0 12px 0;
        float: left;
    }
    .catalog_sidebar .search_auto h3{
        float: none;
    }
    .search_auto .categories{
        float: right;
        padding: 11px 0 0 0;
    }
    .catalog_sidebar .search_auto .categories{
        float: none;
        padding: 1px 0 9px 0;
    }
    .search_auto .categories input{
        display: none;
    }
    .search_auto .categories label{
        position:relative;
        width: 25px;
        height: 13px;
        display: inline-block;
        cursor: pointer;
        margin: 0 0 0 7px;
    }
    .catalog_sidebar .search_auto .categories label{
        margin: 0 7px 0 10px;
    }
    .search_auto .categories label:after{
        width: 25px;
        cursor: pointer;
        height: 13px;
        position:absolute;
        top:0;
        left:0;
        z-index: 1000;
        display: inline-block;
        content: '';
    }

    .search_auto .select_box_1{
        width: 260px;
        padding: 0 0 8px 0;
    }
    .catalog_sidebar .search_auto .select_box_1{
        width: 180px;
    }
    .search_auto .select_box_2{
        width: 260px;
        padding: 0 0 8px 0;
    }
    .catalog_sidebar .search_auto .select_box_2{
        width: 180px;
    }
    .search_auto .select_box_2 .custom-select{
        float: left;
        width: 125px;
    }
    .catalog_sidebar .search_auto .select_box_2 .custom-select{
        float: left;
        width: 85px;
    }
    .search_auto .select_box_2 .custom-select:first-child{
        margin-right: 10px;
    }
    .search_auto label{
        font-size: 13px;
        display: block;
        line-height: 18px;
        padding: 0 0 3px 0;
    }
    .search_auto label strong{
        color: #293848;
    }
    .search_auto label.check_label{
        display: inline;
        vertical-align: top;
        color: #798FA1;
        line-height: 20px;
        font-size: 13px;
    }
    .search_auto .chb_wrapper{
        float: left;
        padding: 25px 0 0 0;
    }
    .catalog_sidebar .search_auto .chb_wrapper{
        float: none;
        padding: 0px 0 0 0;
    }
    .search_auto .chb_wrapper input{
        margin: 4px 2px 0 0;
        vertical-align: top;
    }
    .search_auto .btn_search{
        width: 104px;
        height: 46px;
        background: url(button_2.png) no-repeat 0 0;
        border:0;
        cursor: pointer;
        border-radius: 4px;
        float: right;
        font-family: 'PTSansBold';
        color: #FFFFFF;
        text-shadow:0 -1px 0 #050A0F;
        text-transform: uppercase;
        font-size: 14px;
        margin: 13px 0 0 0;
        padding: 0 0 7px 0;
    }
    .catalog_sidebar .search_auto .btn_search{
        float: none;
        margin: 16px 0 1px 0;
        padding: 0 0 9px 0;
    }

    /*
    ================================================================================
    |                                PAGINATION		                              |
    ================================================================================
    */
    .pagination{
        float: right;
    }
    .pagination ul{
        overflow: hidden;
    }
    .pagination ul li{
        float: left;
        color: #607586;
        text-shadow:1px 0 0 #607586;
        letter-spacing: 1px;
        border:0;
        background: none;
        padding: 0 0 0 2px;
    }
    .pagination ul li.space{
        padding: 5px 8px 0 11px;
    }
    .pagination ul li.next{
        padding: 0 0 0 15px;
    }
    .pagination ul li a{
        display: block;
        width: 29px;
        height: 29px;

        color: #607586;
        font-size: 13px;
        line-height: 28px;
        text-shadow:0 1px 0 #FFFFFF;
        text-align: center;
        text-decoration: none;
    }
    .pagination ul li a:hover,
    .pagination ul li.active a{
        background-position: 0 -29px;
        color: #FFFFFF;
        text-shadow:none;
    }
    .pagination ul li.next a{
        background: none;
        width: 6px;
        padding: 9px 0 0;
        height: 20px;
    }

    /*
    ================================================================================
    |                              CUSTOM SELECT                                   |
    ================================================================================
    */
    .custom-select{
        position: relative;
        width: auto;
    }
    .custom-select select{
        display: none;
    }
    .custom-select .custom-text{
        border:1px solid #D1D5DC;
        border-radius: 3px;
        background: #FFFFFF;
        display: block;
        color: #798FA1;
        font-size: 13px;
        height: 28px;
        line-height: 28px;
        font-family: 'PTSansRegular',Arial,sans-serif;
        padding:1px 0 0 11px;
        box-shadow: 0 1px 0 0 #FFFFFF;
        width: auto;

    }
    .select-list{
        border:1px solid #D1D5DC;
        z-index: 100;
        border-radius: 3px;
        background: #FFFFFF;
        display: block;
        color: #798FA1;
        font-size: 13px;
        top: 31px;
        line-height: 28px;
        font-family: 'PTSansRegular',Arial,sans-serif;
        padding:0px 0 0 0px;
        width: 100%;
        position: absolute;
    }
    .custom-scroll{
        overflow: hidden;
    }
    .select-scroll {
        background-color: #D1D5DC;
        border-radius: 0px 2px 2px 0px;
        width: 12px;
    }
    .select-scroll {
        position: absolute;
        right: 0px;
        top: 0px;
        z-index: 2;
    }
    .maxlength .scroll-drag:after {
        content: "≡";
        display: block;
        font-size: 14px;
        left: 50%;
        margin: -14px 0 0 -4px;
        position: relative;
        top: 50%;
    }
    .scroll-drag {
        background-color: #293648;
        border-radius: 2px 2px 2px 2px;
        top: 0;
        width: 10px;
    }
    .scroll-drag {
        cursor: pointer;
        display: block;
        left: 1px;
        position: absolute;
    }
    .custom-select ul {
        left: 0;
        position: relative;
        top: 0;
    }
    .custom-select ul li{
        padding-left: 10px;
        cursor: pointer;
        border:0;
        background: none;
    }
    .custom-select ul li.selected,
    .custom-select ul li:hover{
        background: #798FA1;
        color: #FFFFFF;
    }
    .select_box_1 .select-list{
        width: 258px;
    }
    .select_box_2 .select-list{
        width: 124px;
    }
    .catalog_sidebar .select_box_1 .select-list,
    .car_sidebar .select_box_1 .select-list{
        width: 178px;
    }
    .catalog_sidebar .select_box_2 .select-list{
        width: 83px;
    }
    .sell_select .select-list{
        width: 205px;
    }



    /*
    ================================================================================
    |                                     CATALOG                                   |
    ================================================================================
    */
    .cars_categories,
    .steps{
        position: absolute;
        top:3px;
        right: 0;
    }
    .cars_categories span,
    .cars_categories a,
    .steps span,
    .steps a{
        overflow: hidden;
        display: inline-block;
        text-decoration: none;
        text-transform: uppercase;
        font-size: 12px;
        line-height: 16px;
    }
    .cars_categories span,
    .cars_categories a.active,
    .steps span,
    .steps a.active{
        border-radius: 5px;

        color: #FFFFFF;
        text-shadow:0 0 0 #FFFFFF;
        padding: 6px 10px 7px 12px;
    }
    .cars_categories a,
    .steps a{
        padding: 6px 10px 7px 11px;
    }
    .cars_categories a span,
    .steps a span{
        padding: 0;
        background: none;
        border-radius: 0;
        color: #798FA1;
        text-shadow:0 0 0 #798FA1;

    }
    .cars_categories a:hover span,
    .steps a:hover span{
        background: none;
    }
    .catalog_sidebar{
        width: 220px;
        padding: 0 40px 0 0;
        float: left;
    }
    .main_catalog{
        float: left;
        width: 680px;
        padding: 15px 0 0 0;
    }
    .top_catalog_box{
        border-bottom: 1px solid #D1D5DC;
        padding-bottom: 30px;
    }
    .bottom_catalog_box{
        padding-top: 30px;
        padding-bottom: 40px;
    }
    .switch{
        overflow: hidden;
        float: left;
        padding: 0 21px 0 0;
    }
    .switch span,
    .switch a{

        background-repeat: no-repeat;
        width: 29px;
        height: 29px;
        float: left;
        display: block;
    }
    .switch span.table_view{
        background-position: 0 0;
    }
    .switch a.table_view{
        background-position: 0 -29px;
    }
    .switch span.list_view{
        background-position: -29px 0;
    }
    .switch a.list_view{
        background-position: -29px -29px;
    }
    .sorting{
    }
    .drop_list{
        padding: 1px 20px 0 0;
        float: left;
        line-height: 20px;
    }
    .drop_list strong{
        color: #293848;
        float: left;
        padding-top: 3px;
    }
    .drop_list span{
        cursor: pointer;
        position: relative;
        z-index: 10;
        display: inline-block;
        height: 18px;
        padding: 5px 11px 0 10px;

    }
    .drop_list .active span{
        background: #FFFFFF;
        border:1px solid #D1D5DC;
        border-bottom: 0;
        border-radius: 5px 5px 0 0;
        padding: 4px 10px 0 9px;
    }
    .drop_list span a{
        display: inline-block;
        text-decoration: none;

        line-height: 16px;
    }
    .drop_list .selected{
        float: left;
        position: relative;
        z-index: 10;
        padding-top: 0px;
    }
    .drop_list ul{
        display: none;
        position:absolute;
        z-index: 1;
        top:22px;
        left:0;
        border:1px solid #D1D5DC;
        border-radius: 0 5px 5px 5px;
        background: #FFFFFF;
        padding: 4px 0 4px 0;
    }
    .drop_list .active ul{
        display: block;
    }
    .drop_list ul li{
        border:0;
        background: none;
        padding: 0;
    }
    .drop_list ul li a{
        display: block;
        text-decoration: none;
        padding: 2px 11px 2px 9px;
    }
    .drop_list ul li a:hover,
    .drop_list ul li.current a{
        background: #F8F8F8;
    }
    /*
    ================================================================================
    |                                CATALOG TABLE	                              |
    ================================================================================
    */
    .catalog_table,
    .dealer_catalog{
        padding: 0 0 0 0;
    }
    .catalog_table li,
    .dealer_catalog li{
        display: block;
        padding: 20px 0;
        border-bottom: 1px solid #D1D5DC;
        overflow: hidden;
        background: none;
    }
    .catalog_table li a.thumb,
    .dealer_catalog li a.thumb{
        display: block;
        width: 165px;
        float: left;
        height: 119px;
        margin: 0 24px 0 0;
    }
    .catalog_table li .catalog_desc{
        padding: 0 0 0 0px;
        width: 491px;
        float: left;
    }
    .catalog_table li .location,
    .dealer_catalog li .location{
        float: right;
        color: #798FA1;
        line-height: 20px;
        padding: 2px 0 0 0;
    }
    .catalog_table li .title_box,
    .dealer_catalog li .title_box{
        float: left;
        color: #798FA1;
        line-height: 20px;
        padding: 0px 0 11px 0;
    }
    .catalog_table li .title_box h4,
    .dealer_catalog li .title_box h4{
        padding-bottom: 7px
    }
    .catalog_table li .title_box h4 a,
    .dealer_catalog li .title_box h4 a{
        line-height: 20px;
    }
    .catalog_table li .title_box .price,
    .dealer_catalog li .title_box .price{
        font-size: 16px;
        line-height: 20px;
        font-weight: bold;
        font-family: 'PTSansBold',Arial,sans-serif;
        color: #F89D13;
    }
    .catalog_table li .grey_area,
    .dealer_catalog li .grey_area{
        color: #798FA1;
        margin: 0 0 10px 0;
    }
    .catalog_table li .grey_area span,
    .dealer_catalog li .grey_area span{
        padding:0 15px 0 0;
    }
    .catalog_table li a.more,
    .dealer_catalog li a.more{
        text-decoration: none;
        color: #798FA1;
        line-height: 18px;
    }
    .catalog_table li a.more:hover,
    .dealer_catalog li a.more:hover{
        text-decoration: underline;
    }
    /*
    ================================================================================
    |                                CATALOG LIST	                              |
    ================================================================================
    */
    .catalog_list{
        padding-top: 20px;
        overflow: hidden;
        border-bottom: 1px solid #D1D5DC;
    }
    .catalog_list li{
        float: left;
        margin-right: 20px;
        margin-bottom: 20px;
        position:relative;
        width: 213px;
        height: 164px;
        border:0;
        background: none;
        padding: 0;
    }
    .catalog_list li.last{
        margin-right: 0px;
    }
    .catalog_list li a{
        cursor: pointer;
        width: 213px;
        height: 164px;
        display: block;
    }
    .catalog_list li .description{
        position: absolute;
        bottom:0;
        left:0;
        width: 184px;
        height: 144px;
        padding: 10px 14px 10px 15px;
        font-family: 'PTSansRegular';
        font-size: 13px;
        line-height: 21px;
        color: #FFFFFF;
        overflow: hidden;
        z-index: 2;
        opacity: 0;

    }
    .catalog_list li:hover .description{
        transition-property: opacity;
        transition-duration: 0.2s;
        opacity: 1;
    }
    .catalog_list li img{
        position:absolute;
        top:0;
        left:0;
        z-index: 1;
        width: 213px;
        height: 164px;
    }
    .catalog_list li .title{
        position: absolute;
        bottom:0;
        left:0;
        width: 184px;
        padding: 7px 14px 10px 15px;
        font-family: 'PTSansBold';
        font-size: 13px;
        line-height: 20px;
        color: #FFFFFF;
        overflow: hidden;
        z-index: 3;

    }
    .catalog_list li .title span.price{
        float: right;
        letter-spacing: 0.5px;
        color: #FFB01F;
        font-family: 'PTSansRegular',Arial,sans-serif;
        font-weight:normal;
        text-shadow:0 0 0 #FFB01F;
    }

    /*
    ================================================================================
    |                                     FOOTER                                   |
    ================================================================================
    */
    #footer{
        min-width:980px;
        width: 100%;
        margin: 0 auto;
        text-align:left;
        background: url(bg_footer.jpg) repeat center 0;
        border-top:1px solid #D1D6DF;
    }
    .bg_top_footer{
        background: url(bg_footer_top.jpg) repeat center 0;
        min-width:980px;
        width: 100%;
        margin: 0 auto;
    }
    .top_footer{
        width:940px;
        padding: 29px 20px 35px;
        margin: 0 auto;
        overflow: hidden;
    }
    .top_footer p{
        font-size: 12px;
        color: #607586;
        line-height: 20px;
    }
    .top_footer h3{
        padding-bottom: 25px;
    }
    .top_footer .f_widget{
        float: left;
        width: 220px;
        padding: 0 20px 0 0;
    }
    .top_footer .fwidget_separator{
        display: none;
    }
    .top_footer .f_widget.last{
        margin:0;
    }
    .schedule{
        padding: 1px 0 0;
    }
    .schedule li{
        border-bottom:1px dashed #CED3D8;
        line-height: 18px;
        padding: 2px 5px 4px 5px;
        overflow: hidden;
        color: #607586;
        background: none;
        font-size: 12px;
    }
    .schedule li strong{
        color: #293848;
        float: left;
    }
    .schedule li span{
        float: right;
    }
    #footer a.footer_logo{
        font-family: 'PTSansBold',Arial,sans-serif;
        font-size: 38px;
        color: #8F98A2;
        line-height: 50px;
        font-weight: bold;
        text-decoration: none;
        margin: 0 0 13px;
        display: block;
    }

    .bottom_footer{
        margin: 0 auto;
        padding: 29px 20px 39px;
        overflow: hidden;
        width: 940px;
    }
    .bottom_footer .f_widget{
        float: left;
        width: 220px;
        padding: 0 20px 0 0;
    }
    .bottom_footer .f_widget.last{
        padding-right: 0;
    }
    .bottom_footer h3{

        color: #FFFFFF;
        padding-bottom: 11px;
        margin-bottom: 14px;
    }
    .bottom_footer .f_widget ul li{

        padding:0 0 7px 10px;
        border:0;
    }
    .bottom_footer .f_widget ul li,
    .bottom_footer .f_widget ul li a{
        color: #A9B5BD;
        font-size: 12px;
        line-height: 18px;
        text-decoration: none;
    }
    .bottom_footer .f_widget ul li a:hover{
        text-decoration: underline;
    }
    .bottom_footer .f_widget ul.horizontal{
        padding: 6px 0;
    }
    .bottom_footer .f_widget ul.horizontal li{
        display: inline-block;
        padding: 0 2px 2px 0;
        background: none;
    }
    #footer .frame_wrapper{
        padding: 7px 0 0;
    }
    #footer .frame_wrapper iframe{
        border:1px solid #CFD3DC;
        background: #FFFFFF;
        padding: 7px;
    }
    .copyright_wrapper{
        width: 100%;

        min-width: 940px;
        margin: 0 auto;
    }
    .copyright{
        width: 940px;
        margin: 0 auto;
        overflow: hidden;
        padding: 19px 20px 21px;
        font-size: 13px;
        color: #A9B5BD;
        line-height: 20px;
    }

</style>