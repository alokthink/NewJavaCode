package com.mps.think.util;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer{                                    
    @Bean
    public Docket api() { 
      
        return new Docket(DocumentationType.SWAGGER_2)
        		.select() 
                .apis(RequestHandlerSelectors.basePackage("com.mps.think"))
                .build()
                .apiInfo(apiInfo());
    }
    private ApiInfo apiInfo() {
        return new ApiInfo(
          "THINK WebApplication documentation", 
          "Web-based Applications documentations and try out functionalities for all the API's to test database.", 
          "API TOS", 
          "Terms of service", 
          new Contact("MPS Limited", "www.mpslimited.com", "thinksubscription@mps-think.com"), 
          "License of API", "www.mpslimited.com", Collections.emptyList());
   }
   /* @Bean
    UiConfiguration uiConfig() {
      return UiConfigurationBuilder.builder()
          .deepLinking(true)
          .displayOperationId(false)
          .defaultModelsExpandDepth(1)
          .defaultModelExpandDepth(1)
          .defaultModelRendering(ModelRendering.EXAMPLE)
          .displayRequestDuration(false)
          .docExpansion(DocExpansion.NONE)
          .filter(false)
          .maxDisplayedTags(null)
          .operationsSorter(OperationsSorter.ALPHA)
          .showExtensions(false)
          .tagsSorter(TagsSorter.ALPHA)
          .supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
          .validatorUrl(null)
          .build();
    }*/
    @Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
  
}