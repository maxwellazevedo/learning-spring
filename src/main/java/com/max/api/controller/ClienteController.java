package com.max.api.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.max.domain.model.Cliente;

@RestController
public class ClienteController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@GetMapping("/clientes")
	public List<Cliente> listar (){
		return manager.createQuery("from cliente", Cliente.class).getResultList();
		
	}

}
