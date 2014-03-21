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
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/crm")
public abstract class AbstractCrmController
{
    protected abstract Map<String, Object> create(String name, Map<String, Object> object);

    protected abstract Map<String, Object> retrieve(String name, String id);

    @RequestMapping(value = "/accounts", method = RequestMethod.POST)
    @CloudElementApi
    public Map<String, Object> createAccount(@RequestBody Map<String, Object> account)
    {
        return create("account", account);
    }

    @RequestMapping(value = "/accounts/{id}", method = RequestMethod.GET)
    @CloudElementApi
    public Map<String, Object> retrieveAccount(@PathVariable String id)
    {
        return retrieve("account", id);
    }

    @ResponseBody
    @RequestMapping(value = "/accounts/{id}", method = RequestMethod.GET, headers = "CloudElement-Version=hydrogen")
    @CloudElementApi
    public Map<String, Object> retrieveAccountHydrogen(@PathVariable String id)
    {
        return retrieve("account-hydrogen", id);
    }
}
