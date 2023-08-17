kamel run --name matrix \
routes-cache.yaml \
routes-from-amq.yaml \
code/routes-from-amq-support.xml \
code/factory.java \
code/globexlistener.java \
code/infinispan.java \
-p file:code/app.properties \
--config secret:client-amq \
--config secret:client-infinispan \
--config secret:client-kafka \
--config secret:client-matrix \
--config configmap:matrix-integration \
--resource file:code/cachetarget.jslt \
-d camel-quarkus-jackson \
-d camel-quarkus-amqp \
-d camel-quarkus-jslt \
-d camel-quarkus-language \
-d camel-quarkus-http \
-d camel-quarkus-infinispan \
-d camel-quarkus-kafka \
-d mvn:io.quarkiverse.messaginghub:quarkus-pooled-jms:1.1.0 \
--dev