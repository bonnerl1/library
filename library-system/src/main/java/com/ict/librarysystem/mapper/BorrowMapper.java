package com.ict.librarysystem.mapper;

import com.ict.librarysystem.domian.Borrow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedList;

/**
 * @Author: Lizbeth9421
 * @Date: 2021/12/25/1:49
 */
@Mapper
public interface BorrowMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Borrow record);

    int insertSelective(Borrow record);

    Borrow selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Borrow record);

    int updateByPrimaryKey(Borrow record);

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
    LinkedList<Borrow> getBorrowByUserId(@Param("userid") Integer userid);
}