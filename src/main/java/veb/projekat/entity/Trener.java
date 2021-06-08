package veb.projekat.entity;

import java.sql.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Trener{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String korisnicko_ime;
	
	@Column
	private String lozinka;
	
	@Column
	private String ime;
	
	@Column
	private String telefon;
	
	@Column
	private String email;
	
	@Column
	private String uloga;
	
	@Column	
	private Date rodjendan;
	
	@Column
	private int ocena;
	
	@Column
	private boolean aktivan;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Fitness_centar fitness_centar;
	
	public Trener(String korisnicko_ime, String lozinka, String ime, String telefon, String email,
			String uloga, Date rodjendan, boolean aktivan) {
		this.korisnicko_ime = korisnicko_ime;
		this.lozinka = lozinka;
		this.ime = ime;
		this.telefon = telefon;
		this.email = email;
		this.uloga = uloga;
		this.rodjendan = rodjendan;
		this.aktivan = aktivan;
	}
	
	public Trener() {}
	
	
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

	public int getOcena() {
		return ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	public boolean isAktivan() {
		return aktivan;
	}

	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}
	
	
/*
	public int getAktivan() {
		return aktivan;
	}

	public void setAktivan(int aktivan) {
		this.aktivan = aktivan;
	}

*/
/*
	public double getProsecnaOcena() {
		return prosecnaOcena;
	}

	public void setProsecnaOcena(int prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}
*/





	


	
	
	
}
