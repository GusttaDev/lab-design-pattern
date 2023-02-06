package br.com.desafiodio.gof.dtos;

import br.com.desafiodio.gof.utils.Utils;
import lombok.*;

@Getter
public class AddressDTO {

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

    public void setCep(String cep) {
        this.cep = Utils.removeHyphenZipcode(cep);
    }
}
