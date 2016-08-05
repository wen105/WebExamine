package com.shuyun.dao.imply;

import com.shuyun.dao.DataDao;
import com.shuyun.entity.UserData;
import com.shuyun.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuyun on 2016/8/4.
 * 数据表接口实现类
 */
public class DataDaoImply implements DataDao {
    public List<UserData> queryData(int userId) {
        List<UserData> userDataList = new ArrayList<UserData>();
        String sql = "SELECT * FROM user.data_tab WHERE user_id="+userId;
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int dataId = rs.getInt(1);
                String dataTitle = rs.getString(3);
                String dataContent = rs.getString(4);
                String dataName = rs.getString(5);
                UserData userData = new UserData(dataId, userId, dataTitle, dataContent, dataName);
                userDataList.add(userData);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            DBUtil.closeAll(con, ps, rs);
        }
        return userDataList;
    }

    public int saveUserData(UserData userData) {
        String sql = "INSERT INTO user.data_tab(user_id,data_title,data_content,data_name) VALUES (?,?,?,?)";
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = null;
        int m;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,userData.getUserId());
            ps.setString(2, userData.getDataTitle());
            ps.setString(3, userData.getDataContent());
            ps.setString(4, userData.getDataName());
            m = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            DBUtil.closeAll(con, ps, null);
        }
        return m;
    }
}
