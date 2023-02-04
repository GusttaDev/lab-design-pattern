package br.com.desafiodio.gof.entities;

import br.com.desafiodio.gof.entities.enums.GenderType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private GenderType gender;
    private String phone;
    @ManyToOne
    private Address address;

    public Optional<Address> getAddress() {
        return Optional.ofNullable(address);
    }
}
