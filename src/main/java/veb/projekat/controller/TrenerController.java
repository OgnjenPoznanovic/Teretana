package veb.projekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
				trenerDTO.getUloga(), trenerDTO.getRodjendan());
		
		Trener newTrener = trenerService.create(trener);
		
		TrenerDTO newTrenerDTO = new TrenerDTO(newTrener.getId(), newTrener.getKorisnicko_ime(), newTrener.getLozinka(),
				newTrener.getIme(), newTrener.getTelefon(), newTrener.getEmail(),
				newTrener.getUloga(), newTrener.getRodjendan());
		
		return new ResponseEntity<>(newTrenerDTO, HttpStatus.CREATED);
	}
	
}
