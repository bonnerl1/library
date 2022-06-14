package com.ict.librarysystem.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ict.librarysystem.domian.User;
import com.ict.librarysystem.mapper.UserMapper;
import com.ict.librarysystem.service.UserService;

import java.util.LinkedList;

/**
 * @Author: Lizbeth9421
 * @Date: 2021/12/20/23:29
 */
@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public User login(final String username, final String password) {
        return userMapper.login(username, password);
    }

    @Override
    public LinkedList<User> getAllUsers(String username) {
        return userMapper.getAllUsers(username);
    }

}
