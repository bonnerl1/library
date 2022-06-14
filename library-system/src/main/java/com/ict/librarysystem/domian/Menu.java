package com.ict.librarysystem.domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Lizbeth9421
 * @Date: 2021/12/21/0:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    /**
    * id
    */
    private Integer id;

    /**
    * 内容
    */
    private String title;

    /**
    * 图标内容
    */
    private String icon;

    /**
    * 是否可用  1为可用   0为不可用
    */
    private Integer available;

    /**
     * 路由路径
     */
    private String path;

}