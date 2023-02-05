package br.com.desafiodio.gof.controller;

import br.com.desafiodio.gof.dtos.CustomerDTO;
import br.com.desafiodio.gof.dtos.CustomerEditDTO;
import br.com.desafiodio.gof.request.CustomerRequest;
import br.com.desafiodio.gof.servicies.impl.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerServiceImpl customerService;

    @PostMapping
    public ResponseEntity<CustomerDTO> create(@RequestBody CustomerRequest request){
        return ResponseEntity.ok(customerService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> findCustomerById(@PathVariable("id") Long id){
        return ResponseEntity.ok(customerService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> update(@PathVariable("id") Long id, @RequestBody CustomerEditDTO customerEditDTO){
        return ResponseEntity.ok().body(customerService.update(id, customerEditDTO));
    }
}
