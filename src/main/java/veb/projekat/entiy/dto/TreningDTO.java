package veb.projekat.entiy.dto;



public class TreningDTO {
	
	private Long id;
	private String naziv;
	private String tip;
	private double trajanje;
	
	public TreningDTO() {}

	public TreningDTO(Long id, String naziv, String tip, double trajanje) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.tip = tip;
		this.trajanje = trajanje;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public double getTrajanje() {
		return trajanje;
	}

	public void setTrajanje(double trajanje) {
		this.trajanje = trajanje;
	}
	
	

}
