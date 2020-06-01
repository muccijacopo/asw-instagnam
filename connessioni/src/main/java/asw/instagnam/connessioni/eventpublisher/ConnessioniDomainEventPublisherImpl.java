package asw.instagnam.connessioni.eventpublisher;

import asw.instagnam.common.api.event.DomainEvent;

import asw.instagnam.connessioni.domain.ConnessioniDomainEventPublisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class ConnessioniDomainEventPublisherImpl implements ConnessioniDomainEventPublisher {

    private final Logger logger = Logger.getLogger(ConnessioniDomainEventPublisherImpl.class.toString());

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
