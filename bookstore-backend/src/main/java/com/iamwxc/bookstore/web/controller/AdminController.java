package com.iamwxc.bookstore.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.iamwxc.bookstore.dao.entity.Book;
import com.iamwxc.bookstore.service.admin.AdminService;
import com.iamwxc.bookstore.service.dto.BookDto;
import com.iamwxc.bookstore.web.resp.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

/**
 * @author 魏啸冲
 * @version 1.0
 * @date 2020/7/27
 * admin api
 * @last-check-in 魏啸冲
 * @date 2020/7/27
 */
@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    private BookDto deserilize(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        BookDto book = new BookDto();
        book.setBookName(mapper.readValue(json, ObjectNode.class).get("book_name").asText("noname"));
        book.setBookImage(mapper.readValue(json, ObjectNode.class).get("book_image").asText("https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E4%B9%A6&step_word=&hs=0&pn=51&spn=0&di=44770&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&istype=0&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=undefined&cs=2721624056%2C2201104458&os=1774176690%2C1722175251&simid=0%2C0&adpicid=0&lpn=0&ln=1867&fr=&fmq=1595847155260_R&fm=&ic=undefined&s=undefined&hd=undefined&latest=undefined&copyright=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&ist=&jit=&cg=&bdtype=0&oriquery=&objurl=http%3A%2F%2Fmy.qqkuyou.com%2Fimg_jianbihua%2F54252270.jpeg&fromurl=ippr_z2C%24qAzdH3FAzdH3Ff_z%26e3Bqqh7y57_z%26e3Bv54AzdH3F3twgkti7wAzdH3Fmandcn_r9_z%26e3Bip4s&gsm=3c&rpstart=0&rpnum=0&islist=&querylist=&force=undefined"));
        book.setBookIntroduction(mapper.readValue(json, ObjectNode.class).get("book_introduction").asText("no introduction..."));
        book.setBookPrice(mapper.readValue(json, ObjectNode.class).get("book_price").asDouble(0.0));
        return book;
    }

    @GetMapping("/api/book")
    public List<BookDto> findBooksByBookNameContains(@RequestParam String keywords) {
        return adminService.findObjects(keywords);
    }

    @PostMapping("/api/book")
    public RespBean addBook(@RequestBody String json) throws JsonProcessingException {
        BookDto book = deserilize(json);
        if (adminService.add(book)) {
            return RespBean.ok("add book successfully");
        } else {
            return RespBean.error("internal server error");
        }
    }

    @PutMapping("/api/book")
    public RespBean updateBook(@RequestParam(value = "book_id") BigInteger id,
                               @RequestBody String json) throws JsonProcessingException {
        BookDto book = deserilize(json);
        book.setId(id);
        if (adminService.update(book)) {
            return RespBean.ok("update book successfully");
        } else {
            return RespBean.error("internal server error");
        }
    }

    @DeleteMapping("/api/book")
    public RespBean deleteBook(@RequestParam(value = "book_id") BigInteger[] bookIds) {
        Boolean flag = true;
        for (BigInteger bookId : bookIds) {
            BookDto book = new BookDto();
            book.setId(bookId);
            flag = adminService.remove(book);
        }
        if (flag) {
            return RespBean.ok("delete book successfully");
        } else {
            return RespBean.error("internal server error");
        }
    }

}
