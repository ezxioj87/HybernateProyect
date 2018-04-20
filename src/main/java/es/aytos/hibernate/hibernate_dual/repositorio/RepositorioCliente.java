package es.aytos.hibernate.hibernate_dual.repositorio;

import java.util.*;

import org.hibernate.*;

import es.aytos.hibernate.hibernate_dual.modelo.*;
import es.aytos.hibernate.hibernate_dual.util.*;

public class RepositorioCliente {

    public static Integer crearCliente(final Cliente cliente) {
        final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

        try {
            sesion.beginTransaction();

            final Integer idCliente = (Integer)sesion.save(cliente);

            sesion.getTransaction().commit();

            return idCliente;

        } catch (Exception e) {
            System.out.println("Se ha producido un error insertando la cliente: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            sesion.close();
        }
    }

    public static void modificarCliente(Cliente cliente) {
        final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

        try {
            sesion.beginTransaction();

            sesion.saveOrUpdate(cliente);

            sesion.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("Se ha producido un error creando una cliente: " + e.getMessage());
            sesion.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            sesion.close();
        }
    }

    public static void eliminarCliente(Integer idCliente) {
        final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

        try {
            sesion.beginTransaction();

            sesion.createQuery("delete Usuario where usu_id = :idCliente").setParameter("idCliente", idCliente)
                    .executeUpdate();

            sesion.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("Se ha producido un error creando una cliente: " + e.getMessage());
            sesion.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            sesion.close();
        }
    }

    public static Cliente consultarNombreCompleto(Integer idCliente) {
        final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

        try {
            sesion.beginTransaction();

            return (Cliente)sesion.createQuery("from Usuario Usu where Usu.idUsuario = :idCliente")
                    .setParameter("idCliente", idCliente).uniqueResult();

        } catch (Exception e) {
            System.out.println("Se ha producido un error creando una cliente: " + e.getMessage());
            sesion.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            sesion.close();
        }
    }

    public static List<Cliente> consultar(String nombre, String apellidos, String dni, EstadoCivil estadoCivil,
            String login) {
        final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

        try {
            sesion.beginTransaction();

            final StringBuilder sb = new StringBuilder("from Cliente Where 1=1");
            if (!nombre.isEmpty()) {
                sb.append(" and CLI_NOM in (select nombre from Cliente where per_nom like :nombre)");
            }
            if (!apellidos.isEmpty()) {
                sb.append(" and CLI_APE like :apellidos");
            }
            if (!dni.isEmpty()) {
                sb.append(" and CLI_DNI = :dni");
            }
            if (estadoCivil != null) {
                sb.append(" and CLI_ECV = :estadoCivil");
            }
            if (login != null && !login.isEmpty()) {
                sb.append(" and USU_LOG = :login");
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
                consulta.setParameter("estadoCivil", estadoCivil.ordinal());
            }
            if (login != null && !login.isEmpty()) {
                consulta.setParameter("login", login);
            }

            return consulta.list();
        } catch (Exception e) {
            System.out.println("Se ha producido un error creando una Cliente: " + e.getMessage());
            sesion.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            sesion.close();
        }
    }
}
