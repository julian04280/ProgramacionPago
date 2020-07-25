package co.com.ceiba.julian.diaz.dominio.servicio;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.ceiba.julian.diaz.dominio.excepcion.ExcepcionDuplicidad;
import co.com.ceiba.julian.diaz.dominio.modelo.entidad.Programar;
import co.com.ceiba.julian.diaz.dominio.puerto.repositorio.RepositorioProgramar;

public class ServicioModificarProgramar {

	private static final String EL_PAGO_PROGRAMADO_NO_SE_ENCUENTRA_EN_EL_SISTEMA = "El pago programado no se encuentra en el sistema";
	
	@Autowired
	private RepositorioProgramar repositorioProgramar;
	
	public ServicioModificarProgramar(RepositorioProgramar repositorioProgramar) {
		this.repositorioProgramar = repositorioProgramar;
	}
	
	public void ejecutar(Programar programar) {
		validarExistenciaPrevia(programar);
		this.repositorioProgramar.modificar(programar);
	}

	private void validarExistenciaPrevia(Programar programar) {
		boolean existe = this.repositorioProgramar.existe(programar);
		if(!existe) {
			throw new ExcepcionDuplicidad(EL_PAGO_PROGRAMADO_NO_SE_ENCUENTRA_EN_EL_SISTEMA);
		}
	}
}
