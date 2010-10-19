package iso3.pt.dao;

import iso3.pt.model.*;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TestDAO {

	public static void main(String[] args) {

		ptDAO dao = ptDAO.getInstancia();
		
		Set<Asignatura> asignaturas = dao.getAsignaturas();
		Set<Alumno> alumnos;
		List<Evaluacion> evaluaciones;
		Set<Evaluacion> evsSet;
		Set<Unidad> unidades;
		Unidad u;
		Asignatura asig;
		Alumno al;
		Evaluacion ev;
		/*
		 for(Iterator<Asignatura> i = asignaturas.iterator();i.hasNext();) 
		{
		
			asig = i.next();
			System.out.println("Asignatura: " + asig.getNombre());
			
			Profesor prof = dao.getProfesor(asig.getId());
			if (prof!=null)
				System.out.println("Profesor: " + prof.getNombre());
			
			evaluaciones = dao.getEvaluacionesAsignatura(asig.getId());
			System.out.println("Evaluaciones de la Asignatura:");
			System.out.println("------------------------------");
			for(Iterator<Evaluacion> i3 =evaluaciones.iterator();i3.hasNext();)
			{
				ev = i3.next();
				System.out.println("		Alumno: " + ev.getAlumno().getNombre() + ", Nota: " + ev.getNota() + ", Concepto:" + ev.getConcepto());
			}
			
			alumnos = dao.getAlumnos(asig.getId());
			System.out.println("	Alumnos:");
			System.out.println("	--------");
			for(Iterator<Alumno> i2 =alumnos.iterator();i2.hasNext();)
			{
				al = i2.next();
				System.out.println("	" + al.getNombre());
				
				System.out.println("		Evaluaciones del Alumno en diferentes asignaturas:");
				System.out.println("		--------------------------------------------------");
				evaluaciones = dao.getEvaluacionesOrderedByAsignatura(al.getDni());
				for(Iterator<Evaluacion> i3 =evaluaciones.iterator();i3.hasNext();)
				{
					ev = i3.next();
					System.out.println("		Asignatura: " + ev.getAsignatura().getNombre() + ", Nota: " + ev.getNota() + ", Concepto:" + ev.getConcepto());
				}
			}
			
			
		}
		
		
		System.out.println("Evaluaciones de Alvaro en la Asignatura: " + dao.getAsignatura(2).getNombre());
		evsSet = dao.getEvaluaciones(2, 78955100);
		for(Iterator<Evaluacion> i3 =evsSet.iterator();i3.hasNext();)
		{
			ev = i3.next();
			System.out.println("Nota: " + ev.getNota() + ", Concepto: " + ev.getConcepto());
		}
		
		dao.addEvaluacion("Seminario", 6, 2, 78955100);
		
		System.out.println("Evaluaciones de Alvaro en la Asignatura: " + dao.getAsignatura(2).getNombre());
		evsSet = dao.getEvaluaciones(2, 78955100);
		for(Iterator<Evaluacion> i3 =evsSet.iterator();i3.hasNext();)
		{
			ev = i3.next();
			System.out.println("Nota: " + ev.getNota() + ", Concepto: " + ev.getConcepto());
		}
		
		*/
		
		unidades = dao.getUnidades(2);
		System.out.println("Unidades de la Asignatura: " + dao.getAsignatura(2).getNombre());
		for(Iterator<Unidad> i3 =unidades.iterator();i3.hasNext();)
		{
			u = i3.next();
			System.out.println("Titulo: " + u.getTitulo());
		}
		
		dao.close();
		
	}

}
