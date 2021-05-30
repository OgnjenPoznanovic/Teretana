package veb.projekat.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Clan extends Korisnik{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy = "clan2", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private  Set<Ocena> ocenee = new HashSet<>();

	@ManyToMany
	@JoinTable(name = "Rezervisano",
				joinColumns = @JoinColumn(name = "clan_id", referencedColumnName = "id"),
				inverseJoinColumns  = @JoinColumn(name = "termin_id", referencedColumnName = "id")
			)
	private Set<Termin> rezervisano = new HashSet<Termin>();
	
	@ManyToMany
	@JoinTable(name = "Prijavljeni",
				joinColumns = @JoinColumn(name = "clan_id", referencedColumnName= "id"),
				inverseJoinColumns = @JoinColumn(name = "termin_id", referencedColumnName = "id")
	)
   	 private Set<Termin> clanovi = new HashSet<Termin>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	
	
	

}
