<!-- Эту сттроку можно закомментить -->
<%--<jsp:useBean id="drug_bean" type="ru.myproject.firstaidkit.beans.DrugBean" scope="request"/>--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<DOCTYPE html>
    <html>
    <body>

    <h1>Drugs List</h1>

    <table border="1">
        <tr>
            <th width="50">id</th>
            <th width="100">Name</th>
            <th width="200">Active substance</th>
            <th width="100">Number</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${requestScope['drug_bean'].drugs}" var="drug">
        <tr>
            <td align="center">${drug.id}</td>
            <td>${drug.drugName}</td>
            <td>${drug.activeSubstance}</td>
            <td>${drug.registrationNumber}</td>
            <td align="center">Edit</td>
            <td align="center">Delete</td>
        <tr>
            </c:forEach>
    </table>

    <p></p>
    <a href="pages/addDrugPage.jsp">Add new drug</a>

    <%--<p>--%>
    <%--<a href="addPart.jsp">Add part</a>--%>
    <%--</p>--%>

    </body>
    </html>
</DOCTYPE>