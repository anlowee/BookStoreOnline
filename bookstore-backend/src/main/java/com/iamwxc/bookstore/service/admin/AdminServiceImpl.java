package com.iamwxc.bookstore.service.admin;

import com.iamwxc.bookstore.dao.dao.BookDao;
import com.iamwxc.bookstore.dao.entity.Book;
import com.iamwxc.bookstore.service.dto.BookDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author 魏啸冲
 * @version 1.0
 * @date 2020/7/27
 * @last-check-in 魏啸冲
 * @date 2020/7/27
 */
@Service
public class AdminServiceImpl extends AdminService {

    @Autowired
    private BookDao bookDao;

    @Override
    public Boolean add(BookDto bookDto) {
        try {
            Book newBook = new Book();
            BeanUtils.copyProperties(bookDto, newBook);
            bookDao.save(newBook);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean remove(BookDto bookDto) {
        try {
            bookDao.deleteById(bookDto.getId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean update(BookDto bookDto) {
        try {
            Book waitToUpdate = bookDao.findById(bookDto.getId()).orElseThrow(Exception::new);
            BeanUtils.copyProperties(bookDto, waitToUpdate);
            bookDao.save(waitToUpdate);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<BookDto> findObjects(String keywords) {
        List<Book> results = bookDao.findBooksByBookNameContains(keywords);
        List<BookDto> bookDtos = new ArrayList<>();
        for (Book book : results) {
            BookDto bookDto = new BookDto();
            BeanUtils.copyProperties(book, bookDto);
            bookDtos.add(bookDto);
        }
        return bookDtos;
    }

    @Override
    @Deprecated
    public BookDto findObject(String s) {
        return null;
    }

}
