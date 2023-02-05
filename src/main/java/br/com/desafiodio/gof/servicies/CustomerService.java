package br.com.desafiodio.gof.servicies;

import br.com.desafiodio.gof.dtos.CustomerDTO;
import br.com.desafiodio.gof.dtos.CustomerEditDTO;
import br.com.desafiodio.gof.entities.Customer;
import br.com.desafiodio.gof.request.CustomerRequest;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    CustomerDTO findById(Long id);
    CustomerDTO create(CustomerRequest customerRequest);
    CustomerDTO update(Long id, CustomerEditDTO customerEditDTO);
    void delete(Long id);
}
