package br.com.cep.restServices;


import br.com.cep.model.dto.ViaCepResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ViaCepService {

    private static final String VIA_CEP_BASE_URL = "https://viacep.com.br/ws/";
    private static final String VIA_CEP_FORMAT = "/json";


    public ViaCepResponse findCep(String cep){
        String uri = VIA_CEP_BASE_URL.concat(cep).concat(VIA_CEP_FORMAT);
        return restTemplate().getForObject(uri, ViaCepResponse.class);
    }

    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
