package com.murillo.apitest.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
@RequestMapping
public class ProductController {

	@Autowired
	private ProductRepository productRep;

	//@PostMapping
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public @ResponseBody Product newProduct(@Valid Product product) {
		productRep.save(product);
		return product;
	}

	@GetMapping("/")
	public String produto() {
		return "product/index";
	}

	@GetMapping(path = "name/{namePart}")
	public Iterable<Product> getProductByName(@PathVariable String namePart) {
		return productRep.findByNameContainingIgnoreCase(namePart);
		//return productRep.searchByNameLike(namePart);
	}
	
	@GetMapping(path = "/page/{pageNum}/{numOfElements}")
	public Iterable<Product> getProductPages(@PathVariable(name = "pageNum") int pageNum, @PathVariable(name = "numOfElements") int numOfelements) {
		if(numOfelements > 2)
			numOfelements = 2;
		Pageable page = PageRequest.of(pageNum, numOfelements);
		return productRep.findAll(page);
	}
	
	@GetMapping(path = "/all")
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
