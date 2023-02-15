package DAO;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;

import modelo.Usuario;

public class UsuarioDAO implements DAO<Usuario> {

	private static final String SQL_INSERT = "INSERT INTO USUARIOS (nombre, apellidos, usuario, contrasena, pais, tecnologia) VALUES (?,?,?,?,?,?)";
	private static final String SQL_DELETE = "DELETE FROM USUARIOS WHERE id_usuario=?";
	private static final String SQL_UPDATE = "INSERT INTO USUARIOS (nombre, apellidos, usuario, contrasena, pais, tecnologia) VALUES (?,?,?,?,?,?)";
	private static final String SQL_READ = "SELECT * FROM USUARIOS WHERE id_usuario=?";
	private static final String SQL_LOGIN = "SELECT * FROM USUARIOS WHERE usuario=? AND contrasena=?";
	private static final String SQL_READALL = "SELECT * FROM USUARIOS";

	private DataSource origenDatos;

	public UsuarioDAO(DataSource origenDatos) {
		this.origenDatos = origenDatos;
	}

	@Override
	public boolean create(Usuario c) throws SQLException {
		//COMANDO
		PreparedStatement ps=null;
		//LO QUE DEVULVE EL COMANDO
		ResultSet rs=null;
		//CONEXION
		Connection con=null;
		
		try {
			//NOS CONECTAMOS
			con=origenDatos.getConnection();
			//GUARDA EL COMANDO
			ps=con.prepareStatement(SQL_INSERT,Statement.RETURN_GENERATED_KEYS);
			
			//PASAR VARIABLES
			ps.setNString(1, c.getNombre());
			ps.setNString(2, c.getApellido());
			ps.setNString(3, c.getUsuario());
			ps.setNString(4, c.getContrasena());
			ps.setNString(5, c.getPais());
			ps.setNString(6, c.getTecnologia());
			
			//EJECUTAMOS EL COMANDO Y SI ES MAYOR A 0 (ES DECIR QUE HA FUNCIONADO, HACEMOS LAS COSAS PARA EL ID_USUARIO)
			if (ps.executeUpdate()>0) {
				rs=ps.getGeneratedKeys();
				if(rs.next()) {
					c.setId_usuario(rs.getLong(1));
				}
				return true;
			}
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return false;
		
	}
	
	public boolean login(Usuario c) throws SQLException {
		//COMANDO
		PreparedStatement ps=null;
		//LO QUE DEVULVE EL COMANDO
		ResultSet rs=null;
		//CONEXION
		Connection con=null;
		
		try {
			//NOS CONECTAMOS
			con=origenDatos.getConnection();
			//GUARDA EL COMANDO
			ps=con.prepareStatement(SQL_LOGIN,Statement.RETURN_GENERATED_KEYS);
			
			//PASAR VARIABLES
			ps.setNString(1, c.getUsuario());
			ps.setNString(2, c.getContrasena());
			rs = ps.executeQuery();
			
			int total = 0;
			while (rs.next()){
			   //Obtienes la data que necesitas...
			   total++;
			}
			if (total>0) {
				return true;
			}
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return false;
		
	}
	
	public Usuario buscar(Usuario u) throws SQLException {
		//COMANDO
		PreparedStatement ps=null;
		//LO QUE DEVULVE EL COMANDO
		ResultSet rs=null;
		//CONEXION
		Connection con=null;
		Usuario usu = new Usuario();
		try {
			//NOS CONECTAMOS
			con=origenDatos.getConnection();
			//GUARDA EL COMANDO
			ps=con.prepareStatement(SQL_READ,Statement.RETURN_GENERATED_KEYS);
			
			//PASAR VARIABLES
			ps.setLong(1, u.getId_usuario());
			rs = ps.executeQuery();
			
			int total = 0;
			while (rs.next())
	         {
	            
	            usu.setId_usuario(rs.getLong("id_usuario"));
	            usu.setNombre(rs.getString("nombre"));
	            usu.setApellido(rs.getString("apellidos"));
	            usu.setPais(rs.getString("pais"));
	            usu.setTecnologia(rs.getString("tecnologia"));
	            usu.setUsuario(rs.getString("usuario"));
	            usu.setContrasena(rs.getString("contrasena"));
	         }
			return usu;
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
	}

}
