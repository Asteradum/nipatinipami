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

public class SubjectStudentsAction extends ActionSupport implements Preparable {
	private PtDaoService dao = new PtDaoService();
	private Set<Alumno> al = null;
	private Asignatura asig = null;
	private Map session = null;
	private  String nombreAsig;
	private String nomProf;
	
	
	public String getNomProf() {
		return nomProf;
	}



	public void setNomProf(String nomProf) {
		this.nomProf = nomProf;
	}



	private int codeAsig;
	private Alumno alumno;
	


	public String getNombreAsig() {
		return nombreAsig;
	}



	public void setNombreAsig(String nombreAsig) {
		this.nombreAsig = nombreAsig;
	}



	public int getCodeAsig() {
		return codeAsig;
	}



	public void setCodeAsig(int codeAsig) {
		this.codeAsig = codeAsig;
	}



	public void prepare() throws Exception {
		session = ActionContext.getContext().getSession();
		al=dao.getAlumnos(codeAsig);
		}


	public Set<Alumno> getAl() {
		return al;
	}



	public void setAl(Set<Alumno> al) {
		this.al = al;
	}



	public Asignatura getAsig() {
		return asig;
	}



	public void setAsig(Asignatura asig) {
		this.asig = asig;
	}



	
	

}


