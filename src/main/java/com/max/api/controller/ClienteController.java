package com.max.api.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.max.domain.model.Cliente;
import com.max.domain.repository.ClienteRepository;

@RestController
@RequestMapping("clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping()
	public List<Cliente> findAllClients() {

		return clienteRepository.findAll();
	}

	@GetMapping("/{clientId}")
	public ResponseEntity<Cliente> findClient(@PathVariable Long clientId) {

		Optional<Cliente> cliente = clienteRepository.findById(clientId);

		if (cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		}

		return ResponseEntity.notFound().build();

	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente addCliente(@Valid @RequestBody Cliente cliente){
		
	    	return clienteRepository.save(cliente);
	    
	}

	@PutMapping("/{clientId}")
	public ResponseEntity<Cliente> editClient(@PathVariable Long clientId, @RequestBody Cliente cliente) {
		if (!clienteRepository.existsById(clientId)) {
			return ResponseEntity.notFound().build();

		}

		cliente.setId(clientId);
		clienteRepository.save(cliente);

		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{clientId}")
	public ResponseEntity<Cliente> editClient(@PathVariable Long clientId) {
		if (!clienteRepository.existsById(clientId)) {
			return ResponseEntity.notFound().build();

		}
		clienteRepository.deleteById(clientId);

		return ResponseEntity.noContent().build();
	}

}
