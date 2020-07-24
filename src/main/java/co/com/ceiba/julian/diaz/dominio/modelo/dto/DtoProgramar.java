package co.com.ceiba.julian.diaz.dominio.modelo.dto;

public class DtoProgramar {
	
	private Double valor;
	private String nombre;
    private String idUsuario;
	private String fechaIngreso;
	private String fechaProgramada;
	private String horaProgramada;
	
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getFechaProgramada() {
		return fechaProgramada;
	}
	public void setFechaProgramada(String fechaProgramada) {
		this.fechaProgramada = fechaProgramada;
	}
	public String getHoraProgramada() {
		return horaProgramada;
	}
	public void setHoraProgramada(String horaProgramada) {
		this.horaProgramada = horaProgramada;
	}
	
}
