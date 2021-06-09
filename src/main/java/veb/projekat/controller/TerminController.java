package veb.projekat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import veb.projekat.entity.Termin;
import veb.projekat.entiy.dto.TerminDTO;
import veb.projekat.service.TerminService;

@RestController
@RequestMapping(value = "/termini")
public class TerminController {

	@Autowired
	private TerminService terminService;
	
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
