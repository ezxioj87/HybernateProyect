package HybernateProyect.HybernateProyect.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import HybernateProyect.HybernateProyect.conversores.ConversorGenero;

@Entity
@Table(name = "A_PER")
public class Persona extends Usuario {

	@Column(name = "PER_NOM", nullable = false, length = 50)
	private String nombre;

	@Column(name = "PER_APE", nullable = false, length = 250)
	private String apellidos;

	@Column(name = "PER_DNI", nullable = false, length = 9, unique = true)
	private String dni;

	@Column(name = "PER_EDA", nullable = false)
	private Integer edad;

	@Column(name = "PER_ECV", nullable = false)
	@Enumerated(value = EnumType.ORDINAL)
	private EstadoCivil estadoCivil;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<Direccion> direcciones = new ArrayList<>();

//	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
//	private List<Aficiones> aficiones = new ArrayList<>();

	@Column(name = "PER_GEN", nullable = false, length = 1)
	@Convert(converter = ConversorGenero.class)
	private Genero genero;

	public List<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}
//
//	public List<Aficiones> getAficiones() {
//		return aficiones;
//	}

//	public void setAficiones(List<Aficiones> aficiones) {
//		this.aficiones = aficiones;
//	}

	public DetallesPersona getDetallePersona() {
		return detallePersona;
	}

	public void setDetallePersona(DetallesPersona detallePersona) {
		this.detallePersona = detallePersona;
	}

	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Telefono> telefonos = new ArrayList<>();

	@OneToOne(cascade = CascadeType.ALL)
	private DetallesPersona detallePersona;

	public Persona() {
	}

	public List<Telefono> getTelefonos() {
		return telefonos;
	}

	public void addPhone(Telefono phone) {
		telefonos.add(phone);
		phone.setPersona(this);
	}

	public void removePhone(Telefono phone) {
		telefonos.remove(phone);
		phone.setPersona(null);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public void addDireccion(Direccion address) {
		direcciones.add(address);
		address.getPropietarios().add(this);
	}

	public void removeAddress(Direccion address) {
		direcciones.remove(address);
		address.getPropietarios().remove(this);
	}

	public DetallesPersona getDetails() {
		return detallePersona;
	}

	public void setDetails(DetallesPersona details) {
		this.detallePersona = details;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

}
