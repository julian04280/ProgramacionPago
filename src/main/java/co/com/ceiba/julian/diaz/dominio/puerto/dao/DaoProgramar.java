package co.com.ceiba.julian.diaz.dominio.puerto.dao;

import java.util.Collection;

import co.com.ceiba.julian.diaz.dominio.modelo.dto.DtoProgramar;


public interface DaoProgramar {

	/**
	 * Permite listar los pagos programados
	 * @return
	 */
	Collection<DtoProgramar> listar();
}
