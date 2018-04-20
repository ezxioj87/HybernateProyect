package HybernateProyect.HybernateProyect.conversores;

import javax.persistence.AttributeConverter;

import HybernateProyect.HybernateProyect.modelo.Genero;

public class ConversorGenero implements AttributeConverter<Genero, String>{

	@Override
	public String convertToDatabaseColumn(Genero genero) {
		return genero.getCodigo();
	}

	@Override
	public Genero convertToEntityAttribute(String generoBBDD) {
		return Genero.getEnumerado(generoBBDD);
	}
}
