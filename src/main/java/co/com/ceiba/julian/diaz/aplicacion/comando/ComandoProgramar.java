package co.com.ceiba.julian.diaz.aplicacion.comando;

import java.util.Date;

public class ComandoProgramar {

	private Double valor;
    private String idUsuario;
	private Date fechaIngreso;
	private Date fechaProgramada;
	private String horaProgramada;
	
	public ComandoProgramar() {
		super();
	}
	public ComandoProgramar(Double valor, String idUsuario, Date fechaIngreso, Date fechaProgramada,
			String horaProgramada) {
		
		super();
		this.valor = valor;
		this.idUsuario = idUsuario;
		this.fechaIngreso = fechaIngreso;
		this.fechaProgramada = fechaProgramada;
		this.horaProgramada = horaProgramada;
	}

	public Double getValor() {
		return valor;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public Date getFechaProgramada() {
		return fechaProgramada;
	}

	public String getHoraProgramada() {
		return horaProgramada;
	}
	
}

