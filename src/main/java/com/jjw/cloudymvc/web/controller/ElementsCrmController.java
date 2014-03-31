package com.jjw.cloudymvc.web.controller;

import com.jjw.cloudymvc.web.mvc.CloudElementApi;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@RequestMapping("/elements")
public class ElementsCrmController extends AbstractController {

    @CloudElementApi(tokenRequired = false, secretRequired = true)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Map<String, Object> retrieveElement(@PathVariable String id) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("elements", id);

        return map;
    }
}
