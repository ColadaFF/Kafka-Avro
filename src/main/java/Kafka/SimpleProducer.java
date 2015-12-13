package Kafka;

import Message.EventMessage;
import Message.EventMessageSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class SimpleProducer {
    private final Producer<String, byte[]> kafkaProducer;


    public SimpleProducer() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "127.0.0.1:9092");
        props.put("acks", "all");
        props.put("retries", 10);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
        kafkaProducer = new KafkaProducer(props);
    }

    public void publish(byte[] event, String Id) {
        kafkaProducer.send(new ProducerRecord<String, byte[]>("test", Id, event));
        kafkaProducer.close();
    }

    public static void main(String[] args) {
        SimpleProducer sp = new SimpleProducer();
        EventMessage event = new EventMessage();
        event.setMachine("pump_1");
        event.setBuilding("building_3");
        event.setId("5ba51e3");
        event.setDate(new Date().toString());
        event.setStatus(Float.toString(1.2f));
        try {
            EventMessageSerializer eventMessageSerializer = new EventMessageSerializer();
            sp.publish(eventMessageSerializer.serializeMessage(event), event.getId().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*Properties props = new Properties();
        props.put("bootstrap.servers", "127.0.0.1:9092");
        props.put("acks", "all");
        props.put("retries", 10);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> producer = new KafkaProducer(props);
        for (int i = 0; i < 100; i++) {
            EventMessage event = new EventMessage();
            event.setMachine("pump_1");
            event.setBuilding("building_3");
            event.setId("5ba51e3");
            event.setDate(new Date().toString());
            event.setStatus(Float.toString(1.2f));
            producer.send(new ProducerRecord<String, EventMessage>("test", Integer.toString(i), ));
        }
        producer.close();*/
    }
}
