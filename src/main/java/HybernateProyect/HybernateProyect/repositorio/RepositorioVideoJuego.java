package HybernateProyect.HybernateProyect.repositorio;

import org.hibernate.Session;

import HybernateProyect.HybernateProyect.modelo.Persona;
import HybernateProyect.HybernateProyect.modelo.Plataformas;
import HybernateProyect.HybernateProyect.modelo.VideoJuego;
import HybernateProyect.HybernateProyect.util.HybernateUtil;

public class RepositorioVideoJuego {
	
	public static Integer crearVideoJuego(final VideoJuego videoJuego) {
		final Session sesion = HybernateUtil.getMiFactorio().getCurrentSession();

		try {
			sesion.beginTransaction();
			final Integer idVideoJuego = (Integer)sesion.save(videoJuego);
			sesion.getTransaction().commit();
			return idVideoJuego;
		} catch (Exception e) {
			System.out.println("Se ha producidoun error insertando el videojuego: " +e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			sesion.close();
		}
	}
	
	public static void modificarVideoJuego(final String nombre,Integer idJuego) {
		final Session sesion = HybernateUtil.getMiFactorio().getCurrentSession();
		
		try {
			sesion.beginTransaction();
			
			final VideoJuego VideoJuegoBBDD= (VideoJuego)sesion.createQuery("from VideoJuego where VDJ_ID = :identificador").
			setParameter("identificador", idJuego).uniqueResult();
			VideoJuegoBBDD.setNombre(nombre);
			VideoJuegoBBDD.setPlataforma(Plataformas.PC);
			
			sesion.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Se ha producidoun error insertando la persona: " +e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			sesion.close();
		}
	}
	
	public static void eliminarVideoJuego(Integer idJuego) {
		final Session sesion = HybernateUtil.getMiFactorio().getCurrentSession();
		
		try {
			sesion.beginTransaction();
			sesion.createQuery("delete VideoJuego where vdj_id = :idJuego")
			.setParameter("idJuego", idJuego).executeUpdate();
			
//			final Persona personaBBDD= (Persona)sesion.createQuery("from Persona where PER_ID = :identificador").
//			setParameter("identifacador", idPersona).uniqueResult();
//			personaBBDD.setNombre(nombre);
//			personaBBDD.setApellidos("Delgado");
//			personaBBDD.setEdad(19);
			sesion.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Se ha producidoun error insertando la persona: " +e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			sesion.close();
		}
	}

}
