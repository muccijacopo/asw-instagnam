package asw.instagnam.ricetteseguite.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ConnessioniService {
	@Autowired
	private ConnessioniRepository connessioniRepository;

	public Collection<Connessione> getConnessioniByFollower(String follower) { return null; }

	public Connessione saveConnessione(Long id, String followed, String follower) {
		Connessione connessione = new Connessione(id, followed, follower);
		return this.connessioniRepository.save(connessione);
	}

	
}
