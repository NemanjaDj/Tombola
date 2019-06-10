package com.nemanja.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.nemanja.model.Igrac;
import com.nemanja.repository.IgracDao;

@Service
public class IgracService {
	
	@Autowired
	public IgracDao igracDao;

	public void dodajIgraca(Igrac igr) throws DuplicateKeyException{
		if(igracDao.findByIme(igr.getIme()) == null) {
		igracDao.save(igr);
		}
		else throw new DuplicateKeyException("Igrac sa " + igr.getIme() + " vec postoji u trenutnoj igri, unesite drugo ime.");
	}
	
	// metoda proverava da li su brojevi jedinstveni
	public void jedinsteviBrojevi(int broj1, int broj2, int broj3, int broj4, int broj5, int broj6)
	throws IndexOutOfBoundsException {
		Set<Integer> brojevi = new HashSet<Integer>();
		brojevi.add(broj1);
		brojevi.add(broj2);
		brojevi.add(broj3);
		brojevi.add(broj4);
		brojevi.add(broj5);
		brojevi.add(broj6);
		if(brojevi.size() < 6){
			throw new IndexOutOfBoundsException("brojevi moraju biti jedinstveni!");
		}
		brojevi.clear();
	}
	
	// metoda proverava da li je uneto ime duze od 3 karaktera ili white space
	public String trimIme(String ime) throws IllegalArgumentException {
		String novoime = ime.trim();
		if(novoime.equals(null) || novoime.length() < 3)
			throw new IllegalArgumentException("Uneli ste nepravilno ime.");
		return novoime;
	}
	
	public List<Igrac> nadjiSveIgrace() {
		return igracDao.findAll();
	}
	
	// metoda koja pravi string od kombinacije da bismo kombinaciju ubacili u bazu
	public String kombinacija(int broj1, int broj2, int broj3, int broj4, int broj5, int broj6)
	throws IndexOutOfBoundsException{
		int[] brojevi = {broj1, broj2, broj3, broj4, broj5, broj6};
		String konacan = "";
		for(int x : brojevi) {
			if(x < 1 || x > 36)
				throw new IndexOutOfBoundsException("Moguce je uneti brojeve izmedju 1 i 36.");
			if(x < 10) {
				konacan = (konacan + "0" + String.valueOf(x));
			} else konacan = (konacan + x);
		}
			
		return konacan;
	}
	
	// metoda koja od stringa(kombinacije iz baze) vraca kombinaciju u Integer arraylist.
	public ArrayList<Integer> PrikazKombinacije(String kombinacija){
		ArrayList<Integer> komb = new ArrayList<Integer>();
		char x, y;
		int z;
		for(int i=0; i < 11; i=i+2) {
			z = i+2;
			x = kombinacija.charAt(i);
			if(x == '0') {
			y = kombinacija.charAt(++i);
				komb.add(Integer.parseInt(String.valueOf(y)));
				i--;
			} else {
				komb.add(Integer.parseInt(String.valueOf(kombinacija.substring(i, z))));
			}
		}
		
		return komb;
	}
	
	// metoda proverava da li ima korisnika za igru 
	public void isEmptyUsers() throws Exception {
		if(igracDao.findAll().isEmpty()) {
			throw new Exception("Nema igraca za igru");
		}
	}
	public void obrisiIgrace() {
		igracDao.obrisiIgrace();
	}
	
}
