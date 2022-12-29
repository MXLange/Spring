package com.murillo.apitest.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.murillo.apitest.model.entities.Product;

public interface ProductRepository
		extends CrudRepository<Product, Integer>, PagingAndSortingRepository<Product, Integer> {

	public Iterable<Product> findByNameContainingIgnoreCase(String namePart);
	
	/*
	 * @Query("SELECT p FROM Product p WHERE p.nome LIKE %:nome%") public
	 * Iterable<Product> searchByNameLike(@Param("nome") String namePart);
	 */
}
