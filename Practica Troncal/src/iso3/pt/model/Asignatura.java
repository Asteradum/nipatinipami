package iso3.pt.model;

import java.util.ArrayList;
import java.util.List;

public class Asignatura {
	public Asignatura() {
		super();
	}
	public Asignatura(Integer code, String nombre, float creditos) {
		super();
		this.code = code;
		this.nombre = nombre;
		this.creditos = creditos;
	}
	private Integer id;
	private Integer code;
	private String nombre;
	private float creditos;
	
	private List<Unidad> unidades = new ArrayList<Unidad>();
	private Profesor profesor;
	private List<Alumno> alumnos = new ArrayList<Alumno>();
	
	boolean estaMatriculado(Alumno al)
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
	public void setUnidades(List<Unidad> unidades) {
		this.unidades = unidades;
	}
	public List<Unidad> getUnidades() {
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
	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	public List<Alumno> getAlumnos() {
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
