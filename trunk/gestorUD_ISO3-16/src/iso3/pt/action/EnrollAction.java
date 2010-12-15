package iso3.pt.action;

import iso3.pt.dao.excepciones.IncorrectPasswordException;
import iso3.pt.dao.excepciones.UserNotFoundException;
import iso3.pt.model.Alumno;
import iso3.pt.model.Asignatura;
import iso3.pt.model.Profesor;
import iso3.pt.service.PtDaoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javassist.bytecode.Descriptor.Iterator;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class EnrollAction extends ActionSupport implements Preparable {

	private PtDaoService dao = new PtDaoService();
	private List<Asignatura> subjectList = new ArrayList<Asignatura>();
	private String selectedSubject = null;

	private Map session = null;
	

	public void enroll()
	{
		session = ActionContext.getContext().getSession();
		//dao.matricular( Integer.parseInt((String) session.get("dni")), Integer.parseInt(subjectId) );
		
	}

	public List<Asignatura> getListaAsignaturas() {
		return subjectList;
	}
	

	public void setListaAsignaturas(List<Asignatura> listaAsignaturas) {
		this.subjectList = listaAsignaturas;
	}

	public String getSelectedSubject() {
		return selectedSubject;
	}

	public void setSelectedSubject(String selectedSubject) {
		this.selectedSubject = selectedSubject;
	}

	@Override
	public void prepare() throws Exception {
		// = dao.getAsignaturas();
				
	}
	

}
