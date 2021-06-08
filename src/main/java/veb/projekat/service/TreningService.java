package veb.projekat.service;

import veb.projekat.repository.TreningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import veb.projekat.entity.Trening;


@Service
public class TreningService {

	@Autowired
	private TreningRepository treningRepository;
	
	
	
	public List<Trening> findAll(){
		List<Trening> treninzi = this.treningRepository.findAll();
		return treninzi;
	}
	
}
