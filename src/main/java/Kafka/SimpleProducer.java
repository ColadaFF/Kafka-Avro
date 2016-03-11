package Kafka;

import Message.EventMessage;
import Message.EventMessageSerializer;
import org.apache.kafka.clients.producer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.EOFException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ExecutionException;

public class SimpleProducer {
    private final Producer<String, byte[]> kafkaProducer;
    private static final Logger logger = LoggerFactory.getLogger(SimpleProducer.class);

    public SimpleProducer() {
        logger.debug("added props");
        Properties props = new Properties();
        props.put("bootstrap.servers", "52.2.239.144:9092");
        props.put("acks", "1");
        props.put("retries", 0);
        props.put("compression.type", "gzip");
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
        kafkaProducer = new KafkaProducer(props);
    }

    public void publish(byte[] event, String Id) throws ExecutionException, InterruptedException {
        logger.debug("Send message");
        RecordMetadata m = kafkaProducer.send(new ProducerRecord<String, byte[]>(
                "events", Id, event)).get();
        System.out.println("Message produced, offset: " + m.offset());
        System.out.println("Message produced, partition : " + m.partition());
        System.out.println("Message produced, topic: " + m.topic());
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
            for (int i = 0; i < 10; i++) {
                event.setStatus(rand.nextFloat() * (maxX - minX) + minX);
                event.setMachine(machines[new Random().nextInt(machines.length)]);
                sp.publish(eventMessageSerializer.serializeMessage(event), event.getId().toString());
            }
        } catch (EOFException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
