package iso3.pt.dao;

import iso3.pt.dao.excepciones.*;
import iso3.pt.model.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PtDAO implements IDAO {

	private static PtDAO instancia;
	private SessionFactory sessionFactory;
	private Session session;
	private HashMap<Integer, Asignatura> asignaturas;
	
	private PtDAO()
	{
		 sessionFactory = new Configuration().configure().buildSessionFactory();
		 session = sessionFactory.openSession();
	     
	     List<Asignatura> ListAsignaturas = session.createQuery("from Asignatura").list();
	     asignaturas = new HashMap<Integer, Asignatura>();
	     
	     for(Iterator<Asignatura> i=ListAsignaturas.iterator();i.hasNext();)
	     {
	    	 Asignatura asig = i.next();
	    	 asignaturas.put(asig.getId(), asig);
	     }
	}
	
	public static PtDAO getInstance()
	{
		if (instancia==null)
			instancia = new PtDAO();
		return instancia;
	}
	
	@Override
	public Profesor getProfesor(int idAsignatura) {
		return asignaturas.get(idAsignatura).getProfesor();
	}

	@Override
	public Set<Alumno> getAlumnos(int idAsignatura) {
		return asignaturas.get(idAsignatura).getAlumnos();
	}

	@Override
	public List<Evaluacion> getEvaluacionesOrderedByAsignatura(int idAlumno) {
		List<Evaluacion> evaluaciones = session.createQuery("from Evaluacion as EV where AL_DNI="+ idAlumno +" order by ASIG_ID").list(); 
		return evaluaciones;
	}

	@Override
	public Set<Evaluacion> getEvaluaciones(int idAsignatura, int idAlumno) {
		Set<Evaluacion> setEvaluaciones = new HashSet<Evaluacion>();
		List<Evaluacion> evaluaciones = session.createQuery("from Evaluacion as EV where AL_DNI="+ idAlumno +" and ASIG_ID=" + idAsignatura).list();
		for(Iterator<Evaluacion> i=evaluaciones.iterator();i.hasNext();)
	     {
	    	 Evaluacion evaluacion = i.next();
	    	 setEvaluaciones.add(evaluacion);
	     }
		return setEvaluaciones;
	}

	@Override
	public void addEvaluacion(String concepto, float nota, int idAsignatura,int idAlumno) 
	{
		Evaluacion ev = new Evaluacion (concepto, nota);
		Asignatura asig = asignaturas.get(idAsignatura);
		Alumno al = getAlumno(idAlumno);
		
		ev.setAlumno(al);
		ev.setAsignatura(asig);
		
		al.addEvaluacion(ev);
		
		Transaction tx = session.beginTransaction();
		session.save(al);
		session.save(ev);
		tx.commit();
	}

	@Override
	public Set<Unidad> getUnidades(int idAsignatura) {
		Set<Unidad> setUnidades = new HashSet<Unidad>();
		List<Unidad> unidades = session.createQuery("from Unidad where ASIG_ID="+ idAsignatura).list();
		for(Iterator<Unidad> i=unidades.iterator();i.hasNext();)
	     {
	    	 Unidad unidad = i.next();
	    	 setUnidades.add(unidad);
	     }
		return setUnidades;
	}

	@Override
	public Set<Asignatura> getAsignaturas() {
		
		Set<Asignatura> set = new HashSet<Asignatura>();
		for(Iterator i=asignaturas.entrySet().iterator(); i.hasNext();)
	     {
			 Map.Entry ent = (Map.Entry)i.next();
	    	 Asignatura asig = (Asignatura) ent.getValue();
	    	 set.add(asig);
	     }
		
		return set;
	}

	@Override
	public Alumno getAlumno(int id) {
		return (Alumno) session.createQuery("from Alumno where AL_DNI="+ id).uniqueResult();
	}

	@Override
	public Asignatura getAsignatura(int id) {
		return asignaturas.get(id);
	}

	@Override
	public Alumno loginAlumno(int dni, String pass) throws UserNotFoundException, IncorrectPasswordException {
		Alumno al = getAlumno(dni);
		if (al == null) throw new UserNotFoundException();
		if (!al.getPassword().equals(pass)) throw new IncorrectPasswordException();
		return al;
	}

	@Override
	public Set<Asignatura> getAsignaturas(int idAlumno) {
		Set<Asignatura> set = new HashSet<Asignatura>();
		Alumno al = getAlumno(idAlumno);
		for(Iterator i=asignaturas.entrySet().iterator(); i.hasNext();)
	     {
			 Map.Entry ent = (Map.Entry)i.next();
	    	 Asignatura asig = (Asignatura) ent.getValue();
	    	 if (asig.estaMatriculado(al))
	    		 set.add(asig);
	     }
		return set;
	}

	@Override
	public void matricular(int idAlumno, int idAsignatura) {
		Asignatura asig = asignaturas.get(idAsignatura);
		Alumno al = getAlumno(idAlumno);
		if (!asig.estaMatriculado(al))
		{
			asig.addAlumno(al);
			al.addAsignatura(asig);
			
			Transaction tx = session.beginTransaction();
			session.save(asig);
			session.save(al);
			tx.commit();
		}
	}

	@Override
	public void desmatricular(int idAlumno, int idAsignatura) {
		Asignatura asig = asignaturas.get(idAsignatura);
		Alumno al = getAlumno(idAlumno);
		if (asig.estaMatriculado(al))
		{
			asig.removeAlumno(al);
			al.removeAsignatura(asig);
		
			Transaction tx = session.beginTransaction();
			session.save(asig);
			session.save(al);
			tx.commit();
		}

	}

	@Override
	public Profesor loginProfesor(int dni, String pass) throws UserNotFoundException, IncorrectPasswordException {
		Profesor prof = getProfesorByDni(dni);
		if (prof == null) throw new UserNotFoundException();
		if (!prof.getPassword().equals(pass)) throw new IncorrectPasswordException();
		return prof;
	}

	@Override
	public Set<Asignatura> getAsignaturasProfesor(int idProfesor) {
		Set<Asignatura> set = new HashSet<Asignatura>();
		Profesor prof;
		for(Iterator i=asignaturas.entrySet().iterator(); i.hasNext();)
	     {
			 Map.Entry ent = (Map.Entry)i.next();
	    	 Asignatura asig = (Asignatura) ent.getValue();
	    	 prof = asig.getProfesor();
	    	 if (prof!= null && prof.getId().equals(idProfesor))
	    	 	set.add(asig);
	     }
		return set;
	}

	@Override
	public Profesor getProfesorByDni(int dni) throws UserNotFoundException {
		Profesor prof = (Profesor) session.createQuery("from Profesor where PROF_DNI="+ dni).uniqueResult();
		if (prof==null) throw new UserNotFoundException();
		return prof;
	}

	@Override
	public List<Evaluacion> getEvaluacionesAsignatura(int idAsignatura) {
		return session.createQuery("from Evaluacion where ASIG_ID="+ idAsignatura).list();
		
	}
	
	public void close()
	{
		session.close();
	}

}
