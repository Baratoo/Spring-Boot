package br.com.barato.spring_boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.barato.spring_boot.model.entities.Produto;
import br.com.barato.spring_boot.model.repositories.IProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
	
	@Autowired //Sempre coloca um objeto
	private IProdutoRepository produtoRepository;

	@PostMapping
	public @ResponseBody Produto novoProduto(@RequestParam String nome) {
		Produto prod = new Produto(nome);
		
		produtoRepository.save(prod);
		
		return prod;
	}
}
