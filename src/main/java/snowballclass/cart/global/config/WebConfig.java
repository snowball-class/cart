package snowballclass.cart.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/**")
                .allowedOrigins("http://localhost:3000", "http://snowball-class.shop", "https://snowball-class.shop", "http://snowball-class.shop:30007")
                .allowedMethods("GET","POST","PUT","DELETE", "OPTIONS");
    }
}
