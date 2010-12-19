package iso3.pt.action;


import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;





import iso3.pt.model.*;
import iso3.pt.service.PtDaoService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class LecturerAction extends ActionSupport implements Preparable {
	
	private Log logger = LogFactory.getLog(this.getClass());
	private Set<Asignatura> listaAsignaturas = null;private Asignatura selectedAsignatura = null;
	private int asigId;//la del studentSubjectMarks
	private PtDaoService dao = new PtDaoService();
	private Map session = null;
	private int profId;
	private String dni;
	private Set<Alumno> alumnos;
	
	public void Asignaturas()
	{
		System.out.println("blablabla " +asigId);
		session = ActionContext.getContext().getSession();
		alumnos=dao.getAlumnos(asigId);
		
	}
	
	
	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public Set<Asignatura> getListaAsignaturas() {
		return listaAsignaturas;
	}


	public void setListaAsignaturas(Set<Asignatura> listaAsignaturas) {
		this.listaAsignaturas = listaAsignaturas;
	}


	public Asignatura getSelectedAsignatura() {
		return selectedAsignatura;
	}


	public void setSelectedAsignatura(Asignatura selectedAsignatura) {
		this.selectedAsignatura = selectedAsignatura;
	}


	public int getAsigId() {
		return asigId;
	}


	public void setAsigId(int asigId) {
		this.asigId = asigId;
	}


	public int getProfId() {
		return profId;
	}


	public void setProfId(int profId) {
		this.profId = profId;
	}


	@Override
	public void prepare() throws Exception {
		session = ActionContext.getContext().getSession();
		dni = (String) session.get("dni");
		profId=dao.getProfesorByDni(Integer.parseInt(dni)).getId();
		listaAsignaturas= dao.getAsignaturasProfesor(profId);	
	}// TODO Auto-generated method stub
		
	} 


