package br.com.desafiodio.gof.repositories;

import br.com.desafiodio.gof.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
