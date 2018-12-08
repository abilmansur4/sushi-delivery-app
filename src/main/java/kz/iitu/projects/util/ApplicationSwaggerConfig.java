package kz.iitu.projects.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan(basePackages = "kz.iitu.projects.rest")
public class ApplicationSwaggerConfig {

    @Bean
    public Docket customDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "REST SushiDelivery backend Api Documentation",
                "This is REST API documentation of the Spring SushiDelivery backend. If authentication is enabled, when calling the APIs use admin/admin",
                "1.0",
                "SushiDelivery backend terms of service",
                new Contact(
                        "Yunis Abilmansur",
                        "https://github.com/abilmansur4",
                        "abilmansur.yunis@gmail.com"),
                "",
                "");
    }

}
