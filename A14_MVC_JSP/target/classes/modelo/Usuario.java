package modelo;

public class Usuario {

	private Long id_usuario;
	private String nombre;
	private String apellido;
	private String usuario;
	private String contrasena;
	private String pais;
	private String tecnologia;
	
	
	public Usuario() {
		this.id_usuario = null;
		this.nombre = "";
		this.apellido = "";
		this.usuario = "";
		this.contrasena = "";
		this.pais = "";
		this.tecnologia = "";
	}
	
	public Usuario(String nombre, String apellido, String usuario, String contrasena, String pais,
			String tecnologia) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.pais = pais;
		this.tecnologia = tecnologia;
	}
	
	public Usuario(String usuario, String contrasena) {
		this.usuario = usuario;
		this.contrasena = contrasena;
	}
	
	public Usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getTecnologia() {
		return tecnologia;
	}
	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", nombre=" + nombre + ", apellido=" + apellido + ", usuario="
				+ usuario + ", contrasena=" + contrasena + ", pais=" + pais + ", tecnologia=" + tecnologia + "]";
	}
	
	
	
}
