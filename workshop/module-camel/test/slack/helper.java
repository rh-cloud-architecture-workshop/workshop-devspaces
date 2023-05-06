// package org.demo;

//Camel API
import org.apache.camel.BindToRegistry;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.PropertyInject;
import org.apache.camel.builder.RouteBuilder;

public class helper extends RouteBuilder {
    
    @PropertyInject("slack.app.id")
    private static String appid;

    //dummy
    @Override
    public void configure() throws Exception {}

    //declaration
    public static class Creator {};

    @BindToRegistry
    public Creator creator(CamelContext context) throws Exception {

        //implementation
        return new Creator(){

            public void startListener(String ticket,CamelContext context) throws Exception{

                String uri="ahc-wss://wss-primary.slack.com/link/?ticket="+ticket+"&app_id="+appid;

                context.addRoutes(new RouteBuilder() {
                    @Override
                    public void configure() throws Exception {
                        from(uri)
                        .to("direct:listener");

                        from("direct:producer")
                        .to(uri);
                    }
                });

                context.start();
            }
        };
    }
}