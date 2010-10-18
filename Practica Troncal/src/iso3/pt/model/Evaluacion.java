package iso3.pt.model;

public class Evaluacion {
	public Evaluacion() {
		super();
	}
	public Evaluacion(String concepto, float nota) {
		super();
		this.concepto = concepto;
		this.nota = nota;
	}
	private Integer id;
	private String concepto;
	private  float nota;
	
	private Alumno alumno;
	private Asignatura asignatura;
	
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
}
