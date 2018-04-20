package es.aytos.hibernate.hibernate_dual.modelo;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "A_AFI")
public class Aficion {

    @Id
    @Column(name = "AFI_ID")
    private int idAficion;

    @Column(name = "AFI_NOM", nullable = false)
    private String aficion;

    @ManyToMany(mappedBy = "aficiones")
    private List<Persona> personas;

    public Aficion() {
    }

    public int getIdAficion() {
        return idAficion;
    }

    public void setIdAficion(int idAficion) {
        this.idAficion = idAficion;
    }

    public String getAficion() {
        return aficion;
    }

    public void setAficion(String aficion) {
        this.aficion = aficion;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

}
