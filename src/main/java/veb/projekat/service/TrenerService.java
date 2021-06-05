package veb.projekat.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import veb.projekat.entity.Trener;
import veb.projekat.repository.TrenerRepository;

@Service
public class TrenerService {
	
	@Autowired
	private TrenerRepository trenerRepository;
	
	public Trener create(Trener trener)throws Exception{
	if(trener.getId() != null) {
		throw new Exception("ID mora biti nula");
		}
		Trener newTrener = this.trenerRepository.save(trener);
		return newTrener;	
	}
	
	
	public List<Trener> findAll(){
		List<Trener> treneri = this.trenerRepository.findAll();
		return treneri;
	}
	
	
}
