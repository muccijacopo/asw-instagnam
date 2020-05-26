package asw.instagnam.ricette.domain;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger; 
import java.util.*; 

@Service
public class RicetteService {

	@Autowired
	private RicetteRepository ricetteRepository;

	@Autowired
	private SimpleMessagePublisher simpleMessagePublisher;

	private final Logger logger = Logger.getLogger(RicetteService.class.toString());

	public RicettaCompleta createRicetta(String autore, String titolo, String preparazione) {
		RicettaCompleta ricetta = new RicettaCompleta(autore, titolo, preparazione); 
		ricetta = ricetteRepository.save(ricetta);

		logger.info("PUBLISHING MESSAGE: " + ricetta);
		simpleMessagePublisher.publish(titolo);

		return ricetta;
	}

 	public RicettaCompleta getRicetta(Long id) {
		RicettaCompleta ricetta = ricetteRepository.findById(id).orElse(null);
		return ricetta;
	}

	public Collection<RicettaCompleta> getRicette() {
		Collection<RicettaCompleta> ricette = ricetteRepository.findAll();
		return ricette;
	}

	public Collection<RicettaCompleta> getRicetteByAutore(String autore) {
		Collection<RicettaCompleta> ricette = ricetteRepository.findAllByAutore(autore);
		return ricette;
	}

}
