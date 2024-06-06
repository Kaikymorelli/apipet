package com.Petprojeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Petprojeto.entities.Proprietario;
import com.Petprojeto.repository.ProprietarioRepository;

@Service
public class ProprietarioService {
	
private final ProprietarioRepository proprietarioRepository;
	
	@Autowired
	public ProprietarioService(ProprietarioRepository proprietarioRepository) {
		this.proprietarioRepository = proprietarioRepository;
	}

	public List<Proprietario> getAllproprietario() {
		return proprietarioRepository.findAll();
	}

	public Proprietario getproprietarioById(Long id) {
		Optional<Proprietario> proprietario = proprietarioRepository.findById(id);
		return proprietario.orElse(null);
	}
	//@query
	public List<Proprietario> getproprietariosPorNome(String nome){
		return proprietarioRepository.findByNome(nome);
	}

	public Proprietario salvarproprietario(Proprietario proprietario) {
		return proprietarioRepository.save(proprietario);
	}

	public Proprietario updateproprietario(Long id, Proprietario updatedproprietario) {
		Optional<Proprietario> existingproprietario = proprietarioRepository.findById(id);
		if (existingproprietario.isPresent()) {
			updatedproprietario.setId(id);
			return proprietarioRepository.save(updatedproprietario);
		}
		return null;
	}

	public boolean deleteproprietario(Long id) {
		Optional<Proprietario> existingproprietario = proprietarioRepository.findById(id);
		if (existingproprietario.isPresent()) {
			proprietarioRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
}
