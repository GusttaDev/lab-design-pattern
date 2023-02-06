package br.com.desafiodio.gof.controller;

import br.com.desafiodio.gof.dtos.CustomerDTO;
import br.com.desafiodio.gof.dtos.CustomerEditDTO;
import br.com.desafiodio.gof.request.CustomerRequest;
import br.com.desafiodio.gof.servicies.impl.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerServiceImpl customerService;

    @PostMapping
    public ResponseEntity<CustomerDTO> create(@RequestBody CustomerRequest request){
        CustomerDTO customerDTO = customerService.create(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(customerDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(customerDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> findCustomerById(@PathVariable Long id){
        return ResponseEntity.ok(customerService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> update(@PathVariable Long id, @RequestBody CustomerEditDTO customerEditDTO){
        return ResponseEntity.ok().body(customerService.update(id, customerEditDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        customerService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
