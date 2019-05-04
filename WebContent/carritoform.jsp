<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<link href="content/css/bootstrap.min.css" rel="stylesheet">
<body>
<div class="container">
<form id="formSuper" action="listasuper"  role="form" method="post">
	<div class="form-group">
		<label for="inputArticulo">Articulo:</label>
		<input id ="inputArticulo" name="inputArticulo" placeholder="Sabriton " type ="text" class="form-control" >
	</div>
	<div class="form-group">
		<label for="inputCantidad">Cantidad:</label>
		<input id ="inputCantidad" name="inputCantidad" placeholder= "1" type ="number" min=0 class="form-control" >
	</div>
	<div class="form-group">
		<label for="inputTipo">Tipo:</label>
		<select id ="inputTipo" name="inputTipo" class="form-control" >
			<option>Botanas</option>
			<option>Caramelos</option>
			<option>Galleta</option>
			<option>Jugos</option>
			
		</select>
	</div>
	<input type="submit" value="Enviar" class="btn btn-default">
</form>
<div id="salida"></div>
</div>
<script type="text/javascript" src="content/js/jquery.js"></script>
<script type="text/javascript" src="content/js/bootstrap.js"></script>
</body>
</html>