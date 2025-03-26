package snowballclass.cart.framework.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ViewClientConfig {
    @Value("${service.view.url}")
    private String viewServiceUrl;

    @Bean("ViewClient")
    ViewClient create() {
        RestClient restClient = RestClient.builder()
                .baseUrl(viewServiceUrl)
                .build();
        RestClientAdapter adapter = RestClientAdapter.create(restClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
        return factory.createClient(ViewClient.class);
    }
}
