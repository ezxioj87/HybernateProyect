package es.aytos.hibernate.hibernate_dual.modelo;

import java.io.*;

import javax.persistence.*;

@Entity
@Table(name = "A_TEL")
public class Telefono implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mi-secuencia")
    @SequenceGenerator(name = "mi-secuencia", sequenceName = "mi_secuencia_bbdd", initialValue = 1, allocationSize = 5)
    @Column(name = "TEL_ID")
    private int idUsuario;

    @Column(name = "TEL_NUM", nullable = false, unique = true)
    private String telefono;

    @ManyToOne
    private Persona persona;

    public Telefono() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
