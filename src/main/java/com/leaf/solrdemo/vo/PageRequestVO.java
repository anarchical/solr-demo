package com.leaf.solrdemo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author YeYaqiao
 */
@Data
@AllArgsConstructor
public class PageRequestVO {
    private Integer pageSize;
    private Integer pageNums;
}
