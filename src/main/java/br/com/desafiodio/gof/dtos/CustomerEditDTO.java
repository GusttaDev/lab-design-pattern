package br.com.desafiodio.gof.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerEditDTO {
    private String name;
    private String genderType;
    private String phone;
}
