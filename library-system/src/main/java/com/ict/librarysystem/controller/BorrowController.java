package com.ict.librarysystem.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.ict.librarysystem.service.BorrowService;
import com.ict.librarysystem.utils.JsonResult;
import com.ict.librarysystem.utils.Meta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Lizbeth9421
 * @Date: 2021/12/25/2:04
 */
@RestController
public class BorrowController {
    @Autowired
    private BorrowService borrowService;

    /**
     * 借阅书籍操作
     *
     * @param userid
     * @param bookid
     * @return
     */
    @PostMapping("/borrowBook")
    public JsonResult borrowBook(Integer userid, Integer bookid) {
        JsonResult jsonResult;
        if (borrowService.borrowBook(userid, bookid) == 1) {
            jsonResult = new JsonResult(1, new Meta("借阅成功", 200));
        } else {
            jsonResult = new JsonResult(0, new Meta("借阅失败", 400));
        }
        return jsonResult;
    }

    /**
     * 借阅记录删除
     *
     * @param id
     * @return
     */
    @PostMapping("/deleteBorrow")
    public JsonResult deleteBorrow(Integer id) {
        JsonResult jsonResult;
        try {
            if (borrowService.deleteByPrimaryKey(id) == 1) {
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
     * 获取借阅记录
     *
     * @param userid 用户id
     * @return
     */
    @PostMapping("/getBorrow")
    public JsonResult getBorrow(Integer userid) {
        JsonResult jsonResult;

        if (userid == null) {
            jsonResult = new JsonResult(borrowService.getAllBorrow(), new Meta("查询成功", 200));
        } else {
            jsonResult = new JsonResult(borrowService.getBorrowByUserId(userid), new Meta("查询成功", 200));
        }
        return jsonResult;
    }
}
