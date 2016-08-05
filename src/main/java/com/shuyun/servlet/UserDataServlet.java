package com.shuyun.servlet;


import com.shuyun.dao.DataDao;
import com.shuyun.dao.imply.DataDaoImply;

import com.shuyun.entity.UserData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by shuyun on 2016/8/4.
 * 保护用户数据Servlet
 */
@WebServlet(name = "UserDataServlet", urlPatterns = {"/saveUserData"})
public class UserDataServlet extends HttpServlet {
    private DataDao dataDao = new DataDaoImply();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        String dataTitle = request.getParameter("dataTitle");
        String dataContent = request.getParameter("dataContent");
        String dataName = request.getParameter("dataName");
        UserData userData = new UserData(userId, dataTitle, dataContent, dataName);
        int m = dataDao.saveUserData(userData);
        if (m > 0) {
            response.sendRedirect("/showData");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
