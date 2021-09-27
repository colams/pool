package cn.colams.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {
    @Bean
    public Docket createRestApi() {
        // http://localhost:5000/swagger-ui.html
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.colams.web.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .title("Spring Boot中使用Swagger2构建RESTful APIs")
                        .description("更多Spring Boot相关文章请关注：http://blog.didispace.com/")
                        .termsOfServiceUrl("http://blog.didispace.com/")
                        .version("1.0")
                        .build());
    }

//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("Spring Boot中使用Swagger2构建RESTful APIs")
//                .description("更多Spring Boot相关文章请关注：http://blog.didispace.com/")
//                .termsOfServiceUrl("http://blog.didispace.com/")
//                .version("1.0")
//                .build();
//    }
}
