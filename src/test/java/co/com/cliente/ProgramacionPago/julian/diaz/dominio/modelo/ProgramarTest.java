package co.com.cliente.ProgramacionPago.julian.diaz.dominio.modelo;

import org.junit.Test;

import co.com.cliente.ProgramacionPago.julian.diaz.dominio.BasePrueba;
import co.com.cliente.ProgramacionPago.julian.diaz.dominio.excepcion.ExcepcionValorObligatorio;
import co.com.cliente.ProgramacionPago.julian.diaz.dominio.testdatabuilder.ProgramarTestDataBuilder;

public class ProgramarTest {

	@Test
	public void validarNombreObligatorio() {
		//Arrange
		ProgramarTestDataBuilder peliculaTestDataBuilder = new ProgramarTestDataBuilder();
		peliculaTestDataBuilder.conIdUsuario(null);
		//Act - Assert
		BasePrueba.assertThrows(() -> peliculaTestDataBuilder.build(),ExcepcionValorObligatorio.class,"El usuario es obligatorio.");
	}
	
}
