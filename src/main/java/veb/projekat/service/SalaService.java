package veb.projekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import veb.projekat.entity.Sala;
import veb.projekat.repository.SalaRepository;

@Service
public class SalaService {

	@Autowired
	private SalaRepository salaRepository;
	
	
	public Sala create(Sala sala) throws Exception{
		if(sala.getId() != null) {
			
			throw new Exception("ID must be null");
		}
		Sala newsala = this.salaRepository.save(sala);
		return newsala;
		
	}
	
	
	public List<Sala> findAll(){
		List<Sala> sale = this.salaRepository.findAll();
		return sale;
	}
	
	public void delete(Long id) {
		this.salaRepository.deleteById(id);
	}
	
	public Sala izmenioznaku(Long id, String oznaka)throws Exception{
		Sala sala = this.salaRepository.getOne(id);
		if(sala == null) {
			throw new Exception("Ne postoji ta sala");
		}
		
		sala.setOznaka(oznaka);
		
		Sala izmenjen = this.salaRepository.save(sala);
		return izmenjen;
	}
	
	
	public Sala izmenikapacitet(Long id, int kapacitet)throws Exception{
		Sala sala = this.salaRepository.getOne(id);
		if(sala == null) {
			throw new Exception("Ne postoji ta sala");
		}
		
		sala.setKapacitet(kapacitet);
		
		Sala izmenjen = this.salaRepository.save(sala);
		return izmenjen;
	}
	
	public Sala izmenikapacitetioznaku(Long id, int kapacitet, String oznaka)throws Exception{
		Sala sala = this.salaRepository.getOne(id);
		if(sala == null) {
			throw new Exception("Ne postoji ta sala");
		}
		
		sala.setKapacitet(kapacitet);
		sala.setOznaka(oznaka);
		
		Sala izmenjen = this.salaRepository.save(sala);
		return izmenjen;
	}
	
	public Sala nadji(Long id)throws Exception {
		Sala sala = this.salaRepository.getOne(id);
		if(sala == null) {
			throw new Exception("Ne postoji ta sala");
		}
		return sala;
	}
	
	
}
