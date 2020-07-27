package com.iamwxc.bookstore.service.dto;

import lombok.Data;

import java.math.BigInteger;

/**
 * @author 魏啸冲
 * @version 1.0
 * @date 2020/7/27
 * @last-check-in 魏啸冲
 * @date 2020/7/27
 */
@Data
public class BookDto {

    private BigInteger id;

    private String bookName;

    /** the url of book image */
    private String bookImage;

    private Double bookPrice;

    private String bookIntroduction;

}
