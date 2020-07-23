package co.com.ceiba.julian.diaz.infraestructura.controlador;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import co.com.ceiba.julian.diaz.infraestructura.ceiba.ProgramacionPagoApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProgramacionPagoApplication.class)
@AutoConfigureMockMvc
public class ConsultaControladorProgramarTest {

    @Autowired
    private MockMvc mocMvc;
    
    @Test 
    public void listar() throws Exception{
        // arrange

        // act - assert
    	mocMvc.perform(get("/privada/programar/listar")
    		      .contentType(MediaType.APPLICATION_JSON))
    		      .andExpect(status().isOk())
    		      .andExpect(jsonPath("$[0].valor", is(50.0)));
    }
}