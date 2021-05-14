package veb.projekat.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Trening {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String naziv;
	
	@Column
	private Date opis;
	
	@Column
	private String vreme;
	
	@Column
	private String tip;
	
	@Column
	private double trajanje;
	
	@Column
	private double cena;
	
	@Column
	private int prijavljenih;
	
    @ManyToMany(mappedBy = "treninzi")
    private Set<Sala> sale = new HashSet<>();
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Fitness_centar fitness_centar;

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
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public double getTrajanje() {
		return trajanje;
	}
	public void setTrajanje(double trajanje) {
		this.trajanje = trajanje;
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
	public Date getOpis() {
		return opis;
	}
	public void setOpis(Date opis) {
		this.opis = opis;
	}
	
	public String getVreme() {
		return vreme;
	}
	public void setVreme(String vreme) {
		this.vreme = vreme;
	}
	public Fitness_centar getFitness_centar() {
		return fitness_centar;
	}
	public void setFitness_centar(Fitness_centar fitness_centar) {
		this.fitness_centar = fitness_centar;
	}

	
	
	
	
}
