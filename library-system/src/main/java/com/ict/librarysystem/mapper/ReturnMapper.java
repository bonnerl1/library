package com.ict.librarysystem.mapper;

import com.ict.librarysystem.domian.Return;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Lizbeth9421
 * @Date: 2021/12/25/16:02
 */
@Mapper
public interface ReturnMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Return record);

    int insertSelective(Return record);

    Return selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Return record);

    int updateByPrimaryKey(Return record);

    /**
     * 获取所有还书记录
     * @return
     */
    LinkedList<Return> getAllReturn();

    /**
     * 根据用户id获取还书记录
     * @param userid
     * @return
     */
    LinkedList<Return> getReturnById(@Param("userid") Integer userid);
}