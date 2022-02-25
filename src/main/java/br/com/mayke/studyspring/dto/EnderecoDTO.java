package br.com.mayke.studyspring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;


    public Boolean inValid(){
        return Objects.isNull(this.getCep()) || Objects.isNull(this.getLogradouro())
                || Objects.isNull(this.getUf()) || Objects.isNull(this.getLocalidade());
    }

}
