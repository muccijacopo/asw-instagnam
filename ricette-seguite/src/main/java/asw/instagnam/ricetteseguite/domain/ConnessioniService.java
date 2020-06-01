package asw.instagnam.ricetteseguite.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ConnessioniService {
	@Autowired
	private ConnessioniRepository connessioniRepository;
	@Autowired
	private RicetteService ricetteService;
	@Autowired
	private RicetteSeguiteService ricetteSeguiteService;

	public Collection<Connessione> getConnessioniByFollower(String follower) { return null; }

	public Collection<Connessione> getFollowers(String autore) {
		return this.connessioniRepository.findAllByFollowed(autore);
	}


	public Connessione saveConnessione(Long id, String followed, String follower) {
		Connessione connessione = new Connessione(id, follower, followed);
		connessione = this.connessioniRepository.save(connessione);

		for (Ricetta ricetta: ricetteService.getRicetteByAutore(connessione.getFollowed())) {
			this.ricetteSeguiteService.saveRicettaSeguita(ricetta.getId(), ricetta.getTitolo(), ricetta.getAutore(), connessione.getFollower());
		}

		return connessione;
	}
}
