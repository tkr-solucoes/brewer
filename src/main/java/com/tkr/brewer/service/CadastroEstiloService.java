package com.tkr.brewer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.tkr.brewer.model.Estilo;

import com.tkr.brewer.repository.Estilos;
import com.tkr.brewer.service.exception.NomeEstiloJaCadastradoExcepition;

@Service
public class CadastroEstiloService {
	
	@Autowired
	private Estilos estilos;
	
	@Transactional
	public Estilo salvar(Estilo estilo) {
		
		Optional<Estilo> estiloOptional = estilos.findByNomeIgnoreCase(estilo.getNome());
		
		if(estiloOptional.isPresent()){
			
			throw new NomeEstiloJaCadastradoExcepition("Nome ja cadastrado");
			
		}
		return estilos.saveAndFlush(estilo);
	}

}
