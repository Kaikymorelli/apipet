package com.Petprojeto.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.Petprojeto.entities.Proprietario;

public interface ProprietarioRepository extends JpaRepository <Proprietario,Long>{
	
	@Query("SELECT a FROM Proprietario a JOIN a.proprietario t WHERE t.nome = :nome")
		List<Proprietario> findByNome(@Param ("nome")String nome);

}
