package iso3.pt.action;



import iso3.pt.model.Alumno;
import iso3.pt.model.Asignatura;
import iso3.pt.model.Evaluacion;
import iso3.pt.service.PtDaoService;

import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class StudentSubjectMarkAction extends ActionSupport implements Preparable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PtDaoService dao = new PtDaoService();
	private Map session = null;
	private String nota;//textBox
	private String concepto;//textBox
	private int dni;
	private int asignatura;
	private Alumno al;
	private Asignatura asig;
	private Set<Evaluacion> evaluaciones;	
	
	public String getNota() {
		return nota;
	}


	public void setNota(String nota) {
		this.nota = nota;
	}


	public String getConcepto() {
		return concepto;
	}


	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}


	public int getDni() {
		return dni;
	}


	public void setDni(int dni) {
		this.dni = dni;
	}


	public int getAsignatura() {
		return asignatura;
	}


	public void setAsignatura(int asignatura) {
		this.asignatura = asignatura;
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


	public Set<Evaluacion> getEvaluaciones() {
		return evaluaciones;
	}


	public void setEvaluaciones(Set<Evaluacion> evaluaciones) {
		this.evaluaciones = evaluaciones;
	}


	
	
	
	public String notas(){
		System.out.println("ha entrado en la clase");
		 int not=Integer.parseInt(nota);
			session = ActionContext.getContext().getSession();
			al=dao.getAlumno(dni);
			asig=dao.getAsignatura(asignatura);
			if (getConcepto().equals("")) 
					return "error";
				else if (not>10 || not<0)
					return "error";		
		   dao.addEvaluacion(getConcepto(),not,asignatura,dni);		
		   evaluaciones = dao.getEvaluaciones(asignatura, dni);		
		   return "success";
	 }


	@Override
	public void prepare() throws Exception {
		
	}
}
