// camel-k: language=java
/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.PropertyInject;
import org.apache.camel.component.amqp.AMQPComponent;
import org.apache.camel.impl.DefaultCamelContext;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import org.apache.qpid.jms.JmsConnectionFactory;
import org.messaginghub.pooled.jms.JmsPoolConnectionFactory;

public class factory extends RouteBuilder {

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

            // Create a MessageProducer for each createProducer() call
            // pool.setUseAnonymousProducers(false);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return pool;
    }    
}