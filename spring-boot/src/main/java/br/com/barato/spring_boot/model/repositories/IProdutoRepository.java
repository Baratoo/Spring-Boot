package br.com.barato.spring_boot.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.barato.spring_boot.model.entities.Produto;

public interface IProdutoRepository extends CrudRepository<Produto, Integer>{
	
	
}
