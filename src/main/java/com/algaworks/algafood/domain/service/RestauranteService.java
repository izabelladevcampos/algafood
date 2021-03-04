package com.algaworks.algafood.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@Service
public class RestauranteService {

	@Autowired
	private RestauranteRepository restauranteRepository;

	public List<Restaurante> listar() {
		return restauranteRepository.findAll();

	}

	public Restaurante buscar(Long id) {
		return restauranteRepository.findById(id).orElse(null); /// NÃO É A MELHOR FORMA "TEMPORÁRIO"

	}

}
