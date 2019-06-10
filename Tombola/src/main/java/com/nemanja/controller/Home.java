package com.nemanja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nemanja.model.Igrac;
import com.nemanja.service.IgraService;
import com.nemanja.service.IgracService;

@Controller
public class Home {
	
	@Autowired
	private IgracService igracService;

	@Autowired
	private IgraService igraService;

	@GetMapping("/")
	public String pocetna(Model themodel) {
		themodel.addAttribute("igrac", new Igrac());
		// prikazuje listu igraca na pocetnoj stranici
		themodel.addAttribute("igraci", igracService.nadjiSveIgrace()); 
	
		return "pocetna";
	}

	@PostMapping("/")
	public String dodajIgraca(@RequestParam("broj1") int broj1, @RequestParam("broj2") int broj2,
			@RequestParam("broj3") int broj3, @RequestParam("broj4") int broj4, @RequestParam("broj5") int broj5,
			@RequestParam("broj6") int broj6, @RequestParam("ime") String ime, Model themodel) {
		
		try {
			String brojevi = igracService.kombinacija(broj1, broj2, broj3, broj4, broj5, broj6);
			igracService.jedinsteviBrojevi(broj1, broj2, broj3, broj4, broj5, broj6);
			Igrac igr = new Igrac(igracService.trimIme(ime), brojevi);
			igracService.dodajIgraca(igr);
		} catch (DuplicateKeyException e) {
			// baca DuplicateKeyException ako pokusamo da unesemo ime koje vec postoji u trenutnoj igri
			themodel.addAttribute("errorMsgKey", e.getMessage());
			themodel.addAttribute("igraci", igracService.nadjiSveIgrace());
			return "pocetna";
		} catch (IndexOutOfBoundsException e) {
			// baca IndexOutOfBoundsException ako broj nije jedinstven ili je manji od 0 ili veci od 36
			themodel.addAttribute("errorMsgIndex", e.getMessage());
			themodel.addAttribute("igraci", igracService.nadjiSveIgrace());
			return "pocetna";
		} catch (IllegalArgumentException e) {
			// baca IllegalArgumentException ako je ime white space ili krace od 3 karaktera
			themodel.addAttribute("errorMsgKey", e.getMessage());
			themodel.addAttribute("igraci", igracService.nadjiSveIgrace());
			return "pocetna";
		}
		return "redirect:/";
	}

	@GetMapping("/tombola")
	public String izvlacenje(Model themodel) {
		try {
		igracService.isEmptyUsers();
		igraService.kreirajIgru();
		} catch (Exception e) {
			// baca Exception ako nema ni jedan uneti igrac za igru
			themodel.addAttribute("errorMsgIgraci", e.getMessage());
			return "pocetna";
		}
		
		themodel.addAttribute("brojevi", igraService.tombola());
		themodel.addAttribute("pobednik", igraService.pobednik());
		return "izvlacenje";
	}
	
	@GetMapping("/listaPobednika")
	public String listaPobednika(Model themodel) {
		themodel.addAttribute("dobitnici", igraService.sveIgre());
		return "listaPobednika";
	}
	
	// klikom na dugme nova igra brisu se igraci iz baze i vracamo se na pocetnoj stranici
	@PostMapping("/tombola")
	public String obrisiIgrace() {
			igracService.obrisiIgrace();
		return "redirect:/";
	}

}
