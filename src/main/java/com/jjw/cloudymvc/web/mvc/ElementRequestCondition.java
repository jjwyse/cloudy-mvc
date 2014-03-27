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

import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;

public class ElementRequestCondition implements RequestCondition<ElementRequestCondition> {

    private Version version;
    private String elementName;

    private ElementRequestCondition() {}

    public ElementRequestCondition(Version version) { this.version = version; }

    public ElementRequestCondition(String elementName) { this.elementName = elementName; }

    @Override
    public ElementRequestCondition combine(ElementRequestCondition other) {
        ElementRequestCondition combo = new ElementRequestCondition();
        combo.version = this.version == null ? other.version : this.version;
        combo.elementName = this.elementName == null ? other.elementName : this.elementName;

        return combo;
    }

    @Override
    public ElementRequestCondition getMatchingCondition(HttpServletRequest request) {
        String element = (String) request.getAttribute("element");
        Version version = (Version) request.getAttribute("version");

        if (this.elementName.equals(element) && this.version.equals(version)) {
            return this;
        }

        return null;
    }

    @Override
    public int compareTo(ElementRequestCondition other, HttpServletRequest request) {
        // if this happens, more than one @CloudElement matched the URL and at this point we don't want this
        // so throw an exception.  In the future we may want to have logic here to resolve this
        throw new RuntimeException("Oh snap...more than one API matched the URL");
    }

}
