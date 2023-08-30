// camel-k: language=java

import org.apache.camel.builder.RouteBuilder;

public class routesglobex extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("platform-http:/support/message")                      
            .setProperty("clientid", simple("${env.NAMESPACE}"))
            .convertBodyTo(String.class)
            .to("jslt:request.jslt?allowContextMapAll=true")
            .toD("amqp:topic:{{broker.amqp.topic.clients}}${env.NAMESPACE}?disableReplyTo=true&connectionFactory=#myFactory");

        
        from("direct:support-response")
            .convertBodyTo(String.class)
            .to("jslt:response.jslt?allowContextMapAll=true")
            .to("{{client.callback.url}}");

  }
}
