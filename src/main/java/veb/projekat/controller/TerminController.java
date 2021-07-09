package veb.projekat.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import veb.projekat.entity.Clan;
import veb.projekat.entity.Sala;
import veb.projekat.entity.Termin;
import veb.projekat.entity.Trening;
import veb.projekat.entiy.dto.TerminDTO;
import veb.projekat.service.ClanService;
import veb.projekat.service.SalaService;
import veb.projekat.service.TerminService;
import veb.projekat.service.TreningService;

@RestController
@RequestMapping(value = "/termini")
public class TerminController {

	@Autowired
	private TerminService terminService;
	/*mozda*/
	@Autowired
	private SalaService salaService;
	@Autowired
	private TreningService treningService;
	@Autowired
	private ClanService clanService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TerminDTO>> getTermini(){
		
		List<Termin> terminList = this.terminService.findAll();
		
		List<TerminDTO> terminiDTOS = new ArrayList<>();
		
		for(Termin termin: terminList) {
			
			TerminDTO terminDTO = new TerminDTO( termin.getId(), termin.getVreme(),
					termin.getCena(), termin.getPrijavljenih());
			
			terminiDTOS.add(terminDTO);
		}
		
		return new ResponseEntity<>(terminiDTOS, HttpStatus.OK);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value= "/detalji/{id}")
	public ResponseEntity<TerminDTO> getTermin(@PathVariable Long id){
		
		Termin terminList = this.terminService.nadji(id);
		
		TerminDTO newTerminDTO = new TerminDTO( terminList.getId(), terminList.getVreme(),
				terminList.getCena(), terminList.getPrijavljenih());
		
		
		return new ResponseEntity<>(newTerminDTO, HttpStatus.OK);
		
		/*
		List<Termin> terminList = this.terminService.findAll();
		
		List<TerminDTO> terminiDTOS = new ArrayList<>();
		
		for(Termin termin: terminList) {
			
			TerminDTO terminDTO = new TerminDTO( termin.getId(), termin.getVreme(),
					termin.getCena(), termin.getPrijavljenih());
			
			terminiDTOS.add(terminDTO);
		}
		
		return new ResponseEntity<>(terminiDTOS, HttpStatus.OK);*/
		
	}
	
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value= "/{cena}")
	public ResponseEntity<List<TerminDTO>> getCena(@PathVariable String cena){
		
		if(cena.contentEquals("cenar")) {
		List<Termin> terminList = this.terminService.findAllByOrderByCenaAsc();
		
		List<TerminDTO> terminiDTOS = new ArrayList<>();
		
		for(Termin termin: terminList) {
			
			TerminDTO terminDTO = new TerminDTO( termin.getId(), termin.getVreme(),
					termin.getCena(), termin.getPrijavljenih());
			
			terminiDTOS.add(terminDTO);
		}
		
		return new ResponseEntity<>(terminiDTOS, HttpStatus.OK);
		}
		else if(cena.contentEquals("cenao")) {
			List<Termin> terminList = this.terminService.findAllByOrderByCenaDesc();
			
			List<TerminDTO> terminiDTOS = new ArrayList<>();
			
			for(Termin termin: terminList) {
				
				TerminDTO terminDTO = new TerminDTO( termin.getId(), termin.getVreme(),
						termin.getCena(), termin.getPrijavljenih());
				
				terminiDTOS.add(terminDTO);
			}
			
			return new ResponseEntity<>(terminiDTOS, HttpStatus.OK);
		}
		else if(cena.contentEquals("vremeo")) {
			List<Termin> terminList = this.terminService.findAllByOrderByVremeDesc();
			
			List<TerminDTO> terminiDTOS = new ArrayList<>();
			
			for(Termin termin: terminList) {
				
				TerminDTO terminDTO = new TerminDTO( termin.getId(), termin.getVreme(),
						termin.getCena(), termin.getPrijavljenih());
				
				terminiDTOS.add(terminDTO);
			}
			
			return new ResponseEntity<>(terminiDTOS, HttpStatus.OK);
		}
		else if(cena.contentEquals("vremer")) {
			List<Termin> terminList = this.terminService.findAllByOrderByVremeAsc();
			
			List<TerminDTO> terminiDTOS = new ArrayList<>();
			
			for(Termin termin: terminList) {
				
				TerminDTO terminDTO = new TerminDTO( termin.getId(), termin.getVreme(),
						termin.getCena(), termin.getPrijavljenih());
				
				terminiDTOS.add(terminDTO);
			}
			
			return new ResponseEntity<>(terminiDTOS, HttpStatus.OK);
		}
		else {
			List<Termin> terminList = this.terminService.findAllByOrderByCenaDesc();
			
			List<TerminDTO> terminiDTOS = new ArrayList<>();
			
			for(Termin termin: terminList) {
				
				TerminDTO terminDTO = new TerminDTO( termin.getId(), termin.getVreme(),
						termin.getCena(), termin.getPrijavljenih());
				
				terminiDTOS.add(terminDTO);
			}
			
			return new ResponseEntity<>(terminiDTOS, HttpStatus.OK);
			
		}
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE, value= "/novi/{sala}/{trening}")
	public ResponseEntity<TerminDTO> createTermin(@RequestBody TerminDTO terminDTO, @PathVariable Long sala, @PathVariable Long trening) throws Exception{
		
		Termin termin = new Termin(terminDTO.getVreme(), terminDTO.getCena(),
				terminDTO.getPrijavljenih());
		
		long m = trening;
		Trening tr = this.treningService.pronadji(m);
		termin.setTrening(tr);
		/*mozda*/
		long n = sala;
		Sala ime = this.salaService.nadji(n);
		
		
		termin.setSale(ime);
		/*mozda*/
		Termin newTermin = this.terminService.create(termin);
		
		TerminDTO newTerminDTO = new TerminDTO(newTermin.getId(), newTermin.getVreme(), 
				newTermin.getCena(), newTermin.getPrijavljenih());
		
		return new ResponseEntity<>(newTerminDTO, HttpStatus.CREATED); 
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/{vreme}/{cena}")
	public ResponseEntity<List<TerminDTO>> getCVpretraga(@PathVariable String vreme, @PathVariable double cena){
		
		System.out.println(vreme);
		System.out.println(cena);
		String provera = "prazno";
		
		if(vreme.equalsIgnoreCase(provera)) {
			if(cena == 0) {
				
			}else {
				List<Termin> terminList = this.terminService.getTerminByCeni(cena);
				
				List<TerminDTO> terminiDTOS = new ArrayList<>();
				
				for(Termin termin: terminList) {
					
					TerminDTO terminDTO = new TerminDTO( termin.getId(), termin.getVreme(),
							termin.getCena(), termin.getPrijavljenih());
					
					terminiDTOS.add(terminDTO);
				}
				
				return new ResponseEntity<>(terminiDTOS, HttpStatus.OK);
			}
			
		}else {
			if(cena == 0) {
				List<Termin> terminList = this.terminService.getTerminByVreme(vreme);
				
				List<TerminDTO> terminiDTOS = new ArrayList<>();
				
				for(Termin termin: terminList) {
					
					TerminDTO terminDTO = new TerminDTO( termin.getId(), termin.getVreme(),
							termin.getCena(), termin.getPrijavljenih());
					
					terminiDTOS.add(terminDTO);
				}
				
				return new ResponseEntity<>(terminiDTOS, HttpStatus.OK);
			}else {
				List<Termin> terminList = this.terminService.getTerminByVremeAndCena(vreme, cena);
				
				List<TerminDTO> terminiDTOS = new ArrayList<>();
				
				for(Termin termin: terminList) {
					
					TerminDTO terminDTO = new TerminDTO( termin.getId(), termin.getVreme(),
							termin.getCena(), termin.getPrijavljenih());
					
					terminiDTOS.add(terminDTO);
				}
				
				return new ResponseEntity<>(terminiDTOS, HttpStatus.OK);
				
			}
		}
		
		List<Termin> terminList = this.terminService.findAll();
		
		List<TerminDTO> terminiDTOS = new ArrayList<>();
		
		for(Termin termin: terminList) {
			
			TerminDTO terminDTO = new TerminDTO( termin.getId(), termin.getVreme(),
					termin.getCena(), termin.getPrijavljenih());
			
			terminiDTOS.add(terminDTO);
		}
		
		return new ResponseEntity<>(terminiDTOS, HttpStatus.OK);
		
	}
	
	@PutMapping(value = "/zakazi/{id}/{korisnik}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TerminDTO> prijavi(@PathVariable Long id, @PathVariable Long korisnik) throws Exception{
		
		Termin termin = this.terminService.prijavaTermina(id, korisnik);
		
			
			Long in = korisnik;
			Clan neko = this.clanService.nadji(in);
			Set<Termin> prijavljeni = neko.getClanovi();
			prijavljeni.add(termin);
			
		

		Termin nesto = this.terminService.sacuvaj(id);
		
		
		TerminDTO terminDTO = new TerminDTO( nesto.getId(), nesto.getVreme(),
				nesto.getCena(), nesto.getPrijavljenih());
		
		return new ResponseEntity<>(terminDTO, HttpStatus.OK);
	}
	
	@PutMapping(value = "/otkazi/{id}/{korisnik}", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TerminDTO> otkazi(@PathVariable Long id, @PathVariable Long korisnik) throws Exception{
		
		Termin termin = this.terminService.otkazivanjeTermina(id);
		
		Termin brisanje = this.terminService.nadji(id);
		Long in = korisnik;
		Clan neko = this.clanService.nadji(in);
		Set<Termin> prijavljeni = neko.getClanovi();
		//prijavljeni.removeAll(prijavljeni);
		prijavljeni.remove(brisanje);
	

	Termin nesto = this.terminService.sacuvaj(id);
	
	
	TerminDTO terminDTO = new TerminDTO( nesto.getId(), nesto.getVreme(),
			nesto.getCena(), nesto.getPrijavljenih());
	
	return new ResponseEntity<>(terminDTO, HttpStatus.OK);
		
		/*
		Termin zakazan = this.terminService.nadji(id);
		
		int broj;
		broj = zakazan.getPrijavljenih();
		
		broj--;
		zakazan.setPrijavljenih(broj);
		
	
		Termin nesto = this.terminService.sacuvaj(id);
		
		
		TerminDTO terminDTO = new TerminDTO( nesto.getId(), nesto.getVreme(),
				nesto.getCena(), nesto.getPrijavljenih());
		
		return new ResponseEntity<>(terminDTO, HttpStatus.OK);*/
	}
	
	
	@PutMapping(value = "/{id}/{vreme}/{cena}/{sala}", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TerminDTO> izmeni(@PathVariable Long id, @PathVariable String vreme, @PathVariable double cena, @PathVariable Long sala) throws Exception{
		
		String provera = "prazno";
		
		if(vreme.equalsIgnoreCase(provera)) {
			if(cena==0) {
				if(sala == 0) {
					
				}else {
					
					Termin termin = this.terminService.nadji(id);
					
					Sala ime = this.salaService.nadji(sala);
					termin.setSale(ime);
					
					Termin nesto = this.terminService.sacuvaj(id);				
					
					TerminDTO terminDTO = new TerminDTO( nesto.getId(), nesto.getVreme(),
							nesto.getCena(), nesto.getPrijavljenih());
									
					
					return new ResponseEntity<>(terminDTO, HttpStatus.OK);
				}
			}else {
				if(sala == 0) {
					Termin termin = this.terminService.nadji(id);
					
					termin.setCena(cena);
					
					Termin nesto = this.terminService.sacuvaj(id);
					
					TerminDTO terminDTO = new TerminDTO( nesto.getId(), nesto.getVreme(),
							nesto.getCena(), nesto.getPrijavljenih());
					
					return new ResponseEntity<>(terminDTO, HttpStatus.OK);
					
				}else {
					Termin termin = this.terminService.nadji(id);
					
					Sala ime = this.salaService.nadji(sala);
					termin.setSale(ime);
					termin.setCena(cena);
					
					Termin nesto = this.terminService.sacuvaj(id);				
					
					TerminDTO terminDTO = new TerminDTO( nesto.getId(), nesto.getVreme(),
							nesto.getCena(), nesto.getPrijavljenih());
					
					return new ResponseEntity<>(terminDTO, HttpStatus.OK);
					
				}
				
			}
		}else {
			if(cena == 0) {
				if(sala == 0) {
					Termin termin = this.terminService.nadji(id);
					
					termin.setVreme(vreme);
					
					Termin nesto = this.terminService.sacuvaj(id);				
					
					TerminDTO terminDTO = new TerminDTO( nesto.getId(), nesto.getVreme(),
							nesto.getCena(), nesto.getPrijavljenih());
					
					return new ResponseEntity<>(terminDTO, HttpStatus.OK);
				}else {
					Termin termin = this.terminService.nadji(id);
					Sala ime = this.salaService.nadji(sala);
					termin.setSale(ime);
					termin.setVreme(vreme);
					
					Termin nesto = this.terminService.sacuvaj(id);				
					
					TerminDTO terminDTO = new TerminDTO( nesto.getId(), nesto.getVreme(),
							nesto.getCena(), nesto.getPrijavljenih());
					
					return new ResponseEntity<>(terminDTO, HttpStatus.OK);
				}
			}else {
				if(sala == 0) {
					Termin termin = this.terminService.nadji(id);
					
					termin.setVreme(vreme);
					termin.setCena(cena);
					
					Termin nesto = this.terminService.sacuvaj(id);				
					
					TerminDTO terminDTO = new TerminDTO( nesto.getId(), nesto.getVreme(),
							nesto.getCena(), nesto.getPrijavljenih());
					
					return new ResponseEntity<>(terminDTO, HttpStatus.OK);
				}else {
					Termin termin = this.terminService.nadji(id);
					Sala ime = this.salaService.nadji(sala);
					termin.setSale(ime);
					termin.setVreme(vreme);
					termin.setCena(cena);
					
					Termin nesto = this.terminService.sacuvaj(id);				
					
					TerminDTO terminDTO = new TerminDTO( nesto.getId(), nesto.getVreme(),
							nesto.getCena(), nesto.getPrijavljenih());
					
					return new ResponseEntity<>(terminDTO, HttpStatus.OK);
				}
				
			}
			
		}
		
		Termin termin = this.terminService.nadji(id);
		double pare = termin.getCena();
		
		Termin nesto = this.terminService.sacuvaj(id);				
		
		TerminDTO terminDTO = new TerminDTO( nesto.getId(), nesto.getVreme(),
				nesto.getCena(), nesto.getPrijavljenih());
		
		return new ResponseEntity<>(terminDTO, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
