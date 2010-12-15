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

public class AllSubjectsGradesAction extends ActionSupport implements Preparable {

	private PtDaoService dao = new PtDaoService();
	private int dni;
	private List<Evaluacion> evaluations = null;
	private Set<Asignatura> listaAsignaturas = null;
	private Alumno al = null;
	private Map session = null;
	

	public List<Evaluacion> getEvaluations() {
		return evaluations;
	}


	public void setEvaluations(List<Evaluacion> evaluations) {
		this.evaluations = evaluations;
	}


	public Alumno getAl() {
		return al;
	}


	public void setAl(Alumno al) {
		this.al = al;
	}


	@Override
	public void prepare() throws Exception {
		session = ActionContext.getContext().getSession();
		dni = Integer.parseInt((String) session.get("dni"));
		listaAsignaturas= dao.getAsignaturas(dni);
		al = dao.getAlumno(dni);
		evaluations = dao.getEvaluacionesOrderedByAsignatura(dni);
				
	}
	

}
