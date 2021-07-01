package veb.projekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import veb.projekat.entity.Termin;
import veb.projekat.repository.TerminRepository;

@Service
public class TerminService {

	@Autowired
	private TerminRepository terminRepository;
	
	public List<Termin> findAll(){
		List<Termin> termini = this.terminRepository.findAll();
		return termini;
	}
	
	public List<Termin> findAllByOrderByCenaAsc(){
		List<Termin> sortPoCeni = this.terminRepository.findAllByOrderByCenaAsc();
		return sortPoCeni;
	}
	
	public List<Termin> findAllByOrderByCenaDesc(){			
		List<Termin> sortPoCeni = this.terminRepository.findAllByOrderByCenaDesc();
		return sortPoCeni;
	}
	
	public List<Termin> findAllByOrderByVremeAsc(){
		List<Termin> sortVreme = this.terminRepository.findAllByOrderByVremeAsc();
		return sortVreme;	
	}
	
	public List<Termin> findAllByOrderByVremeDesc(){
		List<Termin> sortVreme = this.terminRepository.findAllByOrderByVremeDesc();
		return sortVreme;	
	}
	
	public Termin create(Termin termin)throws Exception{
	if(termin.getId() != null) {
		throw new Exception("ID mora biti nula");
	}
		Termin newTermin = this.terminRepository.save(termin);
		return newTermin;
	}
	
	
	
	
	
	
	
}
