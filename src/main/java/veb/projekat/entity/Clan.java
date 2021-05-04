package veb.projekat.entity;

import java.util.ArrayList;

public class Clan extends Korisnik{
	
	private ArrayList<Trening> odradjeni = new ArrayList<Trening>();
	
	private ArrayList<Trening> prijavljeni = new ArrayList<Trening>();
	
	private ArrayList<Double> ocena = new ArrayList<Double>();

	public ArrayList<Trening> getOdradjeni() {
		return odradjeni;
	}

	public void setOdradjeni(ArrayList<Trening> odradjeni) {
		this.odradjeni = odradjeni;
	}

	public ArrayList<Trening> getPrijavljeni() {
		return prijavljeni;
	}

	public void setPrijavljeni(ArrayList<Trening> prijavljeni) {
		this.prijavljeni = prijavljeni;
	}

	public ArrayList<Double> getOcena() {
		return ocena;
	}

	public void setOcena(ArrayList<Double> ocena) {
		this.ocena = ocena;
	}
	
	
	
	

}
