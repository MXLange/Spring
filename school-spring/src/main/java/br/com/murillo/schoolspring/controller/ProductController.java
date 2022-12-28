package br.com.murillo.schoolspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.murillo.schoolspring.model.entities.Product;
import br.com.murillo.schoolspring.model.repositories.ProductRepo;

@Component
@RestController
@RequestMapping("/api/produtos")
public class ProductController {

	@Autowired
	private ProductRepo produtoRep;

	@PostMapping
	public @ResponseBody Product newProduct(@RequestParam String name) {
		Product produto = new Product(name);
		produtoRep.save(produto);
		return produto;
	}

}
