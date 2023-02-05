package br.com.desafiodio.gof.client;

import br.com.desafiodio.gof.dtos.AddressDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "viaCep", url = "${via.cep.url}")
public interface ViaCepApi {

    @GetMapping("{zipcode}/json")
    AddressDTO findAddressByZipcode(@PathVariable("zipcode") String zipcode);
}
