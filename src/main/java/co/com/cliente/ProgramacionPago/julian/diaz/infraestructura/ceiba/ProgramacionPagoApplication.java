package co.com.cliente.ProgramacionPago.julian.diaz.infraestructura.ceiba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"co.com.cliente.ProgramacionPago.julian.diaz"})
public class ProgramacionPagoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgramacionPagoApplication.class, args);
	}

}
