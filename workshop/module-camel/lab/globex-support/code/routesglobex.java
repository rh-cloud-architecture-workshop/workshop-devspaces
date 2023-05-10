// camel-k: language=java

import org.apache.camel.builder.RouteBuilder;

public class routesglobex extends RouteBuilder {
  @Override
  public void configure() throws Exception {

      // Write your routes here, for example:
      from("platform-http:/support/message")                      // <1>
        .setProperty("clientid", simple("${env.NAMESPACE}"))      // <2>
        .convertBodyTo(String.class)                              // <3>
        .to("jslt:request.jslt?allowContextMapAll=true")          // <4>
        .toD("amqp:topic:{{broker.amqp.topic.clients}}${env.NAMESPACE}?disableReplyTo=true&connectionFactory=#myFactory");  // <5>

        
      from("direct:support-response")                      // <1>
        .convertBodyTo(String.class)                       // <2>
        .to("jslt:response.jslt?allowContextMapAll=true")  // <3>
        .to("{{client.callback.url}}");                    // <4>

  }
}
