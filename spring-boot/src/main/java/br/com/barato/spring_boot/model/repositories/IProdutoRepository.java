package br.com.barato.spring_boot.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.barato.spring_boot.model.entities.Produto;

public interface IProdutoRepository extends PagingAndSortingRepository<Produto, Integer>{
	
	//Spring entende o findBy, desde que esteja na sintaxe que ele usa
	public Iterable<Produto> findByNomeContainingIgnoreCase(String nome);
	
	/*
	 Outros exemplos
	 
	 findByNomeIsContaining
	 findByNomeContains
	 
	 findByNomeStartWith
	 findByNomeEndsWith
	 
	 findByNomeNotContaining
	 */
	
	@Query("SELECT p FROM Produto p WHERE p.nome LIKE %:nome%")
	public Iterable<Produto> searchByNameLike(@Param ("nome") String nome);
}
