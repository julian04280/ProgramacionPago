package co.com.ceiba.julian.diaz.dominio.modelo;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.SimpleDateFormat;

import org.junit.Test;

import co.com.ceiba.julian.diaz.dominio.BasePrueba;
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
		BasePrueba.assertThrows(() -> programarTestDataBuilder.build(),ExcepcionValorObligatorio.class,"La fecha de programación de pago se debe ingresar");
	}
	
	@Test
	public void validarHoraProgramadaObligatorio() {
		//Arrange
		ProgramarTestDataBuilder programarTestDataBuilder = new ProgramarTestDataBuilder();
		programarTestDataBuilder.conHoraProgramada(null);
		//Act - Assert
		BasePrueba.assertThrows(() -> programarTestDataBuilder.build(),ExcepcionValorObligatorio.class,"La hora de programación de pago se debe ingresar");
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
	public void validarFechaProgramadaSabado() throws Exception {
		//Arrange
		ProgramarTestDataBuilder programarTestDataBuilder = new ProgramarTestDataBuilder();
		programarTestDataBuilder.conFechaProgramada(new SimpleDateFormat("yyyy-MM-dd").parse("2020-08-01"));
		
		//Act 
		Programar programar = programarTestDataBuilder.build();
		//Assert
		assertThat(programar.getFechaProgramada()).isEqualTo(new SimpleDateFormat("yyyy-MM-dd").parse("2020-08-03"));
	}
	
	@Test
	public void validarFechaProgramadaDomingo() throws Exception {
		//Arrange
		ProgramarTestDataBuilder programarTestDataBuilder = new ProgramarTestDataBuilder();
		programarTestDataBuilder.conFechaProgramada(new SimpleDateFormat("yyyy-MM-dd").parse("2020-08-02"));
		
		//Act 
		Programar programar = programarTestDataBuilder.build();
		//Assert
		assertThat(programar.getFechaProgramada()).isEqualTo(new SimpleDateFormat("yyyy-MM-dd").parse("2020-08-03"));
	}
	
	@Test
	public void validarFechaProgramadaFestivo() throws Exception {
		//Arrange
		ProgramarTestDataBuilder programarTestDataBuilder = new ProgramarTestDataBuilder();
		programarTestDataBuilder.conFechaProgramada(new SimpleDateFormat("yyyy-MM-dd").parse("2020-08-07"));
		
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
	
}
