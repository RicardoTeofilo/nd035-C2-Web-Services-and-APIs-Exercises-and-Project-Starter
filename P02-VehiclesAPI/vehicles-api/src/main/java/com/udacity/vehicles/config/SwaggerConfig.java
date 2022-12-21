package com.udacity.vehicles.config;


import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(true);
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Vehicle Microservices API project",
                "A REST API to maintain vehicle data and to provide a complete view of vehicle details including price and address.\n" +
                        "\n",
                "1.0",
                "https://github.com/RicardoTeofilo/nd035-C2-Web-Services-and-APIs-Exercises-and-Project-Starter",
                new Contact("Ricardo Teofilo", "https://github.com/RicardoTeofilo/nd035-C2-Web-Services-and-APIs-Exercises-and-Project-Starter", "ricardopachec38@gmail.com"),
                "License of API", "https://github.com/RicardoTeofilo/nd035-C2-Web-Services-and-APIs-Exercises-and-Project-Starter/blob/master/LICENSE.txt", Collections.emptyList());
    }


}
