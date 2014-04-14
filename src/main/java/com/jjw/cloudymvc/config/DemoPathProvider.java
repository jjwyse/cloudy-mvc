package com.jjw.cloudymvc.config;

import com.mangofactory.swagger.core.SwaggerPathProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.ServletContext;

/**
 * TODO - JJW
 *
 * @author jjwyse
 * @version %I%, %G%
 */
public class DemoPathProvider implements SwaggerPathProvider {

    private SwaggerPathProvider defaultSwaggerPathProvider;

    @Autowired
    private ServletContext servletContext;

    @Override
    public String getApiResourcePrefix() {
        return defaultSwaggerPathProvider.getApiResourcePrefix();
    }

    public String getAppBasePath() {
        return UriComponentsBuilder
                .fromHttpUrl("http://127.0.0.1:9090")
                .path(servletContext.getContextPath())
                .build()
                .toString();
    }

    @Override
    public String getSwaggerDocumentationBasePath() {
        return UriComponentsBuilder
                .fromHttpUrl(getAppBasePath())
                .pathSegment("api-docs/")
                .build()
                .toString();
    }

    @Override
    public String getRequestMappingEndpoint(String requestMappingPattern) {
        return defaultSwaggerPathProvider.getRequestMappingEndpoint(requestMappingPattern);
    }

    public void setDefaultSwaggerPathProvider(SwaggerPathProvider defaultSwaggerPathProvider) {
        this.defaultSwaggerPathProvider = defaultSwaggerPathProvider;
    }
}
