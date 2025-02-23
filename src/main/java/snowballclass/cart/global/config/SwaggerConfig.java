package snowballclass.cart.global.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class SwaggerConfig {
    @Bean
    OpenAPI openApi() {
        return new OpenAPI()
                .components(new Components())
                .info(getInfo());
    }

    private Info getInfo() {
        return new Info()
                .version("1.0.0")
                .description("Snowball Class")
                .title("Snowball Class API");
    }
}