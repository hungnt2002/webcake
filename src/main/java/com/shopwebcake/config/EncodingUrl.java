package com.shopwebcake.config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "encodingFilter", urlPatterns = "/*")
public class EncodingUrl implements Filter {
    private String encoding = "UTF-8";

    public void init(FilterConfig config) throws ServletException {
        if (config.getInitParameter("encoding") != null) {
            encoding = config.getInitParameter("encoding");
        }
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain next)
            throws IOException, ServletException {
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        response.setContentType("text/html;charset=UTF-8");
        next.doFilter(request, response);
    }

    public void destroy() {
    }
}

