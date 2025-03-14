package snowballclass.cart.infra.lesson;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class LessonClient {
    @Value("${service.lesson.url}")
    private String lessonUrl;

    @Bean("createLessonService")
    public LessonService create() {
        RestClient restClient = RestClient.builder().baseUrl(lessonUrl).build();
        RestClientAdapter adapter = RestClientAdapter.create(restClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
        return factory.createClient(LessonService.class);
    }
}
