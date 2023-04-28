kamel run --name transcript \
transcript.xml \
factory.java \
helper.java \
kafkalistener.java \
-p file:app.properties \
--config secret:client-amq \
--config secret:client-kafka \
--config secret:client-s3 \
--resource file:cachetarget.jslt \
-d camel-quarkus-amqp \
-d camel-quarkus-jackson \
-d camel-quarkus-jslt \
-d camel-pdf \
-d camel-joor \
-d camel-kafka \
-d camel-quarkus-language \
-d mvn:io.quarkiverse.messaginghub:quarkus-pooled-jms:1.1.0 \
