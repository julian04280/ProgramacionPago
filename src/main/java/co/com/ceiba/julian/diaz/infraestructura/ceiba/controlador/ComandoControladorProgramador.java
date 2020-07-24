package co.com.ceiba.julian.diaz.infraestructura.ceiba.controlador;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.julian.diaz.aplicacion.comando.manejador.ManejadorBorrarProgramar;
import co.com.ceiba.julian.diaz.aplicacion.comando.manejador.ManejadorCrearProgramar;
import co.com.ceiba.julian.diaz.aplicacion.comando.ComandoProgramar;

@RestController
@RequestMapping("/privada/programar")

public class ComandoControladorProgramador {

	private final ManejadorCrearProgramar manejadorCrearProgramar;
	private final ManejadorBorrarProgramar manejadorBorrarProgramar;
	
	public ComandoControladorProgramador(ManejadorCrearProgramar manejadorCrearProgramar,
			ManejadorBorrarProgramar manejadorBorrarProgramar) {
		this.manejadorCrearProgramar = manejadorCrearProgramar;
		this.manejadorBorrarProgramar = manejadorBorrarProgramar; 
	}
	
	
	@PostMapping(value = "/crear-pago")
	public void crear(@RequestBody ComandoProgramar comandoProgramar) {
		this.manejadorCrearProgramar.ejecutar(comandoProgramar);
	}
	
	@PostMapping(value = "/borrar-pago")
	public void borrar(@RequestBody ComandoProgramar comandoProgramar) {
		this.manejadorBorrarProgramar.ejecutar(comandoProgramar);
	}
	
	
}
