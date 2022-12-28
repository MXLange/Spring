package com.murillo.apitest.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.murillo.apitest.model.entities.Product;
import com.murillo.apitest.model.repositories.ProductRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductRepository productRep;

	//@PostMapping
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public @ResponseBody Product newProduct(@Valid Product product) {
		productRep.save(product);
		return product;
	}

	@GetMapping
	public Iterable<Product> getProducts() { // This is not a good practice, to return all table.
		return productRep.findAll();
	}

	@GetMapping(path = "/{id}")
	public Optional<Product> getProductById(@PathVariable int id) {
		return productRep.findById(id);
	}
	
	@DeleteMapping(path = "/{id}")
	public void deleteProduct(@PathVariable int id) {
		productRep.deleteById(id);
	}
	/*
	 * @PutMapping public Product updateProduct(@Valid Product product) {
	 * productRep.save(product); return product; }
	 */

}
