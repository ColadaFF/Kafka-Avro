package Storm.Kafka;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.Configuration;
import org.apache.log4j.Logger;

public class Properties {
    private static final Logger LOGGER = Logger.getLogger(Properties.class);
    private static Properties singleton;
    private Configuration configuration;

    private Properties() {
        try {
            this.configuration = new PropertiesConfiguration(
                    this.getClass().getResource("/kafka-storm.Properties")
            );
        } catch (Exception ex) {
            LOGGER.fatal("Could not load configuration", ex);
            LOGGER.trace(null, ex);
        }
    }

    private static Properties get() {
        if (singleton == null) {
            singleton = new Properties();
        }
        return singleton;
    }

    public static String getString(String key) {
        return get().configuration.getString(key);
    }

    public static Integer getInt(String key) {
        return get().configuration.getInt(key);
    }
}
