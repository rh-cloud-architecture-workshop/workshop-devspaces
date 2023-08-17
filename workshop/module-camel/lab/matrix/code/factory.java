// camel-k: language=java

import javax.jms.ConnectionFactory;
import org.apache.camel.PropertyInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.qpid.jms.JmsConnectionFactory;
import org.messaginghub.pooled.jms.JmsPoolConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class factory extends RouteBuilder {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(factory.class);

    @PropertyInject("broker.amqp.uri")
    private static String uri;

    @PropertyInject("broker.amqp.connections")
    private static int maxConnections;

    @Override
    public void configure() {
        JmsPoolConnectionFactory myFactory = createConnectionFactory();
        getContext().getRegistry().bind("myFactory", myFactory);
    }

    private JmsPoolConnectionFactory createConnectionFactory() {
        
        ConnectionFactory factory = new JmsConnectionFactory(uri);
        JmsPoolConnectionFactory pool = new JmsPoolConnectionFactory();

        try {
            pool.setConnectionFactory(factory);

            // Set the max connections per user to a higher value
            pool.setMaxConnections(maxConnections);

        } catch (Exception e) {
            LOGGER.error("Exception creating JMS Connection Factory", e);
        }

        return pool;
    }
}
