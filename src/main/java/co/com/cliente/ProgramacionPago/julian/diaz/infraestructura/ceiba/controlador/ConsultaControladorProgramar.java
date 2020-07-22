package co.com.cliente.ProgramacionPago.julian.diaz.infraestructura.ceiba.controlador;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.cliente.ProgramacionPago.julian.diaz.aplicacion.consulta.manejador.ManejadorListarProgramar;
import co.com.cliente.ProgramacionPago.julian.diaz.dominio.modelo.dto.DtoProgramar;

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
