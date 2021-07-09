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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Termin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String vreme;
	
	@Column
	private double cena;
	
	@Column
	private int prijavljenih;
	
	@OneToMany(mappedBy = "termin1", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ocena> ocenjeno = new HashSet<>();

	@ManyToMany(mappedBy = "rezervisano")
    private Set<Clan> uradio = new HashSet<>();
	
	@ManyToMany(mappedBy = "clanovi")
    private Set<Clan> termini = new HashSet<>();
	
	@ManyToOne(fetch = FetchType.EAGER)
    private Sala sale;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Trening trening;
	
	public Termin(String vreme, double cena, int prijavljenih) {
		this.vreme = vreme;
		this.cena = cena;
		this.prijavljenih = prijavljenih;
	}
	
	public Termin() {}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVreme() {
		return vreme;
	}

	public void setVreme(String vreme) {
		this.vreme = vreme;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public int getPrijavljenih() {
		return prijavljenih;
	}

	public void setPrijavljenih(int prijavljenih) {
		this.prijavljenih = prijavljenih;
	}

	public Sala getSale() {
		return sale;
	}

	public void setSale(Sala sale) {
		this.sale = sale;
	}

	public Trening getTrening() {
		return trening;
	}

	public void setTrening(Trening trening) {
		this.trening = trening;
	}

	public Set<Ocena> getOcenjeno() {
		return ocenjeno;
	}

	public void setOcenjeno(Set<Ocena> ocenjeno) {
		this.ocenjeno = ocenjeno;
	}

	public Set<Clan> getUradio() {
		return uradio;
	}

	public void setUradio(Set<Clan> uradio) {
		this.uradio = uradio;
	}

	public Set<Clan> getTermini() {
		return termini;
	}

	public void setTermini(Set<Clan> termini) {
		this.termini = termini;
	}
	
	
	
}
