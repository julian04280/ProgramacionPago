package co.com.ceiba.julian.diaz.aplicacion.comando.fabrica;

import org.springframework.stereotype.Component;

import co.com.ceiba.julian.diaz.aplicacion.comando.ComandoProgramar;
import co.com.ceiba.julian.diaz.dominio.modelo.entidad.Programar;

@Component
public class FabricaProgramar {

	public Programar crear(ComandoProgramar comandoProgramar) {
		return new Programar(comandoProgramar.getValor(), comandoProgramar.getIdUsuario(), 
				comandoProgramar.getFechaIngreso(), comandoProgramar.getFechaProgramada(), comandoProgramar.getHoraProgramada());
	}
}
