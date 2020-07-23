package co.com.ceiba.julian.diaz.dominio.modelo;

import org.junit.Test;

import co.com.ceiba.julian.diaz.dominio.BasePrueba;
import co.com.ceiba.julian.diaz.dominio.excepcion.ExcepcionValorObligatorio;
import co.com.ceiba.julian.diaz.dominio.testdatabuilder.ProgramarTestDataBuilder;

public class ProgramarTest {

	@Test
	public void validarUsuarioObligatorio() {
		//Arrange
		ProgramarTestDataBuilder peliculaTestDataBuilder = new ProgramarTestDataBuilder();
		peliculaTestDataBuilder.conIdUsuario(null);
		//Act - Assert
		BasePrueba.assertThrows(() -> peliculaTestDataBuilder.build(),ExcepcionValorObligatorio.class,"El Usuario se debe ingresar");
	}
	
}
