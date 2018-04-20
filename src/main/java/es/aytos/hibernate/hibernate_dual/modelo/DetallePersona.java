package es.aytos.hibernate.hibernate_dual.modelo;

import java.io.*;

import javax.persistence.*;

@Entity
@Table(name = "A_DPER")
public class DetallePersona implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "DPER_ID")
    private int idUsuario;

    @Column(name = "DPER_HIJ", nullable = false)
    private boolean hijos;

    @Column(name = "DPER_DEP", nullable = false)
    private boolean deporte;

    @Column(name = "DPER_MSC", nullable = false)
    private boolean mascotas;

    @OneToOne
    @JoinColumn(name = "idPersona")
    private Persona persona;

    public DetallePersona() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public boolean isHijos() {
        return hijos;
    }

    public void setHijos(boolean hijos) {
        this.hijos = hijos;
    }

    public boolean isDeporte() {
        return deporte;
    }

    public void setDeporte(boolean deporte) {
        this.deporte = deporte;
    }

    public boolean isMascotas() {
        return mascotas;
    }

    public void setMascotas(boolean mascotas) {
        this.mascotas = mascotas;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
