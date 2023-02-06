package br.com.desafiodio.gof.dtos;

import br.com.desafiodio.gof.entities.Address;
import br.com.desafiodio.gof.entities.Customer;
import br.com.desafiodio.gof.entities.enums.GenderType;
import lombok.*;

@Getter
@Builder
public class CustomerDTO {

    private Long id;
    private String name;
    private GenderType gender;
    private String phone;
    private Address address;

    public static CustomerDTO convert(Customer customer){
        return CustomerDTO.builder()
                .id(customer.getId())
                .name(customer.getName())
                .gender(customer.getGender())
                .phone(customer.getPhone())
                .address(customer.getAddress().get())
                .build();
    }
}
