package com.Petprojeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Petprojeto.entities.Especialidade;
import com.Petprojeto.repository.EspecialidadeRepository;

@Service
public class EspecialidadeService {

private  EspecialidadeRepository especialidadeRepository;
	
	@Autowired
	public  EspecialidadeService(EspecialidadeRepository especialidadeRepository) {
		this.especialidadeRepository = especialidadeRepository;
	}

	public List<Especialidade> getAllespecialidade() {
		return especialidadeRepository.findAll();
	}

	public Especialidade getespecialidadeById(Long id) {
		Optional<Especialidade> especialidade = especialidadeRepository.findById(id);
		return especialidade.orElse(null);
	}
	

	public Especialidade salvarespecialidade(Especialidade especialidade) {
		return especialidadeRepository.save(especialidade);
	}

	public Especialidade updateespecialidade(Long id, Especialidade updatedespecialidade) {
		Optional<Especialidade> existingespecialidade = especialidadeRepository.findById(id);
		if (existingespecialidade.isPresent()) {
			updatedespecialidade.setId(id);
			return especialidadeRepository.save(updatedespecialidade);
		}
		return null;
	}

	public boolean deleteespecialidade(Long id) {
		Optional<Especialidade> existingespecialidade = especialidadeRepository.findById(id);
		if (existingespecialidade.isPresent()) {
			especialidadeRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
