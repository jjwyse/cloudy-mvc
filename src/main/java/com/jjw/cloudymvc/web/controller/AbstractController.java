package com.jjw.cloudymvc.web.controller;

/**
 * TODO - JJW
 *
 * @author jjwyse
 * @version %I%, %G%
 */
public abstract class AbstractController {

    private String elementName;

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }
}
