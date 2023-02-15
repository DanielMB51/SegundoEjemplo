package DAO;

import java.sql.SQLException;

import modelo.Usuario;

public interface DAO <T>{
	
	/*Se usa esta interface genérica para que todos los programadores empleen los mismos
	Declaro los metodos que se van a usar para acceder a la base de datos
	CRUD create-read-update-delete
	*/

	//Inserta un nuevo registro c de tipo genérico T
	public boolean create (T c) throws SQLException;
	
	public boolean login (T c) throws SQLException;
	
	public Usuario buscar (T c) throws SQLException;

	




}
