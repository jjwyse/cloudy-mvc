package com.jjw.cloudymvc.web.impl;

import com.jjw.cloudymvc.web.AbstractCrmController;
import com.jjw.cloudymvc.web.mvc.Element;
import org.springframework.stereotype.Controller;

/**
 * TODO - JJW
 *
 * @author jjwyse
 * @version %I%, %G%
 */
@Controller
@Element("sugar")
public class SugarCrmControllerImpl extends AbstractCrmController
{
    @Override
    protected void retrieve(String name, String id)
    {
        System.out.println("JJW - Sugar: " + name + ", " + id);
    }
}
