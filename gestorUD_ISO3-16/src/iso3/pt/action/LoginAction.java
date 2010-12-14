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

public class LoginAction extends ActionSupport implements Preparable {
	
	private String username = null;
	private String password = null;
	private String selectedRole = null;
	private PtDaoService dao = new PtDaoService();
	private Map session = null;
	private Profesor prof = null;
	private Alumno al = null;
	private Set<Asignatura> listaAsignaturas = null;
	
	public String login()
	{
		try {
			if ( selectedRole.equals("Profesor") )
			{
				prof = dao.loginProfesor(Integer.parseInt(username), password);
				session = ActionContext.getContext().getSession();
				session.put("dni", username);
                session.put("nombre", prof.getNombre());
                listaAsignaturas = dao.getAsignaturasProfesor(Integer.parseInt(username));
				return "listLecturerSubjects"; //Lista Asig impartida por Profesor
			}
			else {
				al = dao.loginAlumno(Integer.parseInt(username), password);
				session = ActionContext.getContext().getSession();
				session.put("dni", username);
				session.put("nombre", al.getNombre());
				listaAsignaturas = dao.getAsignaturas(Integer.parseInt(username));
				return "listStudentSubjects"; //Lista Asig matriculadas alumno
			}	
		} catch (UserNotFoundException e) {
			addActionError( getText("errors.login.name") );
			return INPUT;
		} catch (IncorrectPasswordException e) {
			addActionError( getText("errors.login.password") );
			return INPUT;
		}
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSelectedRole() {
		return selectedRole;
	}

	public void setSelectedRole(String selectedRole) {
		this.selectedRole = selectedRole;
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
		/* No utilizo prepare porque sino Showlist no funciona correctamente ya que 
		 * intenta cargar el JSP sin tener los valores del comboBox (al no hacer un 
		 * class="LoginAction")
		roles = new ArrayList<String>();
	 	roles.add( getText("label.login.rol.alumno") );
		roles.add( getText("label.login.rol.profesor") );
		*/
	}
	

}
