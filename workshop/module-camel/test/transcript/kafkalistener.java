// camel-k: language=java

import org.apache.camel.builder.RouteBuilder;

public class kafkalistener extends RouteBuilder {
  @Override
  public void configure() throws Exception {

	  String instanceId = System.getenv("NAMESPACE");
	  String kafkaUri    = "kafka:support."+instanceId+".closed";

    // Write your routes here, for example:
    from(kafkaUri)
      .routeId("kafka-consumer")
      .to("direct:process");

  }
}
