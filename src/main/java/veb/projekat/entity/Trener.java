package veb.projekat.entity;

import java.util.ArrayList;

public class Trener extends Korisnik{

	private ArrayList<Trening> drzi = new ArrayList<Trening>();
	
	private double prosecnaOcena;
	
	private Fitness_centar fitnes_centar;

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

	public Fitness_centar getFitnes_centar() {
		return fitnes_centar;
	}

	public void setFitnes_centar(Fitness_centar fitnes_centar) {
		this.fitnes_centar = fitnes_centar;
	}

	


	


	
	
	
}
