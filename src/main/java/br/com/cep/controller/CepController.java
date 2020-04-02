package br.com.cep.controller;

import br.com.cep.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
public class CepController {

	@Autowired
	CepService cepService;


	@RequestMapping(value= "/cep/{cep}", method = RequestMethod.GET)
	public ResponseEntity<?> FindCep(@PathVariable("cep") String cep ){
		return cepService.findCep(cep);
	}

	@RequestMapping(value = "/ceps", method = RequestMethod.GET)
	public ResponseEntity<?> FindCeps(@RequestParam(name = "ibge", required = true) String ibge, @RequestParam(name="uf", required = false) String uf){
		return cepService.findCeps(ibge,uf);
	}
}
