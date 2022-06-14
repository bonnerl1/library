package com.ict.librarysystem.service;

import com.ict.librarysystem.domian.Book;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedList;

/**
 * @Author: Lizbeth9421
 * @Date: 2021/12/21/11:10
 */
public interface BookService {


    int deleteByPrimaryKey(Integer id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    /**
     * 查询图书
     *
     * @param book
     * @return
     */
    LinkedList<Book> queryBookSelective(Book book);

    /**
     * 根据书籍名字查询书籍状态
     * @param name
     * @return
     */
    Integer selectAvialableByBookName(String name);
}
