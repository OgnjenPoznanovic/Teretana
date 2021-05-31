package veb.projekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
 

}
