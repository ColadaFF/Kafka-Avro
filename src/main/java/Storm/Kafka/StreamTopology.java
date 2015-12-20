package Storm.Kafka;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.StormSubmitter;
import backtype.storm.generated.AlreadyAliveException;
import backtype.storm.generated.InvalidTopologyException;
import backtype.storm.generated.StormTopology;
import backtype.storm.spout.SchemeAsMultiScheme;
import backtype.storm.topology.TopologyBuilder;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import storm.kafka.KafkaSpout;
import storm.kafka.SpoutConfig;
import storm.kafka.StringScheme;
import storm.kafka.ZkHosts;

public class StreamTopology {
    private final Logger LOGGER = Logger.getLogger(this.getClass());
    private static final String KAFKA_TOPIC = Properties.getString("kfm.storm.kafka_topic");


    public static void main(String[] args) throws InterruptedException, AlreadyAliveException, InvalidTopologyException {
        /*BasicConfigurator.configure();
        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology(
                "kafka-events-streams",
                createConfig(true),
                createTopology()
        );
        Thread.sleep(60000);
        cluster.shutdown();*/
        if (args.length <= 0 || args.length > 2 || StringUtils.isBlank(args[0])) {
            System.out.println("Error deploying topology.");
            System.out.println("Usage: <topology name> debug(optional)");
            System.out.println("Please provide correct command-line arguments and try again.");
            System.exit(1);
        }

        String topologyName = args[0];
        Config config = createConfig(shouldRunInDebugMode(args));
        StormSubmitter.submitTopology(topologyName, config, createTopology());

    }

    private static boolean shouldRunInDebugMode(String[] args) {
        return args.length > 1 && "debug".equalsIgnoreCase(args[1]);
    }


    private static StormTopology createTopology(){
        SpoutConfig  kafkaConf = new SpoutConfig(
                new ZkHosts(Properties.getString("kfm.storm.zkHost")),
                KAFKA_TOPIC,
                "/kafka",
                "KafkaSpout"
        );
        kafkaConf.scheme = new SchemeAsMultiScheme(new StringScheme());
        TopologyBuilder builder = new TopologyBuilder();

        builder
                .setSpout("kafka_spout", new KafkaSpout(kafkaConf), 4);

        builder
                .setBolt("kafka_logger", new KafkaLogger(), 4)
                .shuffleGrouping("kafka_spout");

        return builder.createTopology();
    }

    private static Config createConfig(boolean local) {
        int workers = Properties.getInt("kfm.storm.workers");
        Config conf = new Config();
        if (local) {
            conf.setMaxTaskParallelism(workers);
        } else {
            conf.setNumWorkers(workers);
        }
        return conf;
    }
}
