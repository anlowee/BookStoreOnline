package com.iamwxc.bookstore.web.resp;

import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

/**
 * @author 魏啸冲
 * @version 1.0
 * @date 2020/7/27
 * basic resp type
 * @last-check-in 魏啸冲
 * @date 2020/7/27
 */
@Data
public class RespBean {

    private Integer code;

    private String msg;

    private Date timeStamp;

    public static RespBean ok(String msg) {
        RespBean respBean = new RespBean();
        respBean.setCode(200);
        respBean.setMsg(msg);
        respBean.setTimeStamp(new Date());
        return respBean;
    }

    public static RespBean error(String msg) {
        RespBean respBean = new RespBean();
        respBean.setCode(500);
        respBean.setMsg(msg);
        respBean.setTimeStamp(new Date());
        return respBean;
    }

}
