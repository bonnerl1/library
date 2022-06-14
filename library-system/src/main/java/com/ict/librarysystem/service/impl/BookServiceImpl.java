package com.ict.librarysystem.service.impl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.ict.librarysystem.domian.Book;
import com.ict.librarysystem.mapper.BookMapper;
import com.ict.librarysystem.service.BookService;

import java.util.LinkedList;

/**
 * @Author: Lizbeth9421
 * @Date: 2021/12/21/11:10
 */
@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookMapper bookMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return bookMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Book record) {
        return bookMapper.insert(record);
    }

    @Override
    public int insertSelective(Book record) {
        return bookMapper.insertSelective(record);
    }

    @Override
    public Book selectByPrimaryKey(Integer id) {
        return bookMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Book record) {
        return bookMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Book record) {
        return bookMapper.updateByPrimaryKey(record);
    }

    /**
     * 查询图书
     *
     * @param book
     * @return
     */
    @Override
    public LinkedList<Book> queryBookSelective(final Book book) {
        return bookMapper.queryBookSelective(book);
    }

    @Override
    public Integer selectAvialableByBookName(final String name) {
        return bookMapper.selectAvialableByBookName(name);
    }

}
