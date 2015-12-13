# Apache Kafka And Avro Example.

This is a simple maven app that uses apache kafka clients and apache avro api libs in order to connect to a kafka instance, send serialized messages by the producer implementation and use the consumer api in order to get and deserialize that messages.

Both classes (Kafka.SimpleConsumer, Kafka.SimpleProducer) have a main method, so, in order to run the example, execute them as you need.

The Avro model is: 
```javascript
{
  "namespace": "Message",
  "type": "record",
  "name": "EventMessage",
  "fields": [
    {
      "name": "machine",
      "type": "string"
    },
    {
      "name": "id",
      "type": "string"
    },
    {
      "name": "date",
      "type": "string"
    },
    {
      "name": "status",
      "type": "string"
    },
    {
      "name": "building",
      "type": "string"
    }
  ]
}
```
And is compiled using the `apache-avro-tools.jar`
