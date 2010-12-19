package iso3.pt.action;

import iso3.pt.model.Alumno;
import iso3.pt.model.Asignatura;
import iso3.pt.service.PtDaoService;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class StudentSubjectMarkingFormAction extends ActionSupport implements Preparable {
	private PtDaoService dao = new PtDaoService();
	private Alumno al = null;
	private Asignatura asigIter = null;
	private Asignatura asig=null;
	private Set<Asignatura> listaAsignaturas = null;
	private Map session = null;
	private  String nombreAsig;
	private String nomProf;
	private int dni;
	@Override
	
	
	
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("llega a ki");
		System.out.println(nombreAsig);
		System.out.println(nomProf);
		session = ActionContext.getContext().getSession();
		al=dao.getAlumno(dni);
		System.out.println("alumno recogido"+ al.getNombre());
		listaAsignaturas=dao.getAsignaturas(dni);
		System.out.println("tenemos la lista");
		for(Iterator<Asignatura> i2 =listaAsignaturas.iterator();i2.hasNext();)
		{
			asigIter = i2.next();
			System.out.println(" asignatura "+ asigIter.getNombre());
			if ((asigIter.getNombre().equals(nombreAsig)))
				//(asigIter.getProfesor().getNombre().equals(nomProf))&& una asignatura solo tiene 1 prof posible
			{System.out.println("ha entrado");
				asig=asigIter;
				System.out.println(asig.getNombre());}
		}
}
	
	public Alumno getAl() {
		return al;
	}
	public void setAl(Alumno al) {
		this.al = al;
	}
	public Asignatura getAsig() {
		return asig;
	}
	public void setAsig(Asignatura asig) {
		this.asig = asig;
	}
	public Asignatura getAsigAlumno() {
		return asigIter;
	}
	public void setAsigAlumno(Asignatura asigAlumno) {
		this.asigIter = asigAlumno;
	}
	public Set<Asignatura> getListaAsignaturas() {
		return listaAsignaturas;
	}
	public void setListaAsignaturas(Set<Asignatura> listaAsignaturas) {
		this.listaAsignaturas = listaAsignaturas;
	}
	
	public String getNombreAsig() {
		return nombreAsig;
	}
	public void setNombreAsig(String nombreAsig) {
		this.nombreAsig = nombreAsig;
	}
	public String getNomProf() {
		return nomProf;
	}
	public void setNomProf(String nomProf) {
		this.nomProf = nomProf;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
}