package HybernateProyect.HybernateProyect.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity(name = "Direccion")
public class Direccion {
	
	@Id
    @GeneratedValue
	private Integer idDireccion;
	
	@Column(name = "provincia", nullable=false)
	private String provincia;
	
	
	@Column(name = "codigoPostal", nullable=false)
	private String codigoPostal;
	
	@Column(name = "ciudad", nullable=false)
	private String ciudad;
	
	@Column(name = "calle", nullable=false)
	private String calle;
	
	@Column(name = "numero", nullable=false)
	private Integer numero;
	
	@Column(name = "bloque")
	private Integer bloque;
	
	@Column(name = "planta")
	private Integer planta;
	
	@Column(name = "puerta")
	private String puerta;
	
	@ManyToMany(mappedBy = "direcciones")
    private List<Persona> propietarios = new ArrayList<>();
	
	public Direccion() {
		
	}

	public Integer getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(Integer idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public List<Persona> getPropietarios() {
		return propietarios;
	}

	public void setPropietarios(List<Persona> propietarios) {
		this.propietarios = propietarios;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getBloque() {
		return bloque;
	}

	public void setBloque(Integer bloque) {
		this.bloque = bloque;
	}

	public Integer getPlanta() {
		return planta;
	}

	public void setPlanta(Integer planta) {
		this.planta = planta;
	}

	public String getPuerta() {
		return puerta;
	}

	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}
	
	

}
