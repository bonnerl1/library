package com.ict.librarysystem.mapper;

import com.ict.librarysystem.domian.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedList;

/**
 * @Author: Lizbeth9421
 * @Date: 2021/12/20/23:29
 */
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     */
    User login(@Param("username") String username, @Param("password") String password);

    /**
     * 获取所有用户
     *
     * @return
     * @param username
     */
    LinkedList<User> getAllUsers(@Param("username") String username);
}