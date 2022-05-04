package hu.webvalto.kafkademo.services;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class KafkaTestService {

    private final MessageProduceService messageProduceService;

    public KafkaTestService(MessageProduceService messageProduceService) {
        this.messageProduceService = messageProduceService;
    }

    @PostConstruct
    public void sendTestMessage() {
        messageProduceService.sendMessage("Hello Kafka");
    }
}
