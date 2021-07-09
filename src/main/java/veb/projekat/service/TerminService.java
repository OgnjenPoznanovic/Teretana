package veb.projekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import veb.projekat.entity.Clan;
import veb.projekat.entity.Sala;
import veb.projekat.entity.Termin;
import veb.projekat.repository.TerminRepository;

@Service
public class TerminService {

	@Autowired
	private TerminRepository terminRepository;
	private Sala salaRepository;
	private Clan clanRepository;
	
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
	
	
	public List<Termin> getTerminByVreme(String vreme){	
		List<Termin> terminPoVremenu = this.terminRepository.findByVreme(vreme);
		return terminPoVremenu;
	}
	
	public List<Termin> getTerminByCeni(double cena){		
		List<Termin> terminPoCeni = this.terminRepository.findByCena(cena);
		return terminPoCeni;
	}
	
	public List<Termin> getTerminByVremeAndCena(String vreme, double cena){		
		List<Termin> terminPoCV = this.terminRepository.findByVremeAndCena(vreme, cena);
		return terminPoCV;
	}
	
	public Termin nadji(Long id) {
		Termin termin = this.terminRepository.getOne(id);
		return termin;
	}
	
	
	public Termin prijavaTermina(Long id, Long korisnik) throws Exception{
		Termin zakazan = this.terminRepository.getOne(id);
		int broj = zakazan.getPrijavljenih();
		
		Sala ime = zakazan.getSale();
		int kap = ime.getKapacitet();
		
		if(broj == kap) {
			throw new Exception("Nema mesta");
		}
		
		broj++;
		zakazan.setPrijavljenih(broj);
		
		Termin promena = this.terminRepository.save(zakazan);
		return promena;
	}
	
	public Termin otkazivanjeTermina(Long id) throws Exception{
		Termin termin = this.terminRepository.getOne(id);
		if(termin == null) {
			throw new Exception("Ne postoji taj termnin");
		}	
		
		
		int broj;
		broj = termin.getPrijavljenih();
		broj--;
		
		termin.setPrijavljenih(broj);
		Termin promena = this.terminRepository.save(termin);
		return promena;
	}
	
	public Termin sacuvaj(Long id) throws Exception{
		Termin termin = this.terminRepository.getOne(id);
		if(termin == null) {
			throw new Exception("Ne postoji taj termnin");
		}	
		
		Termin promena = this.terminRepository.save(termin);
		return promena;
	}
	
	/*
	public Termin menjajcenu(Long id ,double cena) throws Exception{
		Termin termin = this.terminRepository.getOne(id);
		if(termin == null) {
			throw new Exception("Ne postoji taj termnin");
		}	
		termin.setCena(cena);
		Termin promena = this.terminRepository.save(termin);
		return promena;
	}
	
	public Termin menjajsalu(Long id, Long sala) throws Exception{
		Termin termin = this.terminRepository.getOne(id);
		if(termin == null) {
			throw new Exception("Ne postoji taj termnin");
		}	
		Termin promena = this.terminRepository.save(termin);
		return promena;
	}
	
	public Termin menjajvreme(Long id, String vreme) throws Exception{
		Termin termin = this.terminRepository.getOne(id);
		if(termin == null) {
			throw new Exception("Ne postoji taj termnin");
		}	
		
		Termin promena = this.terminRepository.save(termin);
		return promena;
	}
	*/
	
	
	
	
	
}
