
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add storing place</title>
</head>
<body>

<h1>Add new storing place</h1>

<form action="/addStoringPlace" method="post">
    <p>Storing place name*:</p>
    <p><input type="text" name="storingPlaceName"></p>
    <p><input type="submit" value="add new storing place"></p>
    <p></p>
    <p>* required field</p>
</form>

</body>
</html>
