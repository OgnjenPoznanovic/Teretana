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
public class Trening {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String naziv;
	
	@Column
	private String tip;
	
	@Column
	private double trajanje;	
	
    public Trening(String naziv, String tip, double trajanje) {
		this.naziv = naziv;
		this.tip = tip;
		this.trajanje = trajanje;
	}
    
    public Trening() {}
    
    @OneToMany(mappedBy="trening", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Termin> treening = new HashSet<>();
    
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
	
	public Fitness_centar getFitness_centar() {
		return fitness_centar;
	}
	public void setFitness_centar(Fitness_centar fitness_centar) {
		this.fitness_centar = fitness_centar;
	}

	
	
	
	
}
