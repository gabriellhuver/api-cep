package br.com.cep.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ExceptionResponse {
    public static ResponseEntity<GeneralException> InvalidCepException(){
        return new ResponseEntity<GeneralException>(GeneralException
                .builder()
                .code("422")
                .message("Cep inválido")
                .build(), HttpStatus.UNPROCESSABLE_ENTITY);
    }
    public static ResponseEntity<GeneralException> CepNotFoundException(){
        return new ResponseEntity<GeneralException>(GeneralException
                .builder()
                .code("404")
                .message("Cep não encontrado")
                .build(), HttpStatus.NOT_FOUND);
    }

    public static  ResponseEntity<GeneralException> InternalError(){
        return new ResponseEntity<GeneralException>(new GeneralException("500", "Erro interno do servidor"), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
