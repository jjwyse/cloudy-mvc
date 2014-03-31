package com.jjw.cloudymvc.web.servlet;

import com.jjw.cloudymvc.web.mvc.Version;
import org.apache.commons.lang3.StringUtils;
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

        String token = request.getHeader("token");
        String version = request.getHeader("elements-version");
        String user = request.getHeader("user");
        String organization = request.getHeader("organization");

        if (StringUtils.isNotEmpty(token)) {
            if (request.getHeader("token").equals("1")) {
                request.setAttribute("element", "sfdc");
            }
            else if (request.getHeader("token").equals("2")) {
                request.setAttribute("element", "sugar");
            }
        }

        // default
        request.setAttribute("version", Version.ONE);

        // override if its set
        if (StringUtils.isNotEmpty(version)) {
            if (Version.fromVersionName(version) == null) {
                throw new RuntimeException("Invalid elements-version");
            }

            request.setAttribute("version", Version.fromVersionName(version));
        }

        if (StringUtils.isNotEmpty(user)) {
            request.setAttribute("user", new User());
        }

        if (StringUtils.isNotEmpty(organization)) {
            request.setAttribute("organization", new Organization());
        }

        super.doService(request, response);
    }

    private class Organization {}

    private class User {}
}
