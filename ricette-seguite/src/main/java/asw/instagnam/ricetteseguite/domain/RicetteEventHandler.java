package asw.instagnam.ricetteseguite.domain;

import asw.instagnam.common.api.event.RicettaCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import java.util.logging.Logger;

@Service
public class RicetteEventHandler {

    private final Logger logger = Logger.getLogger(RicetteEventHandler.class.toString());
    @Autowired
    private RicetteService ricetteService;

    @Value("${asw.kafka.consumer.name}")
    private String consumerName;

    public void onEvent(RicettaCreatedEvent rce) {
//        String titoloRicetta = rce.getTitolo();
//        System.out.println("RECEIVED RICETTA: " + titoloRicetta);
//        String eventLog = String.format("RECEIVED RICETTA: ", titoloRicetta);
//        logger.info(eventLog);
        Ricetta ricetta = ricetteService.saveRicetta(rce.getId(), rce.getTitolo(), rce.getAutore());
        logger.info("Ricetta created: " + ricetta.getTitolo());
    }

}
