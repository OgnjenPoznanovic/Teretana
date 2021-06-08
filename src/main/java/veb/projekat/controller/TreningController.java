package veb.projekat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

	
	
	
	
	
	
	
}
