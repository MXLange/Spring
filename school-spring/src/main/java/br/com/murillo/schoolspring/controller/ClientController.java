package br.com.murillo.schoolspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.murillo.schoolspring.models.Client;

@RestController
@RequestMapping(path = "/clientes")
public class ClientController{
	
	@GetMapping(path = "/qualquer")
	public Client obterCliente() {
		return new Client(28, "Pedro", "123.456.789-00");
	}
	
	@GetMapping("/{id}")
	public Client getClientById1(@PathVariable int id) {
		return new Client(id, "Maria", "987.654.321-00");
	}
	
	@GetMapping
	public Client getClientById2(@RequestParam(name = "id", defaultValue = "1") int id) {
		return new Client(id, "Marcos", " 987.654.321-00");
	}
}
