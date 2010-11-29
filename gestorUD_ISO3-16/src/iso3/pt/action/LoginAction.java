package iso3.pt.action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	
	private String username = null;
	private String password = null;
	
	public String login()
	{
		
		if ( ( username == "123" ) && ( password == "123" ) )
			if ( profesor )
				return "listStudentSubjects"//Lista Asig  impartida por Profesor
			else return "listLecturerSubjects"//Lista Asig matriculadas alumno
		
	}
	

}
