package br.com.mayke.studyspring.controller;

import br.com.mayke.studyspring.dto.EnderecoDTO;
import br.com.mayke.studyspring.service.ViaCepService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api/cep")
public class ViaCepController {

    @Autowired
    private ViaCepService viaCepService;

    @GetMapping(value = "/v1/cep/{cep}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EnderecoDTO> findByCep(@PathVariable String cep) {
        log.info("ViaCepController.findByCep - start - Cep {}", cep);
        final EnderecoDTO enderecoDTO = viaCepService.buscarPossivelEndereco(cep);
        log.info("ViaCepController.findByCep - end - Response: {}", enderecoDTO);
        return ResponseEntity.status(HttpStatus.OK).body(enderecoDTO);
    }
}
