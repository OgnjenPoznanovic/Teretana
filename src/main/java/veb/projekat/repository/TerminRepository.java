package veb.projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import veb.projekat.entity.Termin;

public interface TerminRepository extends JpaRepository<Termin, Long>{

	List<Termin> findAllByOrderByCenaAsc();
	
	List<Termin> findAllByOrderByCenaDesc();
}
