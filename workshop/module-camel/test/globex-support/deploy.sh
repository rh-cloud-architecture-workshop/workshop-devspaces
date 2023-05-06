# kamel run --name globex \
# apiserver.xml \
# simulator.xml \
# factory.java \
# -p file:app.properties \
# --config secret:client-amq \
# --resource file:request.jslt \
# --resource file:response.jslt \
# -d camel-quarkus-amqp \
# -d camel-quarkus-jackson \
# -d camel-quarkus-jslt \
# -d camel-quarkus-http \
# -d mvn:io.quarkiverse.messaginghub:quarkus-pooled-jms:1.1.0 \

kamel run --name globex-support \
apiserver.xml \
factory.java \
gbxlistener.java \
-p file:app.properties \
--config secret:client-amq \
--resource file:request.jslt \
--resource file:response.jslt \
-d camel-quarkus-amqp \
-d camel-quarkus-jackson \
-d camel-quarkus-jslt \
-d camel-quarkus-http \
-d mvn:io.quarkiverse.messaginghub:quarkus-pooled-jms:1.1.0 \


