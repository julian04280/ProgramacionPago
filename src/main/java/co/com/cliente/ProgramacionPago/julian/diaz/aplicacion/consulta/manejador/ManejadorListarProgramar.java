package co.com.cliente.ProgramacionPago.julian.diaz.aplicacion.consulta.manejador;

import java.util.Collection;

import org.springframework.stereotype.Component;

import co.com.cliente.ProgramacionPago.julian.diaz.dominio.modelo.dto.DtoProgramar;
import co.com.cliente.ProgramacionPago.julian.diaz.dominio.puerto.dao.DaoProgramar;

@Component
public class ManejadorListarProgramar {

	private final DaoProgramar daoProgramar;
	
	public ManejadorListarProgramar(DaoProgramar daoProgramar) {
		this.daoProgramar = daoProgramar;
	}
	
	public Collection<DtoProgramar> ejecutar() {
		return this.daoProgramar.listar();
	}
}
