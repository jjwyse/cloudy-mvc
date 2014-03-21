package com.jjw.cloudymvc.web.service.impl;

import com.jjw.cloudymvc.web.service.AbstractCrmService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO - JJW
 *
 * @author jjwyse
 * @version %I%, %G%
 */
@Component("sfdcService")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SfdcCrmServiceImpl extends AbstractCrmService
{
    @Override
    public Map<String, Object> create(String name, Map<String, Object> account)
    {
        return account;
    }

    @Override
    public Map<String, Object> retrieve(String name, String id)
    {
        Map<String, Object> json = new HashMap<String, Object>();
        Map<String, Object> innerJson = new HashMap<String, Object>();

        innerJson.put("element", "sfdc");
        json.put("account", innerJson);

        return json;
    }
}
