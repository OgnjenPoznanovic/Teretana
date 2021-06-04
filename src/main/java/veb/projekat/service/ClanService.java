package veb.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import veb.projekat.entity.Clan;
import veb.projekat.repository.ClanRepository;

@Service
public class ClanService {

	@Autowired
	private ClanRepository clanRepository;
	
	public Clan create(Clan clan)throws Exception{
		if(clan.getId() != null) {
			throw new Exception("ID mora biti nula");
		}
		
		Clan newClan = this.clanRepository.save(clan);
		return newClan;
		
	}
	
	
	/*
	public Clan create(Clan clan)throws Exception{
		
		String mejl = clan.getEmail();
		clanRepository.findByEmail(mejl);
		
		ClanDTO clanDTO = new ClanDTO();
		clanDTO.setEmail(clan.getEmail());
		String mejl2 = clanDTO.getEmail();
		
		if(mejl == mejl2) {
			throw new Exception("Vec imas profil");
		}
		
		Clan newClan = this.clanRepository.save(clan);
		return newClan;
		
	}*/
	
}
