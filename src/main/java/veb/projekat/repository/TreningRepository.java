package veb.projekat.repository;

import veb.projekat.entity.Trening;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TreningRepository extends JpaRepository<Trening, Long>{
	
	public List<Trening> findByNaziv(String naziv);
	
	
	public List<Trening> findByTip(String tip);
	
	
	public List<Trening> findByTrajanje(double trajanje);

}
