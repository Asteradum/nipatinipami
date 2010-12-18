package iso3.pt.action;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;





import iso3.pt.model.*;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class LecturerAction extends ActionSupport implements Preparable {
	
	private Log logger = LogFactory.getLog(this.getClass());
	private List<Asignatura> asignaturas = null;
	private Asignatura selectedAsignatura = null;
	
	public void setSelectedAsignatura(Asignatura Asignatura) {
		this.selectedAsignatura = Asignatura;
	}
	
	public Asignatura getSelectedAsignatura() {
		return selectedAsignatura;
	}
	public List<Asignatura> getAsignaturas() {
        return this.asignaturas;
    }
	@Override
	public void prepare() throws Exception {
			/*this.asignaturas = new java.util.ArrayList<Asignatura>();
			asignaturas=
			this.asignaturas.add(new LanguageDesigner("Guido van Rosum", "Dutch", "Python"));
			
			if (this.selectedLanguageDesigner != null && this.selectedLanguageDesigner.getFullName() != null) {
				for (LanguageDesigner designer: this.languageDesigners) {
					if (designer.getFullName().equals(this.selectedLanguageDesigner.getFullName())) {
						this.selectedLanguageDesigner = designer;
						break;
					}
				}
			}*/
		}
		// TODO Auto-generated method stub
		
	} 


