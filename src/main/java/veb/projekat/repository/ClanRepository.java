package veb.projekat.repository;

import veb.projekat.entity.Clan;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface ClanRepository extends JpaRepository<Clan, Long>{
	
	Clan findByEmail(String email);
	
	@Query(value = "SELECT * FROM clan c WHERE c.korisnicko_ime =?2 AND c.lozinka = ?1", nativeQuery = true)
	Clan findByLozinkaAndKorisnicko_ime(String lozinka, String korisnicko_ime);
/*
 @Query(value = "SELECT * FROM lekar l WHERE l.ime = ?1 AND l.prezime = ?2", nativeQuery = true)
	ArrayList<Lekar> pretregaLekaraPoImenuIPrezimenu(String ime, String prezime); 
 */
}
