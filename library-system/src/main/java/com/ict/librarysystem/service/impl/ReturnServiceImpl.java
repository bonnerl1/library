package com.ict.librarysystem.service.impl;

import com.ict.librarysystem.domian.Book;
import com.ict.librarysystem.domian.User;
import com.ict.librarysystem.mapper.BookMapper;
import com.ict.librarysystem.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ict.librarysystem.mapper.ReturnMapper;
import com.ict.librarysystem.domian.Return;
import com.ict.librarysystem.service.ReturnService;

import java.util.Date;
import java.util.LinkedList;

/**
 * @Author: Lizbeth9421
 * @Date: 2021/12/25/16:02
 */
@Service
public class ReturnServiceImpl implements ReturnService{

    @Resource
    private ReturnMapper returnMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return returnMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Return record) {
        return returnMapper.insert(record);
    }

    @Override
    public int insertSelective(Return record) {
        return returnMapper.insertSelective(record);
    }

    @Override
    public Return selectByPrimaryKey(Integer id) {
        return returnMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Return record) {
        return returnMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Return record) {
        return returnMapper.updateByPrimaryKey(record);
    }

    @Override
    public int returnBook(final Integer userid, final Integer bookid) {
        Integer returnValue;
        //获取用户信息
        User user = userMapper.selectByPrimaryKey(userid);
        //获取被借书本信息
        Book book = bookMapper.selectByPrimaryKey(bookid);
        Return result=new Return();
        //只有等于0才能换书
        if (book.getAvailable()!=0){
            returnValue=0;
            return returnValue;
        }
        try {
            result.setName(book.getName());
            result.setAuthor(book.getAuthor());
            result.setBooktype(book.getBooktype());
            result.setReturnUser(user.getUsername());
            result.setReturntime(new Date());
            returnMapper.insertSelective(result);
            bookMapper.updateByPrimaryKeySelective(new Book(bookid, 1));
            returnValue = 1;
        } catch (Exception e) {
            returnValue = 0;
            e.printStackTrace();
        }
        return returnValue;
    }

    @Override
    public LinkedList<Return> getAllReturn() {
        return returnMapper.getAllReturn();
    }

    @Override
    public LinkedList<Return> getReturnById(final Integer userid) {
        return returnMapper.getReturnById(userid);
    }

}
