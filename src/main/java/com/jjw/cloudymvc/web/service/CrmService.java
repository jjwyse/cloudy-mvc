package com.jjw.cloudymvc.web.service;

import java.util.Map;

/**
 * TODO - JJW
 *
 * @author jjwyse
 * @version %I%, %G%
 */
public interface CrmService
{
    Map<String, Object> create(String name, Map<String, Object> object);
    Map<String, Object> retrieve(String name, String id);
}
