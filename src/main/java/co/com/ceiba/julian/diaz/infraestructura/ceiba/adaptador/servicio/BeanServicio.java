package co.com.ceiba.julian.diaz.infraestructura.ceiba.adaptador.servicio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.ceiba.julian.diaz.dominio.servicio.ServicioCrearProgramar;
import co.com.ceiba.julian.diaz.infraestructura.ceiba.adaptador.repositorio.RepositorioProgramarEnMemoria;

@Configuration
public class BeanServicio {

	@Bean
	public ServicioCrearProgramar servicioCrearProgramar() {
		return new ServicioCrearProgramar(new RepositorioProgramarEnMemoria());
	}
}