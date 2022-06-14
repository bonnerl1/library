package com.ict.librarysystem.domian;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @Author: Lizbeth9421
 * @Date: 2021/12/25/1:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Borrow {
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
    * 图书类型
    */
    private String booktype;

    /**
    * 借阅人
    */
    private String borrowUser;

    /**
    * 借阅的时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date creattime;


    /**
     * 判断书籍是否归还
     */
    private Integer bookState;

    /**
     * 书籍id
     */
    private Integer bookid;

}