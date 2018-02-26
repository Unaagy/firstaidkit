<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<jsp:useBean id="drug_bean" type="ru.myproject.firstaidkit.beans.DrugBean" scope="request"/>--%>

<html>
<head>
    <title>Edit a drug</title>

    <h1>Edit a drug</h1>

    <form action="/editDrug" method="post">
        <p>Drug ID:</p>
        <p><input type="text" name="id" value="${drug_bean.drug.id}" readonly style="background-color: gray"></p>
        <p>Drug name*:</p>
        <p><input type="text" name="drugName" value="${drug_bean.drug.drugName}"></p>
        <p>Active substance:</p>
        <p><input type="text" name="activeSubstance" value="${drug_bean.drug.activeSubstance}"></p>
        <p>Registration number:</p>
        <p><input type="text" name="registrationNumber" value="${drug_bean.drug.registrationNumber}"></p>
        <p><input type="submit" value="edit a drug"></p>
        <p></p>
        <p>* required fields</p>
    </form>

</head>
<body>

</body>
</html>
