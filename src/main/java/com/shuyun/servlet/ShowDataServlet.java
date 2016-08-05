package com.shuyun.servlet;

import com.shuyun.dao.DataDao;
import com.shuyun.dao.UserDao;
import com.shuyun.dao.imply.DataDaoImply;
import com.shuyun.entity.User;
import com.shuyun.entity.UserData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by shuyun on 2016/8/5.
 * 处理数据的servlet
 */
@WebServlet(name="ShowDataServlet",urlPatterns={"/showData"})
public class ShowDataServlet extends HttpServlet {
    private DataDao dataDao=new DataDaoImply();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=(User)request.getSession().getAttribute("user");
        List<UserData> userDataList=dataDao.queryData(user.getUserId());
        request.getSession().setAttribute("userDataList",userDataList);
        request.getRequestDispatcher("./showData.jsp").forward(request, response);
    }
}
