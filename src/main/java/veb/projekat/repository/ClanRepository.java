package veb.projekat.repository;

import veb.projekat.entity.Clan;


import org.springframework.data.jpa.repository.JpaRepository;



public interface ClanRepository extends JpaRepository<Clan, Long>{
	
	Clan findByEmail(String email);

}
