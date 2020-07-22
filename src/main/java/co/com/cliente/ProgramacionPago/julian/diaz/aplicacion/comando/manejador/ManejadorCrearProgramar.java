package co.com.cliente.ProgramacionPago.julian.diaz.aplicacion.comando.manejador;

import org.springframework.stereotype.Component;

import co.com.cliente.ProgramacionPago.julian.diaz.aplicacion.comando.ComandoProgramar;
import co.com.cliente.ProgramacionPago.julian.diaz.aplicacion.comando.fabrica.FabricaProgramar;
import co.com.cliente.ProgramacionPago.julian.diaz.dominio.modelo.entidad.Programar;
import co.com.cliente.ProgramacionPago.julian.diaz.dominio.servicio.ServicioCrearProgramar;

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
