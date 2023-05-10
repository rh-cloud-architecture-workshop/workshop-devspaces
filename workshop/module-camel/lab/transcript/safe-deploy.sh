kamel run --name transcript \
code/transcript.xml \
code/transcript-support.xml \
code/factory.java \
code/aggregation.java \
code/kafkalistener.java \
-p file:code/app.properties \
--config secret:client-amq \
--config secret:client-kafka \
--config secret:client-s3 \
-d camel-quarkus-amqp \
-d camel-quarkus-jackson \
-d camel-pdf \
-d camel-joor \
-d camel-kafka \
-d camel-quarkus-language \
-d mvn:io.quarkiverse.messaginghub:quarkus-pooled-jms:1.1.0 \
