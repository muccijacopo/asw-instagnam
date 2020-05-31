package asw.instagnam.ricette.eventpublisher;


import asw.instagnam.common.api.event.DomainEvent;
import asw.instagnam.ricette.domain.RicetteDomainEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import java.util.logging.Logger;

@Component
public class RicetteDomainEventPublisherImpl implements RicetteDomainEventPublisher {

    private final Logger logger = Logger.getLogger(RicetteDomainEventPublisherImpl.class.toString());

    @Value("${asw.kafka.channel.out}")
    private String channel;

    @Autowired
    private KafkaTemplate<String, DomainEvent> template;

    @Override
    public void publish(DomainEvent event) {
        logger.info("message");
        template.send(channel, event);
    }

}
