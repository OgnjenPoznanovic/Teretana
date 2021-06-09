package veb.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import veb.projekat.entity.Clan;
import veb.projekat.repository.ClanRepository;

@Service
public class LoginService {

	@Autowired
	private ClanRepository clanRepository;
	
	public Clan proveri(Clan clan)throws Exception{
		String ime=clan.getKorisnicko_ime();
		String sifra=clan.getLozinka();
		if(this.clanRepository.findByLozinkaAndKorisnicko_ime(sifra, ime) == null) {
			
			throw new Exception("Ovaj clan ne postoji");
		}
		
		Clan newClan =this.clanRepository.findByLozinkaAndKorisnicko_ime(sifra, ime);
		
		return newClan;
	}
	
	
	
}
