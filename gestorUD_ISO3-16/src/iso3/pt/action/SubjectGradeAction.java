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
	private String code;
	private String name;
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


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public void prepare() throws Exception {
		session = ActionContext.getContext().getSession();
		dni = Integer.parseInt((String) session.get("dni"));
		asig = dao.getAsignatura(Integer.parseInt(code));
		al = dao.getAlumno(dni);
		evaluations = dao.getEvaluaciones(Integer.parseInt(code), dni);
				
	}
	

}
