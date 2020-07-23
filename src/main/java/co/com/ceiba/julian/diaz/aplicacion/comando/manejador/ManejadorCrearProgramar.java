package co.com.ceiba.julian.diaz.aplicacion.comando.manejador;

import org.springframework.stereotype.Component;

import co.com.ceiba.julian.diaz.aplicacion.comando.fabrica.FabricaProgramar;
import co.com.ceiba.julian.diaz.dominio.modelo.entidad.Programar;
import co.com.ceiba.julian.diaz.dominio.servicio.ServicioCrearProgramar;
import co.com.ceiba.julian.diaz.aplicacion.comando.ComandoProgramar;

@Component
public class ManejadorCrearProgramar {

	private final ServicioCrearProgramar servicioCrearProgramar;
	private final FabricaProgramar fabricaProgramar;

	public ManejadorCrearProgramar(ServicioCrearProgramar servicioCrearProgramar,FabricaProgramar fabricaProgramar) {
		this.servicioCrearProgramar = servicioCrearProgramar;
		this.fabricaProgramar = fabricaProgramar;
	}
	
	public void ejecutar(ComandoProgramar comandoProgramar) {
		Programar programar = this.fabricaProgramar.crear(comandoProgramar);
		this.servicioCrearProgramar.ejecutar(programar);
	}
	
}
