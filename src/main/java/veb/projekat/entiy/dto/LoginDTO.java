package veb.projekat.entiy.dto;

public class LoginDTO {
	
	private Long id;
	private String korisnicko_ime;
	private String lozinka;
	
	public LoginDTO() {}
	
	

	public LoginDTO(Long id, String korisnicko_ime, String lozinka) {
		super();
		this.id = id;
		this.korisnicko_ime = korisnicko_ime;
		this.lozinka = lozinka;
	}

	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getKorisnicko_ime() {
		return korisnicko_ime;
	}
	public void setKorisnicko_ime(String korisnicko_ime) {
		this.korisnicko_ime = korisnicko_ime;
	}
	public String getLozinka() {
		return lozinka;
	}
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	
	
}
