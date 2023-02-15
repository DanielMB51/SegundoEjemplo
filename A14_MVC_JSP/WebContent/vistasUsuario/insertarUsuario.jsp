<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="controlador.control_Usuario.*"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insertar Usuario</title>
</head>
<body>
	<h1>Registro de Usuario</h1>
	<form action="../Controlador_InsertarUsuario" method="get">

		<table>
			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="txtNombre" /></td>
			</tr>
			<tr>
				<td>Apellidos:</td>
				<td><input type="text" name="txtApellidos" /></td>
			</tr>
			<tr>
				<td>Usuario:</td>
				<td><input type="text" name="txtUsuario" /></td>
			</tr>
			<tr>
				<td>Contraseña:</td>
				<td><input type="text" name="txtContrasena" /></td>
			</tr>
			<tr>
				<td>País:</td>
				<td><input type="text" name="txtPais" /></td>
			</tr>
			<tr>
				<td>Tecnología:</td>
				<td><input type="text" name="txtTecnologia" /></td>
			</tr>

		</table>
		<input type="submit" name="boton" value="Enviar" />
	</form>

</body>
</html>