<%--
  Created by IntelliJ IDEA.
  User: madgn
  Date: 02.03.2018
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit storing place</title>
</head>
<body>
<h1>Add new storing place</h1>

<form action="/editStoringPlace" method="post">
    <p>Place ID:</p>
    <p><input type="text" name="id" value="${place_bean.storingPlace.id}" readonly style="background-color: gray"></p>
    <p>Storing place name*:</p>
    <p><input type="text" name="storingPlaceName"></p>
    <p><input type="submit" value="edit storing place"></p>
    <p></p>
    <p>* required field</p>
</form>
</body>
</html>
