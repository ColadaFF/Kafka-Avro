package Kafka;

import Message.EventMessage;
import Message.EventMessageSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class SimpleProducer {
    private final Producer<String, byte[]> kafkaProducer;


    public SimpleProducer() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.1.54:9092");
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
        kafkaProducer.send(new ProducerRecord<String, byte[]>("play-stream", Id, event));
    }

    public static void main(String[] args) {
        SimpleProducer sp = new SimpleProducer();
        EventMessage event = new EventMessage();
        String[] machines = {"pump_1", "pump_2", "tank_1", "tank_2"};
        event.setBuilding("building_3");
        event.setId("5ba51e3");
        event.setDate(new Date().getTime());
        float minX = 1f;
        float maxX = 100.0f;
        Random rand = new Random();
        try {
            EventMessageSerializer eventMessageSerializer = new EventMessageSerializer();
            for (int i = 0; i < 10000; i++) {
                event.setStatus(rand.nextFloat() * (maxX - minX) + minX);
                event.setMachine(machines[new Random().nextInt(machines.length)]);
                sp.publish(eventMessageSerializer.serializeMessage(event), event.getId().toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
