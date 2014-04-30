package com.jjw.cloudymvc.web.config;

import com.jjw.cloudymvc.web.mvc.ElementHandlerMapping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * TODO - JJW
 *
 * @author jjwyse
 * @version %I%, %G%
 */
@EnableWebMvc
@Configuration
@ImportResource("classpath:application-context.xml")
@ComponentScan(basePackages = "com.jjw")
public class WebConfig extends WebMvcConfigurationSupport {

    @Override
    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        RequestMappingHandlerMapping requestMappingHandlerMapping = new ElementHandlerMapping();
        requestMappingHandlerMapping.setOrder(0);
        requestMappingHandlerMapping.setUseTrailingSlashMatch(true);

        return requestMappingHandlerMapping;
    }
}
