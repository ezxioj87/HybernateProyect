package es.aytos.hibernate.hibernate_dual.modelo;

import java.util.*;

import javax.persistence.*;

import es.aytos.hibernate.hibernate_dual.conversores.*;

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
    @Enumerated
    private EstadoCivil estadoCivil;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Direccion> direcciones;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "persona", fetch = FetchType.EAGER)
    private Set<Telefono> telefonos;

    private DetallePersona detallePersona;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE })
    private List<Aficion> aficiones;

    @Column(name = "PER_GEN", nullable = false, length = 1)
    @Convert(converter = ConversorGenero.class)
    private Genero genero;

    public Persona() {
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

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public Set<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(Set<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    public DetallePersona getDetallePersona() {
        return detallePersona;
    }

    public void setDetallePersona(DetallePersona detallePersona) {
        this.detallePersona = detallePersona;
    }

    public List<Aficion> getAficiones() {
        return aficiones;
    }

    public void setAficiones(List<Aficion> aficiones) {
        this.aficiones = aficiones;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

}
