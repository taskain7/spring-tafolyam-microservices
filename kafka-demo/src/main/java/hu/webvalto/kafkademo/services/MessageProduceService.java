package hu.webvalto.kafkademo.services;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class MessageProduceService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Qualifier("topic1")
    private final NewTopic topic;

    public MessageProduceService(KafkaTemplate<String, String> kafkaTemplate, NewTopic topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    public void sendMessage(String message) {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic.name(), message);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Failed");
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("success" + result.getProducerRecord().value());
            }
        });
    }
}
