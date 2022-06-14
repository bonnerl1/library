package com.ict.librarysystem.domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Lizbeth9421
 * @Date: 2021/12/21/11:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    public Book(final Integer id, final Integer available) {
        this.id = id;
        this.available = available;
    }

    private Integer id;

    /**
     * 书名
     */
    private String name;

    /**
     * 作者
     */
    private String author;

    /**
     * 价格
     */
    private Double price;

    /**
     * 书本类别  哲学类 社会科学类 青春校园类 悬疑惊悚类 科幻类
     */
    private String booktype;

    /**
     * 是否可用
     * 1可用
     * 0不可用
     */
    private Integer available;
}