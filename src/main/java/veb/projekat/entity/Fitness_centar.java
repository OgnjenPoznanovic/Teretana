package veb.projekat.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

@Entity
public class Fitness_centar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String naziv;
	
	@Column
	private String adresa;
	
	@Column
	private String broj_telefona;
	
	@Column
	private String email;

	@OneToMany(mappedBy = "fitness_centar", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Trener> treneri = new HashSet<>();
	/*
	@OneToMany(mappedBy = "fitness_centar", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Sala> sale = new HashSet<>();
	*/
	@OneToMany(mappedBy = "fitness_centar", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Trening> raspored = new HashSet<>();
	
	public Fitness_centar(String naziv, String adresa, String broj_telefona, String email) {
		this.naziv = naziv;
		this.adresa = adresa;
		this.broj_telefona = broj_telefona;
		this.email = email;
	}
	
	public Fitness_centar() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
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
/*
	public Set<Sala> getSale() {
		return sale;
	}

	public void setSale(Set<Sala> sale) {
		this.sale = sale;
	}
*/
	public Set<Trening> getRaspored() {
		return raspored;
	}

	public void setRaspored(Set<Trening> raspored) {
		this.raspored = raspored;
	}
	
	
	
	

}
