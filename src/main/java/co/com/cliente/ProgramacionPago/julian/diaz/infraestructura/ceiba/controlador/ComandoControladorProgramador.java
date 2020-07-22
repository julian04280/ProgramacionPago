package co.com.cliente.ProgramacionPago.julian.diaz.infraestructura.ceiba.controlador;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.cliente.ProgramacionPago.julian.diaz.aplicacion.comando.ComandoProgramar;
import co.com.cliente.ProgramacionPago.julian.diaz.aplicacion.comando.manejador.ManejadorCrearProgramar;

@RestController
@RequestMapping("/privada/programar")

public class ComandoControladorProgramador {

	private final ManejadorCrearProgramar manejadorCrearProgramar;
	
	public ComandoControladorProgramador(ManejadorCrearProgramar manejadorCrearProgramar) {
		this.manejadorCrearProgramar = manejadorCrearProgramar;
	}
	
	
	@PostMapping(value = "/crear")
	public void crear(@RequestBody ComandoProgramar comandoProgramar) {
		this.manejadorCrearProgramar.ejecutar(comandoProgramar);
	}
	
}
