package es.aytos.hibernate.hibernate_dual.pruebas;

import java.util.*;

import es.aytos.hibernate.hibernate_dual.modelo.*;
import es.aytos.hibernate.hibernate_dual.repositorio.*;

public class PruebasCliente {

    public static void main(String[] args) {
        final Integer idCliente = crearCliente("12345678L", "jaa");
        // eliminarCliente(idCliente);
        modificarCliente(idCliente);
        consultarCliente(idCliente);
        consultarCliente("", "", "", null, "login_modificado");
    }

    private static Integer crearCliente(String dni, String login) {
        final Cliente cliente = new Cliente();
        cliente.setNombre("Joaquín");
        cliente.setApellidos("Álvarez Álvarez");
        cliente.setEdad(31);
        cliente.setEstadoCivil(EstadoCivil.CASADO);
        cliente.setDni(dni);
        cliente.setFechaAlta(new Date());
        cliente.setLogin(login);
        cliente.setPassword("jaa");

        return RepositorioCliente.crearCliente(cliente);
    }

    private static void modificarCliente(Integer idCliente) {
        final Cliente cliente = new Cliente();
        cliente.setNombre("Joaquín2");
        cliente.setApellidos("Álvarez Álvarez2");
        cliente.setEdad(31);
        cliente.setEstadoCivil(EstadoCivil.CASADO);
        cliente.setDni("56489632L");
        cliente.setFechaAlta(new Date());
        cliente.setLogin("login_modificado");
        cliente.setPassword("jaa");
        cliente.setIdUsuario(idCliente);

        RepositorioCliente.modificarCliente(cliente);
    }

    private static void eliminarCliente(final Integer idCliente) {
        RepositorioCliente.eliminarCliente(idCliente);
    }

    private static void consultarCliente(final Integer idCliente) {
        final Cliente cliente = RepositorioCliente.consultarNombreCompleto(idCliente);
        System.out.println(cliente.getNombre());
        System.out.println(cliente.getApellidos());
        System.out.println(cliente.getEstadoCivil());
        System.out.println(cliente.getEdad());
        System.out.println(cliente.getDni());
    }

    private static void consultarCliente(String nombre, String apellidos, String dni, EstadoCivil estadoCivil,
            String login) {
        final List<Cliente> clientes = RepositorioCliente.consultar(nombre, apellidos, dni, estadoCivil, login);

        System.out.println(clientes.size());
    }
}
