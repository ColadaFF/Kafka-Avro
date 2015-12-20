package Storm.Kafka;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Tuple;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import java.io.File;

public class KafkaLogger extends BaseBasicBolt {
    private static final Logger LOGGER = Logger.getLogger(KafkaLogger.class);

    @Override
    public void execute(Tuple tuple, BasicOutputCollector basicOutputCollector) {
        LOGGER.debug("Printing Incoming Messages");
        String data = tuple.getString(0);
        try {
            System.out.println(data);
            File file = new File("test.txt");
            FileUtils.writeStringToFile(file, data);

        }catch(Exception ex){
            LOGGER.error("Error while printing the messages");
            LOGGER.trace(null, ex);
        }
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {

    }
}
