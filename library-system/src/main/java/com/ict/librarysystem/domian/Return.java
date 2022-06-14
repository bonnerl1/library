package com.ict.librarysystem.domian;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Lizbeth9421
 * @Date: 2021/12/25/16:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Return {
    /**
    * id
    */
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
    * 书籍类型
    */
    private String booktype;

    /**
    * 还书人
    */
    private String returnUser;

    /**
    * 还书时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date returntime;
}