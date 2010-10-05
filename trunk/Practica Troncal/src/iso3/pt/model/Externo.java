package iso3.pt.model;

public class Externo extends Empleado{
	
	private String empresa;
	private String emailAlt;
	private String descColaboracion;
	
	protected Externo(){
		super();
	}
	
	public Externo(Integer nif, String nombre, String puesto, String email, String empresa, String emailAlt, String descColaboracion) {
		super(nif, nombre, puesto, email);
		this.empresa = empresa;
		this.emailAlt = emailAlt;
		this.descColaboracion = descColaboracion;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getEmailAlt() {
		return emailAlt;
	}
	public void setEmailAlt(String emailAlt) {
		this.emailAlt = emailAlt;
	}
	public String getDescColaboracion() {
		return descColaboracion;
	}
	public void setDescColaboracion(String descColaboracion) {
		this.descColaboracion = descColaboracion;
	}
	
	public String toString(){
		return super.toString() + " + (" + this.empresa + "|" + this.emailAlt + "|" + this.descColaboracion + ")";
	}
	

}
