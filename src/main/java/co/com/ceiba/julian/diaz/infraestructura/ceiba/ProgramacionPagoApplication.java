package co.com.ceiba.julian.diaz.infraestructura.ceiba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"co.com.ceiba.julian.diaz"})
public class ProgramacionPagoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgramacionPagoApplication.class, args);
	}

}
