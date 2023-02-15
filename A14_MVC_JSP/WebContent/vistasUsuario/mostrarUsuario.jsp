<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EXITO</title>
</head>
<body>
	<h1>EXITO</h1>
	<table border=1>
	<tr>
		<th>ID USUARIO</th>
		<th>NOMBRE</th>
		<th>APELLIDOS</th>
		<th>USUARIO</th>
		<th>CONTRASENA</th>
		<th>PAIS</th>
		<th>TECNOLOGIA</th>
	</tr>
	<tr>
		<td>${usuario.getId_usuario()}</td>
		<td>${usuario.getNombre()}</td>
		<td>${usuario.getApellido()}</td>
		<td>${usuario.getUsuario()}</td>
		<td>${usuario.getContrasena()}</td>
		<td>${usuario.getPais()}</td>
		<td>${usuario.getTecnologia()}</td>
	</tr>
		
	</table>
	<a href="tratarUsuarios.html">Volver...</a>
</body>
</html>