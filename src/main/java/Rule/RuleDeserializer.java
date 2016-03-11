package Rule;

import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import java.io.EOFException;
import java.io.IOException;

public class RuleDeserializer {
    public RuleDeserializer() {

    }

    public RuleMessage DeserializeRule(byte[] event) throws Exception {
        SpecificDatumReader<RuleMessage> reader = new SpecificDatumReader<RuleMessage>(RuleMessage.getClassSchema());
        Decoder decoder = null;
        try{
            System.out.println(event);
            decoder = DecoderFactory.get().binaryDecoder(event, null);
            return reader.read(null, decoder);
        } catch(EOFException exception){
            exception.printStackTrace();
        } catch(IOException exception){
            exception.printStackTrace();
        }
        return null;
    }
}

