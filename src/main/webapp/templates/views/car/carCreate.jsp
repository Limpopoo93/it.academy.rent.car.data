<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="login-page">
    <div class="form">
        <%--@elvariable id="car" type="it.academy.rent.bean.Car"--%>
        <form:form class="register-form" action="${pageContext.request.contextPath}/createCar"
                   modelAttribute="car" method="post">

            <form:errors path="nameCar" cssStyle="color: red"/>
            <form:input path="nameCar" type="text" placeholder="nameCar"/>

            <form:errors path="typeFuel" cssStyle="color: red"/>
            <form:input path="typeFuel" type="text" placeholder="typeFuel"/>

            <form:errors path="colDoors" cssStyle="color: red"/>
            <form:input path="colDoors" type="text" placeholder="colDoors"/>

            <form:errors path="colPeople" cssStyle="color: red"/>
            <form:input path="colPeople" type="text" placeholder="colPeople"/>

            <form:errors path="mileage" cssStyle="color: red"/>
            <form:input path="mileage" type="text" placeholder="mileage"/>

            <form:errors path="makeCar" cssStyle="color: red"/>
            <form:input path="makeCar" type="text" placeholder="makeCar"/>

            <form:errors path="typeCar" cssStyle="color: red"/>
            <form:input path="typeCar" type="text" placeholder="typeCar"/>

            <form:errors path="company.nameCompany" cssStyle="color: red"/>
            <form:input path="company.nameCompany" type="text" placeholder="nameCompany"/>

            <form:errors path="priceCar" cssStyle="color: red"/>
            <form:input path="priceCar" type="text" placeholder="priceCar"/>

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
            <button>Registration</button>
        </form:form>
    </div>
</div>
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