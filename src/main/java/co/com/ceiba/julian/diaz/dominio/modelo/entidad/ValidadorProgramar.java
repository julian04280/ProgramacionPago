package co.com.ceiba.julian.diaz.dominio.modelo.entidad;

import co.com.ceiba.julian.diaz.dominio.excepcion.ExcepcionHora;
import co.com.ceiba.julian.diaz.dominio.excepcion.ExcepcionValorObligatorio;

public final class ValidadorProgramar {
	
	private ValidadorProgramar() {}

    public static void validarObligatorio(Object valor, String mensaje) {
        if (valor == null) {
            throw new ExcepcionValorObligatorio(mensaje);
        }
    }
    
    public static void validarHora(String valor, String mensaje) {
        
    	int hora = Integer.parseInt(valor.substring(0, 2));
    	
    	if(hora < 8 || hora > 17) {
    		throw new ExcepcionHora(mensaje);
    	}
    	
    }
        
}
