package br.com.barato.spring_boot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.barato.spring_boot.model.entities.Cliente;

@RestController
@RequestMapping("/clientes") //Define o caminnho para toda a página
public class ClienteController {
	
	@GetMapping("/qualquer") //Não precisa necessariamente do path
	public Cliente getCliente() {
		return new Cliente(05, "Teste","126.456.845-55");
	}
	
	//passando parametro pela irl
	@GetMapping("/{id}") //colocando entre chaves e usando @pathVariable pode ser "/qualquerid" 
	public Cliente getClienteId(@PathVariable int id) { //pega o id da irl - http://localhost:8080/clientes/56
		return new Cliente(id, "Joao", "156.138.187-56");
	}
	
	@GetMapping
	public Cliente getClienteId2(@RequestParam(name = "id") int id) { //name é o nome do parametro - http://localhost:8080/clientes?id=56
		return new Cliente(id, "Maria", "535.158.185-58");
	}
	
	
}
