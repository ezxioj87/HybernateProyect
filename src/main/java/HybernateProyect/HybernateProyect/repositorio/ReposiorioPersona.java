package HybernateProyect.HybernateProyect.repositorio;

import java.util.List;

import org.hibernate.Session;

import HybernateProyect.HybernateProyect.modelo.EstadoCivil;
import HybernateProyect.HybernateProyect.modelo.Persona;
import HybernateProyect.HybernateProyect.util.*;

public class ReposiorioPersona {

	public static Integer crearPersona(final Persona persona) {
		final Session sesion = HybernateUtil.getMiFactorio().getCurrentSession();

		try {
			sesion.beginTransaction();
			final Integer idPersona = (Integer) sesion.save(persona);
			sesion.getTransaction().commit();
			return idPersona;
		} catch (Exception e) {
			System.out.println("Se ha producidoun error insertando la persona: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

	public static void modificarPersona(final String nombre, Integer idPersona) {
		final Session sesion = HybernateUtil.getMiFactorio().getCurrentSession();

		try {
			sesion.beginTransaction();
			sesion.createQuery("Update Persona set per_nom = :nombre where per_id = :indentificador")
					.setParameter("nombre", nombre).setParameter("indentificador", idPersona).uniqueResult();

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

	public static void modificarPersona1(final String nombre, Integer idPersona) {
		final Session sesion = HybernateUtil.getMiFactorio().getCurrentSession();

		try {
			sesion.beginTransaction();

			final Persona personaBBDD = (Persona) sesion.createQuery("from Persona where PER_ID = :identificador")
					.setParameter("identificador", idPersona).uniqueResult();
			personaBBDD.setNombre(nombre);
			personaBBDD.setApellidos("Delgado");
			personaBBDD.setEdad(19);

			sesion.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("Se ha producidoun error insertando la persona: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

	public static void modificarPersona2(Persona persona) {
		final Session sesion = HybernateUtil.getMiFactorio().getCurrentSession();

		try {
			sesion.beginTransaction();
			// sesion.createQuery("Update Persona set per_nom = :nombre where per_id =
			// :indentificador")
			// .setParameter("nombre", nombre).setParameter("indentificador",
			// idPersona).uniqueResult();

			// final Persona personaBBDD= (Persona)sesion.createQuery("from Persona where
			// PER_ID = :identificador").
			// setParameter("identifacador", idPersona).uniqueResult();
			// personaBBDD.setNombre(nombre);
			// personaBBDD.setApellidos("Delgado");
			// personaBBDD.setEdad(19);
			sesion.saveOrUpdate(persona);
			sesion.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("Se ha producidoun error insertando la persona: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

	public static void eliminarPersona(Integer idPersona) {
		final Session sesion = HybernateUtil.getMiFactorio().getCurrentSession();

		try {
			sesion.beginTransaction();
			sesion.createQuery("delete Persona where per_id = :idPersona").setParameter("idPersona", idPersona)
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

	public static List<Persona> consultar(String nombre, String apellidos, String dni, EstadoCivil estadoCivil) {
		final Session sesion = HybernateUtil.getMiFactorio().getCurrentSession();
		try {
			sesion.beginTransaction();
			final StringBuilder sb = new StringBuilder("from Persona where 1=1");
			if (!nombre.isEmpty()) {
				sb.append(" and per_nom in (select nombre from Persona where per_nom like :nombre)");
			}
			if (!apellidos.isEmpty()) {
				sb.append(" and per_ape like :apellidos");
			}
			if (!dni.isEmpty()) {
				sb.append(" and per_dni = :dni");
			}
			if (estadoCivil != null) {
				sb.append(" and per_ecv = :estadoCivil");
			}
			final org.hibernate.query.Query<Persona> consulta = sesion.createQuery(sb.toString());

			if (!nombre.isEmpty()) {
				consulta.setParameter("nombre", nombre);
			}
			if (!apellidos.isEmpty()) {
				consulta.setParameter("apellidos", apellidos);
			}
			if (!dni.isEmpty()) {
				consulta.setParameter("dni", dni);
			}
			if (estadoCivil != null) {
				consulta.setParameter("estadoCivil", estadoCivil);
			}
			return consulta.list();
		} catch (Exception e) {
			System.out.println("Se ha producidoun error insertando la persona: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}

	}

}
