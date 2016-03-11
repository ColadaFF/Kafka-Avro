package Kafka;

import Message.EventMessage;
import Message.EventMessageDeserializer;
import Rule.RuleDeserializer;
import Rule.RuleMessage;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class SimpleConsumer {
    public SimpleConsumer() {

    }

    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.put("bootstrap.servers", "ec2-52-2-239-144.compute-1.amazonaws.com:9092");
        props.put("group.id", "events");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.ByteArrayDeserializer");
        KafkaConsumer<String, byte[]> consumer = new KafkaConsumer<String, byte[]>(props);
        consumer.subscribe(Arrays.asList("events"));
        while (true) {
            ConsumerRecords<String, byte[]> records = consumer.poll(100);
            for (ConsumerRecord<String, byte[]> record : records) {
                RuleMessage eventMessage = new RuleDeserializer().DeserializeRule(record.value());
                System.out.printf("offset = %d, key = %s, value = %s \n", record.offset(), record.key(), eventMessage);
            }

        }
    }
}
