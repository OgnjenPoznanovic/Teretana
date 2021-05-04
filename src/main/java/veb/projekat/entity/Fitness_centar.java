package veb.projekat.entity;

import java.util.HashSet;
import java.util.Set;

public class Fitness_centar {
	
	private String naziv;
	private String adresa;
	private String broj_telefona;
	private String email;
	
	private Set<Trener> treneri = new HashSet<>();
	
	private Set<Sala> sale = new HashSet<>();
	
	private Set<Trening> raspored = new HashSet<>();

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getBroj_telefona() {
		return broj_telefona;
	}

	public void setBroj_telefona(String broj_telefona) {
		this.broj_telefona = broj_telefona;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Trener> getTreneri() {
		return treneri;
	}

	public void setTreneri(Set<Trener> treneri) {
		this.treneri = treneri;
	}

	public Set<Sala> getSale() {
		return sale;
	}

	public void setSale(Set<Sala> sale) {
		this.sale = sale;
	}

	public Set<Trening> getRaspored() {
		return raspored;
	}

	public void setRaspored(Set<Trening> raspored) {
		this.raspored = raspored;
	}
	
	
	
	

}
