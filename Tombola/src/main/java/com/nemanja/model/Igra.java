package com.nemanja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "igra")
public class Igra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idIgre;
	@Column(length = 45)
	private String dobitnaKomb;
	@Column
	private String imePobednika;
	
	public Igra() {
	}

	public int getIdIgre() {
		return idIgre;
	}

	public String getDobitnaKomb() {

		return dobitnaKomb;
	}

	public void setDobitnaKomb(String dobitnaKomb) {
		this.dobitnaKomb = dobitnaKomb;
	}

	public String getImePobednika() {
		return imePobednika;
	}

	public void setImePobednika(String imePobednika) {
		this.imePobednika = imePobednika;
	}

	@Override
	public String toString() {
		return "Igra [idIgre=" + idIgre + ", dobitnaKomb=" + dobitnaKomb + ", imePobednika=" + imePobednika + "]";
	}

	public StringBuilder prikazKomb(String komb) {
		StringBuilder newKomb = new StringBuilder();
		newKomb.append(komb.substring(0, 2) + ", " + komb.substring(2, 4) + ", " + komb.substring(4, 6) + ", "
				+ komb.substring(6, 8) + ", " + komb.substring(8, 10) + ", " + komb.substring(10, 12));

		return newKomb;
	}

}
