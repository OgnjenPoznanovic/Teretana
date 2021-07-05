package veb.projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import veb.projekat.entity.Termin;

public interface TerminRepository extends JpaRepository<Termin, Long>{

	List<Termin> findAllByOrderByCenaAsc();
	
	List<Termin> findAllByOrderByCenaDesc();
	
	List<Termin> findAllByOrderByVremeDesc();
	
	List<Termin> findAllByOrderByVremeAsc();
	
	public List<Termin> findByCena(Double cena);
	
	public List<Termin> findByVreme(String vreme);
	
	@Query(value = "SELECT * FROM termin t WHERE t.vreme =?1 AND t.cena = ?2", nativeQuery = true)
	public List<Termin> findByVremeAndCena(String vreme, double cena);
}
