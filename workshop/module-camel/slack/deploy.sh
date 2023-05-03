# oc create secret generic slack-credentials \
# --from-file=slack.properties

kamel run --name slack \
routes.xml \
factory.java \
helper.java \
-p file:app.properties \
--config secret:client-amq \
--config secret:slack-credentials \
--resource file:request.jslt \
-d mvn:org.apache.camel:camel-ahc-ws:3.18.2 \
-d camel-quarkus-amqp \
-d camel-quarkus-jackson \
-d camel-quarkus-jslt \
-d mvn:io.quarkiverse.messaginghub:quarkus-pooled-jms:1.1.0




