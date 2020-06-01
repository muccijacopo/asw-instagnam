package asw.instagnam.ricetteseguite.eventlistener;

import asw.instagnam.common.api.event.DomainEvent;
import asw.instagnam.common.api.event.RicettaCreatedEvent;

import asw.instagnam.ricetteseguite.domain.EventHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import java.util.logging.Logger;

@Component
public class RicettaCreatedEventListener {

    private final Logger logger = Logger.getLogger(RicettaCreatedEventListener.class.toString());

    @Value("${asw.kafka.channels.ricette.in}")
    private String channel;

    @Value("${asw.kafka.groupid}")
    private String groupId;

    @Autowired
    private EventHandler eventHandler;

    @KafkaListener(topics = "${asw.kafka.channels.ricette.in}", groupId = "${asw.kafka.groupid}")
    public void listen(ConsumerRecord<String, DomainEvent> record) throws Exception {
        DomainEvent event = record.value();
        if(event.getClass().equals(RicettaCreatedEvent.class)) {
            RicettaCreatedEvent ricettaCreatedEvent = (RicettaCreatedEvent) event;
            eventHandler.onEvent(ricettaCreatedEvent);
        }
    }

}

