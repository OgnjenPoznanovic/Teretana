package veb.projekat.entiy.dto;

import veb.projekat.entity.Termin;

public class ClanTerminDTO {
	
	private Long id;
	Termin termin;
	
	public ClanTerminDTO() {}

	public ClanTerminDTO(Long id, Termin termin) {
		super();
		this.id = id;
		this.termin = termin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Termin getTermin() {
		return termin;
	}

	public void setTermin(Termin termin) {
		this.termin = termin;
	}
	
	

}
