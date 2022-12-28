package com.murillo.apitest.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.murillo.apitest.model.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
