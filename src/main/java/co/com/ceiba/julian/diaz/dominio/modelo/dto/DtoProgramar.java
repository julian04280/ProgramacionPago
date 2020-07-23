package co.com.ceiba.julian.diaz.dominio.modelo.dto;

import java.util.Date;

public class DtoProgramar {
	
	private Double valor;
    private String idUsuario;
	private Date fechaIngreso;
	private Date fechaProgramada;
	private String horaProgramada;
	
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Date getFechaProgramada() {
		return fechaProgramada;
	}
	public void setFechaProgramada(Date fechaProgramada) {
		this.fechaProgramada = fechaProgramada;
	}
	public String getHoraProgramada() {
		return horaProgramada;
	}
	public void setHoraProgramada(String horaProgramada) {
		this.horaProgramada = horaProgramada;
	}
	
}
