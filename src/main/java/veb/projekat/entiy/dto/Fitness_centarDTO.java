package veb.projekat.entiy.dto;

public class Fitness_centarDTO {

	private Long id;
	private String naziv;
	private String adresa;
	private String broj_telefona;
	private String email;
	
	public Fitness_centarDTO(){}
	
	public Fitness_centarDTO(Long id, String naziv, String adresa, String broj_telefona, String email) {
		this.id = id;
		this.naziv = naziv;
		this.adresa = adresa;
		this.broj_telefona = broj_telefona;
		this.email= email;
	}

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
	
	
	
	
	
}
