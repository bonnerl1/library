package com.ict.librarysystem.domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Lizbeth9421
 * @Date: 2021/12/20/23:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /**
    * 用户id
    */
    private Integer id;

    /**
    * 用户名
    */
    private String username;

    /**
    * 密码
    */
    private String password;

    /**
    * 性别 
    */
    private String sex;

    /**
    * 年龄
    */
    private Integer age;

    /**
    * 1为管理员 0为普通用户
    */
    private Integer type;

    /**
    * 是否可用
    */
    private Integer status;
}