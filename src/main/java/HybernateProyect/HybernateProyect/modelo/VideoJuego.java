package HybernateProyect.HybernateProyect.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name="A_VDJ")
public class VideoJuego implements Serializable {
	@Id
	@GeneratedValue
	@Column(name = "VDJ_ID")
	private int idJuego;
	
	@Column(name = "VDJ_NOM", nullable=false, length=50)
	private String nombre;
	
	@Column(name = "VDJ_DES", nullable=false, length=350)
	private String Descripcion;
	
	@Column(name = "VDJ_FEC", nullable = false)
	private Date fechaDeSalidad;
	
	@Column(name = "VDJ_PLAT", nullable = false)
	private Plataformas plataforma;
	
	public VideoJuego() {
		
	}

	public int getIdJuego() {
		return idJuego;
	}

	public void setIdJuego(int idJuego) {
		this.idJuego = idJuego;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public Date getFechaDeSalidad() {
		return fechaDeSalidad;
	}

	public void setFechaDeSalidad(Date fechaDeSalidad) {
		this.fechaDeSalidad = fechaDeSalidad;
	}

	public Plataformas getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(Plataformas plataforma) {
		this.plataforma = plataforma;
	}
	
	
	
	
}
