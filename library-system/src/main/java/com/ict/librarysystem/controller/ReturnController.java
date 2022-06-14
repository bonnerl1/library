package com.ict.librarysystem.controller;

import com.ict.librarysystem.service.ReturnService;
import com.ict.librarysystem.utils.JsonResult;
import com.ict.librarysystem.utils.Meta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Lizbeth9421
 * @Date: 2021/12/25/16:07
 */
@RestController
public class ReturnController {
    @Autowired
    private ReturnService returnService;

    /**
     * 用于还书操作
     *
     * @param userid
     * @param bookid
     * @return
     */
    @PostMapping("/returnBook")
    public JsonResult returnBook(Integer userid, Integer bookid) {
        JsonResult jsonResult;
        if (returnService.returnBook(userid, bookid) == 1) {
            jsonResult = new JsonResult(1, new Meta("还书成功", 200));
        } else {
            jsonResult = new JsonResult(0, new Meta("还书失败", 400));
        }
        return jsonResult;
    }

    /**
     * 获取还书记录
     *
     * @param userid
     * @return
     */
    @PostMapping("/getReturns")
    public JsonResult getReturns(Integer userid) {
        JsonResult jsonResult;

        if (userid == null) {
            jsonResult = new JsonResult(returnService.getAllReturn(), new Meta("查询成功", 200));
        } else {
            jsonResult = new JsonResult(returnService.getReturnById(userid), new Meta("查询成功", 200));
        }
        return jsonResult;
    }
}