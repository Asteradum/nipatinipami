package iso3.pt.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Asignatura {
	public Asignatura() {
		super();
		unidades = new HashSet<Unidad>();
		alumnos = new HashSet<Alumno>();
	}
	public Asignatura(Integer code, String nombre, float creditos) {
		super();
		this.code = code;
		this.nombre = nombre;
		this.creditos = creditos;
		unidades = new HashSet<Unidad>();
		alumnos = new HashSet<Alumno>();
	}
	private Integer id;
	private Integer code;
	private String nombre;
	private float creditos;
	
	private Set<Unidad> unidades;
	private Profesor profesor;
	private Set<Alumno> alumnos;
	
	public boolean estaMatriculado(Alumno al)
	{
		if (alumnos.contains(al))
			return true;
		else
			return false;
	}
	
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
	public void setUnidades(Set<Unidad> unidades) {
		this.unidades = unidades;
	}
	public Set<Unidad> getUnidades() {
		return unidades;
	}
	public void addUnidad(Unidad u)
	{
		unidades.add(u);
	}
	public void removeUnidad(Unidad u)
	{
		unidades.remove(u);
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setAlumnos(Set<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	public Set<Alumno> getAlumnos() {
		return alumnos;
	}
	public void addAlumno(Alumno a)
	{
		alumnos.add(a);
	}
	public void removeAlumno(Alumno a)
	{
		alumnos.remove(a);
	}

}
