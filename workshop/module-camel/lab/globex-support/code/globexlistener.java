// camel-k: language=java

import org.apache.camel.builder.RouteBuilder;

public class globexlistener extends RouteBuilder {

  @Override
  public void configure() throws Exception {

    //ID will be: globex-camel-user1, globex-camel-user2, globex-camel-user3
	  String instanceId = System.getenv("NAMESPACE");
	  String amqpUri    = "amqp:topic:{{broker.amqp.topic.agents}}"+instanceId+"?connectionFactory=#myFactory";

    // Write your routes here, for example:
    from(amqpUri)
      .routeId("amqp-globex-consumer")
      .to("direct:support-response");

  }
}
