// camel-k: language=java

import org.apache.camel.BindToRegistry;
import org.apache.camel.builder.RouteBuilder;
import org.asynchttpclient.AsyncHttpClientConfig;
import org.asynchttpclient.DefaultAsyncHttpClientConfig;
import org.asynchttpclient.filter.RequestFilter;
import org.asynchttpclient.filter.FilterContext;
import org.asynchttpclient.filter.FilterException;

public class wsConfig extends RouteBuilder {

    //dummy
    @Override
    public void configure() throws Exception {}

    @BindToRegistry
    public static AsyncHttpClientConfig myconfig(){

        DefaultAsyncHttpClientConfig.Builder configBuilder = new DefaultAsyncHttpClientConfig.Builder();
        configBuilder.addRequestFilter(new RequestFilter() {
            public FilterContext filter(FilterContext ctx) throws FilterException {

                    ctx.getRequest().getHeaders().add("Origin", "https://gateway.discord.gg");

                    return ctx;
                }
        });

        return configBuilder.build();
    }
}