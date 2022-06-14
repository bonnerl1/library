package com.ict.librarysystem.controller;

import cn.hutool.core.util.ObjectUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.ict.librarysystem.domian.Menu;
import com.ict.librarysystem.domian.User;
import com.ict.librarysystem.service.MenuService;
import com.ict.librarysystem.service.UserService;
import com.ict.librarysystem.utils.JsonResult;
import com.ict.librarysystem.utils.Meta;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.MarshalledObject;
import java.util.*;

/**
 * @Author: Lizbeth9421
 * @Date: 2021/12/17/12:58
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    /**
     * 登录方法
     *
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    public JsonResult login(String username, String password) {
        User user = userService.login(username, DigestUtils.md5DigestAsHex(password.getBytes()));
        JsonResult jsonResult = null;
        if (ObjectUtil.isNotNull(user)) {
            jsonResult = new JsonResult(user, new Meta("登录成功", 200));
        } else {
            jsonResult = new JsonResult(user, new Meta("账号或密码错误", 400));
        }
        return jsonResult;
    }

    /**
     * 根据用户id获取用户所拥有的菜单
     *
     * @param id
     * @return
     */
    @PostMapping("/getMenu")
    public List<Menu> getMenu(Integer id) {
        User user = userService.selectByPrimaryKey(id);
        List<Menu> list = menuService.queryMenuById(user.getId(), user.getStatus());
        return list;
    }

    /**
     * 根据用户id获取用户信息
     *
     * @param id
     * @return
     */
    @PostMapping("/getUserById")
    public User getUserById(Integer id) {
        User user = userService.selectByPrimaryKey(id);
        return user;
    }

    /**
     * 获取所有用户
     *
     * @return
     */
    @PostMapping("/getAllUsers")
    public LinkedList<User> getAllUsers(String username) {
        return userService.getAllUsers(username);
    }

    /**
     * 增加用户
     *
     * @param user
     * @return
     */
    @PostMapping("/insertUser")
    public JsonResult insertUser(User user) {
        JsonResult jsonResult = null;
        try {
            user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
            userService.insertSelective(user);
            jsonResult = new JsonResult(1, new Meta("添加成功", 200));
        } catch (Exception e) {
            jsonResult = new JsonResult(null, new Meta("添加失败", 400));
            e.printStackTrace();
        }
        return jsonResult;
    }


    /**
     * 根据用户id删除用户
     *
     * @param id
     * @return
     */
    @PostMapping("/deleteUser")
    public JsonResult deleteUser(Integer id) {
        JsonResult jsonResult = null;
        try {
            int keyCow = userService.deleteByPrimaryKey(id);
            if (keyCow == 1) {
                jsonResult = new JsonResult(1, new Meta("删除成功", 200));
            } else {
                jsonResult = new JsonResult(null, new Meta("此用户不存在", 400));
            }
        } catch (Exception e) {
            jsonResult = new JsonResult(null, new Meta("删除失败", 400));
            e.printStackTrace();
        }
        return jsonResult;
    }

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    @PostMapping("/updateUser")
    public JsonResult updateUser(User user) {
        JsonResult jsonResult = null;
        try {
            userService.updateByPrimaryKeySelective(user);
            jsonResult = new JsonResult(1, new Meta("修改成功", 200));
        } catch (Exception e) {
            jsonResult = new JsonResult(null, new Meta("修改失败", 400));
            e.printStackTrace();
        }
        return jsonResult;
    }
}
