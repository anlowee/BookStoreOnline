package com.iamwxc.bookstore.service.basic;

import java.util.List;

/**
 * @author 魏啸冲
 * @version 1.0
 * @date 2020/7/27
 * T is the entity's dto type, E is the key's type
 * @last-check-in 魏啸冲
 * @date 2020/7/27
 */
public interface BasicQueryOperation<T, E> {

    /** find a list objects whose type is T */
    List<T> findObjects(E e);

    /** find a single object whose type is T */
    T findObject(E e);

}

