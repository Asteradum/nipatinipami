package iso3.pt.action;

import iso3.pt.service.PtDaoService;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	
	private String username = null;
	private String password = null;
	private PtDaoService dao = new PtDaoService();
	
	public String login()
	{

		if ( ( username.equals("123") ) && ( password.equals("123") ) )
			if ( true )//profesor )
				return "listLecturerSubjects"; //Lista Asig impartida por Profesor
			else return "listStudentSubjects"; //Lista Asig matriculadas alumno
		else { 
			addActionError("Compulsory to specify both username and password!");
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
	

}
