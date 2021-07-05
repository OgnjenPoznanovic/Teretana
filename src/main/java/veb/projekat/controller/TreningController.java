package veb.projekat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
/*
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
*/
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
	
	/*
	@PostMapping(value="/login",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TreningDTO> vpretraga(@RequestBody TreningDTO treningDTO) throws Exception{
		
		Trening trening = new Trening(treningDTO.getNaziv(), treningDTO.getTip(), treningDTO.getTrajanje());
		
		Trening newTrening = this.treningService.provera(trening);
		
		Trening vpretraga = new TreningDTO(newTrening.getId(), newTrening.getNaziv(),
				newTrening.getTip(), newTrening.getTrajanje());
		
		
		return new ResponseEntity<>(vpretraga, HttpStatus.OK);
		
	}
	*/
	
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "vpretraga/{naziv}/{tip}/{trajanje}")
	public  ResponseEntity<List<TreningDTO>> getVpretraga(@PathVariable String naziv, @PathVariable String tip, @PathVariable double trajanje){
		
	
		System.out.println(naziv);
		System.out.println(tip);
		System.out.println(trajanje);
		String provera = "prazno";
	/*	if(naziv.equalsIgnoreCase(provera)) {
			System.out.println("Radim");
		}else {
			System.out.println("Ne radim");
		}*/
		
		
		if(naziv.equalsIgnoreCase(provera)) {
			if(tip.equalsIgnoreCase(provera)) {
				if(trajanje == 0) {
					
				}else {
					System.out.println("Ja u trajanju");
					List<Trening> treningList = this.treningService.getTreningByTrajanje(trajanje);
					System.out.println("Greska");
					List<TreningDTO> treninziDTOS = new ArrayList<>();
					
					for(Trening trening: treningList) {
						
						TreningDTO treningDTO = new TreningDTO(trening.getId(), trening.getNaziv(),
								trening.getTip(), trening.getTrajanje());
						
							treninziDTOS.add(treningDTO);
					}
					
					return new ResponseEntity<>(treninziDTOS, HttpStatus.OK);
				}
				
				
			}else {
				if(trajanje == 0) {
						
					List<Trening> treningList = this.treningService.getTreningByTip(tip);
					
					List<TreningDTO> treninziDTOS = new ArrayList<>();
					
					for(Trening trening: treningList) {
						
						TreningDTO treningDTO = new TreningDTO(trening.getId(), trening.getNaziv(),
								trening.getTip(), trening.getTrajanje());
						
							treninziDTOS.add(treningDTO);
					}
					
					return new ResponseEntity<>(treninziDTOS, HttpStatus.OK);
					
				}else {

					List<Trening> treningList = this.treningService.getTreningByTipAndTrajanje(tip, trajanje);
					
					List<TreningDTO> treninziDTOS = new ArrayList<>();
					
					for(Trening trening: treningList) {
						
						TreningDTO treningDTO = new TreningDTO(trening.getId(), trening.getNaziv(),
								trening.getTip(), trening.getTrajanje());
						
							treninziDTOS.add(treningDTO);
					}
					
					return new ResponseEntity<>(treninziDTOS, HttpStatus.OK);
				}				
			}
		}
		else {
			if(tip.equalsIgnoreCase(provera)) {
				if(trajanje == 0) {
					
					List<Trening> treningList = this.treningService.getTreningByNaziv(naziv);
					
					List<TreningDTO> treninziDTOS = new ArrayList<>();
					
					for(Trening trening: treningList) {
						
						TreningDTO treningDTO = new TreningDTO(trening.getId(), trening.getNaziv(),
								trening.getTip(), trening.getTrajanje());
						
							treninziDTOS.add(treningDTO);
					}
					
					return new ResponseEntity<>(treninziDTOS, HttpStatus.OK);
				}
				
			}else {
				if(trajanje == 0) {
					List<Trening> treningList = this.treningService.getTreningByNazivAndTip(naziv, tip);
					
					List<TreningDTO> treninziDTOS = new ArrayList<>();
					
					for(Trening trening: treningList) {
						
						TreningDTO treningDTO = new TreningDTO(trening.getId(), trening.getNaziv(),
								trening.getTip(), trening.getTrajanje());
						
							treninziDTOS.add(treningDTO);
					}
					
					return new ResponseEntity<>(treninziDTOS, HttpStatus.OK);
					
					
				}else {
					List<Trening> treningList = this.treningService.getTreningByNazivAndTipAndTrajanje(naziv, tip, trajanje);
					
					List<TreningDTO> treninziDTOS = new ArrayList<>();
					
					for(Trening trening: treningList) {
						
						TreningDTO treningDTO = new TreningDTO(trening.getId(), trening.getNaziv(),
								trening.getTip(), trening.getTrajanje());
						
							treninziDTOS.add(treningDTO);
					}
					
					return new ResponseEntity<>(treninziDTOS, HttpStatus.OK);
					
				}
				
			}
			
			
			
			
		}
					
		List<Trening> treningList = this.treningService.findAll();
		
		List<TreningDTO> treninziDTOS = new ArrayList<>();
		
		for(Trening trening: treningList) {
			
			TreningDTO treningDTO = new TreningDTO(trening.getId(), trening.getNaziv(),
					trening.getTip(), trening.getTrajanje());
			
				treninziDTOS.add(treningDTO);
		}
		
		return new ResponseEntity<>(treninziDTOS, HttpStatus.OK);		

	}
		

	
	
	
	
	
	
	
	
}
