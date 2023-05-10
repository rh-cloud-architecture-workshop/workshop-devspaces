// package org.demo;

//Camel API
import org.apache.camel.AggregationStrategy;
import org.apache.camel.BindToRegistry;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.PropertyInject;
import org.apache.camel.builder.RouteBuilder;

//PDFBox API
// import org.apache.pdfbox.pdmodel.PDDocument;
// import org.apache.pdfbox.pdmodel.PDPage;
// import org.apache.pdfbox.pdmodel.PDPageContentStream;
// import org.apache.pdfbox.pdmodel.font.PDType1Font;
// import org.apache.pdfbox.pdmodel.common.PDRectangle;

//Java API
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class aggregation extends RouteBuilder {
    
    //dummy
    @Override
    public void configure() throws Exception {}


    @BindToRegistry
    public static AggregationStrategy myStrategy(){

        return new AggregationStrategy() {
            public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {

System.out.println("props: "+newExchange.getProperties());

                if (oldExchange == null) {
                    return newExchange;
                }

                oldExchange.setProperty("continue", newExchange.getProperty("continue"));

                //ignore last message (body is 'done')
                if(newExchange.getProperty("continue").equals("false")) {
                
                    oldExchange.setProperty("context", newExchange.getIn().getHeader("context"));
                    oldExchange.setProperty("source",  newExchange.getIn().getHeader("source" ));
                    return oldExchange;
                }

                String oldBody = oldExchange.getIn().getBody(String.class);
                String newBody = newExchange.getIn().getBody(String.class);
                oldExchange.getIn().setBody(oldBody + "\n" + newBody);

                return oldExchange;
            }
        };
    }

}