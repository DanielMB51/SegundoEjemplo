package controlador.control_Usuario;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import DAO.UsuarioDAO;
import modelo.Usuario;

@WebServlet("/Controlador_BuscarUsuario")
public class Controlador_BuscarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/MVC_JSP")
	private DataSource miPool;

	private UsuarioDAO usuarioDAO;

	public Controlador_BuscarUsuario() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// RECIBO LOS PARAMETROS DEL FORMULARIO
		try {
			usuarioDAO = new UsuarioDAO(miPool);
		} catch (Exception e) {
			throw new ServletException();
		}
		try {
			// RECOGER LOS DATOS DEL REQUEST DEL FORMULARIO
			request.setCharacterEncoding("UTF-8");

			Long id_usuario = Long.parseLong(request.getParameter("txtIDUSUARIO"));
			// VALIDO EN EL SERVIDOR LOS DATOS

			try {

				if (id_usuario != null) {
					Usuario u = new Usuario(id_usuario);
					
					Usuario mostrar=usuarioDAO.buscar(u);
					if (mostrar!=null) {
						request.setAttribute("usuario", mostrar);
						RequestDispatcher miDispatcher=request.getRequestDispatcher("vistasUsuario/mostrarUsuario.jsp");
						miDispatcher.forward(request, response);
						request.getRequestDispatcher("vistasUsuario/exito.jsp").forward(request, response);
						request.getRequestDispatcher("vistasUsuario/mostrarUsuario.jsp").forward(request, response);
					} else {
						request.getRequestDispatcher("vistasUsuario/error.jsp").forward(request, response);
					}
				}
			} catch (SQLException e) {
				request.getRequestDispatcher("vistasUsuario/error.jsp").forward(request, response);
			}
		} catch (NumberFormatException e) {
			request.getRequestDispatcher("vistasUsuario/error.jsp").forward(request, response);
		} catch (Exception e) {
			request.getRequestDispatcher("vistasUsuario/error.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
