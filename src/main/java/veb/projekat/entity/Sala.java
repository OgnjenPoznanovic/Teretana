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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Sala {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private int kapacitet;
	
	@Column
	private String oznaka;
	
	@Column
	private int fitnessid;
	/*
	@ManyToOne(fetch = FetchType.EAGER)
	private Fitness_centar fitness_centar;
	*/
	
	@OneToMany(mappedBy = "sale", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Termin> salaa = new HashSet<>();

	@ManyToMany
	@JoinTable(name = "lista_treninga",
			joinColumns = @JoinColumn(name = "sala_id", referencedColumnName= "id"),
			inverseJoinColumns = @JoinColumn(name = "trening_id", referencedColumnName = "id")
			)
	private Set<Trening> treninzi = new HashSet<>();
	
	public Sala(int kapacitet, String oznaka, int fitnessid) {
		this.kapacitet= kapacitet;
		this.oznaka = oznaka;
		this.fitnessid = fitnessid;	
	}
	
	public Sala() {}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getKapacitet() {
		return kapacitet;
	}

	public void setKapacitet(int kapacitet) {
		this.kapacitet = kapacitet;
	}

	public String getOznaka() {
		return oznaka;
	}

	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}

	public int getFitnessid() {
		return fitnessid;
	}

	public void setFitnessid(int fitnessid) {
		this.fitnessid = fitnessid;
	}



	
	
	
	
	
}
