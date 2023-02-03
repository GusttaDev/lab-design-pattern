package br.com.desafiodio.gof.repositories;

import br.com.desafiodio.gof.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
