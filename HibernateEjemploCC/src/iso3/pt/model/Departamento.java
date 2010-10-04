package iso3.pt.model;

import java.util.HashSet;
import java.util.Set;

public class Departamento {
	private Integer id;
	private String nombre;
	
	private Set<Empleado> empleados;
	
	protected Departamento(){
	}
	
	public Departamento(String nombre) {
		super();
		this.nombre = nombre;
		empleados = new HashSet<Empleado>();

	}
	public Integer getId() {
		return id;
	}
	
	protected void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Set<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Set<Empleado> empleados) {
		this.empleados = empleados;
	}
	
	public void addEmpleado(Empleado empleado){
		empleados.add(empleado);
	}
	
	public void removeEmpleado(Empleado empleado){
		empleados.remove(empleado);
	}

	public String toString(){
		return "(" + this.id + "|" + this.nombre + ")";
	}
}
