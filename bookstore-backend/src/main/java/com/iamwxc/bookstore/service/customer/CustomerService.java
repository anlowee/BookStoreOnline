package com.iamwxc.bookstore.service.customer;

import com.iamwxc.bookstore.service.basic.BasicQueryOperation;
import com.iamwxc.bookstore.service.dto.BookDto;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

/**
 * @author 魏啸冲
 * @version 1.0
 * @date 2020/7/27
 * include all customer operations
 * @last-check-in 魏啸冲
 * @date 2020/7/27
 */
@Service
public abstract class CustomerService implements BasicQueryOperation<BookDto, BigInteger> {

}
