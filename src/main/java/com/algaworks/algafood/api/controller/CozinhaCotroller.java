package com.algaworks.algafood.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.service.CozinhaService;


@RestController
@RequestMapping(value = "/cozinhas")
public class CozinhaCotroller {

	@Autowired
	private CozinhaService cozinhaService;

	@GetMapping
	public List<Cozinha> listar() {
		return cozinhaService.listar();
	}
	
	@GetMapping("/{cozinhaId}")
	public Optional<Cozinha> listarPorId(@PathVariable Long cozinhaId){
		return cozinhaService.findById(cozinhaId);
	}

}
