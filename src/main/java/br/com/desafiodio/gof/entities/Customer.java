package br.com.desafiodio.gof.entities;

import br.com.desafiodio.gof.entities.enums.GenderType;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer implements Serializable {

    private static final long serialVersionUID = -3805337747722460215L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private GenderType gender;
    private String phone;
    @ManyToOne
    private Address address;

    public Optional<Address> getAddress() {
        return Optional.ofNullable(address);
    }
}
