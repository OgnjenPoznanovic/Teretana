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
	
	
	public Trener odobravanje(Long id) throws Exception {
		Trener trener_odobravanje = this.trenerRepository.getOne(id);
		if(trener_odobravanje == null) {
			throw new Exception("Ne postoji taj trener");
		}
		
		trener_odobravanje.setAktivan(true);
		
		
		Trener odobren = this.trenerRepository.save(trener_odobravanje);
		return odobren;
		
	}
	
	
}
