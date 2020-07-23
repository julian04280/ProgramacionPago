package co.com.ceiba.julian.diaz.dominio.modelo.entidad;

import java.util.Date;

public class Programar {

	private static final int COSTO_TRANSACCION = 1;
	private static final String PROGRAMAR_PAGO_LUNES_VIERNES = "El pago debe ser programado entre lunes y viernes";
	private static final String PAGO_ASIGNADO_SIGUIENTE_DIA_HABIL = "El pago se programa para el siguiente d&iacute;a habil.";
	private static final String PAGO_FESTIVO = "El costo de transacci&oacute;n es del doble por ser festivo";
	private static final String PAGO_HORARIO_VALIDO = "El pago solo se puede realizar de 8am a 5pm, jornada continua";
	private static final String USUARIO_PROGRAMADA_OBLIGATORIA = "El Usuario se debe ingresar";
	private static final String FECHA_PROGRAMADA_OBLIGATORIA = "La fecha de programaci&oacute;n de pago se debe ingresar";
	private static final String HORA_PROGRAMADA_OBLIGATORIA = "La hora de programaci&oacute;n de pago se debe ingresar";
	private static final String VALOR_A_PAGAR_OBLIGATORIO = "El valor a pagar se debe ingresar";
	
    private Double valor;
    private String idUsuario;
	private Date fechaIngreso;
	private Date fechaProgramada;
	private String horaProgramada;
	
	public Programar(Double valor,String idUsuario, Date fechaIngreso, Date fechaProgramada,String horaProgramada) {
		
		ValidadorProgramar.validarObligatorio(idUsuario, USUARIO_PROGRAMADA_OBLIGATORIA);
		ValidadorProgramar.validarObligatorio(fechaProgramada, FECHA_PROGRAMADA_OBLIGATORIA);
		ValidadorProgramar.validarObligatorio(horaProgramada, HORA_PROGRAMADA_OBLIGATORIA);
		ValidadorProgramar.validarObligatorio(valor, VALOR_A_PAGAR_OBLIGATORIO);
		
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
