package co.com.ceiba.julian.diaz.infraestructura.ceiba.controlador;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.julian.diaz.aplicacion.comando.ComandoProgramar;
import co.com.ceiba.julian.diaz.aplicacion.consulta.manejador.ManejadorBuscarPagosUsuarioProgramar;
import co.com.ceiba.julian.diaz.aplicacion.consulta.manejador.ManejadorListarProgramar;
import co.com.ceiba.julian.diaz.dominio.modelo.dto.DtoProgramar;

@RestController
@RequestMapping("/privada/programar")

public class ConsultaControladorProgramar {
	
	private final ManejadorListarProgramar manejadorListarProgramar;
	private final ManejadorBuscarPagosUsuarioProgramar manejadorBuscarPagosUsuarioProgramar;
	
	public ConsultaControladorProgramar(ManejadorListarProgramar manejadorListarProgramar,
			ManejadorBuscarPagosUsuarioProgramar manejadorBuscarPagosUsuarioProgramar) {
		this.manejadorListarProgramar = manejadorListarProgramar;
		this.manejadorBuscarPagosUsuarioProgramar = manejadorBuscarPagosUsuarioProgramar;
	}

	@GetMapping(value="/listar")
	public Collection<DtoProgramar> listar() {
		return this.manejadorListarProgramar.ejecutar();
	}
	
	@PostMapping(value="/buscar-pagos-usuario")
	public Collection<DtoProgramar> buscarPagosUsuarioProgramar(@RequestBody ComandoProgramar comandoProgramar) {
		return this.manejadorBuscarPagosUsuarioProgramar.ejecutar(comandoProgramar);
	}
}
