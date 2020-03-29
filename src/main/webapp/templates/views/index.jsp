<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul id="menu">
    <li><a href="${pageContext.request.contextPath}/">Home</a></li>
    <li>
        <a>User</a>
        <ul class="hidden">
            <li><a href="${pageContext.request.contextPath}/adminCreate">Create Admin</a></li>
            <li><a href="${pageContext.request.contextPath}/users">List User</a></li>
            <li><a href="${pageContext.request.contextPath}/letterAdminList">List Letter to Admin</a></li>
            <li><a href="${pageContext.request.contextPath}/userBlockList">List Block User</a></li>
            <li><a href="${pageContext.request.contextPath}/createCreditCard">Create Credit Card</a></li>
            <li><a href="${pageContext.request.contextPath}/countryRegistration">Create Country</a></li>
            <li><a href="${pageContext.request.contextPath}/createCompany">Create Company</a></li>
            <li><a href="${pageContext.request.contextPath}/createCar">Create Car</a></li>
            <li><a href="${pageContext.request.contextPath}/createPrice">Create PriceCar</a></li>
            <li><a href="${pageContext.request.contextPath}/createTown">Create Town</a></li>

            <%--@elvariable id="carSearch" type="it.academy.rent.car.bean.CarSearch"--%>
            <form:form class="register-form" name="address" action="${pageContext.request.contextPath}/searchFormCountry"
                        method="post" modelAttribute="carSearch">
                Country:

                <select name="country" onChange="MkHouseValues(this.selectedIndex)">
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

                &nbsp;Town:
                <select name="town">
                    <option value="N/A">N/A</option>
                </select>
                <form:input path="dateCheck" type="date" value="2017-06-01"/>
                <form:input path="dateReturn" type="date" value="2017-06-01"/>
                <button>Search</button>
            </form:form>



            <li><a href="${pageContext.request.contextPath}/">Select User</a></li>
            <li><a href="${pageContext.request.contextPath}/">Select Car</a></li>
            <li><a href="${pageContext.request.contextPath}/">Select Company</a></li>
            <li><a href="${pageContext.request.contextPath}/">Select Country</a></li>
            <li><a href="${pageContext.request.contextPath}/">Select Town</a></li>

        </uL>
    </li>
<table>
    <tr>
        <th>name</th>
        <th>surname</th>
        <th>email</th>
        <th>age</th>
        <th>login</th>
        <th>password</th>
        <th>role</th>
        <th>profileClose</th>
    </tr>
    <tr>
        <td>
        <td>${sessionScope.authenticate.login}</td>
        <td>
        <td>${sessionScope.authenticate.password}</td>
        <td>
        <td>${sessionScope.authenticate.profileClose}</td>
        <td>
        <td>${sessionScope.authenticate.email}</td>
        <td>
        <td>${sessionScope.authenticate.role}</td>
        <td>
    </tr>
</table>
</ul>
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

</style>