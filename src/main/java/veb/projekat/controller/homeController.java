package veb.projekat.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class homeController{
	

	@GetMapping("/")
	public String welcome() {
		return "Login.html";
	}
	
	@GetMapping("/adm")
	public String admin() {
		return "Administrator.html";
	}
	
	@GetMapping("/profil")
	public String treneri() {
		return "profil.html";
	}
	
	/*
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/trening/naziv/joga")
	public  ResponseEntity<List<TreningDTO>> getTreninziPoImenu(){
		
		List<Trening> treningList = this.treningService.getTreningByNaziv("joga");
		
		List<TreningDTO> treningPoImenuDTOS = new ArrayList<>();
		
	for(Trening trening: treningList) {
			
			TreningDTO treningDTO = new TreningDTO(trening.getId(), trening.getNaziv(),
					trening.getTip(), trening.getTrajanje());
			
			treningPoImenuDTOS.add(treningDTO);
		}
		
		return new ResponseEntity<>(treningPoImenuDTOS, HttpStatus.OK);
		
		
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/trening/naziv/kardio")
	public  ResponseEntity<List<TreningDTO>> getTreninziPoImenuKardio(){
		
		List<Trening> treningList = this.treningService.getTreningByNaziv("kardio");
		
		List<TreningDTO> treningPoImenuDTOS = new ArrayList<>();
		
	for(Trening trening: treningList) {
			
			TreningDTO treningDTO = new TreningDTO(trening.getId(), trening.getNaziv(),
					trening.getTip(), trening.getTrajanje());
			
			treningPoImenuDTOS.add(treningDTO);
		}
		
		return new ResponseEntity<>(treningPoImenuDTOS, HttpStatus.OK);
		
		
	}
	*/
	
	/*
	@GetMapping("/pregled")
	public String treneri() {
		return "pregled_trenera.html";
	}
	
	
	@GetMapping("/registracija_clana")
	public String prijavaclana() {
		return "Registracija_korisnika.html";
	}
	
	@GetMapping("/trener")
	public String prijavatrenera() {
		return "Registracija_trenera.html";
	}*/
}
