package asw.instagnam.ricetteseguite.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RicetteService {

	@Autowired
	private RicetteRepository ricetteRepository;

    public Collection<Ricetta> getRicetteByAutore(String autore) {
    	return null;
	}

	public Ricetta saveRicetta(Long id, String titolo, String autore) {
		Ricetta ricetta = new Ricetta(id, titolo, autore);
		System.out.println("Titolo: " + ricetta.getTitolo());
		return this.ricetteRepository.save(ricetta);
	}
	
}
