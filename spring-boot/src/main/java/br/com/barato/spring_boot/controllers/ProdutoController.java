package br.com.barato.spring_boot.controllers;


import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public @ResponseBody Produto novoProduto(@Valid Produto produto) { //@Valid valida o que foi definido em Produto
		produtoRepository.save(produto);
		return produto;
	}
	
	/*
	@PostMapping
	public @ResponseBody Produto novoProduto(
			@RequestParam String nome,
			@RequestParam double preco,
			@RequestParam double desconto) {
		
		Produto prod = new Produto(nome, preco, desconto);	
		produtoRepository.save(prod);
		return prod;
	}*/
	
	@GetMapping
	public Iterable<Produto> getProdutos(){
		return produtoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Produto> getProdutoById(@PathVariable int id){
		return produtoRepository.findById(id);
	}
	
	@GetMapping(path = "/nome/{parteNome}")
	public Iterable<Produto> getProdutoByNome(@PathVariable String parteNome){
		return produtoRepository.findByNomeContainingIgnoreCase(parteNome);
		//return produtoRepository.searchByNameLike(parteNome);
	}
	
	@GetMapping(path = "/pagina/{numPagina}/{qtdePagina}")
	public Iterable<Produto> getProdutosByPag(@PathVariable int numPagina, @PathVariable int qtdePagina){
		if(qtdePagina >= 5) qtdePagina = 5;
		Pageable page = PageRequest.of(numPagina, qtdePagina); 
		return produtoRepository.findAll(page);
	}
	
	/* Pode ser utilizado junto do metodo de novoProduto
	@PutMapping //Utiliza put para atualizar produto/objeto inteiro
	public Produto updateProduto(@Valid Produto produto) {
		produtoRepository.save(produto);
		return produto;
	}*/
	
	@DeleteMapping(path = "/{id}")
	public void deleteProduto(@PathVariable int id) {
		produtoRepository.deleteById(id);
	}
	
	
	
	
	
	

	
}
