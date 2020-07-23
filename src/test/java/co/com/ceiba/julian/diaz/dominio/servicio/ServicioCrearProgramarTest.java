package co.com.ceiba.julian.diaz.dominio.servicio;

import org.junit.Test;
import org.mockito.Mockito;

import co.com.ceiba.julian.diaz.dominio.BasePrueba;
import co.com.ceiba.julian.diaz.dominio.excepcion.ExcepcionDuplicidad;
import co.com.ceiba.julian.diaz.dominio.modelo.entidad.Programar;
import co.com.ceiba.julian.diaz.dominio.puerto.repositorio.RepositorioProgramar;
import co.com.ceiba.julian.diaz.dominio.servicio.ServicioCrearProgramar;
import co.com.ceiba.julian.diaz.dominio.testdatabuilder.ProgramarTestDataBuilder;



public class ServicioCrearProgramarTest {

	@Test
	public void validarExistenciaPrevia() {
		//Arrange
		Programar programar = new ProgramarTestDataBuilder().build();
		RepositorioProgramar repositorioProgramar = Mockito.mock(RepositorioProgramar.class);
		Mockito.when(repositorioProgramar.existe(Mockito.any())).thenReturn(true);
		//Act
		ServicioCrearProgramar servicioCrearPelicula = new ServicioCrearProgramar(repositorioProgramar);
		//Assert
		BasePrueba.assertThrows(() -> servicioCrearPelicula.ejecutar(programar), ExcepcionDuplicidad.class,"El pago programado ya existe en el sistema");
	}
}
