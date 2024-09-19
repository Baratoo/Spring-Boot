package br.com.barato.spring_boot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Não precisa declarar na main para ser chamado
public class PrimeiroController {
														
	@GetMapping(path = {"/teste", "/ola"}) //Método get é uma array
	public String ola(){
		return "Testando Spring Boot";
	}
	

}
