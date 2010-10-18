package iso3.pt.model;

public class Evaluacion {
	
	private Integer id;
	private String concepto;
	private float nota;
	
	private Alumno alumno;
	private Asignatura asignatura;
	
	public Evaluacion() {
		super();
	}
	public Evaluacion(String concepto, float nota) {
		super();
		this.concepto = concepto;
		this.nota = nota;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public float getNota() {
		return nota;
	}
	public void setNota(float nota) {
		this.nota = nota;
	}
	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}
	public Asignatura getAsignatura() {
		return asignatura;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public Alumno getAlumno() {
		return alumno;
	}
}
