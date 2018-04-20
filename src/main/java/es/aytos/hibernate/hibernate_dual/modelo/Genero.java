package es.aytos.hibernate.hibernate_dual.modelo;

import java.util.*;

public enum Genero {

    MASCULINO("M"), FEMENINO("F");

    private String codigo;

    private Genero(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public static Genero getEnumerado(String valor) {
        return Arrays.asList(values()).stream().filter(genero -> genero.getCodigo().equals(valor)).findAny()
                .orElse(null);
    }

}
