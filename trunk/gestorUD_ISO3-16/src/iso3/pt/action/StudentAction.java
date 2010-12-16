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

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class StudentAction extends ActionSupport implements Preparable {
	
	private String username = null;
	private PtDaoService dao = new PtDaoService();
	private Map session = null;
	private String dni = null;
	private Set<Asignatura> listaAsignaturas = null;	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public void setListaAsignaturas(Set<Asignatura> listaAsignaturas) {
		this.listaAsignaturas = listaAsignaturas;
	}

	public Set<Asignatura> getListaAsignaturas() {
		return listaAsignaturas;
	}

	@Override
	public void prepare() throws Exception {
		session = ActionContext.getContext().getSession();
		dni = (String) session.get("dni");
		listaAsignaturas = dao.getAsignaturas(Integer.parseInt(dni));
	}
	

}
