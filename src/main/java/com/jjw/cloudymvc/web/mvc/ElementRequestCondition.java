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

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;

public class ElementRequestCondition implements RequestCondition<ElementRequestCondition> {

    private Version version;
    private Boolean isTokenRequired;
    private String elementName;

    private ElementRequestCondition() {}

    public ElementRequestCondition(Version version, boolean isTokenRequired) {
        this.version = version;
        this.isTokenRequired = isTokenRequired;
    }

    public ElementRequestCondition(String elementName) { this.elementName = elementName; }

    @Override
    public ElementRequestCondition combine(ElementRequestCondition other) {
        ElementRequestCondition combo = new ElementRequestCondition();

        combo.version = this.version == null ? other.version : this.version;
        combo.elementName = this.elementName == null ? other.elementName : this.elementName;
        combo.isTokenRequired = this.isTokenRequired == null ? other.isTokenRequired : this.isTokenRequired;

        return combo;
    }

    @Override
    public ElementRequestCondition getMatchingCondition(HttpServletRequest request) {
        String element = (String) request.getAttribute("element");
        Version version = (Version) request.getAttribute("version");

        if (StringUtils.isEmpty(element) && !this.isTokenRequired) {
            return this;
        }

        if (this.elementName.equals(element) && equalsMyVersionOrAPreviousVersion(version)) {
            return this;
        }

        return null;
    }

    private boolean equalsMyVersionOrAPreviousVersion(Version version) {
        // base case
        if (version == null) {
            return false;
        }

        if (this.version.equals(version)) {
            return true;
        }

        return equalsMyVersionOrAPreviousVersion(Version.fromVersionNumber(version.getVersionNumber() - 1));
    }

    @Override
    public int compareTo(ElementRequestCondition other, HttpServletRequest request) {
        // this ensures that when elements-version: three is sent, and we don't have a version three of the specified
        // API, we invoke the latest version of the API
        return other.version.getVersionNumber() - ((Version) request.getAttribute("version")).getVersionNumber();
    }

}
