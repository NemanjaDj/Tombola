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
	// u ovom nizu stavljamo jedinice na pozicijama brojeva koji su izvuceni a korisnik ih ima u kombinaciji
	private int[] nizBrojeva = new int[37];
	
	public Igrac() {}
	
	public Igrac(String ime, String brojevi) {
		super();
		this.ime = ime;
		this.brojevi = brojevi;
	}

	public int[] getNizBrojeva() {
		return nizBrojeva;
	}

	public void setNizBrojeva() {
		for(int i = 0; i < nizBrojeva.length; i++) {
			nizBrojeva[i] = 0;
		}
	}

	public void setIdIgraca(int idIgraca) {
		this.idIgraca = idIgraca;
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
