package com.Petprojeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Petprojeto.entities.Consulta;

public interface ConsultaRepository extends JpaRepository <Consulta,Long>{

	//QUERY METHOD
	List<Consulta>findByData(String data);
	
	//QUERY METHOD
	List<Consulta>findByHora(String hora);
	
	
	@Query("SELECT a FROM Consulta a WHERE a.descricao = :descricao")
	List<Consulta> findByDescricao(@Param("descricao")String descricao);
	
}
