package veb.projekat.entiy.dto;


public class TerminDTO {

	private Long id;
	private String vreme;
	private double cena;
	private int prijavljenih;

	
	public TerminDTO() {}



	public TerminDTO(Long id, String vreme, double cena, int prijavljenih) {
		this.id = id;
		this.vreme = vreme;
		this.cena = cena;
		this.prijavljenih = prijavljenih;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVreme() {
		return vreme;
	}
	public void setVreme(String vreme) {
		this.vreme = vreme;
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

	
}
