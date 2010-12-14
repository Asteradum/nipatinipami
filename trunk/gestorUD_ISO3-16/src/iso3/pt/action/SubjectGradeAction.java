package iso3.pt.action;

import iso3.pt.model.Alumno;
import iso3.pt.model.Asignatura;
import iso3.pt.model.Evaluacion;
import iso3.pt.service.PtDaoService;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class SubjectGradeAction extends ActionSupport implements Preparable {

	private PtDaoService dao = new PtDaoService();
	private int dni;
	private int code;
	private Set<Evaluacion> evaluations = null;
	private Alumno al = null;
	private Asignatura asig = null;
	private Map session = null;
	

	public Set<Evaluacion> getEvaluations() {
		return evaluations;
	}


	public void setEvaluations(Set<Evaluacion> evaluations) {
		this.evaluations = evaluations;
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


	@Override
	public void prepare() throws Exception {
		session = ActionContext.getContext().getSession();
		dni = Integer.parseInt((String) session.get("dni"));
		/*
		 * Tengo que conseguir el code de la asignatura de algun modo.
		 * No funciona el Matricularse en una asignatura.
		 * No funciona el boton de cancelar de ver todas las notas. 
		 */
		code = Integer.parseInt((String) session.get("subject.code"));
		asig = dao.getAsignatura(code);
		al = dao.getAlumno(dni);
		evaluations = dao.getEvaluaciones(code, dni);
				
	}
	

}
