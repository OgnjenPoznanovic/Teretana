package veb.projekat.entiy.dto;

import java.sql.Date;

public class ClanDTO {

	private Long id;
	private String korisnicko_ime;
	private String lozinka;
	private String ime;
	private String telefon;	
	private String email;
	private String uloga;
	private Date rodjendan;
	
	public ClanDTO() {}
	
	public ClanDTO(Long id, String korisnicko_ime, String lozinka, String ime, String telefon, String email,
			String uloga, Date rodjendan) {
		this.id = id;
		this.korisnicko_ime = korisnicko_ime;
		this.lozinka = lozinka;
		this.ime = ime;
		this.telefon = telefon;
		this.email = email;
		this.uloga = uloga;
		this.rodjendan = rodjendan;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getKorisnicko_ime() {
		return korisnicko_ime;
	}
	public void setKorisnicko_ime(String korisnicko_ime) {
		this.korisnicko_ime = korisnicko_ime;
	}
	public String getLozinka() {
		return lozinka;
	}
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUloga() {
		return uloga;
	}
	public void setUloga(String uloga) {
		this.uloga = uloga;
	}
	public Date getRodjendan() {
		return rodjendan;
	}
	public void setRodjendan(Date rodjendan) {
		this.rodjendan = rodjendan;
	}
	
	
	
	
}
