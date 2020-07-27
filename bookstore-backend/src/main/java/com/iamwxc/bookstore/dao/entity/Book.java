package com.iamwxc.bookstore.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * @author 魏啸冲
 * @version 1.0
 * @date 2020/7/27
 * @last-check-in 魏啸冲
 * @date 2020/7/27
 */
@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;

    private String bookName;

    /** the url of book image */
    private String bookImage;

    private Double bookPrice;

    @Column(length = 3000)
    private String bookIntroduction;

}
