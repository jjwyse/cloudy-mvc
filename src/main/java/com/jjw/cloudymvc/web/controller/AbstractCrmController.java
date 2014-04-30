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

package com.jjw.cloudymvc.web.controller;

import com.jjw.cloudymvc.web.mvc.CloudElementApi;
import com.jjw.cloudymvc.web.mvc.Version;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@RequestMapping("/crm")
public abstract class AbstractCrmController {

    protected abstract Map<String, Object> create(String name, Map<String, Object> object);

    protected abstract Map<String, Object> retrieve(String name, String id);

    @CloudElementApi
    @RequestMapping(value = "/accounts", method = RequestMethod.POST)
    public Map<String, Object> createAccount(
            @ApiParam(required = true, name = "account", value = "The account object that needs to be created")
            @RequestBody Map<String, Object> account) {
        return create("account", account);
    }

    @CloudElementApi(version = Version.ONE)
    @RequestMapping(value = "/accounts/{id}", method = RequestMethod.GET)
    public Map<String, Object> retrieveAccount(@PathVariable String id) {
        return retrieve("account", id);
    }

    @CloudElementApi(version = Version.TWO)
    @RequestMapping(value = "/accounts/{id}", method = RequestMethod.GET)
    public Map<String, Object> retrieveAccountNew(@PathVariable String id) {
        return retrieve("account-new", id);
    }

    @CloudElementApi
    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.GET)
    public Map<String, Object> retrieveContact(@PathVariable String id) {
        return retrieve("contact", id);
    }
}
