package veb.projekat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import veb.projekat.entity.Trener;
import veb.projekat.entiy.dto.TrenerDTO;
import veb.projekat.service.TrenerService;

@RestController
@RequestMapping(value = "/trener")
public class TrenerController {

	@Autowired
	private TrenerService trenerService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TrenerDTO> createFitness(@RequestBody TrenerDTO trenerDTO) throws Exception {
		
		Trener trener = new Trener(trenerDTO.getKorisnicko_ime(), trenerDTO.getLozinka(),
				trenerDTO.getIme(), trenerDTO.getTelefon(), trenerDTO.getEmail(),
				trenerDTO.getUloga(), trenerDTO.getRodjendan(), trenerDTO.isAktivan());
		
		Trener newTrener = trenerService.create(trener);
		
		TrenerDTO newTrenerDTO = new TrenerDTO(newTrener.getId(), newTrener.getKorisnicko_ime(), newTrener.getLozinka(),
				newTrener.getIme(), newTrener.getTelefon(), newTrener.getEmail(),
				newTrener.getUloga(), newTrener.getRodjendan(), newTrener.isAktivan());
		
		return new ResponseEntity<>(newTrenerDTO, HttpStatus.CREATED);
	}
	

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TrenerDTO>> getTreneri(){
		
		
		List<Trener> trenerList = this.trenerService.findAll();
		
		List<TrenerDTO> treneriDTOS = new ArrayList<>();
		
		for(Trener trener: trenerList) {
			
			
			TrenerDTO trenerDTO = new TrenerDTO( trener.getId(), trener.getKorisnicko_ime(),
					trener.getLozinka(), trener.getIme(), trener.getTelefon(), trener.getEmail(),
					trener.getUloga(), trener.getRodjendan(), trener.isAktivan());
			
			treneriDTOS.add(trenerDTO);
		}
		

		return new ResponseEntity<>(treneriDTOS, HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TrenerDTO> dozvoli(@PathVariable Long id) throws Exception{
		
		
		Trener odobren_trener = trenerService.odobravanje(id);
		
		TrenerDTO odobren_trenerDTO = new TrenerDTO(odobren_trener.getId(), odobren_trener.getKorisnicko_ime(),
				odobren_trener.getLozinka(), odobren_trener.getIme(), odobren_trener.getTelefon(),
				odobren_trener.getEmail(), odobren_trener.getUloga(), odobren_trener.getRodjendan(),
				odobren_trener.isAktivan());
		
		return new ResponseEntity<>(odobren_trenerDTO, HttpStatus.OK);
		
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteTrener(@PathVariable Long id){
		this.trenerService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
	
	
	
}
