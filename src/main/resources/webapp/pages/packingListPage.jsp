<!-- Эту сттроку можно закомментить -->
<%--<jsp:useBean id="drugs_bean" type="ru.myproject.firstaidkit.beans.DrugBean" scope="request"/>--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<DOCTYPE html>
    <html>
    <body>

    <h1>Packing List</h1>

    <a href="<c:url value="/drugs"/>">Drugs </a>
    <br/>
    <a href="<c:url value="/storingPlaceList"/>">Storing places </a>
    <br/>
    <a href="pages/addPackingPage.jsp">Add new packing</a>
    <br/>
    <br/>

    <table border="1">
        <tr>
            <th width="50">id</th>
            <th width="100">Drug name</th>
            <th width="200">Manufacturer</th>
            <th width="100">Amount</th>
            <th width="100">Dosage</th>
            <th width="150">Expiration date</th>
            <%--<th width="200">Storing place</th>--%>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${requestScope['packings_bean'].packings}" var="packing">
        <tr>
            <td align="center">${packing.id}</td>
            <td>${packing.drug.drugName}</td>
            <td>${packing.manufacturer}</td>
            <td>${packing.amount}</td>
            <td>${packing.dosage}</td>
            <td>${packing.expirationDate}</td>
            <%--<td>${packing.storingPlaces}</td>--%>
            <td align="center"><a href="<c:url value="/editPacking/${packing.id}"/>">Edit</a></td>
            <td align="center"><a href="<c:url value="/deletePacking/${packing.id}"/>">Delete</a></td>
        <tr>
            </c:forEach>
    </table>


    </body>
    </html>
</DOCTYPE>