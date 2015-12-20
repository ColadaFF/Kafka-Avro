package Kafka;

import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.List;

public class KafkaBrokerInfoFetcher {
    public static void main(String[] args) throws Exception {
        ZooKeeper zk = new ZooKeeper("solr:2181", 10000, null);
        List<String> ids = zk.getChildren("/brokers/ids", false);
        Stat ex = zk.exists("/brokers/topics", true);
        for (String id : ids) {
            String brokerInfo = new String(zk.getData("/brokers/ids/" + id, false, null));
            System.out.println(id + ": " + brokerInfo);
        }
        System.out.println(ex.getNumChildren());
    }

}
