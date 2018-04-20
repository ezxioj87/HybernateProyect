package HybernateProyect.HybernateProyect.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "A_DTL")
public class DetallesPersona {

	@Id
	@GeneratedValue
	@Column(name = "DTL_ID")
	private Integer idDtl;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_PER")
	private Persona persona;

	@Column(name = "DTL_HIJ", nullable = false)
	private boolean tieneHijos;

	@Column(name = "DTL_MAS", nullable = false)
	private boolean tieneMascota;

	@Column(name = "DTL_DEP", nullable = false)
	private boolean haceDeporte;

	public Integer getIdDtl() {
		return idDtl;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public void setIdDtl(Integer idDtl) {
		this.idDtl = idDtl;
	}

	public boolean isTieneHijos() {
		return tieneHijos;
	}

	public void setTieneHijos(boolean tieneHijos) {
		this.tieneHijos = tieneHijos;
	}

	public boolean isTieneMascota() {
		return tieneMascota;
	}

	public void setTieneMascota(boolean tieneMascota) {
		this.tieneMascota = tieneMascota;
	}

	public boolean isHaceDeporte() {
		return haceDeporte;
	}

	public void setHaceDeporte(boolean haceDeporte) {
		this.haceDeporte = haceDeporte;
	}

}
