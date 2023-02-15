package controlador.control_Usuario;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import DAO.UsuarioDAO;
import modelo.Usuario;

@WebServlet("/Controlador_InsertarUsuario")
public class Controlador_InsertarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name="jdbc/MVC_JSP")
	private DataSource miPool;
	
	private UsuarioDAO usuarioDAO;
	
    public Controlador_InsertarUsuario() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//RECIBO LOS PARAMETROS DEL FORMULARIO
		try {
			usuarioDAO=new UsuarioDAO(miPool);
		}catch(Exception e) {
			throw new ServletException();
		}
		
		//RECOGER LOS DATOS DEL REQUEST DEL FORMULARIO
		request.setCharacterEncoding("UTF-8");
		String nombre=request.getParameter("txtNombre");
		String apellidos=request.getParameter("txtApellidos");
		String usuario=request.getParameter("txtUsuario");
		String contrasena=request.getParameter("txtContrasena");
		String pais=request.getParameter("txtPais");
		String tecno=request.getParameter("txtTecnologia");
		
		//VALIDO EN EL SERVIDOR LOS DATOS
		
		if(nombre!="" && apellidos!="" && usuario!="" && contrasena!="") {
			Usuario u =new Usuario(nombre, apellidos, usuario, contrasena, pais, tecno);
			
			try {
				if(usuarioDAO.create(u)) {
					request.getRequestDispatcher("vistasUsuario/exito.jsp").forward(request, response);
				}
			}catch(SQLException e) {
				request.getRequestDispatcher("vistasUsuario/error.jsp").forward(request, response);
			}
		}else {
			request.getRequestDispatcher("vistasUsuario/error.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
