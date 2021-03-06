package asw.instagnam.ricetteseguite.domain;

import asw.instagnam.common.api.event.DomainEvent;

import asw.instagnam.common.api.event.RicettaCreatedEvent;
import asw.instagnam.common.api.event.ConnessioneCreatedEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class EventHandler {

    private final Logger logger = Logger.getLogger(EventHandler.class.toString());
    @Autowired
    private RicetteService ricetteService;
    @Autowired
    private ConnessioniService connessioniService;

    @Value("${asw.kafka.consumer.name}")
    private String consumerName;

    public void onEvent(DomainEvent event) {
        if (event.getClass().equals(RicettaCreatedEvent.class)) {
            RicettaCreatedEvent rce = (RicettaCreatedEvent) event;
            createRicetta(rce);
        }
        else if(event.getClass().equals(ConnessioneCreatedEvent.class)) {
            ConnessioneCreatedEvent cce = (ConnessioneCreatedEvent) event;
            createConnessione(cce);
        }
        else {
            logger.info("UNKNOWN COMMAND: " + event);
        }
    }

    private void createRicetta(RicettaCreatedEvent event) {
        logger.info("RECEIVED RICETTA: " + event.getTitolo());
        ricetteService.saveRicetta(event.getId(), event.getTitolo(), event.getAutore());
    }

    private void createConnessione(ConnessioneCreatedEvent event) {
        logger.info("RECEIVED CONNESSIONE: " + event.getFollower());
        connessioniService.saveConnessione(event.getId(), event.getFollowed(), event.getFollower());
    }

}
