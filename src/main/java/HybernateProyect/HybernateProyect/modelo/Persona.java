package HybernateProyect.HybernateProyect.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "A_PER")
public class Persona  extends Usuario{


	
	@Column(name = "PER_NOM", nullable=false, length=50)
	private String nombre;
	
	@Column(name = "PER_APE", nullable=false, length=250)
	private String apellidos;
	
	@Column(name = "PER_DNI", nullable=false, length=9, unique=true)
	private String dni;
	
	@Column(name = "PER_EDA", nullable=false)
	private Integer edad;
	
	@Column(name = "PER_ECV", nullable = false)
	@Enumerated(value=EnumType.ORDINAL)
	private EstadoCivil estadoCivil;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Direccion> direcciones = new ArrayList<>();
	
	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Telefono> telefonos = new ArrayList<>();
	
	 @OneToOne
	 @JoinColumn(name = "detalles_id")
	 private DetallesPersona detalles;
	
	public Persona() {
	}

	 public List<Telefono> getPhones() {
	        return telefonos;
	    }

	    public void addPhone(Telefono phone) {
	        telefonos.add( phone );
	        phone.setPersona( this );
	    }

	    public void removePhone(Telefono phone) {
	    	telefonos.remove( phone );
	        phone.setPersona( null );
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
	        direcciones.add( address );
	        address.getPropietarios().add( this );
	    }

	    public void removeAddress(Direccion address) {
	    	direcciones.remove( address );
	    	address.getPropietarios().remove( this );
	    }
	
	    public DetallesPersona getDetails() {
	        return detalles;
	    }

	    public void setDetails(DetallesPersona details) {
	        this.detalles = details;
	    }
	    
	    
	
	
}
