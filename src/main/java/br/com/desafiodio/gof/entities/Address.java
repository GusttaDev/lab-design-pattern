package br.com.desafiodio.gof.entities;

import br.com.desafiodio.gof.dtos.AddressDTO;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address implements Serializable {

    private static final long serialVersionUID = -7718434260152342075L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String zipcode;
    private String publicPlace;
    private String complement;
    private String neighborhood;
    private String locality;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;

    public static Address convert(AddressDTO addressDTO){
        return Address.builder()
                .zipcode(addressDTO.getCep())
                .publicPlace(addressDTO.getLogradouro())
                .complement(addressDTO.getComplemento())
                .neighborhood(addressDTO.getBairro())
                .locality(addressDTO.getLocalidade())
                .uf(addressDTO.getUf())
                .ibge(addressDTO.getIbge())
                .gia(addressDTO.getGia())
                .ddd(addressDTO.getDdd())
                .siafi(addressDTO.getSiafi())
                .build();
    }
}
