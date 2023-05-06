// camel-k: language=java

import org.apache.camel.builder.RouteBuilder;

public class gbxlistener extends RouteBuilder {
  @Override
  public void configure() throws Exception {


	  String instanceId = System.getenv("NAMESPACE");
	  String amqpUri    = "amqp:topic:{{broker.amqp.topic.clients.globex}}"+instanceId+"?connectionFactory=#myFactory";
 
        // <from uri="amqp:topic:{{broker.amqp.topic.clients.globex}}.?connectionFactory=#myFactory"/>
        // <log message="new NODEJS message: ${body}"/>
        // <to uri="direct:support-request"/>

      // Write your routes here, for example:
      from(amqpUri)
        .routeId("amqp-globex-consumer")
        .log("new GLOBEX message: ${body}")
        .to("direct:support-request");

  }
}
