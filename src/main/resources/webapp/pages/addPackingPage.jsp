<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<jsp:useBean id="drug_bean" type="ru.myproject.firstaidkit.beans.DrugBean" scope="application"/>--%>

<html>
<head>
    <title>Add new packing</title>

    <h1>Add new packing</h1>

    <form action="/addPacking" method="post">
        <p>Drug name*:</p>
        <p><input type="text" name="drug"></p>
        <p>Manufacturer:</p>
        <p><input type="text" name="manufacturer"></p>
        <p>Amount:</p>
        <p><input type="text" name="amount" value="0"></p>
        <p>Dosage:</p>
        <p><input type="text" name="dosage" value="0"></p>
        <p>Expiration date*:</p>
        <p><input type="date" name="expirationDate"></p>
        <p>Storing place name*:</p>
        <p><input type="text" name="storingPlaceName"></p>

        <p><input type="submit" value="add new packing"></p>
        <p></p>
        <p>* required field</p>
    </form>

</head>
<body>

</body>
</html>
