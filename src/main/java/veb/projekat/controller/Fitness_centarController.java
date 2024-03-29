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
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import veb.projekat.entity.Fitness_centar;
import veb.projekat.entiy.dto.Fitness_centarDTO;
import veb.projekat.service.Fitness_centarService;



@RestController
@RequestMapping(value = "/admin")
public class Fitness_centarController {

	@Autowired
	private Fitness_centarService fitness_centarService;

	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Fitness_centarDTO> createFitness(@RequestBody Fitness_centarDTO fitness_centarDTO) throws Exception {
		
		Fitness_centar fitness_centar = new Fitness_centar(fitness_centarDTO.getNaziv(),
				fitness_centarDTO.getAdresa(), fitness_centarDTO.getBroj_telefona(), 
				fitness_centarDTO.getEmail());
		
		Fitness_centar newFitness = fitness_centarService.create(fitness_centar);
		
		Fitness_centarDTO newFitness_centarDTO = new Fitness_centarDTO(
				newFitness.getId(), newFitness.getNaziv(), newFitness.getAdresa(),
				newFitness.getBroj_telefona(), newFitness.getEmail());
		
		return new ResponseEntity<>(newFitness_centarDTO, HttpStatus.CREATED);
	}
 
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Fitness_centarDTO>> getCentri(){
		
		List<Fitness_centar> centriList = this.fitness_centarService.findAll();
		
		List<Fitness_centarDTO> centriDTOS = new ArrayList<>();
		
		for(Fitness_centar  centar: centriList) {
			
			Fitness_centarDTO  centarDTO = new Fitness_centarDTO(
				centar.getId(), centar.getNaziv(), centar.getAdresa(),
				centar.getBroj_telefona(), centar.getEmail());
					
			centriDTOS.add(centarDTO);
		}
		
		return new ResponseEntity<>(centriDTOS, HttpStatus.OK);
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteCentar(@PathVariable Long id){
		this.fitness_centarService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping(value = "/{kriterijum}/{id}/{zamena}", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Fitness_centarDTO> izmeni(@PathVariable String kriterijum, @PathVariable Long id, @PathVariable String zamena)throws Exception{
		
		if(kriterijum.equalsIgnoreCase("naziv")) {
			Fitness_centar centar = this.fitness_centarService.izmeninaziv(id, zamena);
			
			Fitness_centarDTO  centarDTO = new Fitness_centarDTO(
					centar.getId(), centar.getNaziv(), centar.getAdresa(),
					centar.getBroj_telefona(), centar.getEmail());
			
			return new ResponseEntity<>(centarDTO, HttpStatus.OK);
		}else
			if(kriterijum.equalsIgnoreCase("adresa")) {
				
				Fitness_centar centar = this.fitness_centarService.izmeniadresa(id, zamena);
				
				Fitness_centarDTO  centarDTO = new Fitness_centarDTO(
						centar.getId(), centar.getNaziv(), centar.getAdresa(),
						centar.getBroj_telefona(), centar.getEmail());
				
				return new ResponseEntity<>(centarDTO, HttpStatus.OK);
			}else 
				if(kriterijum.equalsIgnoreCase("broj_telefona")){
				
					Fitness_centar centar = this.fitness_centarService.izmenibroj(id, zamena);
					
					Fitness_centarDTO  centarDTO = new Fitness_centarDTO(
							centar.getId(), centar.getNaziv(), centar.getAdresa(),
							centar.getBroj_telefona(), centar.getEmail());
					
					return new ResponseEntity<>(centarDTO, HttpStatus.OK);
				
			}else {
				
				Fitness_centar centar = this.fitness_centarService.izmeniemail(id, zamena);
				
				Fitness_centarDTO  centarDTO = new Fitness_centarDTO(
						centar.getId(), centar.getNaziv(), centar.getAdresa(),
						centar.getBroj_telefona(), centar.getEmail());
				
				return new ResponseEntity<>(centarDTO, HttpStatus.OK);
			}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
