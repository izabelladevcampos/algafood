package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

}
