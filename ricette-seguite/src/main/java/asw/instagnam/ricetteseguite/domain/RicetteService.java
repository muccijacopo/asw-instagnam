package asw.instagnam.ricetteseguite.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.logging.Logger;

@Service
public class RicetteService {
	private final Logger logger = Logger.getLogger(RicetteService.class.toString());
	@Autowired
	private RicetteRepository ricetteRepository;
	@Autowired
	private ConnessioniService connessioniService;
	@Autowired
	private RicetteSeguiteService ricetteSeguiteService;


	public Ricetta saveRicetta(Long id, String titolo, String autore) {
		Ricetta ricetta = new Ricetta(id, autore, titolo);
		ricetta = this.ricetteRepository.save(ricetta);

		for (Connessione connessione: connessioniService.getFollowers(autore)) {
			this.ricetteSeguiteService.saveRicettaSeguita(id, titolo, autore, connessione.getFollower());
		}

		return ricetta;
	}

	public Collection<Ricetta> getRicetteByAutore(String autore) {
		return this.ricetteRepository.findAllByAutore(autore);
	}
	
}
