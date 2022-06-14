package com.ict.librarysystem.service;

import com.ict.librarysystem.domian.Borrow;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedList;

/**
 * @Author: Lizbeth9421
 * @Date: 2021/12/25/1:49
 */
public interface BorrowService {


    int deleteByPrimaryKey(Integer id);

    int insert(Borrow record);

    int insertSelective(Borrow record);

    Borrow selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Borrow record);

    int updateByPrimaryKey(Borrow record);

    /**
     * 用于完成借书逻辑
     *
     * @param userid 用户id
     * @param bookid 书本id
     * @return
     */
    int borrowBook(Integer userid, Integer bookid);

    /**
     * 获取所有借阅记录
     * @return
     */
    LinkedList<Borrow> getAllBorrow();

    /**
     * 根据用户id获取借阅记录
     * @param userid
     * @return
     */
    LinkedList<Borrow> getBorrowByUserId(Integer userid);
}
