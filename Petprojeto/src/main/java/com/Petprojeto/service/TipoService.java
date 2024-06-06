package com.Petprojeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Petprojeto.entities.Tipo;
import com.Petprojeto.repository.TipoRepository;

@Service
public class TipoService {

private  TipoRepository tipoRepository;
	
@Autowired
public TipoService(TipoRepository tipoRepository) {
		this.tipoRepository = tipoRepository;
	}

	public List<Tipo> getAlltipo() {
		return tipoRepository.findAll();
	}

	public Tipo gettipoById(Long id) {
		Optional<Tipo> tipo = tipoRepository.findById(id);
		return tipo.orElse(null);
	}
	

	public Tipo salvartipo(Tipo tipo) {
		return tipoRepository.save(tipo);
	}

	public Tipo updatetipo(Long id, Tipo updatedtipo) {
		Optional<Tipo> existingtipo = tipoRepository.findById(id);
		if (existingtipo.isPresent()) {
			updatedtipo.setId(id);
			return tipoRepository.save(updatedtipo);
		}
		return null;
	}

	public boolean deletetipo(Long id) {
		Optional<Tipo> existingtipo = tipoRepository.findById(id);
		if (existingtipo.isPresent()) {
			tipoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
