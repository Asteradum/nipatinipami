package iso3.pt.action;

import java.util.ArrayList;
import java.util.List;

import iso3.pt.dao.excepciones.IncorrectPasswordException;
import iso3.pt.dao.excepciones.UserNotFoundException;
import iso3.pt.service.PtDaoService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class LoginAction extends ActionSupport implements Preparable {
	
	private int username = -1;
	private String password = null;
	private String selectedRole = null;
	private List<String> roles = null;
	private PtDaoService dao = new PtDaoService();
	
	public String login()
	{
		try {
			if ( (username == -1) || password.isEmpty()  )
				if ( selectedRole.equals("Profesor") )
				{
					dao.loginProfesor(username, password);
					return "listLecturerSubjects"; //Lista Asig impartida por Profesor
				}
				else {
					dao.loginAlumno(username, password);					
					return "listStudentSubjects"; //Lista Asig matriculadas alumno
				}	
			else { 
				addActionError("Compulsory to specify both username and password!");
				return INPUT;
			}
		} catch (UserNotFoundException e) {
			addActionError( getText("errors.required.login.name") );
			return ERROR;
		} catch (IncorrectPasswordException e) {
			addActionError( getText("errors.required.login.password") );
			return ERROR;
		}
	}

	public int getUsername() {
		return username;
	}

	public void setUsername(int username) {
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
