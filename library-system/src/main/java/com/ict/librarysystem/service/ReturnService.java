package com.ict.librarysystem.service;

import com.ict.librarysystem.domian.Return;

import java.util.LinkedList;

/**
 * @Author: Lizbeth9421
 * @Date: 2021/12/25/16:02
 */
public interface ReturnService {


    int deleteByPrimaryKey(Integer id);

    int insert(Return record);

    int insertSelective(Return record);

    Return selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Return record);

    int updateByPrimaryKey(Return record);

    /**
     * @param userid
     * @param bookid
     * @return
     */
    int returnBook(Integer userid, Integer bookid);

    /**
     * 获取所有还书记录
     *
     * @return
     */
    LinkedList<Return> getAllReturn();

    /**
     * 根据用户id获取还书记录
     *
     * @param userid 用户id
     * @return
     */
    LinkedList<Return> getReturnById(Integer userid);
}
