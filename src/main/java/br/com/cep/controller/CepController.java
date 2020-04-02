package br.com.cep.controller;

import br.com.cep.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CepController {

	@Autowired
	CepService cepService;


	@RequestMapping(value= "/cep/{cep}", method = RequestMethod.GET)
	public ResponseEntity<?> FindCep(@PathVariable("cep") String cep ){
		return cepService.findCep(cep);
	}

}
