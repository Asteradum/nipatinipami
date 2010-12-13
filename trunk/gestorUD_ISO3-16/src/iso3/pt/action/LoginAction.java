package iso3.pt.action;

import iso3.pt.dao.excepciones.IncorrectPasswordException;
import iso3.pt.dao.excepciones.UserNotFoundException;
import iso3.pt.service.PtDaoService;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class LoginAction extends ActionSupport implements Preparable {
	
	private String username = null;
	private String password = null;
	private String selectedRole = null;
	private List<String> roles = null;
	private PtDaoService dao = new PtDaoService();
	
	public String login()
	{
		try {
			if ( !username.isEmpty() && !password.isEmpty()  )
				if ( selectedRole.equals("Profesor") )
				{
					dao.loginProfesor(Integer.parseInt(username), password);
					//ActionContext.getContext().getSession());
					return "listLecturerSubjects"; //Lista Asig impartida por Profesor
				}
				else {
					dao.loginAlumno(Integer.parseInt(username), password);
					//ActionContext.getContext().getSession());
					return "listStudentSubjects"; //Lista Asig matriculadas alumno
				}	
			else { 
				addActionError(getText("errors.required.login"));
				return INPUT;
			}
		} catch (UserNotFoundException e) {
			addActionError( getText("errors.login.name") );
			return INPUT;
		} catch (IncorrectPasswordException e) {
			addActionError( getText("errors.login.password") );
			return INPUT;
		}
	}
	
	//public String Logout()

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

	@Override
	public void prepare() throws Exception {
		
		roles = new ArrayList<String>();
		/*roles.add("Alumno");
		roles.add("Profesor");
		*/
	 	roles.add( getText("label.login.rol.alumno") );
		roles.add( getText("label.login.rol.profesor") );
	}
	

}
