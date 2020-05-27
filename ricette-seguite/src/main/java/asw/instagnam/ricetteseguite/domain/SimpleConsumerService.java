package asw.instagnam.ricetteseguite.domain;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import java.util.logging.Logger;

@Service
public class SimpleConsumerService {

    private final Logger logger = Logger.getLogger(SimpleConsumerService.class.toString());

    @Value("${asw.kafka.consumer.name}")
    private String consumerName;

    public void onMessage(String message) {
        String logMessage = String.format("RECEIVED MESSAGE", consumerName, message);
        logger.info(logMessage);
    }

}
