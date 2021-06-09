package veb.projekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import veb.projekat.entity.Clan;
import veb.projekat.entiy.dto.ClanDTO;
import veb.projekat.entiy.dto.LoginDTO;
import veb.projekat.service.LoginService;

@RestController
@RequestMapping(value = "/prijava")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping(value="/login",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LoginDTO> proveri(@RequestBody LoginDTO loginDTO) throws Exception{
	
		
		Clan clan = new Clan(loginDTO.getKorisnicko_ime(), loginDTO.getLozinka());
		
		Clan newClan = loginService.proveri(clan);
		
	/*	ClanDTO newClanDTO = new ClanDTO(newClan.getId(), newClan.getKorisnicko_ime(), newClan.getLozinka(),
				newClan.getIme(), newClan.getTelefon(), newClan.getEmail(),
				newClan.getUloga(), newClan.getRodjendan());*/
		
	//	System.out.println(newClanDTO.getKorisnicko_ime());
		
		LoginDTO retval = new LoginDTO(newClan.getId(), newClan.getKorisnicko_ime(), newClan.getLozinka());
		
		System.out.println(retval.getKorisnicko_ime());
		System.out.println( retval.getId());
		System.out.println(retval.getLozinka());
		return new ResponseEntity<>(retval, HttpStatus.OK);
	}

	
	
	
	
}
