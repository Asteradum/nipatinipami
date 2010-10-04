package iso3.pt.model;

public class Asignatura {
	public Asignatura() {
		super();
	}
	public Asignatura(Integer id, Integer code, String nombre, float creditos) {
		super();
		this.id = id;
		this.code = code;
		this.nombre = nombre;
		this.creditos = creditos;
	}
	private Integer id;
	private Integer code;
	private String nombre;
	private float creditos;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getCreditos() {
		return creditos;
	}
	public void setCreditos(float creditos) {
		this.creditos = creditos;
	}
	

}
