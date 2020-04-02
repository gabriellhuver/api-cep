package br.com.cep;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class CepApplicationTests extends AbstractTest {

	@Before
	void contextLoads() {
		super.setUp();
	}

	@Test
	private void findCep() throws Exception {
		MvcResult mvcResult2 = mvc.perform(MockMvcRequestBuilders.get("/cep/01001000")
				.contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		int status = mvcResult2.getResponse().getStatus();
		assertEquals(200, status);
	}

	@Test
	private void findCepsByUfAndIbge() throws Exception {
		MvcResult mvcResult2 = mvc.perform(MockMvcRequestBuilders.get("/ceps?ibge=3550308&uf=SP")
				.contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		int status = mvcResult2.getResponse().getStatus();
		assertEquals(200, status);
	}

}
