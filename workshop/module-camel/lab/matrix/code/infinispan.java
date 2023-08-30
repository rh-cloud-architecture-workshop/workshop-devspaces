// camel-k: language=java

import org.apache.camel.builder.RouteBuilder;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;

import java.util.Properties;

public class infinispan extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        Properties props = getContext().getPropertiesComponent().loadProperties(key -> key.startsWith("infinispan.client"));

        // create remote infinispan cache manager and start it
        RemoteCacheManager remote = new RemoteCacheManager(
                new ConfigurationBuilder().withProperties(props).build(),
                true
        );

        getContext().getRegistry().bind("myCM", remote);
    }
}
