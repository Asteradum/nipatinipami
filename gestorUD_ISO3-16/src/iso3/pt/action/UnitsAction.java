package iso3.pt.action;

import iso3.pt.model.Alumno;
import iso3.pt.model.Asignatura;
import iso3.pt.model.Evaluacion;
import iso3.pt.model.Unidad;
import iso3.pt.service.PtDaoService;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class UnitsAction extends ActionSupport implements Preparable {

	private PtDaoService dao = new PtDaoService();
	private int codeAsig;
	private String nombreAsig = null;
	private Map session = null;
	private Set<Unidad> unidades = null;
	private Asignatura asig;


	public void setNombreAsig(String nombreAsig) {
		this.nombreAsig = nombreAsig;
	}


	public String getNombreAsig() {
		return nombreAsig;
	}
	
	public void setCodeAsig(int codeAsig) {
		this.codeAsig = codeAsig;
	}


	public int getCodeAsig() {
		return codeAsig;
	}	


	public void setUnidades(Set<Unidad> unidades) {
		this.unidades = unidades;
	}


	public Set<Unidad> getUnidades() {
		return unidades;
	}


	public void setAsig(Asignatura asig) {
		this.asig = asig;
	}


	public Asignatura getAsig() {
		return asig;
	}


	@Override
	public void prepare() throws Exception {
		/*
		session = ActionContext.getContext().getSession();
		codeAsig = Integer.parseInt((String) session.get("dni"));
			*/	
		unidades = dao.getUnidades(codeAsig);
		setAsig(dao.getAsignatura(codeAsig));
	}
	

}
