package com.ict.librarysystem.service;

import com.ict.librarysystem.domian.Menu;

import java.util.List;

/**
 * @Author: Lizbeth9421
 * @Date: 2021/12/21/0:57
 */
public interface MenuService {


    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    /**
     * 根据用户id查询用户拥有的菜单
     * @param id
     * @return
     */
    List<Menu> queryMenuById(Integer id,Integer status);

}
