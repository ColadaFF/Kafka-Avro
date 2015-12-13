package Message;

import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.commons.io.output.ByteArrayOutputStream;

import java.io.IOException;

public class EventMessageSerializer {

    public EventMessageSerializer() throws IOException {

    }

    public byte[] serializeMessage(EventMessage eventMessage) throws IOException {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        BinaryEncoder encoder = EncoderFactory.get().binaryEncoder(out, null);
        DatumWriter<EventMessage> writer = new SpecificDatumWriter<EventMessage>(EventMessage.getClassSchema());
        writer.write(eventMessage, encoder);
        encoder.flush();
        out.close();
        return out.toByteArray();
    }
}
