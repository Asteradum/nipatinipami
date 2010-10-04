package iso3.pt.model;

public class Profesor {
	public Profesor(Integer id, Integer dNI, String password, String nombre,
			String telefono, String email, String despacho) {
		super();
		this.id = id;
		dni = dNI;
		this.password = password;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.despacho = despacho;
	}
	public Profesor() {
		super();
	}
	private Integer id;
	private Integer dni;
	private String password;
	private String nombre;
	private String telefono;
	private String email;
	private String despacho;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDNI() {
		return dni;
	}
	public void setDNI(Integer dNI) {
		dni = dNI;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDespacho() {
		return despacho;
	}
	public void setDespacho(String despacho) {
		this.despacho = despacho;
	}

}
