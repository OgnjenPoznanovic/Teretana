package veb.projekat.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Clan{
	
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
	private boolean aktivan;
	
	public Clan() {}
	
	public Clan(String korisnicko_ime, String lozinka) {
		this.korisnicko_ime = korisnicko_ime;
		this.lozinka = lozinka;
	}
	
	public Clan(String korisnicko_ime, String lozinka, String ime, String telefon, String email,
			String uloga, Date rodjendan) {
		this.korisnicko_ime = korisnicko_ime;
		this.lozinka = lozinka;
		this.ime = ime;
		this.telefon = telefon;
		this.email = email;
		this.uloga = uloga;
		this.rodjendan = rodjendan;
		this.aktivan = true;
	}
	
	@OneToMany(mappedBy = "clan2", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private  Set<Ocena> ocenee = new HashSet<>();

	@ManyToMany
	@JoinTable(name = "Rezervisano",
				joinColumns = @JoinColumn(name = "clan_id", referencedColumnName = "id"),
				inverseJoinColumns  = @JoinColumn(name = "termin_id", referencedColumnName = "id")
			)
	private Set<Termin> rezervisano = new HashSet<Termin>();
	
	@ManyToMany
	@JoinTable(name = "Prijavljeni",
				joinColumns = @JoinColumn(name = "clan_id", referencedColumnName= "id"),
				inverseJoinColumns = @JoinColumn(name = "termin_id", referencedColumnName = "id")
	)
   	 private Set<Termin> clanovi = new HashSet<Termin>();
	
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

	public boolean isAktivan() {
		return aktivan;
	}

	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}

	
	
	
	

}
