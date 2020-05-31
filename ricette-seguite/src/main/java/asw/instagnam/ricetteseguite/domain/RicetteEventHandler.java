package asw.instagnam.ricetteseguite.domain;

import asw.instagnam.common.api.event.RicettaCreatedEvent;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import java.util.logging.Logger;

@Service
public class RicetteEventHandler {

    private final Logger logger = Logger.getLogger(RicetteEventHandler.class.toString());

    @Value("${asw.kafka.consumer.name}")
    private String consumerName;

    public void onEvent(RicettaCreatedEvent rce) {
        String eventLog = String.format("RECEIVED RICETTA: ", rce.getTitolo());
        logger.info(eventLog);
    }

}
