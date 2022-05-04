package hu.webvalto.kafkademo.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumeService {

    @KafkaListener(topics = "tanfolyam", groupId = "group")
    public void listenGroupTanfolyam(String message, @Header(KafkaHeaders.PARTITION_ID) int partition) {
        System.out.println(message);
    }

    @KafkaListener(
            topicPartitions = @TopicPartition(
                    topic = "tanfolyam", partitionOffsets = @PartitionOffset(partition = "0", initialOffset = "0")))
    public void listenPartiotionTanfolyam(String message, @Header(KafkaHeaders.PARTITION_ID) int partition) {
        System.out.println(partition);
    }
}
