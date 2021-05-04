package veb.projekat.entity;

import java.util.HashSet;
import java.util.Set;

public class Sala {
	private int kapacitet;
	private String oznaka;
	
	private Fitness_centar fitnes_centar;
	
	private Set<Trening> treninzi = new HashSet<>();

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

	public Fitness_centar getFitnes_centar() {
		return fitnes_centar;
	}

	public void setFitnes_centar(Fitness_centar fitnes_centar) {
		this.fitnes_centar = fitnes_centar;
	}

	public Set<Trening> getTreninzi() {
		return treninzi;
	}

	public void setTreninzi(Set<Trening> treninzi) {
		this.treninzi = treninzi;
	}
	
	
	
}
