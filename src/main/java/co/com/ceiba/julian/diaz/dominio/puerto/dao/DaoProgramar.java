package co.com.ceiba.julian.diaz.dominio.puerto.dao;

import java.util.Collection;

import co.com.ceiba.julian.diaz.dominio.modelo.dto.DtoProgramar;
import co.com.ceiba.julian.diaz.dominio.modelo.entidad.Programar;


public interface DaoProgramar {

	/**
	 * Permite listar los pagos programados
	 * @return
	 */
	Collection<DtoProgramar> listar();
	
	/**
	 * Permite Buscar los pagos programados de un usuario
	 * @return
	 */
	Collection<DtoProgramar> buscarPagosProgramadosUsuario(Programar programar);
}
