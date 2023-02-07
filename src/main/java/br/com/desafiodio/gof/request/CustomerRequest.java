package br.com.desafiodio.gof.request;

import br.com.desafiodio.gof.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {

    private Long id;
    private String name;
    private String genderType;
    private String phone;
    private String zipcode;

    public void setZipcode(String zipcode) {
        this.zipcode = Utils.removeCharacterEspecialZipcode(zipcode);
    }
}
