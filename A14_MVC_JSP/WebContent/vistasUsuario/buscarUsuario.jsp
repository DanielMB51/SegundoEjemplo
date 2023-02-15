<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="controlador.control_Usuario.*"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buscar Usuario</title>
</head>
<body>
	<h1>Buscar de Usuario</h1>
	<form action="../Controlador_BuscarUsuario" method="get">

		<table>
			<tr>
				<td>ID del USUARIO:</td>
				<td><input type="text" name="txtIDUSUARIO" /></td>
			</tr>
		</table>
		<input type="submit" name="boton" value="Enviar" />
	</form>

</body>
</html>