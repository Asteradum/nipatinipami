package iso3.pt.action;


import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class LogoutAction extends ActionSupport implements Preparable {
	
	private Map session = null;

	
	public String Logout()
	{
		session = ActionContext.getContext().getSession();
		session.clear();
		return SUCCESS;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
