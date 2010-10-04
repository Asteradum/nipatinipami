package iso3.pt.model;

import java.util.*;

public class Direccion {
	private Integer id; 
	private String desc;
	private int cp;
		
	private Set<Empleado> empleados;
	
	protected Direccion(){
	}

	public Direccion(String desc, int cp) {
		super();
		this.desc = desc;
		this.cp = cp;
		empleados = new HashSet<Empleado>();
	}

	public Integer getId() {
		return id;
	}

	protected void setId(Integer id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public Set<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Set<Empleado> empleados) {
		this.empleados = empleados;
	}
	
	public void addEmpleado(Empleado empleado){
		this.empleados.add(empleado);
	}
	
	public void removeEmpleado(Empleado empleado){
		this.empleados.remove(empleado);
	}
	
	public String toString(){
		return "(" + this.id + "|" + this.desc + "|" + this.cp + ")";
	}
}
