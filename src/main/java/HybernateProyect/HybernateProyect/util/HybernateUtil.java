package HybernateProyect.HybernateProyect.util;

import org.hibernate.*;
import org.hibernate.cfg.*;
public class HybernateUtil {
	
	private static SessionFactory miFactoria = construirSessionFactory();
	
	private static SessionFactory construirSessionFactory() {
		try {
		return new Configuration().configure().buildSessionFactory();
		}catch (Exception e) {
			System.out.println("seha producido un error obteniendo la factorio de sesiones: "+e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public static SessionFactory getMiFactorio() {
		return miFactoria;
	}
		
}
