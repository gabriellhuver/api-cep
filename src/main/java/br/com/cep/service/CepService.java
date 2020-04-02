package br.com.cep.service;


import br.com.cep.exception.ExceptionResponse;
import br.com.cep.model.Cep;
import br.com.cep.model.Cidade;
import br.com.cep.model.dto.ViaCepResponse;
import br.com.cep.repository.CepRepository;
import br.com.cep.restServices.ViaCepService;
import br.com.cep.restServices.mapper.ViaCepObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CepService {


    @Autowired
    private ViaCepService viaCepService;

    @Autowired
    private ViaCepObjectMapper viaCepObjectMapper;

    @Autowired
    private CepRepository cepRepository;

    public ResponseEntity findCep(String cep){
        // Verificar existencia no banco de dados
        if(cep.length() != 8){
            return ExceptionResponse.InvalidCepException();
        }
        Optional<Cep> cepById = cepRepository.findById(cep);
        if(cepById.isPresent()){
            return new ResponseEntity<Cep>(cepById.get(), HttpStatus.OK);
        }
        // Fazer a requisição no ViaCep e salvar no banco
        ViaCepResponse viaCepResponse = viaCepService.findCep(cep);
        if(viaCepResponse.getCep() == null){
            return ExceptionResponse.CepNotFoundException();
        }
        Cep cepSaved = cepRepository.save(viaCepObjectMapper.mapViaCepResponseToCep(viaCepResponse));
        return new ResponseEntity<Cep>(cepSaved, HttpStatus.OK);
    }




}
