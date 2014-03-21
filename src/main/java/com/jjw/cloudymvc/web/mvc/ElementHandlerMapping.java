/*
 * Copyright 2002-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jjw.cloudymvc.web.mvc;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * Extends RequestMappingHandlerMapping to provide a custom {@link ElementRequestCondition}.
 *
 * Plugged in via {@link com.jjw.cloudymvc.config.WebConfig#requestMappingHandlerMapping()}.
 */
public class ElementHandlerMapping extends RequestMappingHandlerMapping
{
    @Override
    protected RequestCondition<?> getCustomTypeCondition(Class<?> handlerType)
    {
        CloudElement cloudElementAnnotation = AnnotationUtils.findAnnotation(handlerType, CloudElement.class);
        CloudElementApi cloudElementApiAnnotation = AnnotationUtils.findAnnotation(handlerType, CloudElementApi.class);

        return createCondition(cloudElementAnnotation, cloudElementApiAnnotation);
    }

    @Override
    protected RequestCondition<?> getCustomMethodCondition(Method method)
    {
        CloudElement cloudElementMethodAnnotation = AnnotationUtils.findAnnotation(method, CloudElement.class);
        CloudElementApi cloudElementApiMethodAnnotation = AnnotationUtils.findAnnotation(method, CloudElementApi.class);

        return createCondition(cloudElementMethodAnnotation, cloudElementApiMethodAnnotation);
    }

    private RequestCondition<?> createCondition(CloudElement cloudElement, CloudElementApi cloudElementApi)
    {
        // TODO - JJW
        return (cloudElement != null) ? new ElementRequestCondition(cloudElement.value()) : null;
    }

}
