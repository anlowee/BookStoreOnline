package com.iamwxc.bookstore.service.admin;

import com.iamwxc.bookstore.dao.entity.Book;
import com.iamwxc.bookstore.service.basic.BasicDataManageOperation;
import com.iamwxc.bookstore.service.basic.BasicQueryOperation;
import com.iamwxc.bookstore.service.dto.BookDto;
import org.springframework.stereotype.Service;

/**
 * @author 魏啸冲
 * @version 1.0
 * @date 2020/7/27
 * include all admin operations
 * @last-check-in 魏啸冲
 * @date 2020/7/27
 */
@Service
public abstract class AdminService implements BasicDataManageOperation<BookDto>, BasicQueryOperation<BookDto, String> {

}
