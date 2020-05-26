package asw.instagnam.ricetteseguite.messageSubscriber;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class RicettaListener {
    @KafkaListener(topics = "ricette", groupId = "ricette-seguite")
    public void listen(ConsumerRecord<String, String> record) {
        System.out.println("Listen message: "+ record.value());
    }


}
