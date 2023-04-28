# kamel run --name discord \
# routes-cache.xml \
# routes-discord-consume.xml \
# routes-discord-produce.xml \
# factory.java \
# infinispan.java \
# wsConfig.java \
# -p file:app.properties \
# --resource file:../common/client-amq.ts \
# --resource file:../common/client-is.ts \
# --resource file:cachetarget.jslt \
# -d mvn:org.apache.camel:camel-ahc-ws:3.18.2 \
# -d camel-quarkus-amqp \
# -d camel-quarkus-jackson \
# -d camel-quarkus-jslt \
# -d camel-quarkus-language \
# -d camel-quarkus-infinispan \
# -d mvn:io.quarkiverse.messaginghub:quarkus-pooled-jms:1.1.0

# -d file://camel-infinispan-embedded-3.20.2.jar
# -d mvn:org.apache.camel:camel-infinispan-embedded:3.20.0 \


kamel run --name discord \
routes-cache.xml \
routes-discord-consume.xml \
routes-discord-produce.xml \
factory.java \
gbxlistener.java \
infinispan.java \
wsConfig.java \
-p file:app.properties \
--config secret:client-amq \
--config secret:client-infinispan \
--config secret:client-kafka \
--config secret:discord-credentials \
--resource file:cachetarget.jslt \
-d mvn:org.apache.camel:camel-ahc-ws:3.18.2 \
-d camel-quarkus-amqp \
-d camel-quarkus-jackson \
-d camel-quarkus-jslt \
-d camel-quarkus-language \
-d mvn:io.quarkiverse.messaginghub:quarkus-pooled-jms:1.1.0 \
# --dev



# kamel run --name discord \
# routes-cache.xml \
# infinispan.java \
# -p file:app.properties \
# --config secret:client-infinispan \
# --config secret:client-amq \
# --resource file:cachetarget.jslt \
# -d mvn:org.apache.camel:camel-ahc-ws:3.18.2 \
# -d camel-quarkus-amqp \
# -d camel-quarkus-jackson \
# -d camel-quarkus-jslt \
# -d camel-quarkus-language \
# -d mvn:io.quarkiverse.messaginghub:quarkus-pooled-jms:1.1.0 \
# --dev