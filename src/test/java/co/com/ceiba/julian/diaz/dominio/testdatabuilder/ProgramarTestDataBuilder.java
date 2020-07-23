package co.com.ceiba.julian.diaz.dominio.testdatabuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import co.com.ceiba.julian.diaz.dominio.modelo.entidad.Programar;

public class ProgramarTestDataBuilder {

	private Double valor;
    private String idUsuario;
	private Date fechaIngreso;
	private Date fechaProgramada;
	private String horaProgramada;
	
	
	public ProgramarTestDataBuilder(){
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
	
	public ProgramarTestDataBuilder conValor(Double valor) {
		this.valor = valor;
		return this;
	}
	
	public ProgramarTestDataBuilder conIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
		return this;
	}
	
	public ProgramarTestDataBuilder conFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
		return this;
	}
	
	public ProgramarTestDataBuilder conFechaProgramada(Date fechaProgramada) {
		this.fechaProgramada = fechaProgramada;
		return this;
	}
	
	public ProgramarTestDataBuilder conHoraProgramada(String horaProgramada) {
		this.horaProgramada = horaProgramada;
		return this;
	}
	
	public Programar build() {
		return new Programar(valor,idUsuario,fechaIngreso,fechaProgramada,horaProgramada);
	}
}
