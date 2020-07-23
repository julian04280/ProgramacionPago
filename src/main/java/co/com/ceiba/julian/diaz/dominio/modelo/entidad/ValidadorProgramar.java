package co.com.ceiba.julian.diaz.dominio.modelo.entidad;

import co.com.ceiba.julian.diaz.dominio.excepcion.ExcepcionValorObligatorio;

public class ValidadorProgramar {
	
	private ValidadorProgramar() {}

    public static void validarObligatorio(Object valor, String mensaje) {
        if (valor == null) {
            throw new ExcepcionValorObligatorio(mensaje);
        }
    }
    
}
