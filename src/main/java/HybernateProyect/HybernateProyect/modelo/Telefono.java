package HybernateProyect.HybernateProyect.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "A_Tlf")
public class Telefono {
	
	@Id
    @GeneratedValue
    @Column(name = "TLF_ID")
	private Integer idTlf;
	
	@Column(name = "TLF_NUM", nullable=false)
	private String numTlf;
	
	@ManyToOne
    private Persona persona;

	public String getNumTlf() {
		return numTlf;
	}

	public void setNumTlf(String numTlf) {
		this.numTlf = numTlf;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	


}
