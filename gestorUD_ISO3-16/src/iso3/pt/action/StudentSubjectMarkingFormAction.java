package iso3.pt.action;

import iso3.pt.model.Alumno;
import iso3.pt.model.Asignatura;
import iso3.pt.model.Evaluacion;
import iso3.pt.service.PtDaoService;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class StudentSubjectMarkingFormAction extends ActionSupport implements Preparable {
	private PtDaoService dao = new PtDaoService();
	private Alumno al = null;
	private Asignatura asig=null;
	private Set<Asignatura> listaAsignaturas = null;
	private Map session = null;
	private  String nombreAsig;
	private String nomProf;
	private int dni;
	private int code;
	@Override
	
	
	
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("llega a ki");
		System.out.println(nombreAsig);
		System.out.println(nomProf);
		session = ActionContext.getContext().getSession();
		al=dao.getAlumno(dni);
		System.out.println("alumno recogido"+ al.getNombre());
		asig = dao.getAsignatura(code);
		System.out.println("Asignatura recogido "+ code);
	}
	
	public Alumno getAl() {
		return al;
	}
	public void setAl(Alumno al) {
		this.al = al;
	}
	public Asignatura getAsig() {
		return asig;
	}
	public void setAsig(Asignatura asig) {
		this.asig = asig;
	}
	public Set<Asignatura> getListaAsignaturas() {
		return listaAsignaturas;
	}
	public void setListaAsignaturas(Set<Asignatura> listaAsignaturas) {
		this.listaAsignaturas = listaAsignaturas;
	}
	
	public String getNombreAsig() {
		return nombreAsig;
	}
	public void setNombreAsig(String nombreAsig) {
		this.nombreAsig = nombreAsig;
	}
	public String getNomProf() {
		return nomProf;
	}
	public void setNomProf(String nomProf) {
		this.nomProf = nomProf;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}