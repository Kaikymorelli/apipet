package com.Petprojeto.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.Petprojeto.entities.Pet;

public interface PetRepository extends JpaRepository <Pet, Long>{
	//QUERY METHOD
	List<Pet>findByNome(String nome);
	
	//QUERY METHOD
	List<Pet>findByRaca(String raca);
	
	@Query("SELECT a FROM Pet a WHERE a.dataNasc = :data")
	List<Pet> findByData(@Param("data")String data);
	
	
}