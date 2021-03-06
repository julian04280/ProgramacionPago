package co.com.ceiba.julian.diaz.infraestructura.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.ceiba.julian.diaz.infraestructura.ceiba.ProgramacionPagoApplication;
import co.com.ceiba.julian.diaz.infraestructura.testdatabuilder.ComandoProgramarTestDataBuilder;
import co.com.ceiba.julian.diaz.aplicacion.comando.ComandoProgramar;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProgramacionPagoApplication.class)
@AutoConfigureMockMvc
public class ComandoControladorProgramadorTest {

	@Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;
    
	@Test
    public void crear() throws Exception{
        // arrange
        ComandoProgramar comandoProgramar = new ComandoProgramarTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/privada/programar/crear-pago")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoProgramar)))
        		.andExpect(status().isOk());
        
    }
	
	@Test
    public void borrar() throws Exception{
        // arrange
		ComandoProgramarTestDataBuilder comandoProgramarBuilder = new ComandoProgramarTestDataBuilder();
				comandoProgramarBuilder.conNombre("Pago Impuestos");
        		comandoProgramarBuilder.conIdUsuario("1019136385");
        		comandoProgramarBuilder.conFechaIngreso("2020-07-20");
        		comandoProgramarBuilder.conFechaProgramada("2020-08-01");
        		comandoProgramarBuilder.conHoraProgramada("14:16:40");
        		comandoProgramarBuilder.conValor(50.0);
        		
		ComandoProgramar comandoProgramar = comandoProgramarBuilder.build();
        // act - assert
        mocMvc.perform(post("/privada/programar/borrar-pago")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoProgramar)))
        		.andExpect(status().isOk());
        
    }
	
	@Test
    public void modificar() throws Exception{
        // arrange
		ComandoProgramarTestDataBuilder comandoProgramarBuilder = new ComandoProgramarTestDataBuilder();
				comandoProgramarBuilder.conNombre("Servicio Agua");
        		comandoProgramarBuilder.conIdUsuario("51967755");
        		comandoProgramarBuilder.conFechaProgramada("2020-08-03");
        		comandoProgramarBuilder.conHoraProgramada("14:16:40");
        		comandoProgramarBuilder.conValor(1000.0);
        		
		ComandoProgramar comandoProgramar = comandoProgramarBuilder.build();
        // act - assert
        mocMvc.perform(post("/privada/programar/modificar-pago")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoProgramar)))
        		.andExpect(status().isOk());
        
    }
}
