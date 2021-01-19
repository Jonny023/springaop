package com.example.springaop.entity;

import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: Jonny
 * @date: 2021-01-19
 */
@Data
public class Order extends Base {

    private String orderId;
    private Date createTime;
}
