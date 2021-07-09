package veb.projekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import veb.projekat.entity.Trening;
import veb.projekat.repository.TreningRepository;


@Service
public class TreningService {

	@Autowired
	private TreningRepository treningRepository;
		
	
	public List<Trening> findAll(){
		List<Trening> treninzi = this.treningRepository.findAll();
		return treninzi;
	}
	
	
	public List<Trening> getTreningByNaziv(String naziv){
		List<Trening> trenigPoImenu = this.treningRepository.findByNaziv(naziv);
		return trenigPoImenu;
	}
	
	
	public List<Trening> getTreningByTip(String tip){
		List<Trening> trenigPoTipu = this.treningRepository.findByTip(tip);
		return trenigPoTipu;
	}
	
	
	public List<Trening> getTreningByTrajanje(Double trajanje){
		List<Trening> trenigPoTrajanju = this.treningRepository.findByTrajanje(trajanje);
		return trenigPoTrajanju;
	}
	
	public List<Trening> getTreningByTipAndTrajanje(String tip, double trajanje){
		List<Trening> treningPoTipAndTrajanje = this.treningRepository.findByTipAndTrajanje(tip, trajanje);
		return treningPoTipAndTrajanje;
	}
	
	
	public List<Trening> getTreningByNazivAndTip(String naziv, String tip){
		List<Trening> treningPoTipAndTrajanje = this.treningRepository.findByNazivAndTip(naziv, tip);
		return treningPoTipAndTrajanje;
	}
	
	public List<Trening> getTreningByNazivAndTrajanje(String naziv, double trajanje){
		List<Trening> treningPoTipAndTrajanje = this.treningRepository.findByNazivAndTrajanje(naziv, trajanje);
		return treningPoTipAndTrajanje;
	}
	
	public List<Trening> getTreningByNazivAndTipAndTrajanje(String naziv, String tip, double trajanje){
		System.out.println("Radim Sa Tri");
		List<Trening> treningPoTipAndTrajanje = this.treningRepository.findByNazivAndTipAndTrajanje(naziv, tip, trajanje);
		return treningPoTipAndTrajanje;
	}
	
	public Trening pronadji(Long id)throws Exception{
		Trening tr = this.treningRepository.getOne(id);
		if(tr == null) {
			throw new Exception("Ne postoji taj trening");
		}
		return tr;
	}

	
	
}
