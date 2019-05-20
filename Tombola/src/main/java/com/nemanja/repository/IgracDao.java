package com.nemanja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.nemanja.model.Igrac;

public interface IgracDao extends JpaRepository<Igrac, String>{
	
	public List<Igrac> findAll();
	
	public Igrac findByIme(String ime);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM Igrac")
	public void obrisiIgrace();
}
