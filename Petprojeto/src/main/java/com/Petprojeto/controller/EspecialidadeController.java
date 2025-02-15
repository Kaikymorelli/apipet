package com.Petprojeto.controller;

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

import com.Petprojeto.entities.Especialidade;
import com.Petprojeto.service.EspecialidadeService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/especialidade")
public class EspecialidadeController {
	private final EspecialidadeService especialidadeService;
	@Autowired
	public EspecialidadeController(EspecialidadeService especialidadeService) {
		this.especialidadeService = especialidadeService;
	}

	@GetMapping("/{id}")
	@Operation(summary = "Localiza especialidade por ID")
	public ResponseEntity<Especialidade> getEspecialidadeById(@PathVariable Long id) {
		Especialidade especialidade = especialidadeService.getespecialidadeById(id);
		if (especialidade != null) {
			return ResponseEntity.ok(especialidade);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	@Operation(summary = "Aprensenta todas as especialidades")
	public ResponseEntity<List<Especialidade>> getAllEspecialidade() {
		List<Especialidade> especialidade = especialidadeService.getAllespecialidade();
		return ResponseEntity.ok(especialidade);
	}

	@PostMapping("/")
	@Operation(summary = "Cadastra uma especialidade")
	public ResponseEntity<Especialidade> criarEspecialidade(@RequestBody Especialidade especialidade) {
		Especialidade criarEspecialidade = especialidadeService.salvarespecialidade(especialidade);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarEspecialidade);
	}


	@PutMapping("/{id}")
	@Operation(summary = "Altera a especialidade")
	public ResponseEntity<Especialidade> updateEspecialidade(@PathVariable Long id,@RequestBody Especialidade especialidade) {
		Especialidade updatedEspecialidade = especialidadeService.updateespecialidade(id, especialidade);
		if (updatedEspecialidade != null) {
			return ResponseEntity.ok(updatedEspecialidade);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deleta uma especialidade")
	public ResponseEntity<String> deleteEspecialidade(@PathVariable Long id) {
		boolean deleted = especialidadeService.deleteespecialidade(id);
		if (deleted) {
			return ResponseEntity.ok().body("A especialidade foi excluído com sucesso.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}