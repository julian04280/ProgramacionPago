package co.com.ceiba.julian.diaz.infraestructura.testdatabuilder;

import co.com.ceiba.julian.diaz.aplicacion.comando.ComandoProgramar;

public class ComandoProgramarTestDataBuilder {

	private Double valor;
	private String nombre;
    private String idUsuario;
	private String fechaIngreso;
	private String fechaProgramada;
	private String horaProgramada;
	
	public ComandoProgramarTestDataBuilder() {
		
		this.valor = 50.0;
		this.nombre = "Servicio Agua";
		this.idUsuario = "1018463059";
		this.fechaIngreso = "2020-07-22";
		this.fechaProgramada = "2020-08-03";
		this.horaProgramada = "16:25:10";
		
	}
	
	public ComandoProgramarTestDataBuilder conValor(Double valor) {
		this.valor = valor;
		return this;
	}
	
	public ComandoProgramarTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}
	
	public ComandoProgramarTestDataBuilder conIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
		return this;
	}
	
	public ComandoProgramarTestDataBuilder conFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
		return this;
	}
	
	public ComandoProgramarTestDataBuilder conFechaProgramada(String fechaProgramada) {
		this.fechaProgramada = fechaProgramada;
		return this;
	}
	
	public ComandoProgramarTestDataBuilder conHoraProgramada(String horaProgramada) {
		this.horaProgramada = horaProgramada;
		return this;
	}
	
	public ComandoProgramar build() {
		return new ComandoProgramar(valor, nombre, idUsuario, fechaIngreso, fechaProgramada, horaProgramada);
	}
}
