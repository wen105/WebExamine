package com.shuyun.dao;

import com.shuyun.entity.UserData;

import java.util.List;

/**
 * Created by shuyun on 2016/8/4.
 * 定义数据表的接口类
 */
public interface DataDao {
    public List<UserData> queryData(int userId);
    public int saveUserData(UserData userData);
}
