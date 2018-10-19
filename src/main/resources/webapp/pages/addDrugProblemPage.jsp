<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Adding drug problem</title>
    <link rel="stylesheet" type="text/css" href="webapp/pages/css/DrugProblemStyle.css" /> <!-- подключение внешней таблицы стилей -->
    		<link href="https://fonts.googleapis.com/css?family=Josefin+Slab|Montserrat:300,500i" rel="stylesheet"> <!-- ссылка на шрифт Josefin -->
    		<link href="https://fonts.googleapis.com/css?family=Arvo" rel="stylesheet"> <!-- ссылка на шрифт Arvo -->
    		<style type="text/css">
    			body {
    				background: #ffffff url("zombie1.jpg") no-repeat center center; /* Вставка фона, на белом фоне, без повторения картинки, по центру страницы*/
    				background-attachment: scroll; /*прокручивается вместе с текстом*/
    				background-size: 50%; /*размеры фоновой картинки по ширине, по высоте выстроится пропорционально*/
    				overflow: scroll; /* Добавляем полосы прокрутки, если все не помещается на экран */
    				text-align: left; /*текст выровнен по левому краю*/
    			}
    		</style>

</head>
<body>
<section>
		<p>
			<h1>Oops!!!</h1>
		</p>

		<div id="text">
		<p>There is a problem with a creation of a new drug!</p>
		<p>Maybe it already exists</p>
		</div>
		<div class="return">
			<p><a href="<c:url value = "/"/>">Return to a drugs list</a></p>
		</div>
		<div class="empty">
				<p> </p>
			</div>
	</section>
</body>
</html>