package co.com.ceiba.julian.diaz.infraestructura.testdatabuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import co.com.ceiba.julian.diaz.aplicacion.comando.ComandoProgramar;

public class ComandoProgramarTestDataBuilder {

	private Double valor;
    private String idUsuario;
	private Date fechaIngreso;
	private Date fechaProgramada;
	private String horaProgramada;
	
	public ComandoProgramarTestDataBuilder() {
		
		this.valor = 50.0;
		this.idUsuario = "1018463059";
		try {
			this.fechaIngreso = new SimpleDateFormat("yyyy-MM-dd").parse("2020-07-22");
			this.fechaProgramada = new SimpleDateFormat("yyyy-MM-dd").parse("2020-08-03");
		} catch (ParseException e) {
			this.fechaIngreso = new Date();
			this.fechaProgramada = new Date();
		}  
		  
		this.horaProgramada = "16:25:10";
	}
	
	public ComandoProgramarTestDataBuilder conValor(Double valor) {
		this.valor = valor;
		return this;
	}
	
	public ComandoProgramarTestDataBuilder conIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
		return this;
	}
	
	public ComandoProgramarTestDataBuilder conFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
		return this;
	}
	
	public ComandoProgramarTestDataBuilder conFechaProgramada(Date fechaProgramada) {
		this.fechaProgramada = fechaProgramada;
		return this;
	}
	
	public ComandoProgramarTestDataBuilder conHoraProgramada(String horaProgramada) {
		this.horaProgramada = horaProgramada;
		return this;
	}
	
	public ComandoProgramar build() {
		return new ComandoProgramar(valor, idUsuario, fechaIngreso, fechaProgramada, horaProgramada);
	}
}
