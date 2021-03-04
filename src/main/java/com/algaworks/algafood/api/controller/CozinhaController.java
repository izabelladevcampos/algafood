package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.service.CozinhaService;

@RestController
@RequestMapping(value = "/cozinhas")
public class CozinhaController {

	@Autowired
	private CozinhaService cozinhaService;

	@GetMapping
	public ResponseEntity<List<Cozinha>> listar() {
		List<Cozinha> list = cozinhaService.listar();
		return ResponseEntity.ok().body(list);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Cozinha> buscar(@PathVariable Long id) {
		Cozinha cozinha = cozinhaService.buscar(id);

		if (cozinha != null) {
			return ResponseEntity.ok().body(cozinha);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Cozinha> adicionar(@RequestBody Cozinha cozinha) {
		cozinhaService.salvar(cozinha);
		return ResponseEntity.status(HttpStatus.CREATED).body(cozinha);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cozinha> atualizar(@PathVariable Long id, @RequestBody Cozinha cozinha) {
		Cozinha cozinhaAtual = cozinhaService.buscar(id);
		cozinhaAtual.setNome(cozinha.getNome());
		cozinhaService.salvar(cozinhaAtual);

		return ResponseEntity.ok().body(cozinhaAtual);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Cozinha> remover(@PathVariable Long id) {
		Cozinha cozinha = cozinhaService.buscar(id);

		if (cozinha != null) {
			cozinhaService.deletar(cozinha);
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.notFound().build();
	}
}
