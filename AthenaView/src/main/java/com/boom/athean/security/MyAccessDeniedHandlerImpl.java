package com.boom.athean.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/1/12.
 */
@Component
public class MyAccessDeniedHandlerImpl implements AccessDeniedHandler {

    private String accessDeniedUrl;

    public MyAccessDeniedHandlerImpl() {

    }


    public MyAccessDeniedHandlerImpl(String accessDeniedUrl) {
        this.accessDeniedUrl = accessDeniedUrl;
    }

    public String getAccessDeniedUrl() {
        return accessDeniedUrl;
    }

    public void setAccessDeniedUrl(String accessDeniedUrl) {
        this.accessDeniedUrl = accessDeniedUrl;
    }

    @Override
    public void handle(HttpServletRequest req, HttpServletResponse resp, AccessDeniedException reason) throws ServletException, IOException {
        boolean isAjax = "XMLHttpRequest".equals(req.getHeader("X-Requested-With"));
        if (isAjax) {
            String jsonObject = "{\"message\":\"You are not privileged to request this resource.\",\"\"access-denied\":true,\"cause\":\"AUTHORIZATION_FAILURE\"}";
            String contentType = "application/json";
            resp.setContentType(contentType);
            PrintWriter out = resp.getWriter();
            out.print(jsonObject);
            out.flush();
            out.close();
            return;
        } else {
            String path = req.getContextPath();
            String basePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + path + "/index.html";
            resp.sendRedirect(basePath);
        }
    }

}



