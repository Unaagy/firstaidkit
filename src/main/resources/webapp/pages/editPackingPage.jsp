<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<jsp:useBean id="drug_bean" type="ru.myproject.firstaidkit.beans.DrugBean" scope="application"/>--%>

<html>
<head>
    <title>Add new packing</title>

    <h1>Add new packing</h1>

    <form action="/editPacking" method="post">
        <p>Packing ID:</p>
        <p><input type="text" name="id" value="${packing_bean.packing.id}" readonly style="background-color: gray"></p>
        <p>Drug name*:</p>
        <p><input type="text" name="drug" value="${packing_bean.packing.drug.drugName}"></p>
        <p>Manufacturer:</p>
        <p><input type="text" name="manufacturer" value="${packing_bean.packing.manufacturer}"></p>
        <p>Amount:</p>
        <p><input type="text" name="amount" value="0" value="${packing_bean.packing.amount}"></p>
        <p>Dosage:</p>
        <p><input type="text" name="dosage" value="0" value="${packing_bean.packing.dosage}"></p>
        <p>Expiration date*:</p>
        <p><input type="date" name="expirationDate" value="${packing_bean.packing.expirationDate}"></p>
        <p>Storing place name*:</p>
        <p><input type="text" name="storingPlaceName" value="${packing_bean.packing.storingPlace.storingPlaceName}"></p>

        <p><input type="submit" value="edit packing"></p>
        <p></p>
        <p>* required field</p>
    </form>

</head>
<body>

</body>
</html>
