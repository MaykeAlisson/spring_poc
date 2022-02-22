package br.com.mayke.studyspring.client;

import br.com.mayke.studyspring.dto.EnderecoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "viacep", url = "${viacep-service.url-base}")
public interface ViaCepClient {

    @GetMapping("/{cep}/json")
    EnderecoDTO buscaEnderecoPorCep(@PathVariable("cep") String cep);
}
