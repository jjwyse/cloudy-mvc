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

        // default
        request.setAttribute("version", Version.ONE);

        // override if its set
        if (request.getHeader("elements-version") != null) {
            String elementsVersion = request.getHeader("elements-version");
            if (Version.fromVersionName(elementsVersion) == null) {
                throw new RuntimeException("Invalid elements-version");
            }

            request.setAttribute("version", Version.fromVersionName(elementsVersion));
        }

        super.doService(request, response);
    }
}
