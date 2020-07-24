package co.com.ceiba.julian.diaz.dominio.testdatabuilder;

import co.com.ceiba.julian.diaz.dominio.modelo.entidad.Programar;

public class ProgramarTestDataBuilder {

	private Double valor;
	private String nombre;
    private String idUsuario;
	private String fechaIngreso;
	private String fechaProgramada;
	private String horaProgramada;
	
	
	public ProgramarTestDataBuilder(){
		this.valor = 50.0;
		this.nombre = "Servicio Agua";
		this.idUsuario = "1018463059";
		this.fechaIngreso = "2020-07-22";
		this.fechaProgramada = "2020-08-03";
		this.horaProgramada = "16:25:10";
		
	}
	
	public ProgramarTestDataBuilder conValor(Double valor) {
		this.valor = valor;
		return this;
	}
	
	public ProgramarTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}
	
	public ProgramarTestDataBuilder conIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
		return this;
	}
	
	public ProgramarTestDataBuilder conFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
		return this;
	}
	
	public ProgramarTestDataBuilder conFechaProgramada(String fechaProgramada) {
		this.fechaProgramada = fechaProgramada;
		return this;
	}
	
	public ProgramarTestDataBuilder conHoraProgramada(String horaProgramada) {
		this.horaProgramada = horaProgramada;
		return this;
	}
	
	public Programar build() {
		return new Programar(valor,nombre,idUsuario,fechaIngreso,fechaProgramada,horaProgramada);
	}
}
