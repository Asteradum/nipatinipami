package iso3.pt.action;

import iso3.pt.dao.excepciones.IncorrectPasswordException;
import iso3.pt.dao.excepciones.UserNotFoundException;
import iso3.pt.model.Alumno;
import iso3.pt.model.Profesor;
import iso3.pt.service.PtDaoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class LoginAction extends ActionSupport implements Preparable {
	
	private String username = null;
	private String password = null;
	private String selectedRole = null;
	private List<String> roles = null;
	private PtDaoService dao = new PtDaoService();
	private Map session = null;
	private Profesor prof = null;
	private Alumno al = null;
	
	public String login()
	{
		try {
			if ( selectedRole.equals("Profesor") )
			{
				prof = dao.loginProfesor(Integer.parseInt(username), password);
				session = ActionContext.getContext().getSession();
				session.put("dni", username);
                session.put("nombre", prof.getNombre());                
				return "listLecturerSubjects"; //Lista Asig impartida por Profesor
			}
			else {
				al = dao.loginAlumno(Integer.parseInt(username), password);
				session = ActionContext.getContext().getSession();
				session.put("dni", username);
				session.put("nombre", al.getNombre());	
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
	
	public String Logout()
	{
		session.clear();
		return SUCCESS;
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

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
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
