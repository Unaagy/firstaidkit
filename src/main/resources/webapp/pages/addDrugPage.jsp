<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<jsp:useBean id="drug_bean" type="ru.myproject.firstaidkit.beans.DrugBean" scope="application"/>--%>

<html>
<head>
    <title>Add new drug</title>

    <h1>Add new drug</h1>

    <form action="/addDrugPage" method="post">
        <p>Drug name*:</p>
        <p><input type="text" name="drugName"></p>
        <p>Active substance:</p>
        <p><input type="text" name="activeSubstance"></p>
        <p>Registration number:</p>
        <p><input type="text" name="registrationNumber"></p>
        <p><input type="submit" value="add new drug"></p>
        <p></p>
        <p>* required fields</p>
    </form>

</head>
<body>

</body>
</html>
