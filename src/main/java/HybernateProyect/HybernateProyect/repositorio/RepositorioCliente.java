package HybernateProyect.HybernateProyect.repositorio;

import java.util.List;

import org.hibernate.Session;

import HybernateProyect.HybernateProyect.modelo.Cliente;
import HybernateProyect.HybernateProyect.modelo.EstadoCivil;
import HybernateProyect.HybernateProyect.util.HybernateUtil;

public class RepositorioCliente {
	
		public static Integer crearCliente(final Cliente persona) {
			final Session sesion = HybernateUtil.getMiFactorio().getCurrentSession();

			try {
				sesion.beginTransaction();
				final Integer idPersona = (Integer) sesion.save(persona);
				sesion.getTransaction().commit();
				return idPersona;
			} catch (Exception e) {
				System.out.println("Se ha producidoun error insertando el Cliente: " + e.getMessage());
				e.printStackTrace();
				throw new RuntimeException();
			} finally {
				sesion.close();
			}
		}
		
		public static void eliminarCliente(Integer idPersona) {
			final Session sesion = HybernateUtil.getMiFactorio().getCurrentSession();

			try {
				sesion.beginTransaction();
				sesion.createQuery("delete Cliente where usu_id = :idPersona").setParameter("idPersona", idPersona)
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
		
		public static void modificarCliente(final String nombre, Integer idPersona) {
			final Session sesion = HybernateUtil.getMiFactorio().getCurrentSession();

			try {
				sesion.beginTransaction();

				final Cliente personaBBDD = (Cliente) sesion.createQuery("from Cliente where usu_ID = :identificador")
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
		
		public static List<Cliente> consultar(String nombre, String apellidos, String dni, EstadoCivil estadoCivil) {
			final Session sesion = HybernateUtil.getMiFactorio().getCurrentSession();
			try {
				sesion.beginTransaction();
				final StringBuilder sb = new StringBuilder("from Cliente where 1=1");
				if (!nombre.isEmpty()) {
					sb.append(" and cli_nom in (select nombre from Cliente where per_nom like :nombre)");
				}
				if (!apellidos.isEmpty()) {
					sb.append(" and cli_ape like :apellidos");
				}
				if (!dni.isEmpty()) {
					sb.append(" and cli_dni = :dni");
				}
				if (estadoCivil != null) {
					sb.append(" and cli_ecv = :estadoCivil");
				}
				final org.hibernate.query.Query<Cliente> consulta = sesion.createQuery(sb.toString());

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
				System.out.println("Se ha producidoun error insertando el Cliente: " + e.getMessage());
				e.printStackTrace();
				throw new RuntimeException();
			} finally {
				sesion.close();
			}

		}

}
