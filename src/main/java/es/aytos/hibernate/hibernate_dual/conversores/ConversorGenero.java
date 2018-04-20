package es.aytos.hibernate.hibernate_dual.conversores;

import javax.persistence.*;

import es.aytos.hibernate.hibernate_dual.modelo.*;

public class ConversorGenero implements AttributeConverter<Genero, String> {

    @Override
    public String convertToDatabaseColumn(Genero genero) {
        return genero.getCodigo();
    }

    @Override
    public Genero convertToEntityAttribute(String generoBBDD) {
        return Genero.getEnumerado(generoBBDD);
    }

}
