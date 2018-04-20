package HybernateProyect.HybernateProyect.Pruebas;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import HybernateProyect.HybernateProyect.modelo.Cliente;
import HybernateProyect.HybernateProyect.modelo.DetallesPersona;
import HybernateProyect.HybernateProyect.modelo.Direccion;
import HybernateProyect.HybernateProyect.modelo.EstadoCivil;
import HybernateProyect.HybernateProyect.modelo.Genero;
import HybernateProyect.HybernateProyect.modelo.Persona;
import HybernateProyect.HybernateProyect.modelo.Plataformas;
import HybernateProyect.HybernateProyect.modelo.Telefono;
import HybernateProyect.HybernateProyect.modelo.VideoJuego;
import HybernateProyect.HybernateProyect.repositorio.RepositorioCliente;
import HybernateProyect.HybernateProyect.repositorio.RepositorioPersona;
import HybernateProyect.HybernateProyect.repositorio.RepositorioUsuario;
import HybernateProyect.HybernateProyect.repositorio.RepositorioVideoJuego;
public class Pruebas {

	public static void main(String[] args) {
		crearPersona("12345678A","Juan");
//		crearCliente("12845678","Dani");
//		crearPersona("12345678D","Miguel");
//		crearCliente("12349678B","Sergio");
//		crearPersona("12349688B","Sergi");
//		eliminarUsuario(1);		eliminarPersona(1);
//		eliminarUsuario(2);
//		modificarPersona("Juan",3);
//		modificarCliente("Largo",4);
		consultarPersona(1);
	}

	private static Integer crearPersona(String dni,String login) {
		final Persona persona = new Persona();
		persona.setNombre("Juan de Dios");
		persona.setApellidos("Bermudo Delgado");
		persona.setEdad(18);
		persona.setEstadoCivil(EstadoCivil.SOLTERO);
		persona.setDni(dni);
		persona.setFechaAlta(new Date());
		persona.setLogin(login);
		persona.setPassword("12345");
		persona.setGenero(Genero.MASCULINO);
		
		Direccion direccion1 = new Direccion();
		direccion1.setProvincia("Sevilla");
		direccion1.setCodigoPostal("41400");
		direccion1.setCiudad("Ecija");
		direccion1.setCalle("Calle Pepito");
		direccion1.setNumero(1);
		direccion1.setPropietarios(Arrays.asList(persona));
		

//		persona.addDireccion(direccion1);
		
		DetallesPersona detalle1 = new DetallesPersona();
		detalle1.setHaceDeporte(true);
		detalle1.setTieneHijos(false);
		detalle1.setTieneMascota(false);
		persona.setDetails(detalle1);
		detalle1.setPersona(persona);
		Direccion direccion2 = new Direccion();
		direccion2.setProvincia("Sevilla");
		direccion2.setCodigoPostal("41400");
		direccion2.setCiudad("Ecija");
		direccion2.setCalle("Calle Juanito");
		direccion2.setNumero(2);
		direccion2.setPropietarios(Arrays.asList(persona));
		
		Telefono telefono1 = new Telefono();
		telefono1.setNumTlf("674539246");
		Telefono telefono2 = new Telefono();
		telefono2.setNumTlf("674639246");
		persona.addPhone( telefono1 );
		persona.addPhone(telefono2);
		return RepositorioPersona.crearPersona(persona);

	}
	
	private static Integer crearCliente(String dni,String login) {
		final Cliente persona = new Cliente();
		persona.setNombre("Juan de Dios");
		persona.setApellidos("Bermudo Delgado");
		persona.setEdad(18);
		persona.setEstadoCivil(EstadoCivil.SOLTERO);
		persona.setDni(dni);
		persona.setFechaAlta(new Date());
		persona.setLogin(login);
		persona.setPassword("12345");
		return RepositorioCliente.crearCliente(persona);

	}
	
	private static void modificarPersona(String nombre,Integer idPersona) {
		final Persona persona = new Persona();
		persona.setNombre(nombre);
		persona.setApellidos("Bermudo Delgado");
		persona.setEdad(18);
		persona.setEstadoCivil(EstadoCivil.CASDO);
		persona.setDni("12345578A");

		
		RepositorioPersona.modificarPersona(nombre,idPersona);

	}
	
	private static void modificarCliente(String nombre,Integer idPersona) {
		final Persona persona = new Persona();
		persona.setNombre(nombre);
		persona.setApellidos("Bermudo Delgado");
		persona.setEdad(18);
		persona.setEstadoCivil(EstadoCivil.CASDO);
		persona.setDni("12345578A");

		
		RepositorioUsuario.modificar(nombre,idPersona);

	}
	
	private static void eliminarUsuario(final Integer idPersona) {
		RepositorioUsuario.eliminar(idPersona);

	}
	
	private static void eliminarPersona(final Integer idPersona) {
		RepositorioUsuario.eliminar(idPersona);
	}
	
	private static void eliminarCliente(final Integer idPersona) {
		RepositorioUsuario.eliminar(idPersona);
		RepositorioCliente.eliminarCliente(idPersona);

	}
	
	private static void eliminarVideojuego(final Integer idVideoJuego) {
		RepositorioVideoJuego.eliminarVideoJuego(idVideoJuego);

	}
	
	private static Integer crearVideoJuego() {
		final VideoJuego videoJuego = new VideoJuego();
		videoJuego.setNombre("God of War 2");
		videoJuego.setPlataforma(Plataformas.PS4);
		videoJuego.setFechaDeSalidad(new Date());
		videoJuego.setDescripcion("El dios de la guerra.....");
		return RepositorioVideoJuego.crearVideoJuego(videoJuego);

	}
	
	private static void consultar(String nombre, String apellidos, String dni, EstadoCivil estadoCivil) {
		final List<Persona> personas=RepositorioPersona.consultar(nombre, apellidos, dni, estadoCivil);
		System.out.println(personas.size()); 

	}
	
	public static void consultarPersona(Integer idPersona) {
		Persona persona = RepositorioPersona.consultarPersona(idPersona);
		System.out.println(persona.getNombre());
		System.out.println(persona.getApellidos());
		System.out.println(persona.getDni());
		System.out.println(persona.getEstadoCivil());
		persona.getTelefonos().stream().forEach(telefono -> System.out.println(telefono.getIdTlf()));
		System.out.println(persona.getGenero());
}
	

	

}
