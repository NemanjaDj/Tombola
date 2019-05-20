package com.nemanja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nemanja.model.Igra;

public interface IgraDao extends JpaRepository<Igra, Integer>{
	
	public List<Igra> findAll();
	
	public Igra findById(int id);
	
	@Query("SELECT Max(i.idIgre) FROM Igra i")
	public int poslednjaIgraId();
	
	
}
