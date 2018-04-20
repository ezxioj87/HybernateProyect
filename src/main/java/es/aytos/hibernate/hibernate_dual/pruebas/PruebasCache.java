package es.aytos.hibernate.hibernate_dual.pruebas;

import java.util.*;

import es.aytos.hibernate.hibernate_dual.modelo.*;
import es.aytos.hibernate.hibernate_dual.repositorio.*;

public class PruebasCache {

    public static void main(String[] args) {
        consultarAficiones();
        consultarAficiones();
    }

    private static void consultarAficiones() {
        final List<Aficion> aficiones = RepositorioAficion.consultarAficiones();

        aficiones.stream().map(Aficion::getAficion).forEach(System.out::println);

    }
}
