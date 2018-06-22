package com.example.esdemo.model;

import lombok.Data;

import java.util.Date;

/**
 * 类的实现描述：TODO 类实现描述
 *
 * @author sunyajun 2018/6/21 19:19
 */
@Data
public class User {

    private int id;
    private String username;
    private int age;
    private Date ctm;

    public User() {
    }

}
