package co.com.ceiba.julian.diaz.dominio.modelo.entidad;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import co.com.ceiba.julian.diaz.dominio.excepcion.ExcepcionFecha;

public class Programar {

	private static final String USUARIO_PROGRAMADA_OBLIGATORIA = "El Usuario se debe ingresar";
	private static final String FECHA_PROGRAMADA_OBLIGATORIA = "La fecha de programación de pago se debe ingresar";
	private static final String HORA_PROGRAMADA_OBLIGATORIA = "La hora de programación de pago se debe ingresar";
	private static final String VALOR_A_PAGAR_OBLIGATORIO = "El valor a pagar se debe ingresar";
	private static final String CONVERTIR_FECHA = "El valor de la fecha no se puede convertir";
	
    private Double valor;
    private String idUsuario;
	private Date fechaIngreso;
	private Date fechaProgramada;
	private String horaProgramada;
	private Double costoTransaccion;
	
	public Programar(Double valor,String idUsuario, Date fechaIngreso, Date fechaProgramada,String horaProgramada) {
		
		ValidadorProgramar.validarObligatorio(idUsuario, USUARIO_PROGRAMADA_OBLIGATORIA);
		ValidadorProgramar.validarObligatorio(fechaProgramada, FECHA_PROGRAMADA_OBLIGATORIA);
		ValidadorProgramar.validarObligatorio(horaProgramada, HORA_PROGRAMADA_OBLIGATORIA);
		ValidadorProgramar.validarObligatorio(valor, VALOR_A_PAGAR_OBLIGATORIO);
		
		fechaProgramada = this.actualizarFechaProgramadaParaLunes(fechaProgramada);
		
		this.costoTransaccion = this.calcularCostoTransaccion(valor,diasFestivos().contains(fechaProgramada));
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

	public Double getCostoTransaccion() {
		return costoTransaccion;
	}
	
	private Date actualizarFechaProgramadaParaLunes(Date fechaProgramada) {

    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(fechaProgramada);
    	
    	if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ) {
    		calendar.add(Calendar.DAY_OF_YEAR, 2); 
    	}
    	
    	if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ) {
    		calendar.add(Calendar.DAY_OF_YEAR, 1); 
    	}
    	
        return calendar.getTime();
    }
	
	private List<Date> diasFestivos(){
		
		List<Date> diasFestivos = new ArrayList<>();
		
		try {
			
			String formatoFecha = "yyyy-MM-dd";
			
			diasFestivos.add(new SimpleDateFormat(formatoFecha).parse("2020-01-01"));
			diasFestivos.add(new SimpleDateFormat(formatoFecha).parse("2020-01-06"));
			diasFestivos.add(new SimpleDateFormat(formatoFecha).parse("2020-03-23"));
			diasFestivos.add(new SimpleDateFormat(formatoFecha).parse("2020-04-09"));
			diasFestivos.add(new SimpleDateFormat(formatoFecha).parse("2020-04-10"));
			diasFestivos.add(new SimpleDateFormat(formatoFecha).parse("2020-05-01"));
			diasFestivos.add(new SimpleDateFormat(formatoFecha).parse("2020-05-25"));
			diasFestivos.add(new SimpleDateFormat(formatoFecha).parse("2020-06-15"));
			diasFestivos.add(new SimpleDateFormat(formatoFecha).parse("2020-06-22"));
			diasFestivos.add(new SimpleDateFormat(formatoFecha).parse("2020-06-29"));
			diasFestivos.add(new SimpleDateFormat(formatoFecha).parse("2020-07-20"));
			diasFestivos.add(new SimpleDateFormat(formatoFecha).parse("2020-08-07"));
			diasFestivos.add(new SimpleDateFormat(formatoFecha).parse("2020-08-17"));
			diasFestivos.add(new SimpleDateFormat(formatoFecha).parse("2020-10-12"));
			diasFestivos.add(new SimpleDateFormat(formatoFecha).parse("2020-11-02"));
			diasFestivos.add(new SimpleDateFormat(formatoFecha).parse("2020-11-16"));
			diasFestivos.add(new SimpleDateFormat(formatoFecha).parse("2020-12-08"));
			diasFestivos.add(new SimpleDateFormat(formatoFecha).parse("2020-12-25"));
			
		} catch (ParseException e) {
			throw new ExcepcionFecha(CONVERTIR_FECHA);
		}
		
		return diasFestivos;
	}
    
    private Double calcularCostoTransaccion(Double valor,boolean festivo) {
    	
    	if(festivo){
    		valor = valor*0.02;
    	}else {
    		valor = valor*0.01;
    	}
    	
        return valor;
    }
	
}
