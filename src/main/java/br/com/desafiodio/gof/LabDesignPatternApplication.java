package br.com.desafiodio.gof;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class LabDesignPatternApplication {
	public static void main(String[] args) {
		SpringApplication.run(LabDesignPatternApplication.class, args);
	}
}
