package co.com.ceiba.julian.diaz.aplicacion.comando.manejador;

import org.springframework.stereotype.Component;

import co.com.ceiba.julian.diaz.aplicacion.comando.fabrica.FabricaProgramar;
import co.com.ceiba.julian.diaz.dominio.modelo.entidad.Programar;
import co.com.ceiba.julian.diaz.dominio.servicio.ServicioModificarProgramar;
import co.com.ceiba.julian.diaz.aplicacion.comando.ComandoProgramar;

@Component
public class ManejadorModificarProgramar {

	private final ServicioModificarProgramar servicioModificarProgramar;
	private final FabricaProgramar fabricaProgramar;

	public ManejadorModificarProgramar(ServicioModificarProgramar servicioModificarProgramar,FabricaProgramar fabricaProgramar) {
		this.servicioModificarProgramar = servicioModificarProgramar;
		this.fabricaProgramar = fabricaProgramar;
	}
	
	public void ejecutar(ComandoProgramar comandoProgramar) {
		Programar programar = this.fabricaProgramar.crear(comandoProgramar);
		this.servicioModificarProgramar.ejecutar(programar);
	}
	
}
