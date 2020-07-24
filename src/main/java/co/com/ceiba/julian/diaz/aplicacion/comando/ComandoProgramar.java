package co.com.ceiba.julian.diaz.aplicacion.comando;

public class ComandoProgramar {

	private Double valor;
	private String nombre;
    private String idUsuario;
	private String fechaIngreso;
	private String fechaProgramada;
	private String horaProgramada;
	
	public ComandoProgramar() {
		super();
	}
	public ComandoProgramar(Double valor, String nombre, String idUsuario, String fechaIngreso, String fechaProgramada,
			String horaProgramada) {
		
		super();
		this.valor = valor;
		this.nombre = nombre;
		this.idUsuario = idUsuario;
		this.fechaIngreso = fechaIngreso;
		this.fechaProgramada = fechaProgramada;
		this.horaProgramada = horaProgramada;
	}

	public Double getValor() {
		return valor;
	}

	public String getNombre() {
		return nombre;
	}
	public String getIdUsuario() {
		return idUsuario;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public String getFechaProgramada() {
		return fechaProgramada;
	}

	public String getHoraProgramada() {
		return horaProgramada;
	}
	
}

