package com.ict.librarysystem.controller;

import com.ict.librarysystem.domian.Book;
import com.ict.librarysystem.service.BookService;
import com.ict.librarysystem.utils.JsonResult;
import com.ict.librarysystem.utils.Meta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;

/**
 * @Author: Lizbeth9421
 * @Date: 2021/12/21/11:25
 */
@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    /**
     * 查询书籍，包含模糊查询
     *
     * @param book
     * @return
     */
    @PostMapping("/queryBookSelective")
    public LinkedList<Book> queryBookSelective(Book book) {
        return bookService.queryBookSelective(book);
    }

    /**
     * 添加书籍
     *
     * @param book
     * @return
     */
    @PostMapping("/insertBook")
    public JsonResult insertBook(Book book) {
        JsonResult jsonResult = null;
        try {
            bookService.insertSelective(book);
            jsonResult = new JsonResult(book, new Meta("添加成功", 200));
        } catch (Exception e) {
            jsonResult = new JsonResult(null, new Meta("添加失败", 400));
            e.printStackTrace();
        }
        return jsonResult;
    }

    /**
     * 修改书籍信息
     *
     * @param book
     * @return
     */
    @PostMapping("/updateBook")
    public JsonResult updateBook(Book book) {
        JsonResult jsonResult = null;
        try {
            if (bookService.updateByPrimaryKeySelective(book) == 1) {
                jsonResult = new JsonResult(book, new Meta("修改成功", 200));
            } else {
                jsonResult = new JsonResult(book, new Meta("修改失败", 400));
            }
        } catch (Exception e) {
            jsonResult = new JsonResult(book, new Meta("修改失败", 400));
            e.printStackTrace();
        }
        return jsonResult;
    }


    /**
     * 删除书籍
     *
     * @param id 书籍id
     * @return
     */
    @PostMapping("/deleteBook")
    public JsonResult deleteBook(Integer id) {
        JsonResult jsonResult;
        try {
            if (bookService.deleteByPrimaryKey(id) == 1) {
                jsonResult = new JsonResult(1, new Meta("删除成功", 200));
            } else {
                jsonResult = new JsonResult(1, new Meta("删除失败", 400));
            }

        } catch (Exception e) {
            jsonResult = new JsonResult(1, new Meta("删除失败", 400));
        }
        return jsonResult;
    }

    /**
     * 根据书籍id获取书籍信息
     *
     * @param id
     * @return
     */
    @PostMapping("/getBookById")
    public Book getBookById(Integer id) {
        return bookService.selectByPrimaryKey(id);
    }
}
