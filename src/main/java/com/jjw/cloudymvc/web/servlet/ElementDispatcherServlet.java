package com.jjw.cloudymvc.web.servlet;

import com.jjw.cloudymvc.web.mvc.Version;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TODO - JJW
 *
 * @author jjwyse
 * @version %I%, %G%
 */
public class ElementDispatcherServlet extends DispatcherServlet {
    @Override
    protected void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (request.getHeader("token").equals("1")) {
            request.setAttribute("element", "sfdc");
        }
        else if (request.getHeader("token").equals("2")) {
            request.setAttribute("element", "sugar");
        }
        else {
            throw new Exception("No element found with given token");
        }

        if (request.getHeader("elements-version") != null) {
            request.setAttribute("version", Version.fromVersionName(request.getHeader("elements-version")));
        }

        super.doService(request, response);
    }
}
