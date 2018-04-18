package HybernateProyect.HybernateProyect.Pruebas;

import java.util.Date;
import java.util.List;

import HybernateProyect.HybernateProyect.modelo.EstadoCivil;
import HybernateProyect.HybernateProyect.modelo.Persona;
import HybernateProyect.HybernateProyect.modelo.Plataformas;
import HybernateProyect.HybernateProyect.modelo.VideoJuego;
import HybernateProyect.HybernateProyect.repositorio.ReposiorioPersona;
import HybernateProyect.HybernateProyect.repositorio.RepositorioVideoJuego;
public class Pruebas {

	public static void main(String[] args) {
		consultarPersona("%a%","","",EstadoCivil.SOLTERO);
	}

	private static Integer crearPersona() {
		final Persona persona = new Persona();
		persona.setNombre("Juan de Dios");
		persona.setApellidos("Bermudo Delgado");
		persona.setEdad(18);
		persona.setEstadoCivil(EstadoCivil.SOLTERO);
		persona.setDni("12345578A");
		return ReposiorioPersona.crearPersona(persona);

	}
	
	private static void modificarPersona() {
		final Persona persona = new Persona();
		persona.setNombre("Juan de dios");
		persona.setApellidos("Bermudo Delgado");
		persona.setEdad(18);
		persona.setEstadoCivil(EstadoCivil.CASDO);
		persona.setDni("12345578A");	
		
		ReposiorioPersona.modificarPersona2(persona);

	}
	
	private static void eliminarPersona(final Integer idPersona) {
		ReposiorioPersona.eliminarPersona(idPersona);

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
	
	private static void consultarPersona(String nombre, String apellidos, String dni, EstadoCivil estadoCivil) {
		final List<Persona> personas=ReposiorioPersona.consultar(nombre, apellidos, dni, estadoCivil);
		System.out.println(personas.size()); 
	}
	

}
