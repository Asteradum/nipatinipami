package iso3.pt.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Alumno {
	
	private Integer dni;
	private String password;
	private String nombre;
	private String telefono;
	
	private Set<Asignatura> asignaturas; 
	private Set<Evaluacion> evaluaciones;
	
	public Alumno() {
		super();
		evaluaciones = new HashSet<Evaluacion>();
		asignaturas = new HashSet<Asignatura>();
	}

	public Alumno(Integer dni, String password, String nombre, String telefono) {
		super();
		this.dni = dni;
		this.password = password;
		this.nombre = nombre;
		this.telefono = telefono;
		evaluaciones = new HashSet<Evaluacion>();
		asignaturas = new HashSet<Asignatura>();
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

	public void setAsignaturas(Set<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	public Set<Asignatura> getAsignaturas() {
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

	public void setEvaluaciones(Set<Evaluacion> evaluaciones) {
		this.evaluaciones = evaluaciones;
	}

	public Set<Evaluacion> getEvaluaciones() {
		return evaluaciones;
	}
	
	public void addEvaluacion(Evaluacion e)
	{
		evaluaciones.add(e);
	}
	
	public void removeEvaluacion(Evaluacion e)
	{
		evaluaciones.remove(e);
	}

}
