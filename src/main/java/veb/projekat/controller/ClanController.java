package veb.projekat.controller;



import java.util.Set;

//import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import veb.projekat.entity.Clan;
import veb.projekat.entity.Termin;
import veb.projekat.entiy.dto.ClanDTO;
import veb.projekat.entiy.dto.ClanTerminDTO;
import veb.projekat.service.ClanService;

@RestController
@RequestMapping(value = "/registracija_clana")
public class ClanController {
	
	@Autowired
	private ClanService clanService;
	
	
	
		@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClanDTO> createFitness(@RequestBody ClanDTO clanDTO) throws Exception {
		
		Clan clan = new Clan(clanDTO.getKorisnicko_ime(), clanDTO.getLozinka(),
				clanDTO.getIme(), clanDTO.getTelefon(), clanDTO.getEmail(),
				clanDTO.getUloga(), clanDTO.getRodjendan());
		
		Clan newClan = clanService.create(clan);
		
		ClanDTO newClanDTO = new ClanDTO(newClan.getId(), newClan.getKorisnicko_ime(), newClan.getLozinka(),
				newClan.getIme(), newClan.getTelefon(), newClan.getEmail(),
				newClan.getUloga(), newClan.getRodjendan());
		
		return new ResponseEntity<>(newClanDTO, HttpStatus.CREATED);
	}
	 
		@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value= "/{id}")
		public ResponseEntity<ClanDTO> pregled(@PathVariable Long id) throws Exception {
			
			Clan clan = this.clanService.nadji(id);
			
			ClanDTO newClanDTO = new ClanDTO(clan.getId(), clan.getKorisnicko_ime(), clan.getLozinka(),
					clan.getIme(), clan.getTelefon(), clan.getEmail(),
					clan.getUloga(), clan.getRodjendan());
			
			return new ResponseEntity<>(newClanDTO, HttpStatus.CREATED);
		}
		/*
		@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value= "/termini/{id}")
		public ResponseEntity<ClanTerminDTO> pregledzakazanih(@PathVariable Long id) throws Exception {
			
			Clan clan = this.clanService.nadji(id);
			
			Set<Termin> termin = clan.getClanovi();
			
			
			
			return new ResponseEntity<>(nesto, HttpStatus.CREATED);
		}
		*/
		
		
		
		
		
		
		

}
