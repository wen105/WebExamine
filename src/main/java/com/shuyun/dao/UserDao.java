package com.shuyun.dao;

import com.shuyun.entity.User;

/**
 * Created by shuyun on 2016/8/4.
 * 操作用户表的Dao
 */
public interface UserDao {
    public User queryUser(String userName);
    public int  addUser(User user);
}
