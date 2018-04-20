package es.aytos.hibernate.hibernate_dual.pruebas;

import java.util.*;

import es.aytos.hibernate.hibernate_dual.modelo.*;
import es.aytos.hibernate.hibernate_dual.repositorio.*;

public class PruebasPersona {

    public static void main(String[] args) {
        final Integer idPersona = crearPersona("12345688L", "jaa34");
        // eliminarPersona(idPersona);
        // modificarPersona(idPersona);
        consultarPersona(idPersona);
        // consultarPersona("", "", "", null, "login_modificado");
    }

    private static Integer crearPersona(String dni, String login) {
        final Persona persona = new Persona();
        persona.setNombre("Joaquín");
        persona.setApellidos("Álvarez Álvarez");
        persona.setEdad(31);
        persona.setEstadoCivil(EstadoCivil.CASADO);
        persona.setDni(dni);
        persona.setFechaAlta(new Date());
        persona.setLogin(login);
        persona.setPassword("jaa");
        persona.setGenero(Genero.MASCULINO);

        final Direccion direccion1 = new Direccion();
        direccion1.setProvincia("Sevilla");
        direccion1.setCiudad("Écija");
        direccion1.setCodigoPostal("41420");
        direccion1.setDireccion("Calle metalurgia");
        direccion1.setNumero(2);
        direccion1.setPersonas(Arrays.asList(persona));

        final Direccion direccion2 = new Direccion();
        direccion2.setProvincia("Sevilla");
        direccion2.setCiudad("Écija");
        direccion2.setCodigoPostal("41400");
        direccion2.setDireccion("Calle Invernalia");
        direccion2.setNumero(2);
        direccion2.setPersonas(Arrays.asList(persona));

        final Telefono telefono = new Telefono();
        telefono.setTelefono("954837770");
        telefono.setPersona(persona);

        persona.setDirecciones(Arrays.asList(direccion1, direccion2));
        persona.setTelefonos(new HashSet<>(Arrays.asList(telefono)));

        return RepositorioPersona.crearPersona(persona);
    }

    private static void modificarPersona(Integer idPersona) {
        final Persona persona = new Persona();
        persona.setNombre("Joaquín2");
        persona.setApellidos("Álvarez Álvarez2");
        persona.setEdad(31);
        persona.setEstadoCivil(EstadoCivil.CASADO);
        persona.setDni("56489632L");
        persona.setFechaAlta(new Date());
        persona.setPassword("jaa");
        persona.setLogin("login_modificado");
        persona.setIdUsuario(idPersona);

        RepositorioPersona.modificarPersona(persona);
    }

    private static void eliminarPersona(final Integer idPersona) {
        RepositorioPersona.eliminarPersona(idPersona);
    }

    private static void consultarPersona(final Integer idPersona) {
        final Persona persona = RepositorioPersona.consultarNombreCompleto(idPersona);
        // System.out.println(persona.getNombre());
        // System.out.println(persona.getApellidos());
        // System.out.println(persona.getEstadoCivil());
        // System.out.println(persona.getEdad());
        // System.out.println(persona.getDni());
        // System.out.println(persona.getTelefonos());
        System.out.println(persona.getGenero().getCodigo());
        persona.getTelefonos().stream().map(Telefono::getTelefono).forEach(System.out::println);
    }

    private static void consultarPersona(String nombre, String apellidos, String dni, EstadoCivil estadoCivil,
            String login) {
        final List<Persona> personas = RepositorioPersona.consultar(nombre, apellidos, dni, estadoCivil, login);

        System.out.println(personas.size());
    }
}
