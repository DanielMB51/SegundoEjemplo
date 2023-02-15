package clase.com.servlet;

import java.io.*;
import java.sql.*;


import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/ServletPrueba")
public class ServletPrueba extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name="jdbc/MVC_JSP")
	private DataSource miPool;
	
    public ServletPrueba() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter salida=response.getWriter();
		response.setContentType("text/plain");
		
		Connection miConexion=null;
		ResultSet miR=null;
		try {
			miConexion=miPool.getConnection();
			miR=miConexion.createStatement().executeQuery("SELECT * FROM PRODUCTOS");
			while(miR.next()) {
				salida.println(miR.getNString(3));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
