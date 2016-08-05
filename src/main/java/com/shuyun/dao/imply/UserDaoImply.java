package com.shuyun.dao.imply;

import com.shuyun.dao.UserDao;
import com.shuyun.entity.User;
import com.shuyun.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by shuyun on 2016/8/4.
 * 用户操作接口类的实现
 */
public class UserDaoImply implements UserDao {
    //根据姓名查询用户
    public User queryUser(String name) {
        String sql = "SELECT * FROM user.user_tbl WHERE user_name=?";
        Connection con = DBUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        User user=null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {
                int userId = rs.getInt(1);
                String userName = rs.getString(2);
                String userPassword = rs.getString(3);
                user = new User(userId, userName, userPassword);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        finally {
            DBUtil.closeAll(con,ps,rs);
        }
        return user;
    }
    //添加用户
    public int addUser(User user) {
        System.out.println(user.getUserName()+user.getUserPassword());
        String sql = "insert into user.user_tbl(user_name, user_password) values (?,?)";
        Connection con = DBUtil.getConnection();
        PreparedStatement ps=null;
        int m;
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,user.getUserName());
            ps.setString(2,user.getUserPassword());
            m=ps.executeUpdate();
        }catch (SQLException e){
            throw  new RuntimeException(e.getMessage(),e);
        }
        finally {
            DBUtil.closeAll(con,ps,null);
        }
        return m;
    }
}
