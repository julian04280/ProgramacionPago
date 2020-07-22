package co.com.cliente.ProgramacionPago.julian.diaz.dominio.modelo.entidad;

import co.com.cliente.ProgramacionPago.julian.diaz.dominio.excepcion.ExcepcionValorObligatorio;

public class ValidadorProgramar {
	
	private ValidadorProgramar() {}

    public static void validarObligatorio(Object valor, String mensaje) {
        if (valor == null) {
            throw new ExcepcionValorObligatorio(mensaje);
        }
    }
    
}
