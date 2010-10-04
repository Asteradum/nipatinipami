package iso3.pt.model;

import java.util.*;

public class Empleado {
	private Integer nif;
	private String nombre;
	private String puesto;
	private String email;
	
	private Departamento departamento;
	private Set<Direccion> direcciones;
	
	protected Empleado(){
	}
	
	public Empleado(Integer nif, String nombre, String puesto, String email) {
		super();
		this.nif = nif;
		this.nombre = nombre;
		this.puesto = puesto;
		this.email = email;
		this.direcciones = new HashSet<Direccion>();
	}

	public Integer getNif() {
		return nif;
	}
	
	protected void setNif(Integer nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Set<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(Set<Direccion> direcciones) {
		this.direcciones = direcciones;
	}
	
	public void addDireccion(Direccion direccion){
		this.direcciones.add(direccion);
	}
	
	public void removeDireccion(Direccion direccion){
		this.direcciones.remove(direccion);
	}
	
	public String toString(){
		return "(" + this.nif + "|" + this.nombre + "|" + this.puesto + "|" + this.email + ")";
	}
}
