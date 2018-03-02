<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<DOCTYPE html>
    <html>
    <head>
        <title>Storing places</title>
    </head>

    <body>

    <h1>Drugs List</h1>

    <a href="pages/addStoringPlacePage.jsp">Add new storing place</a>
    <br/>
    <br/>


    <table border="1">
        <tr>
            <th width="50">id</th>
            <th width="100">Name</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${requestScope['places_bean'].storingPlaces}" var="place">
            <tr>
                <td align="center">${place.id}</td>
                <td>${place.storingPlaceName}</td>
                <td align="center"><a href="<c:url value="/editStoringPlace/${place.id}"/>">Edit</a></td>
                <td align="center"><a href="<c:url value="/deleteStoringPlace/${place.id}"/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>


    </body>
    </html>
</DOCTYPE>