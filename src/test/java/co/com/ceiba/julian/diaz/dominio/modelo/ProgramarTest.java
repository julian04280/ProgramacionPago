package co.com.ceiba.julian.diaz.dominio.modelo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import co.com.ceiba.julian.diaz.dominio.BasePrueba;
import co.com.ceiba.julian.diaz.dominio.excepcion.ExcepcionFecha;
import co.com.ceiba.julian.diaz.dominio.excepcion.ExcepcionHora;
import co.com.ceiba.julian.diaz.dominio.excepcion.ExcepcionValorObligatorio;
import co.com.ceiba.julian.diaz.dominio.modelo.entidad.Programar;
import co.com.ceiba.julian.diaz.dominio.testdatabuilder.ProgramarTestDataBuilder;

public class ProgramarTest {

	@Test
	public void validarUsuarioObligatorio() {
		//Arrange
		ProgramarTestDataBuilder programarTestDataBuilder = new ProgramarTestDataBuilder();
		programarTestDataBuilder.conIdUsuario(null);
		//Act - Assert
		BasePrueba.assertThrows(() -> programarTestDataBuilder.build(),ExcepcionValorObligatorio.class,"El Usuario se debe ingresar");
	}
	
	@Test
	public void validarFechaProgramadaObligatorio() {
		//Arrange
		ProgramarTestDataBuilder programarTestDataBuilder = new ProgramarTestDataBuilder();
		programarTestDataBuilder.conFechaProgramada(null);
		//Act - Assert
		BasePrueba.assertThrows(() -> programarTestDataBuilder.build(),ExcepcionValorObligatorio.class,"La fecha de programacion de pago se debe ingresar");
	}
	
	@Test
	public void validarHoraProgramadaObligatorio() {
		//Arrange
		ProgramarTestDataBuilder programarTestDataBuilder = new ProgramarTestDataBuilder();
		programarTestDataBuilder.conHoraProgramada(null);
		//Act - Assert
		BasePrueba.assertThrows(() -> programarTestDataBuilder.build(),ExcepcionValorObligatorio.class,"La hora de programacion de pago se debe ingresar");
	}
	
	@Test
	public void validarValorObligatorio() {
		//Arrange
		ProgramarTestDataBuilder programarTestDataBuilder = new ProgramarTestDataBuilder();
		programarTestDataBuilder.conValor(null);
		//Act - Assert
		BasePrueba.assertThrows(() -> programarTestDataBuilder.build(),ExcepcionValorObligatorio.class,"El valor a pagar se debe ingresar");
	}
	
	@Test
	public void validarFechaProgramadaSabado() {
		//Arrange
		ProgramarTestDataBuilder programarTestDataBuilder = new ProgramarTestDataBuilder();
		programarTestDataBuilder.conFechaProgramada("2020-08-01");
		
		//Act 
		Programar programar = programarTestDataBuilder.build();
		//Assert
		assertThat(programar.getFechaProgramada()).isEqualTo("2020-08-03");
	}
	
	@Test
	public void validarFechaProgramadaDomingo() {
		//Arrange
		ProgramarTestDataBuilder programarTestDataBuilder = new ProgramarTestDataBuilder();
		programarTestDataBuilder.conFechaProgramada("2020-08-02");
		
		//Act 
		Programar programar = programarTestDataBuilder.build();
		//Assert
		assertThat(programar.getFechaProgramada()).isEqualTo("2020-08-03");
	}
	
	@Test
	public void validarFechaProgramadaFestivo() {
		//Arrange
		ProgramarTestDataBuilder programarTestDataBuilder = new ProgramarTestDataBuilder();
		programarTestDataBuilder.conFechaProgramada("2020-08-07");
		
		//Act 
		Programar programar = programarTestDataBuilder.build();
		//Assert
		assertThat(programar.getCostoTransaccion()).isEqualTo(1.0);
	}
	
	@Test
	public void validarIntervaloHora() {
		//Arrange
		ProgramarTestDataBuilder programarTestDataBuilder = new ProgramarTestDataBuilder();
		programarTestDataBuilder.conHoraProgramada("07:50:30");
		//Act - Assert
		BasePrueba.assertThrows(() -> programarTestDataBuilder.build(),ExcepcionHora.class,"El valor de la hora debe estar entre las 8am y 17pm");
	}
	
	@Test
	public void validarFechaProgramadaInvalida() {
		//Arrange
		ProgramarTestDataBuilder programarTestDataBuilder = new ProgramarTestDataBuilder();
		programarTestDataBuilder.conFechaProgramada("2020/08/01");
		
		//Act - Assert
		BasePrueba.assertThrows(() -> programarTestDataBuilder.build(),ExcepcionFecha.class,"El valor de la fecha no se puede convertir");
	}
	
	@Test
	public void validarFechaIngreso() {
		//Arrange
		ProgramarTestDataBuilder programarTestDataBuilder = new ProgramarTestDataBuilder();
		programarTestDataBuilder.conFechaIngreso("2020-08-01");
		
		//Act 
		Programar programar = programarTestDataBuilder.build();

		//Assert
		assertThat(programar.getFechaIngreso()).isEqualTo("2020-08-01");
	}
	
	@Test
	public void validarNombre() {
		//Arrange
		ProgramarTestDataBuilder programarTestDataBuilder = new ProgramarTestDataBuilder();
		programarTestDataBuilder.conNombre("Servicios Publicos");
		
		//Act 
		Programar programar = programarTestDataBuilder.build();

		//Assert
		assertThat(programar.getNombre()).isEqualTo("Servicios Publicos");
	}
	
}
