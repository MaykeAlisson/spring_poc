package br.com.mayke.studyspring.controller;

import br.com.mayke.studyspring.dto.MensagemQueuDTO;
import br.com.mayke.studyspring.rabbitMq.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(value = "/api/mensagem")
public class MensageriaController {

    @Autowired
    private Producer producer;

    @PostMapping(value = "/v1/mensagem", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createMensagem(@Valid @RequestBody MensagemQueuDTO msg) {
        log.info("MensageriaController.createMensagem - start - Body {}", msg);
        producer.send(msg.getMsg());
        log.info("MensageriaController.createMensagem - end");
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
