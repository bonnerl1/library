package com.ict.librarysystem.service;

import com.ict.librarysystem.domian.User;

import java.util.LinkedList;

/**
 * @Author: Lizbeth9421
 * @Date: 2021/12/20/23:29
 */
public interface UserService {


    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User login(String username, String password);

    /**
     * 获取所有用户
     *
     * @return
     */
    LinkedList<User> getAllUsers(String username);
}
