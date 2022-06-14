package com.ict.librarysystem.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Lizbeth9421
 * @Date: 2021/12/18/23:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult {
    private Object data;

    private Meta meta;

}
