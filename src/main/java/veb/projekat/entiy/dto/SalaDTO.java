package veb.projekat.entiy.dto;


public class SalaDTO {

	private Long id;
	private int kapacitet;
	private String oznaka;
	private int fitnessid;
	
	public SalaDTO() {}

	public SalaDTO(Long id, int kapacitet, String oznaka, int fitnessid) {
		super();
		this.id = id;
		this.kapacitet = kapacitet;
		this.oznaka = oznaka;
		this.fitnessid = fitnessid;
	}

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
