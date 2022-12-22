package br.com.murillo.schoolspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.murillo.schoolspring.models.Client;

@RestController
@RequestMapping(path = "/clientes")
public class ClientController{
	
	@GetMapping(path = "/qualquer")
	public Client obterCliente() {
		return new Client(28, "Pedro", "123.456.789-00");
	}

}
