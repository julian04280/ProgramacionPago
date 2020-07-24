package co.com.ceiba.julian.diaz.dominio.puerto.repositorio;

import co.com.ceiba.julian.diaz.dominio.modelo.entidad.Programar;

public interface RepositorioProgramar {
	
	/**
	 * Permite crear la programacion pago
	 * @param programar
	 */
	void crear(Programar programar);
	
	/**
	 * Permite determinar si previamente se registro esa programacion pago
	 * @param programar
	 * @return si existe o no
	 */
	boolean existe(Programar programar);
	
	/**
	 * Permite borrar la programacion pago
	 * @param programar
	 */
	void borrar(Programar programar);
}
