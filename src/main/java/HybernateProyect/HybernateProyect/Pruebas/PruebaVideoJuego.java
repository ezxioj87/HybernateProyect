package HybernateProyect.HybernateProyect.Pruebas;

import java.util.Date;

import HybernateProyect.HybernateProyect.modelo.Plataformas;
import HybernateProyect.HybernateProyect.modelo.VideoJuego;
import HybernateProyect.HybernateProyect.repositorio.RepositorioVideoJuego;

public class PruebaVideoJuego {
	
	private static Integer crearVideoJuego() {
		final VideoJuego videoJuego = new VideoJuego();
		videoJuego.setNombre("God of War");
		videoJuego.setPlataforma(Plataformas.PS4);
		videoJuego.setFechaDeSalidad(new Date());
		videoJuego.setDescripcion("El dios de la guerra.....");
		return RepositorioVideoJuego.crearVideoJuego(videoJuego);

	}
}
