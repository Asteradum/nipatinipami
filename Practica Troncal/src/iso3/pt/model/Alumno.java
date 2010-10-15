package iso3.pt.model;

import java.util.ArrayList;
import java.util.List;


public class Alumno {
	
	private Integer dni;
	private String password;
	private String nombre;
	private String telefono;
	private List<Asignatura> asignaturas = new ArrayList<Asignatura>();
	
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

	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}
	
	public void addAsignatura(Asignatura a)
	{
		asignaturas.add(a);
	}
	
	public void removeAsignatura(Asignatura a)
	{
		asignaturas.remove(a);
	}

}
