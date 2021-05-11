package veb.projekat.entity;

import java.util.HashSet;
import java.util.Set;

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

@Entity
public class Sala {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private int kapacitet;
	
	@Column
	private String oznaka;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Fitness_centar fitness_centar;
	
	
	@ManyToMany
	@JoinTable(name = "lista_treninga",
				joinColumns = @JoinColumn(name = "sala_id", referencedColumnName= "id"),
				inverseJoinColumns = @JoinColumn(name = "trening_id", referencedColumnName = "id"))
	private Set<Trening> treninzi = new HashSet<>();

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

	public Fitness_centar getFitness_centar() {
		return fitness_centar;
	}

	public void setFitness_centar(Fitness_centar fitness_centar) {
		this.fitness_centar = fitness_centar;
	}

	
	
	
	
	
}
