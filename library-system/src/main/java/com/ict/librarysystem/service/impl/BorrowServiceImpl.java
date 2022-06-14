package com.ict.librarysystem.service.impl;

import com.ict.librarysystem.domian.Book;
import com.ict.librarysystem.domian.User;
import com.ict.librarysystem.mapper.BookMapper;
import com.ict.librarysystem.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.ict.librarysystem.domian.Borrow;
import com.ict.librarysystem.mapper.BorrowMapper;
import com.ict.librarysystem.service.BorrowService;

import java.util.Date;
import java.util.LinkedList;

/**
 * @Author: Lizbeth9421
 * @Date: 2021/12/25/1:49
 */
@Service
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private BorrowMapper borrowMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return borrowMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Borrow record) {
        return borrowMapper.insert(record);
    }

    @Override
    public int insertSelective(Borrow record) {
        return borrowMapper.insertSelective(record);
    }

    @Override
    public Borrow selectByPrimaryKey(Integer id) {
        return borrowMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Borrow record) {
        return borrowMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Borrow record) {
        return borrowMapper.updateByPrimaryKey(record);
    }

    /**
     * @param userid 用户id
     * @param bookid 书本id
     * @return 1表示成功借阅    0表示借阅失败
     */
    @Override
    public int borrowBook(final Integer userid, final Integer bookid) {
        Integer returnValue;
        //获取用户信息
        User user = userMapper.selectByPrimaryKey(userid);
        //获取被借书本信息
        Book book = bookMapper.selectByPrimaryKey(bookid);
        Borrow borrow = new Borrow();
        if (book.getAvailable() == 0) {
            returnValue = 0;
            return returnValue;
        }
        try {
            borrow.setName(book.getName());
            borrow.setAuthor(book.getAuthor());
            borrow.setBooktype(book.getBooktype());
            borrow.setBorrowUser(user.getUsername());
            borrow.setCreattime(new Date());
            borrowMapper.insertSelective(borrow);
            bookMapper.updateByPrimaryKeySelective(new Book(bookid, 0));
            returnValue = 1;
        } catch (Exception e) {
            returnValue = 0;
            e.printStackTrace();
        }
        return returnValue;
    }

    @Override
    public LinkedList<Borrow> getAllBorrow() {
        LinkedList<Borrow> allBorrow = borrowMapper.getAllBorrow();
        for (Borrow borrow : allBorrow) {
            String name = borrow.getName();
            Integer avialable = bookMapper.selectAvialableByBookName(name);
            Integer bookid=bookMapper.selectBookidByBookName(name);
            borrow.setBookState(avialable);
            borrow.setBookid(bookid);
        }
        return allBorrow;
    }

    @Override
    public LinkedList<Borrow> getBorrowByUserId(final Integer userid) {
        LinkedList<Borrow> allBorrow = borrowMapper.getBorrowByUserId(userid);
        for (Borrow borrow : allBorrow) {
            String name = borrow.getName();
            Integer avialable = bookMapper.selectAvialableByBookName(name);
            Integer bookid=bookMapper.selectBookidByBookName(name);
            borrow.setBookState(avialable);
            borrow.setBookid(bookid);
        }
        return allBorrow;
    }

}
