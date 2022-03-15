package br.com.mayke.studyspring.client;

import br.com.mayke.studyspring.dto.EnderecoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "viacep", url = "${viacep-service.url-base}", configuration = FeignClientConfiguration.class)
public interface ViaCepClient {

    @GetMapping(value = "${viacep-service.url-cep}", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<EnderecoDTO> buscaEnderecoPorCep(@PathVariable("cep") String cep);
}
