package iso3.pt.model;

import java.util.*;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;


public class Test { 
	
		SessionFactory sessionFactory;
		
		public Test(){
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
	
		public void inserciones1(){
	    	
	        Session session = sessionFactory.openSession();
	        Transaction tx = session.beginTransaction();
	        
	        Profesor prof1 = new Profesor(78944100, "prof1", "Profesor1", "", "", "");
	        Profesor prof2 = new Profesor(78944100, "prof2", "Profesor2", "", "", "");

	        Asignatura asig1 = new Asignatura(1, "Ingenieria del Software", 6);
	        Asignatura asig2 = new Asignatura(2, "EDR", (float) 4.5);
	        
	        asig1.setProfesor(prof1);
	        
	        Unidad ud1 = new Unidad("HIB", "Hibernate", "");
	        Unidad ud2 = new Unidad("STR", "Strut2", "");
	        Unidad ud3 = new Unidad("MySQL", "MySQL Server y Admin tool", "");
	        
	        Unidad ud4 = new Unidad("VSLM", "Variable Subnet Lenght Masks", "");
	        Unidad ud5 = new Unidad("ROUTERS", "Routers CISCO", "");
	        
	        asig1.addUnidad(ud1);
	        asig1.addUnidad(ud2);
	        asig1.addUnidad(ud3);
	        
	        asig2.addUnidad(ud4);
	        asig2.addUnidad(ud5);
	        
	        Alumno al1 = new Alumno(78955100, "al1", "Alvaro Martin", "");
	        Alumno al2 = new Alumno(12345678, "al2", "Sonia Pierola", "");
	        
	        Evaluacion ev1 = new Evaluacion("Primera Evaluacion", 9);
	        Evaluacion ev2 = new Evaluacion("Segunda Evaluacion", 7);
	        Evaluacion ev3 = new Evaluacion("Recuperacion", 5);
	        Evaluacion ev4 = new Evaluacion("Primera Evaluacion", 10);
	        
	        ev1.setAsignatura(asig1);
	        ev1.setAlumno(al1);
	        ev2.setAsignatura(asig1);
	        ev2.setAlumno(al1);
	        ev3.setAsignatura(asig2);
	        ev3.setAlumno(al1);
	        ev4.setAsignatura(asig1);
	        ev4.setAlumno(al2);
	        
	        
	        al1.addEvaluacion(ev1);
	        al1.addEvaluacion(ev2);
	        al1.addEvaluacion(ev3);
	        al2.addEvaluacion(ev4);
	        	        
	        
	        al1.addAsignatura(asig1);
	        al1.addAsignatura(asig2);
	        
	        al2.addAsignatura(asig2);
	        
	        asig1.addAlumno(al1);
	        
	        asig2.addAlumno(al1);
	        asig2.addAlumno(al2);
	        
	        /*Saves*/
	        
	        session.save(prof1);
	        session.save(prof2);
	        
	        session.save(asig1);
	        session.save(asig2);
	        
	        session.save(al1);
	        session.save(al2);
	        
	        session.save(ev1);
	        session.save(ev2);
	        session.save(ev3);
	        session.save(ev4);
	        
	        tx.commit();
	        session.close();
	        System.out.println("Done inserciones1!");
		}
		
		public void busquedaPK(){

	        Session session = sessionFactory.openSession();
	        Transaction tx = session.beginTransaction();
	        /*
	        Empleado emp1 = (Empleado) session.get(Empleado.class, 111);
	        System.out.println(emp1);
	        emp1.setNombre("Asier Perallos Ruiz");
	        session.flush();
	        
	        Departamento dep = emp1.getDepartamento();
	        System.out.println(dep);
	        
	        Set<Empleado> empleados = dep.getEmpleados();
	        for (Iterator<Empleado> iter = empleados.iterator(); iter.hasNext();) {
	        	Empleado emp2 = iter.next();
	        	System.out.println(emp2);	
	        }
	        */
	        tx.commit();
	        session.close();
	        System.out.println("Done busquedaPK!");
		}
		
		
		public void busquedaCompleja(){
	    	
	        Session session = sessionFactory.openSession();
	        Transaction tx = session.beginTransaction();
	        /*
	        List<Empleado> empleados = session.createQuery("from Empleado as emp where emp.departamento.nombre = 'Servicios - ESIDE' and emp.puesto = 'secretaria'").list();
	        
	        for (Iterator<Empleado> iter = empleados.iterator(); iter.hasNext();) {
	            Empleado emp1 = iter.next();
	            System.out.println(emp1);
	        }
	        */
	        tx.commit();
	        session.close();
	        System.out.println("Done busquedaCompleja!");
	        
	        
		}
		
		public void borrado(){
	    	
	        Session session = sessionFactory.openSession();
	        Transaction tx = session.beginTransaction();
	        /*
	        Empleado emp1 = (Empleado) session.get(Empleado.class, 222);
	        
	        Set<Direccion> direcciones = emp1.getDirecciones();
	        
	        for (Iterator<Direccion> iter = direcciones.iterator(); iter.hasNext();) {
	            Direccion dir = iter.next();
	            emp1.removeDireccion(dir);
	        }
	        emp1.getDirecciones().clear();
	        emp1.getDepartamento().removeEmpleado(emp1);
	        
	        session.delete(emp1);
	        */
	        tx.commit();
	        session.close();
	        System.out.println("Done borrado!");
		}
		
		
		public void close(){
	        sessionFactory.close();
		}

	    public static void main(String[] args) {
	    	Test t1 = new Test();
	    	t1.inserciones1();
	    	t1.close();
	    }
	}
