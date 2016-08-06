package com.shuyun.filter;

import com.shuyun.dao.UserDao;
import com.shuyun.dao.imply.UserDaoImply;
import com.shuyun.entity.User;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by shuyun on 2016/8/4.
 * 登陆过滤器
 */
@WebFilter(filterName = "UserLoginFilter", urlPatterns = {"/userLogin.jsp", "/showData.jsp"})
public class UserLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        if (request.getServletPath().equals("/userLogin.jsp")) {
            request.getRequestDispatcher("userLogin.jsp").forward(request, response);
            return;
        }

        //如果session中有用户则进入主页
        Object object = request.getSession().getAttribute("user");
        System.out.println(request.getSession().getAttribute("user") == null);
        if (object != null) {
            System.out.println("session中有值");
            request.getRequestDispatcher("showData.jsp").forward(request, response);
            return;
        }

        //如果session中没有用户，则判断cookie
        Cookie autoCookie = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("autologin".equals(cookie.getName())) {
                    autoCookie = cookie;
                }
            }
            //判断cookie是否为空，如果为空则跳转到登录页面
            if (autoCookie == null) {
                //如果cookie为空则继续执行userLogin.jsp页面
                request.getRequestDispatcher("userLogin.jsp").forward(request, response);
                return;
            }
            //如果autoCookie不为null，则根据cookie值到数据库查找用户
            String value = autoCookie.getValue();
            String[] temp = value.split(":");
            String userName = temp[1];

            //cookie没有失效,根据用户名查询用户信息
            UserDao userDao = new UserDaoImply();
            User user = userDao.queryUser(userName);
            //如果没有查到用户，则跳转到登录页面
            if (user == null) {
                System.out.println("filter里面如果没有查到用户则继续userLogin.jsp");
                chain.doFilter(request, response);
                return;
            }
            //如果满足cookie则跳转到登录页面
            request.getSession().setAttribute("user", user);
            request.getRequestDispatcher("./showData.jsp").forward(request, response);

        } else {
            request.getRequestDispatcher("userLogin.jsp").forward(request, response);
        }
    }

    public void init(FilterConfig config) throws ServletException {
    }

}
