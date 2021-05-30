package veb.projekat.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ocena {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Double ocena;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Clan clan2;
	
	@ManyToOne(fetch = FetchType.EAGER)
    private Termin termin1;
	
	public Double getOcena() {
		return ocena;
	}

	public void setOcena(Double ocena) {
		this.ocena = ocena;
	}
	
	
}
