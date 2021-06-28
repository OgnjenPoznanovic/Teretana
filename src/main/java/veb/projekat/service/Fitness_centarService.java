package veb.projekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import veb.projekat.entity.Fitness_centar;
import veb.projekat.repository.Fitness_centarRepository;

@Service
public class Fitness_centarService {
	
	@Autowired
	private Fitness_centarRepository fitness_centarRepository;
	
	
	public Fitness_centar create(Fitness_centar fitness_centar) throws Exception{
		if(fitness_centar.getId() != null) {
			throw new Exception("ID must be null");
		}
		
		Fitness_centar newFitness = this.fitness_centarRepository.save(fitness_centar);
		return newFitness;
		
	}
	
	public List<Fitness_centar> findAll(){
		List<Fitness_centar> centri = this.fitness_centarRepository.findAll();
		return centri;
	}
	
	public void delete(Long id) {
		this.fitness_centarRepository.deleteById(id);
	}
	
	
	
}
