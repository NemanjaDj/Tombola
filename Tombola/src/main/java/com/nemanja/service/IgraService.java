package com.nemanja.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nemanja.model.Igra;
import com.nemanja.model.Igrac;
import com.nemanja.repository.IgraDao;

@Service
public class IgraService {

	@Autowired
	private IgraDao igraDao;

	@Autowired
	private IgracService igracService;

	public void kreirajIgru() {
		Igra igra = new Igra();
		igraDao.save(igra);
	}

	// metoda proverava da li igrac ima dobitnu kombinaciju
	public boolean proveri(ArrayList<Integer> igraceviBrojevi, int[] igracovNiz, ArrayList<Integer> svibrojevi) {
		int x = svibrojevi.size();
		boolean proveriBroj = igraceviBrojevi.contains(svibrojevi.get(x-1));
		if(proveriBroj) {
			igracovNiz[svibrojevi.get(x-1)] = 1;
			igracovNiz[0] += 1;
		}
		if(igracovNiz[0] == 6)
			return true;
			return false;
	}

	// metoda simulacije tombole
	public ArrayList<Integer> tombola() {
		ArrayList<Integer> svibrojevi = new ArrayList<Integer>();
		ArrayList<Integer> brojevi = new ArrayList<Integer>();
		List<Igrac> igraci = igracService.nadjiSveIgrace();
		boolean dobitnik = false;
		for (int i = 1; i < 37; i++) {
			svibrojevi.add(i);
		}
		Collections.shuffle(svibrojevi);
		int i = 1;
		while (!dobitnik) {
			brojevi.add(svibrojevi.indexOf(i));
			
			for (Igrac x : igraci) {
				dobitnik = proveri(igracService.PrikazKombinacije(x.getBrojevi()),x.getNizBrojeva(), brojevi);
				if (dobitnik) {
					Igra igr = igraDao.findById(igraDao.poslednjaIgraId());
					igr.setDobitnaKomb(x.getBrojevi());
					igr.setImePobednika(x.getIme());
					igraDao.save(igr);
					break;
				}

			}
			i++;
		}
		return brojevi;
	}
	
	public String pobednik() {
		Igra igra = igraDao.findById(trenutnaIgra());
		return igra.getImePobednika();
	}

	public int trenutnaIgra() {
		return igraDao.poslednjaIgraId();
	}

	public Igra findById(int lastIdIgre) {
		return igraDao.findById(lastIdIgre);
	}

	public List<Igra> sveIgre() {
		return igraDao.findAll();
	}

}
