package com.ict.librarysystem.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ict.librarysystem.mapper.MenuMapper;
import com.ict.librarysystem.domian.Menu;
import com.ict.librarysystem.service.MenuService;

import java.util.List;

/**
 * @Author: Lizbeth9421
 * @Date: 2021/12/21/0:57
 */
@Service
public class MenuServiceImpl implements MenuService{

    @Resource
    private MenuMapper menuMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return menuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Menu record) {
        return menuMapper.insert(record);
    }

    @Override
    public int insertSelective(Menu record) {
        return menuMapper.insertSelective(record);
    }

    @Override
    public Menu selectByPrimaryKey(Integer id) {
        return menuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Menu record) {
        return menuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Menu record) {
        return menuMapper.updateByPrimaryKey(record);
    }

    /**
     * 根据用户id查询用户拥有的菜单
     * @param id
     * @return
     */
    @Override
    public List<Menu> queryMenuById(final Integer id,final Integer status) {
        return menuMapper.queryMenuById(id,status);
    }

}
