package br.com.desafiodio.gof.servicies.impl;

import br.com.desafiodio.gof.client.ViaCepApi;
import br.com.desafiodio.gof.dtos.AddressDTO;
import br.com.desafiodio.gof.dtos.CustomerDTO;
import br.com.desafiodio.gof.dtos.CustomerEditDTO;
import br.com.desafiodio.gof.entities.Address;
import br.com.desafiodio.gof.entities.Customer;
import br.com.desafiodio.gof.entities.enums.GenderType;
import br.com.desafiodio.gof.repositories.AddressRepository;
import br.com.desafiodio.gof.repositories.CustomerRepository;
import br.com.desafiodio.gof.request.CustomerRequest;
import br.com.desafiodio.gof.servicies.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;
    private final ViaCepApi viaCepApi;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerDTO findById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não localizado!"));
        return CustomerDTO.convert(customer);
    }

    @Override
    public CustomerDTO create(CustomerRequest customerRequest) {
        String zipcode = customerRequest.getZipcode();
        Address address = findAddressByZipcode(zipcode);
        Customer customer = createCustomer(customerRequest, address);


        return buildCustomerDTO(customer, address);
    }

    private Customer createCustomer(CustomerRequest customerRequest, Address address) {
        Customer customer = new Customer();
        customer.setName(customerRequest.getName());
        customer.setGender(GenderType.getGenderType(customerRequest.getGenderType()));
        customer.setPhone(customerRequest.getPhone());
        customer.setAddress(address);

        return customerRepository.save(customer);
    }

    private CustomerDTO buildCustomerDTO(Customer customer, Address address) {
        return CustomerDTO.builder()
                .id(customer.getId())
                .name(customer.getName())
                .gender(customer.getGender())
                .phone(customer.getPhone())
                .address(address)
                .build();
    }

    private Address findAddressByZipcode(String zipcode) {
       return addressRepository.findByZipcode(zipcode).orElseGet(() -> getAddressByViaCep(zipcode));
    }

    private Address getAddressByViaCep(String zipcode) {
        AddressDTO addressDTO = viaCepApi.findAddressByZipcode(zipcode);
        Address addressEntity = Address.convert(addressDTO);
        return addressRepository.save(addressEntity);
    }

    @Override
    public CustomerDTO update(Long id, CustomerEditDTO customerEditDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
