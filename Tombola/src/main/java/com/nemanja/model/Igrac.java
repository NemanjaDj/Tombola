package com.nemanja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="igrac")
public class Igrac {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_igraca")
	private int idIgraca;
	@Column(length = 30, unique = true)
	private String ime;
	@Column(length = 60)
	private String brojevi;
	
	public Igrac() {}
	
	public Igrac(String ime, String brojevi) {
		super();
		this.ime = ime;
		this.brojevi = brojevi;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getBrojevi() {
		return brojevi;
	}
	public void setBrojevi(String brojevi) {
		this.brojevi = brojevi;
	}

	public int getIdIgraca() {
		return idIgraca;
	}
	
	@Override
	public String toString() {
		return "Igrac [ime=" + ime + ", brojevi=" + brojevi + "]";
	}

}
