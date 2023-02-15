<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="controlador.control_Usuario.*"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Usuario</title>
</head>
<body>
	<h1>Login de Usuario</h1>
	<form action="../Controlador_LoginUsuario" method="get">

		<table>
			<tr>
				<td>Usuario:</td>
				<td><input type="text" name="txtUsuario" /></td>
			</tr>
			<tr>
				<td>Contraseña:</td>
				<td><input type="text" name="txtContrasena" /></td>
			</tr>
		</table>
		<input type="submit" name="boton" value="Enviar" />
	</form>

</body>
</html>