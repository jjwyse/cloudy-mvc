package com.jjw.cloudymvc.web.controller.impl;

import com.jjw.cloudymvc.web.controller.CrmController;
import com.jjw.cloudymvc.web.mvc.Element;
import com.jjw.cloudymvc.web.service.CrmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
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
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Element("sfdc")
public class SfdcCrmControllerImpl extends CrmController
{
    @Autowired
    @Qualifier("sfdcService")
    CrmService sfdcService;

    @Override
    protected Map<String, Object> create(String name, Map<String, Object> object)
    {
        return sfdcService.create(name, object);
    }

    @Override
    protected Map<String, Object> retrieve(String name, String id)
    {
        return sfdcService.retrieve(name, id);
    }
}
