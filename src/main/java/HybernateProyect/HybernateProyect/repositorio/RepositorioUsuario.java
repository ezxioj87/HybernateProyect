package HybernateProyect.HybernateProyect.repositorio;

import org.hibernate.Session;

import HybernateProyect.HybernateProyect.modelo.Cliente;
import HybernateProyect.HybernateProyect.util.HybernateUtil;

public class RepositorioUsuario {
	
	public static void eliminar(Integer idPersona) {
		final Session sesion = HybernateUtil.getMiFactorio().getCurrentSession();

		try {
			sesion.beginTransaction();
			sesion.createQuery("delete Usuario where usu_id = :idPersona").setParameter("idPersona", idPersona)
					.executeUpdate();

			// final Persona personaBBDD= (Persona)sesion.createQuery("from Persona where
			// PER_ID = :identificador").
			// setParameter("identifacador", idPersona).uniqueResult();
			// personaBBDD.setNombre(nombre);
			// personaBBDD.setApellidos("Delgado");
			// personaBBDD.setEdad(19);
			sesion.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("Se ha producidoun error insertando la persona: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}
	
	public static void modificar(final String nombre, Integer idPersona) {
		final Session sesion = HybernateUtil.getMiFactorio().getCurrentSession();

		try {
			sesion.beginTransaction();

			final Cliente personaBBDD = (Cliente) sesion.createQuery("from Usuario USU2 where USU2.idUsuario = :identificador")
					.setParameter("identificador", idPersona).uniqueResult();
			personaBBDD.setNombre(nombre);
			personaBBDD.setApellidos("Delgado");
			personaBBDD.setEdad(19);

			sesion.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("Se ha producidoun error insertando el Cliente: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

}
