// camel-k: language=java

import org.apache.camel.builder.RouteBuilder;

public class globexlistener extends RouteBuilder {

    @Override
  public void configure() throws Exception {


	  String instanceId = System.getenv("NAMESPACE");
	  String amqpUri    = "amqp:topic:{{broker.amqp.topic.clients.globex}}"+instanceId+"?connectionFactory=#myFactory";
 
      // Write your routes here, for example:
      from(amqpUri)
        .routeId("amqp-globex-consumer")
        .log("new GLOBEX message: ${body}")
        .to("direct:support-request");

  }
}
