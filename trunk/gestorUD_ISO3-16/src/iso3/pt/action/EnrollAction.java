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
	private Set<Asignatura> subjectList = null;
	private String selectedSubject = null;
	private int subjectId;

	private Map session = null;

	public String enroll()
	{
		session = ActionContext.getContext().getSession();
		/*
		System.out.println("El id de la asignatura es: " + subjectId);
		System.out.println("El dni del alumno es: " + (String) session.get("dni"));
		*/
		
		dao.matricular( Integer.parseInt((String) session.get("dni")), subjectId );
		
		return SUCCESS;
	}

	public String unenroll()
	{
		session = ActionContext.getContext().getSession();
		/*
		System.out.println("El id de la asignatura es: " + subjectId);
		System.out.println("El dni del alumno es: " + (String) session.get("dni"));
		*/
		dao.desmatricular(Integer.parseInt((String) session.get("dni")), subjectId);
		subjectList = dao.getAsignaturas(Integer.parseInt((String) session.get("dni")));
		
		return SUCCESS;
	}

	public void setListaAsignaturas(Set<Asignatura> listaAsignaturas) {
		this.subjectList = listaAsignaturas;
	}

	public String getSelectedSubject() {
		return selectedSubject;
	}

	public void setSelectedSubject(String selectedSubject) {
		this.selectedSubject = selectedSubject;
	}

	public Set<Asignatura> getSubjectList() {
		return subjectList;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	@Override
	public void prepare() throws Exception {
		subjectList = dao.getAsignaturas();
	}
	

}
