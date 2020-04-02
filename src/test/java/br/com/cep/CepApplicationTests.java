package br.com.cep;

import br.com.cep.controller.CepController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

@SpringBootTest(classes = CepApplication.class)
@AutoConfigureMockMvc
public class CepApplicationTests  {

	@Autowired
	private MockMvc mvc;

	@Test
	public void findCep() throws Exception {
		MvcResult mvcResult2 = mvc.perform(MockMvcRequestBuilders.get("/cep/01001000")
				.contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		int status = mvcResult2.getResponse().getStatus();
		assertEquals(200, status);
	}

	@Test
	public void findCepsByUfAndIbge() throws Exception {
		MvcResult mvcResult2 = mvc.perform(MockMvcRequestBuilders.get("/ceps?ibge=3550308&uf=SP")
				.contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		int status = mvcResult2.getResponse().getStatus();
		assertEquals(200, status);
	}

}











































