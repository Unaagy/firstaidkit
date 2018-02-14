<jsp:useBean id="drug_bean" type="ru.myproject.firstaidkit.beans.DrugBean" scope="request"/> <!-- Эту сттроку можно закомментить -->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<DOCTYPE html>
    <html>
    <body>

    <h1>Drugs List</h1>

    <c:forEach items="${requestScope['drug_bean'].drugs}" var="drug">
        <p>${drug.drugName}</p>
    </c:forEach>

    <%--<p>--%>
    <%--<a href="addPart.jsp">Add part</a>--%>
    <%--</p>--%>

    </body>
    </html>
</DOCTYPE>