package com.example.springaop.controller;

import com.example.springaop.annotation.Auto;
import com.example.springaop.entity.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Jonny
 * @date: 2021-01-19
 */
@RestController
public class MainController {

    @Auto
    @RequestMapping("fun1")
    public Order fun1(Order order) {
        return order;
    }

    @RequestMapping("fun2")
    public Order fun2(Order order) {
        return order;
    }
}
