kamel run -n globex-camel-user1 --name globex-support \
routesglobex.java \
code/factory.java \
code/gbxlistener.java \
-p file:code/app.properties \
--config secret:client-amq \
--resource file:request.jslt \
--resource file:response.jslt \
-d camel-quarkus-amqp \
-d camel-quarkus-jackson \
-d camel-quarkus-jslt \
-d camel-quarkus-http \
-d mvn:io.quarkiverse.messaginghub:quarkus-pooled-jms:1.1.0 \