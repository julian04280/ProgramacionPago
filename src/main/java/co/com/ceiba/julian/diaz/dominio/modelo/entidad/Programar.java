package co.com.ceiba.julian.diaz.dominio.modelo.entidad;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import co.com.ceiba.julian.diaz.dominio.excepcion.ExcepcionFecha;

public class Programar {

	private static final String NOMBRE_OBLIGATORIO = "El Nombre se debe ingresar";
	private static final String USUARIO_PROGRAMADA_OBLIGATORIA = "El Usuario se debe ingresar";
	private static final String FECHA_PROGRAMADA_OBLIGATORIA = "La fecha de programacion de pago se debe ingresar";
	private static final String HORA_PROGRAMADA_OBLIGATORIA = "La hora de programacion de pago se debe ingresar";
	private static final String VALOR_A_PAGAR_OBLIGATORIO = "El valor a pagar se debe ingresar";
	private static final String CONVERTIR_FECHA = "El valor de la fecha no se puede convertir";
	private static final String HORA_PROGRAMDA_VALIDA = "El valor de la hora debe estar entre las 8am y 17pm";
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
    private Double valor;
    private String nombre;
    private String idUsuario;
	private String fechaIngreso;
	private String fechaProgramada;
	private String horaProgramada;
	private Double costoTransaccion;
	
	public Programar(Double valor,String nombre,String idUsuario, String fechaIngreso, String fechaProgramada,String horaProgramada){
		
		ValidadorProgramar.validarObligatorio(nombre, NOMBRE_OBLIGATORIO);
		ValidadorProgramar.validarObligatorio(idUsuario, USUARIO_PROGRAMADA_OBLIGATORIA);
		ValidadorProgramar.validarObligatorio(fechaProgramada, FECHA_PROGRAMADA_OBLIGATORIA);
		ValidadorProgramar.validarObligatorio(horaProgramada, HORA_PROGRAMADA_OBLIGATORIA);
		ValidadorProgramar.validarObligatorio(valor, VALOR_A_PAGAR_OBLIGATORIO);
		
		fechaProgramada = this.actualizarFechaProgramadaParaLunes(fechaProgramada);
		
		this.costoTransaccion = this.calcularCostoTransaccion(valor,fechaProgramada);
		
		ValidadorProgramar.validarHora(horaProgramada, HORA_PROGRAMDA_VALIDA);
		
		this.valor = valor;
		this.nombre = nombre;
		this.idUsuario = idUsuario;
		this.fechaIngreso = fechaIngreso;
		this.fechaProgramada = fechaProgramada;
		this.horaProgramada = horaProgramada;
	}
	
	private String actualizarFechaProgramadaParaLunes(String fechaProgramada) {

    	try {
    		
    		Calendar calendar = Calendar.getInstance();
			
    		calendar.setTime(sdf.parse(fechaProgramada));
			
    		if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ) {
	    		calendar.add(Calendar.DAY_OF_YEAR, 2); 
	    	}
	    	
	    	if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ) {
	    		calendar.add(Calendar.DAY_OF_YEAR, 1); 
	    	}
	    	
	    	return sdf.format(calendar.getTime());
	    	 
		} catch (ParseException e) {
			throw new ExcepcionFecha(CONVERTIR_FECHA);
		}
       
    }
	
	private List<Date> diasFestivos(){
		
		List<Date> diasFestivos = new ArrayList<>();
		
		try {
			
			diasFestivos.add(sdf.parse("2020-01-01"));
			diasFestivos.add(sdf.parse("2020-01-06"));
			diasFestivos.add(sdf.parse("2020-03-23"));
			diasFestivos.add(sdf.parse("2020-04-09"));
			diasFestivos.add(sdf.parse("2020-04-10"));
			diasFestivos.add(sdf.parse("2020-05-01"));
			diasFestivos.add(sdf.parse("2020-05-25"));
			diasFestivos.add(sdf.parse("2020-06-15"));
			diasFestivos.add(sdf.parse("2020-06-22"));
			diasFestivos.add(sdf.parse("2020-06-29"));
			diasFestivos.add(sdf.parse("2020-07-20"));
			diasFestivos.add(sdf.parse("2020-08-07"));
			diasFestivos.add(sdf.parse("2020-08-17"));
			diasFestivos.add(sdf.parse("2020-10-12"));
			diasFestivos.add(sdf.parse("2020-11-02"));
			diasFestivos.add(sdf.parse("2020-11-16"));
			diasFestivos.add(sdf.parse("2020-12-08"));
			diasFestivos.add(sdf.parse("2020-12-25"));
			
		} catch (ParseException e) {
			throw new ExcepcionFecha(CONVERTIR_FECHA);
		}
		
		return diasFestivos;
	}
    
    private Double calcularCostoTransaccion(Double valor,String fechaProgramada) {
    	
    	try {
    		
    		if(diasFestivos().contains(sdf.parse(fechaProgramada))){
        		valor = valor*0.02;
        	}else {
        		valor = valor*0.01;
        	}
    		
    	} catch (ParseException e) {
			throw new ExcepcionFecha(CONVERTIR_FECHA);
		}

        return valor;
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

	public Double getCostoTransaccion() {
		return costoTransaccion;
	}
	
}
