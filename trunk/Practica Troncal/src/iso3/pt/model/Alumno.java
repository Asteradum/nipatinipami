package iso3.pt.model;
//lalalalolo
public class Alumno {
	
	private Integer dni;
	private String password;
	private String nombre;
	private String telefono;
	
	public Alumno() {
		super();
	}

	public Alumno(Integer dni, String password, String nombre, String telefono) {
		super();
		this.dni = dni;
		this.password = password;
		this.nombre = nombre;
		this.telefono = telefono;
	}
	
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	

}
