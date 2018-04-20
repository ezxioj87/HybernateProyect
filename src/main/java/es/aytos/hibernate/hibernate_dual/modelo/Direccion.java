package es.aytos.hibernate.hibernate_dual.modelo;

import java.io.*;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "A_DIR")
public class Direccion implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "DIR_ID")
    private Integer idDireccion;

    @Column(name = "DIR_PRO")
    private String provincia;

    @Column(name = "DIR_CIU")
    private String ciudad;

    @Column(name = "DIR_CP")
    private String codigoPostal;

    @Column(name = "DIR_DIR")
    private String direccion;

    @Column(name = "DIR_NUM")
    private Integer numero;

    @Column(name = "DIR_BLQ")
    private Integer bloque;

    @Column(name = "DIR_PLT")
    private Integer planta;

    @Column(name = "DIR_PUR")
    private String puerta;

    @ManyToMany(mappedBy = "direcciones")
    private List<Persona> personas;

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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
}
