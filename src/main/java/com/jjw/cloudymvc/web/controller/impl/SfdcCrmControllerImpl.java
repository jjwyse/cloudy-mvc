package com.jjw.cloudymvc.web.controller.impl;

import com.jjw.cloudymvc.web.controller.CrmController;
import com.jjw.cloudymvc.web.mvc.Element;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO - JJW
 *
 * @author jjwyse
 * @version %I%, %G%
 */
@Controller
@Element("sfdc")
public class SfdcCrmControllerImpl extends CrmController
{
    @Override
    protected Map<String, Object> create(String name, Map<String, Object> object)
    {
        return object;
    }

    @Override
    protected Map<String, Object> retrieve(String name, String id)
    {
        Map<String, Object> json = new HashMap<String, Object>();
        Map<String, Object> innerJson = new HashMap<String, Object>();

        innerJson.put("element", "sfdc");
        json.put("account", innerJson);

        return json;
    }
}
