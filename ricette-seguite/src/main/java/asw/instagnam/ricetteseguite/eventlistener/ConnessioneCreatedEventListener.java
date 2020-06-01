package asw.instagnam.ricetteseguite.eventlistener;

import asw.instagnam.common.api.event.DomainEvent;

import asw.instagnam.common.api.event.ConnessioneCreatedEvent;
import asw.instagnam.ricetteseguite.domain.EventHandler;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class ConnessioneCreatedEventListener {

    private final Logger logger = Logger.getLogger(ConnessioneCreatedEventListener.class.toString());

    @Value("${asw.kafka.channels.connessioni.in}")
    private String channel;

    @Value("${asw.kafka.groupid}")
    private String groupId;

    @Autowired
    private EventHandler eventHandler;

    @KafkaListener(topics = "${asw.kafka.channels.connessioni.in}", groupId = "${asw.kafka.groupid}")
    public void listen(ConsumerRecord<String, DomainEvent> record) throws Exception {
        DomainEvent event = record.value();
        if(event.getClass().equals(ConnessioneCreatedEvent.class)) {
            ConnessioneCreatedEvent connessioneCreatedEvent = (ConnessioneCreatedEvent) event;
            eventHandler.onEvent(connessioneCreatedEvent);
        }
    }

}

