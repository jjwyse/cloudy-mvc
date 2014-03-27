package com.jjw.cloudymvc.web.controller.impl;

import com.jjw.cloudymvc.web.controller.AbstractCrmController;
import com.jjw.cloudymvc.web.mvc.CloudElement;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO - JJW
 *
 * @author jjwyse
 * @version %I%, %G%
 */
@RestController
@CloudElement("sugar")
public class SugarCrmControllerImpl extends AbstractCrmController {

    @Override
    protected Map<String, Object> create(String name, Map<String, Object> object) {
        return object;
    }

    @Override
    protected Map<String, Object> retrieve(String name, String id) {
        Map<String, Object> json = new HashMap<String, Object>();
        Map<String, Object> innerJson = new HashMap<String, Object>();

        innerJson.put("element", "sugar");
        json.put(name, innerJson);

        return json;
    }
}
