package Storm.Test;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CommitFeedListener extends BaseRichSpout{
    private SpoutOutputCollector outputCollector;
    private List<String> commits;

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("commit"));
    }

    @Override
    public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {
        this.outputCollector = spoutOutputCollector;

        try{
            commits = IOUtils.readLines(
                    new FileInputStream("changelog.txt"),
                    Charset.defaultCharset().name()
            );
            System.out.println("Array " +Arrays.toString(commits.toArray()));
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void nextTuple() {
        for(String commit: commits){
            outputCollector.emit(new Values(commit));
        }
    }

}
