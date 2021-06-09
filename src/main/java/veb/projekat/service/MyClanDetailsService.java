/*package veb.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import veb.projekat.entity.Clan;
import veb.projekat.entity.ClanPrincipal;
import veb.projekat.repository.ClanRepository;

@Service
public class MyClanDetailsService implements UserDetailsService {

	@Autowired
	private ClanRepository clanRepository;
	
	@Override
	public UserDetails loadUserByUsername(String korisnicko_ime) throws UsernameNotFoundException {
			Clan clan = clanRepository.findByKorisnicko_ime(korisnicko_ime);
			
			if(clan == null) {
				throw new UsernameNotFoundException("Ne postoji ovaj profil");
			}
			
			return new ClanPrincipal(clan);
	}

	
	
	
	
} */
