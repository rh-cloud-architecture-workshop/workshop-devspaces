kamel run --name discord \
routes-cache.yaml \
routes-from-amq.yaml \
routes-from-discord-main.yaml \
code/routes-from-amq-support.xml \
code/routes-from-discord-listener.xml \
code/factory.java \
code/gbxlistener.java \
code/infinispan.java \
code/wsConfig.java \
-p file:my.properties \
-p file:code/app.properties \
--config secret:client-amq \
--config secret:client-infinispan \
--config secret:client-kafka \
--config secret:discord-credentials \
--resource file:code/cachetarget.jslt \
-d mvn:org.apache.camel:camel-ahc-ws:3.18.2 \
-d camel-quarkus-amqp \
-d camel-quarkus-jackson \
-d camel-quarkus-jslt \
-d camel-quarkus-language \
-d mvn:io.quarkiverse.messaginghub:quarkus-pooled-jms:1.1.0 \
