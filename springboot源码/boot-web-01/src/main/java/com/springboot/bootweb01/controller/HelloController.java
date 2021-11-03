package com.springboot.bootweb01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    /**
     * 请求进来时，先看controller能不能处理，不能处理再交给静态资源处理器处理，还是不能处理，返回404
     * @return
     */
    @RequestMapping("/7.png")
    public String hello(){
        return "aaa";
    }
}
