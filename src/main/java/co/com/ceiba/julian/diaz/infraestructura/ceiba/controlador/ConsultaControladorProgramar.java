package co.com.ceiba.julian.diaz.infraestructura.ceiba.controlador;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.julian.diaz.aplicacion.consulta.manejador.ManejadorListarProgramar;
import co.com.ceiba.julian.diaz.dominio.modelo.dto.DtoProgramar;

@RestController
@RequestMapping("/privada/programar")

public class ConsultaControladorProgramar {
	
	private final ManejadorListarProgramar manejadorListarProgramar;
	
	public ConsultaControladorProgramar(ManejadorListarProgramar manejadorListarProgramar) {
		this.manejadorListarProgramar = manejadorListarProgramar;
	}

	@GetMapping(value="/listar")
	public Collection<DtoProgramar> listar() {
		return this.manejadorListarProgramar.ejecutar();
	}
}
