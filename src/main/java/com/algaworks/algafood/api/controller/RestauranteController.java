package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.service.RestauranteService;


@RestController
@RequestMapping(value = "/restaurantes")
public class RestauranteController {
	
	private @Autowired RestauranteService restauranteService;
	
	@GetMapping
	public ResponseEntity<List<Restaurante>> listar() {
		List<Restaurante> list = restauranteService.listar();
		return ResponseEntity.ok().body(list);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Restaurante> buscar(@PathVariable Long id) {
		Restaurante restaurante = restauranteService.buscar(id);

		if (restaurante != null) {
			return ResponseEntity.ok().body(restaurante);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Restaurante> adicionar(@RequestBody Restaurante restaurante) {
		restauranteService.salvar(restaurante);
		return ResponseEntity.status(HttpStatus.CREATED).body(restaurante);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Restaurante> atualizar(@PathVariable Long id, @RequestBody Restaurante restaurante) {
		Restaurante restauranteAtual = restauranteService.buscar(id);
		restauranteAtual.setNome(restaurante.getNome());
		restauranteService.salvar(restauranteAtual);

		return ResponseEntity.ok().body(restauranteAtual);

	}

}
