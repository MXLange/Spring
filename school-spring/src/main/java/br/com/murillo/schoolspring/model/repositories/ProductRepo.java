package br.com.murillo.schoolspring.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.murillo.schoolspring.model.entities.Product;

public interface ProductRepo extends CrudRepository<Product, Integer> {

}
