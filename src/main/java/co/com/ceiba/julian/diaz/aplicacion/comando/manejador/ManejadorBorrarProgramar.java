package co.com.ceiba.julian.diaz.aplicacion.comando.manejador;

import org.springframework.stereotype.Component;

import co.com.ceiba.julian.diaz.aplicacion.comando.fabrica.FabricaProgramar;
import co.com.ceiba.julian.diaz.dominio.modelo.entidad.Programar;
import co.com.ceiba.julian.diaz.dominio.servicio.ServicioBorrarProgramar;
import co.com.ceiba.julian.diaz.aplicacion.comando.ComandoProgramar;

@Component
public class ManejadorBorrarProgramar {

	private final ServicioBorrarProgramar servicioBorrarProgramar;
	private final FabricaProgramar fabricaProgramar;

	public ManejadorBorrarProgramar(ServicioBorrarProgramar servicioBorrarProgramar,FabricaProgramar fabricaProgramar) {
		this.servicioBorrarProgramar = servicioBorrarProgramar;
		this.fabricaProgramar = fabricaProgramar;
	}
	
	public void ejecutar(ComandoProgramar comandoProgramar) {
		Programar programar = this.fabricaProgramar.crear(comandoProgramar);
		this.servicioBorrarProgramar.ejecutar(programar);
	}
	
}
