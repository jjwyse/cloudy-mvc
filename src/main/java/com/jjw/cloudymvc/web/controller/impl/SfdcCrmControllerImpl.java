package com.jjw.cloudymvc.web.controller.impl;

import com.jjw.cloudymvc.web.ServiceException;
import com.jjw.cloudymvc.web.controller.AbstractCrmController;
import com.jjw.cloudymvc.web.mvc.CloudElement;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * TODO - JJW
 *
 * @author jjwyse
 * @version %I%, %G%
 */
@CloudElement(name = "sfdc", documentation = "docs/sfdc.json")
@RestController
public class SfdcCrmControllerImpl extends AbstractCrmController {

    @Override
    protected Map<String, Object> create(String name, Map<String, Object> object) {
        return object;
    }

    @Override
    protected Map<String, Object> retrieve(String name, String id) {
        throw new ServiceException(HttpStatus.BAD_REQUEST, "ow now brown cow");
//        Map<String, Object> json = new HashMap<String, Object>();
//        Map<String, Object> innerJson = new HashMap<String, Object>();
//
//        innerJson.put("element", "sfdc");
//        json.put(name, innerJson);
//
//        return json;
    }
}
