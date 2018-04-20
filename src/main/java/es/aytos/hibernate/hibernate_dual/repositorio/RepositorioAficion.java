package es.aytos.hibernate.hibernate_dual.repositorio;

import java.util.*;

import org.hibernate.*;

import es.aytos.hibernate.hibernate_dual.modelo.*;
import es.aytos.hibernate.hibernate_dual.util.*;

public class RepositorioAficion {

    public static List<Aficion> consultarAficiones() {
        final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

        try {
            sesion.beginTransaction();

            return sesion.createQuery("from Aficion").setCacheable(true).list();

        } catch (Exception e) {
            System.out.println("Se ha producido un error insertando la persona: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            sesion.close();
        }
    }
}
