package br.com.cep.restServices.mapper;


import br.com.cep.model.Cep;
import br.com.cep.model.Cidade;
import br.com.cep.model.dto.ViaCepResponse;
import org.springframework.stereotype.Component;

@Component
public class ViaCepObjectMapper {

    public Cep mapViaCepResponseToCep(ViaCepResponse viaCepResponse) {
        return Cep.builder()
                .cep(viaCepResponse.getCep())
                .logradouro(viaCepResponse.getLogradouro())
                .complemento(viaCepResponse.getComplemento())
                .bairro(viaCepResponse.getBairro())
                .cidade(Cidade.builder()
                        .localidade(viaCepResponse.getLocalidade())
                        .uf(viaCepResponse.getUf())
                        .ibge(viaCepResponse.getIbge())
                        .build())
                .build();
    }
}
