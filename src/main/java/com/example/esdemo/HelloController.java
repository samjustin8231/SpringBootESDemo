package com.example.esdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类的实现描述：TODO 类实现描述
 *
 * @author sunyajun 2018/6/19 10:11
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public  String say() {
        return "hello java";
    }
}
