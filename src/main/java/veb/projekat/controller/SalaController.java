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

import veb.projekat.entity.Sala;
import veb.projekat.entiy.dto.SalaDTO;
import veb.projekat.service.SalaService;

@RestController
@RequestMapping(value = "/sala")
public class SalaController {
	
	@Autowired
	private SalaService salaService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SalaDTO> createSala(@RequestBody SalaDTO salaDTO) throws Exception{
		
		Sala sala = new Sala(salaDTO.getKapacitet(), salaDTO.getOznaka(),
				salaDTO.getFitnessid());
		
		Sala newSala = this.salaService.create(sala);
		
		SalaDTO newSalaDTO = new SalaDTO(newSala.getId(), newSala.getKapacitet(),
				newSala.getOznaka(), newSala.getFitnessid());
		
		return new ResponseEntity<>(newSalaDTO, HttpStatus.CREATED);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<List<SalaDTO>> getSale(){
		
		List<Sala> saleList = this.salaService.findAll();
		
		List<SalaDTO> saleDTOS = new ArrayList<>();
		
		for(Sala sale: saleList) {
			
			SalaDTO salaDTO = new SalaDTO(sale.getId(), sale.getKapacitet(),
					sale.getOznaka(), sale.getFitnessid());
			
			saleDTOS.add(salaDTO);
		}
		
		return new ResponseEntity<>(saleDTOS, HttpStatus.OK);
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteSala(@PathVariable Long id){
		
		this.salaService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping(value = "/{id}/{kapacitet}/{oznaka}", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SalaDTO> izmeni(@PathVariable Long id, @PathVariable int kapacitet, @PathVariable String oznaka)throws Exception{
	
	if(kapacitet == 0) {
		if(oznaka.equalsIgnoreCase("prazno")) {
			
		}else{
			Sala sala = this.salaService.izmenioznaku(id, oznaka);
			
			SalaDTO salaDTO = new SalaDTO(sala.getId(), sala.getKapacitet(),
					sala.getOznaka(), sala.getFitnessid());
			
			return new ResponseEntity<>(salaDTO, HttpStatus.OK);
		}
	}else {
		if(oznaka.equalsIgnoreCase("prazno")) {
			Sala sala = this.salaService.izmenikapacitet(id, kapacitet);
			
			SalaDTO salaDTO = new SalaDTO(sala.getId(), sala.getKapacitet(),
					sala.getOznaka(), sala.getFitnessid());
			
			return new ResponseEntity<>(salaDTO, HttpStatus.OK);
			
			
		}else {
			Sala sala = this.salaService.izmenikapacitetioznaku(id, kapacitet, oznaka);
			
			SalaDTO salaDTO = new SalaDTO(sala.getId(), sala.getKapacitet(),
					sala.getOznaka(), sala.getFitnessid());
			
			return new ResponseEntity<>(salaDTO, HttpStatus.OK);
		}
		
	}
		Sala sala = this.salaService.izmenikapacitetioznaku(id, kapacitet, oznaka);
	
		SalaDTO salaDTO = new SalaDTO(sala.getId(), sala.getKapacitet(),
			sala.getOznaka(), sala.getFitnessid());
	
		return new ResponseEntity<>(salaDTO, HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
