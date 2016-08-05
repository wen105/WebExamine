package com.shuyun.util;

import java.sql.*;

/**
 * Created by shuyun on 2016/8/4.
 * 数据库连接的表
 */
public class DBUtil {
    private static final String url = "jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=UTF-8";
    private static final String username = "root";
    private static final String password = "12";
    private static final String driverClass = "com.mysql.jdbc.Driver";

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(driverClass);
            try {
                con = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }
    public static void closeAll(Connection con, PreparedStatement ps, ResultSet rs){
        try {
            if (rs != null) {
                rs.close();
            }
            if(ps!=null){
                ps.close();
            }
            if (con!=null){
                con.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
