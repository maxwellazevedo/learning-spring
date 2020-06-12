package com.max.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.max.domain.model.Cliente;
import com.max.domain.repository.ClienteRepository;

@RestController
@RequestMapping("clientes")
public class ClienteController {
		
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping()
	public List<Cliente> findAllClients(){
		
		return clienteRepository.findAll();		
	}	
	
	@GetMapping("/{clientId}")
	public ResponseEntity<Cliente> findClient(@PathVariable Long clientId ){
		
		Optional<Cliente> cliente = clienteRepository.findById(clientId);
		
		if (cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		}
		
		return ResponseEntity.notFound().build();
		
	}		

}
