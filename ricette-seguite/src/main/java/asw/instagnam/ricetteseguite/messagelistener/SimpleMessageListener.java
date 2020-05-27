package asw.instagnam.ricetteseguite.messagelistener;

import asw.instagnam.ricetteseguite.domain.DomainEvent;
import asw.instagnam.ricetteseguite.domain.SimpleConsumerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import java.util.logging.Logger;

@Component
public class SimpleMessageListener {

    private final Logger logger = Logger.getLogger(SimpleMessageListener.class.toString());

    @Value("${asw.kafka.channel.in}")
    private String channel;

    @Value("${asw.kafka.groupid}")
    private String groupId;

    @Autowired
    private SimpleConsumerService simpleConsumerService;

    @KafkaListener(topics = "${asw.kafka.channel.in}", groupId="${asw.kafka.groupid}")
    public void listen(ConsumerRecord<String, String> record) throws Exception {
        logger.info("MESSAGE LISTENER: " + record.toString());
        String message = record.value();
        simpleConsumerService.onMessage(message);
    }

}

