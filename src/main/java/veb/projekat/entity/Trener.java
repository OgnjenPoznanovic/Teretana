package veb.projekat.entity;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Trener extends Korisnik{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private ArrayList<Trening> drzi = new ArrayList<Trening>();
	
	@Column
	private double prosecnaOcena;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Fitness_centar fitness_centar;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public ArrayList<Trening> getDrzi() {
		return drzi;
	}

	public void setDrzi(ArrayList<Trening> drzi) {
		this.drzi = drzi;
	}

	public double getProsecnaOcena() {
		return prosecnaOcena;
	}

	public void setProsecnaOcena(double prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}

	public Fitness_centar getFitness_centar() {
		return fitness_centar;
	}

	public void setFitnes_centar(Fitness_centar fitness_centar) {
		this.fitness_centar = fitness_centar;
	}




	


	
	
	
}
