package com.shuyun.servlet;


import com.shuyun.dao.UserDao;
import com.shuyun.dao.imply.UserDaoImply;
import com.shuyun.entity.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


/**
 * Created by shuyun on 2016/8/4.
 * 用户登陆Servlet
 */
@WebServlet(name="UserLoginServlet",urlPatterns={"/userLogin"})
public class UserLoginServlet extends javax.servlet.http.HttpServlet {
    private UserDao userDao = new UserDaoImply();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        String mark = request.getParameter("mark");
        User user = userDao.queryUser(userName);
        if (user == null) {
            request.setAttribute("msg", "用户名不存在");
            request.getRequestDispatcher("userLogin.jsp").forward(request, response);

        } else {
            if (user.getUserPassword().equals(userPassword)) {
                //如果用户登陆验证成功，则跳转到登陆页面
                setUserLogin(request, response, user, mark);
            } else {
                //如果用户登陆验证失败，则给当前页面返回给错误信息
                request.setAttribute("msg", "登录名和密码不匹配");
                request.getRequestDispatcher("userLogin.jsp").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
     //用户登录时关于cookie和跳转的一些操作
    private void setUserLogin(HttpServletRequest request, HttpServletResponse response, User user, String mark) throws ServletException, IOException {
        if ("mark".equals(mark)) {
            Cookie autoCookie ;
            String cookieValue = user.getUserId() + ":" + user.getUserName();
            autoCookie = new Cookie("autologin", cookieValue);
            autoCookie.setPath("/");
            //添加cookie
            response.addCookie(autoCookie);
        }
        request.getSession().setAttribute("user", user);
        response.sendRedirect("/showData");
    }
}
