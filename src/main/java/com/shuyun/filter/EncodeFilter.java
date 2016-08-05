package com.shuyun.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by shuyun on 2016/8/5.
 * 对所有servlet的编码过滤
 */
@WebFilter(filterName="UserLoginFilter",urlPatterns={"/*"},initParams={@WebInitParam(name="encoding",value="utf-8")})
public class EncodeFilter implements Filter {
    private FilterConfig config;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest)req;
        request.setCharacterEncoding(config.getInitParameter("encoding"));
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
          this.config=config;
    }

}
