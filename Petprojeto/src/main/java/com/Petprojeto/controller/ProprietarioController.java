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

import com.Petprojeto.entities.Proprietario;
import com.Petprojeto.service.ProprietarioService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/proprietario")
public class ProprietarioController {
	private final ProprietarioService proprietarioService;
	@Autowired
	public ProprietarioController(ProprietarioService proprietarioService) {
		this.proprietarioService = proprietarioService;
	}

	@GetMapping("/{id}")
	@Operation(summary = "Localiza proprietario por ID")
	public ResponseEntity<Proprietario> getProprietarioById(@PathVariable Long id) {
		Proprietario proprietario = proprietarioService.getproprietarioById(id);
		if (proprietario != null) {
			return ResponseEntity.ok(proprietario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	@Operation(summary = "Aprensenta todos os proprietario")
	public ResponseEntity<List<Proprietario>> getAllProprietario() {
		List<Proprietario> proprietario = proprietarioService.getAllproprietario();
		return ResponseEntity.ok(proprietario);
	}
	//@Query
	@GetMapping("/nome/{nome}")
	@Operation(summary = "Aprensenta o nome dos proprietario")
	public ResponseEntity<List<Proprietario>> getProdutosPorNome(@PathVariable String nome){
		List<Proprietario> proprietarios = proprietarioService.getproprietariosPorNome(nome);
		return ResponseEntity.ok(proprietarios);
	}
	
	@PostMapping("/")
	@Operation(summary = "Cadastra um proprietario")
	public ResponseEntity<Proprietario> criarProprietario(@RequestBody Proprietario proprietario) {
		Proprietario criarProprietario = proprietarioService.salvarproprietario(proprietario);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarProprietario);
	}


	@PutMapping("/{id}")
	@Operation(summary = "Altera o proprietario")
	public ResponseEntity<Proprietario> updateProprietario(@PathVariable Long id,@RequestBody Proprietario proprietario) {
		Proprietario updatedProprietario = proprietarioService.updateproprietario(id, proprietario);
		if (updatedProprietario != null) {
			return ResponseEntity.ok(updatedProprietario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deleta um proprietario")
	public ResponseEntity<String> deleteProprietario(@PathVariable Long id) {
		boolean deleted = proprietarioService.deleteproprietario(id);
		if (deleted) {
			return ResponseEntity.ok().body("O proprietario foi excluído com sucesso.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}


}
