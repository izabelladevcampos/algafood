package com.algaworks.algafood.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired 
	private CidadeRepository cidadeRepository;
	
	public List<Cidade> listar() {
		return cidadeRepository.findAll();

	}

}
