package HybernateProyect.HybernateProyect.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "A_Tlf")
public class Telefono {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
	@GenericGenerator(name = "product_generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = "sequence_name", value = "product_sequence"),
			@Parameter(name = "initial_value", value = "1000"),
			@Parameter(name = "increment_size", value = "4"),
			@Parameter(name = "optimizer", value = "pooled-lo") })
	@Column(name = "TLF_ID")
	private Integer idTlf;

	@Column(name = "TLF_NUM", nullable = false)
	private String numTlf;

	public Integer getIdTlf() {
		return idTlf;
	}

	public void setIdTlf(Integer idTlf) {
		this.idTlf = idTlf;
	}

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
