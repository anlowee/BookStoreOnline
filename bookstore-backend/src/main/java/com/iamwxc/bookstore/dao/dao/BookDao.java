package com.iamwxc.bookstore.dao.dao;

import com.iamwxc.bookstore.dao.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

/**
 * @author 魏啸冲
 * @version 1.0
 * @date 2020/7/27
 * @last-check-in 魏啸冲
 * @date 2020/7/27
 */
@Repository
public interface BookDao extends JpaRepository<Book, BigInteger> {

    List<Book> findBooksByBookNameContains(String keywords);

}
