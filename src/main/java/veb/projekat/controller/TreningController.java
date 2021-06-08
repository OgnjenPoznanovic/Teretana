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

import veb.projekat.entity.Trening;
import veb.projekat.entiy.dto.TreningDTO;
import veb.projekat.service.TreningService;

@RestController
@RequestMapping(value = "/trening")
public class TreningController {
	
	@Autowired
	private TreningService treningService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TreningDTO>> getTreninzi(){
		
		List<Trening> treningList = this.treningService.findAll();
		
		List<TreningDTO> treninziDTOS = new ArrayList<>();
		
		for(Trening trening: treningList) {
			
			TreningDTO treningDTO = new TreningDTO(trening.getId(), trening.getNaziv(),
					trening.getTip(), trening.getTrajanje());
			
				treninziDTOS.add(treningDTO);
		}
		
		return new ResponseEntity<>(treninziDTOS, HttpStatus.OK);
	}
	

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/naziv/{naziv}")
	public  ResponseEntity<List<TreningDTO>> getTreninziPoImenu(@PathVariable String naziv){
		
		
		List<Trening> treningList = this.treningService.getTreningByNaziv(naziv);
		
		List<TreningDTO> treningPoImenuDTOS = new ArrayList<>();
		
	for(Trening trening: treningList) {
			
			TreningDTO treningDTO = new TreningDTO(trening.getId(), trening.getNaziv(),
					trening.getTip(), trening.getTrajanje());
			
			treningPoImenuDTOS.add(treningDTO);
		}
		
		return new ResponseEntity<>(treningPoImenuDTOS, HttpStatus.OK);
		
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/tip/{tip}")
	public  ResponseEntity<List<TreningDTO>> getTreninziPoTipu(@PathVariable String tip){
		
		
		List<Trening> treningList = this.treningService.getTreningByTip(tip);
		
		List<TreningDTO> treningPoImenuDTOS = new ArrayList<>();
		
	for(Trening trening: treningList) {
			
			TreningDTO treningDTO = new TreningDTO(trening.getId(), trening.getNaziv(),
					trening.getTip(), trening.getTrajanje());
			
			treningPoImenuDTOS.add(treningDTO);
		}
		
		return new ResponseEntity<>(treningPoImenuDTOS, HttpStatus.OK);
		
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/trajanje/{trajanje}")
	public  ResponseEntity<List<TreningDTO>> getTreninziPoTrajanju(@PathVariable double trajanje){
		
		
		List<Trening> treningList = this.treningService.getTreningByTrajanje(trajanje);
		
		List<TreningDTO> treningPoImenuDTOS = new ArrayList<>();
		
	for(Trening trening: treningList) {
			
			TreningDTO treningDTO = new TreningDTO(trening.getId(), trening.getNaziv(),
					trening.getTip(), trening.getTrajanje());
			
			treningPoImenuDTOS.add(treningDTO);
		}
		
		return new ResponseEntity<>(treningPoImenuDTOS, HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
}
