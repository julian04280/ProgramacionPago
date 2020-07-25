package co.com.ceiba.julian.diaz.aplicacion.consulta.manejador;

import java.util.Collection;

import org.springframework.stereotype.Component;

import co.com.ceiba.julian.diaz.aplicacion.comando.ComandoProgramar;
import co.com.ceiba.julian.diaz.aplicacion.comando.fabrica.FabricaProgramar;
import co.com.ceiba.julian.diaz.dominio.modelo.dto.DtoProgramar;
import co.com.ceiba.julian.diaz.dominio.modelo.entidad.Programar;
import co.com.ceiba.julian.diaz.dominio.puerto.dao.DaoProgramar;

@Component
public class ManejadorBuscarPagosUsuarioProgramar {

	private final DaoProgramar daoProgramar;
	private final FabricaProgramar fabricaProgramar;
	
	public ManejadorBuscarPagosUsuarioProgramar(DaoProgramar daoProgramar, FabricaProgramar fabricaProgramar) {
		this.daoProgramar = daoProgramar;
		this.fabricaProgramar = fabricaProgramar;
	}
	
	public Collection<DtoProgramar> ejecutar(ComandoProgramar comandoProgramar) {
		Programar programar = this.fabricaProgramar.crear(comandoProgramar);
		return this.daoProgramar.buscarPagosProgramadosUsuario(programar);
	}
}
