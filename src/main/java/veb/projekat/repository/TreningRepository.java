package veb.projekat.repository;

import veb.projekat.entity.Trening;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TreningRepository extends JpaRepository<Trening, Long>{
	
	public List<Trening> findByNaziv(String naziv);
	
	
	public List<Trening> findByTip(String tip);
	
	
	public List<Trening> findByTrajanje(double trajanje);
	
	@Query(value = "SELECT * FROM trening t WHERE t.tip =?1 AND t.trajanje = ?2", nativeQuery = true)
	public List<Trening> findByTipAndTrajanje(String tip, double trajanje);
	
	@Query(value = "SELECT * FROM trening t WHERE t.naziv =?1 AND t.tip = ?2", nativeQuery = true)
	public List<Trening> findByNazivAndTip(String Naziv, String tip);
	
	@Query(value = "SELECT * FROM trening t WHERE t.naziv =?1 AND t.trajanje = ?2", nativeQuery = true)
	public List<Trening> findByNazivAndTrajanje(String Naziv, double trajanje);

	@Query(value = "SELECT * FROM trening t WHERE t.naziv =?1 AND t.tip = ?2 AND t.trajanje = ?3", nativeQuery = true)
	public List<Trening> findByNazivAndTipAndTrajanje(String Naziv, String tip, double trajanje);
	

}
