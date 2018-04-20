package es.aytos.hibernate.hibernate_dual.repositorio;

import java.util.*;

import org.hibernate.*;

import es.aytos.hibernate.hibernate_dual.modelo.*;
import es.aytos.hibernate.hibernate_dual.util.*;

public class RepositorioPersona {

    public static Integer crearPersona(final Persona persona) {
        final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

        try {
            sesion.beginTransaction();

            final Integer idPersona = (Integer)sesion.save(persona);

            sesion.getTransaction().commit();

            return idPersona;

        } catch (Exception e) {
            System.out.println("Se ha producido un error insertando la persona: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            sesion.close();
        }
    }

    public static void modificarPersona(Persona persona) {
        final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

        try {
            sesion.beginTransaction();

            sesion.saveOrUpdate(persona);

            sesion.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("Se ha producido un error creando una persona: " + e.getMessage());
            sesion.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            sesion.close();
        }
    }

    public static void eliminarPersona(Integer idPersona) {
        final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

        try {
            sesion.beginTransaction();

            final Persona persona = (Persona)sesion.createQuery("from Usuario usu where usu.idUsuario = :idPersona")
                    .setParameter("idPersona", idPersona).uniqueResult();

            sesion.delete(persona);

            sesion.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("Se ha producido un error creando una persona: " + e.getMessage());
            sesion.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            sesion.close();
        }
    }

    public static Persona consultarNombreCompleto(Integer idPersona) {
        final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

        try {
            sesion.beginTransaction();

            Persona persona = (Persona)sesion.createQuery("from Usuario Usu where Usu.idUsuario = :idPersona")
                    .setParameter("idPersona", idPersona).uniqueResult();

            // Voy a pintar los telefonos de la persona
            // persona.getTelefonos().stream().forEach(telefono -> System.out.println(telefono.getTelefono()));

            return persona;

        } catch (Exception e) {
            System.out.println("Se ha producido un error creando una persona: " + e.getMessage());
            sesion.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            sesion.close();
        }
    }

    public static List<Persona> consultar(String nombre, String apellidos, String dni, EstadoCivil estadoCivil,
            String login) {
        final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

        try {
            sesion.beginTransaction();

            final StringBuilder sb = new StringBuilder("from Persona Where 1=1");
            if (!nombre.isEmpty()) {
                sb.append(" and PER_NOM in (select nombre from Persona where per_nom like :nombre)");
            }
            if (!apellidos.isEmpty()) {
                sb.append(" and PER_APE like :apellidos");
            }
            if (!dni.isEmpty()) {
                sb.append(" and PER_DNI = :dni");
            }
            if (estadoCivil != null) {
                sb.append(" and PER_ECV = :estadoCivil");
            }
            if (login != null && !login.isEmpty()) {
                sb.append(" and USU_LOG = :login");
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
                consulta.setParameter("estadoCivil", estadoCivil.ordinal());
            }
            if (login != null && !login.isEmpty()) {
                consulta.setParameter("login", login);
            }

            return consulta.list();
        } catch (Exception e) {
            System.out.println("Se ha producido un error creando una persona: " + e.getMessage());
            sesion.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            sesion.close();
        }
    }
}
