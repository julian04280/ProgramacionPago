package co.com.ceiba.julian.diaz.dominio.servicio;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.ceiba.julian.diaz.dominio.excepcion.ExcepcionDuplicidad;
import co.com.ceiba.julian.diaz.dominio.modelo.entidad.Programar;
import co.com.ceiba.julian.diaz.dominio.puerto.repositorio.RepositorioProgramar;

public class ServicioCrearProgramar {

	private static final String EL_PAGO_PROGRAMADO_YA_EXISTE_EN_EL_SISTEMA = "El pago programado ya existe en el sistema";
	
	@Autowired
	private RepositorioProgramar repositorioProgramar;
	
	public ServicioCrearProgramar(RepositorioProgramar repositorioProgramar) {
		this.repositorioProgramar = repositorioProgramar;
	}
	
	public void ejecutar(Programar programar) {
		validarExistenciaPrevia(programar);
		this.repositorioProgramar.crear(programar);
	}

	private void validarExistenciaPrevia(Programar programar) {
		boolean existe = this.repositorioProgramar.existe(programar);
		if(existe) {
			throw new ExcepcionDuplicidad(EL_PAGO_PROGRAMADO_YA_EXISTE_EN_EL_SISTEMA);
		}
	}
}
