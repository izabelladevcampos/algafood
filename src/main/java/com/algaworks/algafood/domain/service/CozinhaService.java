package com.algaworks.algafood.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

@Service
public class CozinhaService {

	@Autowired
	private CozinhaRepository cozinhaRepository;

	public List<Cozinha> listar() {
		return cozinhaRepository.findAll();

	}

	public Cozinha buscar(Long id) {
		return cozinhaRepository.findById(id).orElse(null); /// NÃO É A MELHOR FORMA "TEMPORÁRIO"

	}

	public Cozinha salvar(Cozinha cozinha) {
		return cozinhaRepository.save(cozinha);
	}

	public void deletar(Cozinha cozinha) {
		cozinhaRepository.delete(cozinha);
	}
}
