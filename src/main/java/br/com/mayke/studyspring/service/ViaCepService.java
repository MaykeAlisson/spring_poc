package br.com.mayke.studyspring.service;

import br.com.mayke.studyspring.client.ViaCepClient;
import br.com.mayke.studyspring.dto.EnderecoDTO;
import br.com.mayke.studyspring.exceptions.BadRequestException;
import br.com.mayke.studyspring.exceptions.ResourceNotFoundException;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static java.lang.String.format;

@Service
public class ViaCepService {

    @Autowired
    private ViaCepClient viaCepClient;

    public EnderecoDTO buscarPossivelEndereco(final String cep){
        try {
            ResponseEntity<EnderecoDTO> possivelEndereco = viaCepClient.buscaEnderecoPorCep(cep);
            if(Objects.isNull(possivelEndereco.getBody()))
                throw new ResourceNotFoundException(format("Não foi encontrado endereço para o cep: %s", cep));

            if (possivelEndereco.getBody().inValid())
                throw new ResourceNotFoundException(format("Não foi encontrado endereço para o cep: %s", cep));

            return possivelEndereco.getBody();
        } catch (FeignException e) {
            throw new BadRequestException(e.getMessage());
        }
    }
}
