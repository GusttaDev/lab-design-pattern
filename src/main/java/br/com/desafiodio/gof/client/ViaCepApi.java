package br.com.desafiodio.gof.client;

import br.com.desafiodio.gof.entities.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient
public interface ViaCepApi {

    @GetMapping(value = "{zipcode}/json")
    Address findAddressByZipcode(String zipcode);
}
