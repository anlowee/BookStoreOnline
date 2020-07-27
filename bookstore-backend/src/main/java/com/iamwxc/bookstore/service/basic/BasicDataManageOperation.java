package com.iamwxc.bookstore.service.basic;

import java.util.List;

/**
 * @author 魏啸冲
 * @version 1.0
 * @date 2020/7/27
 * define basic dao operations
 * E is the dto class
 * @last-check-in 魏啸冲
 * @date 2020/7/27
 */
public interface BasicDataManageOperation<E> {

    /** true-success, false-failed, the following three methods is the same*/
    Boolean add(E e);

    Boolean remove(E e);

    Boolean update(E e);

}
