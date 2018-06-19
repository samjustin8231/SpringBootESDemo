package com.example.esdemo;

import java.io.Serializable;

/**
 * 类的实现描述：TODO 类实现描述
 *
 * @author sunyajun 2018/6/19 10:43
 */
public class Tutorial implements Serializable {
    private Long id;
    private String name;//教程名称

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tutorial{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
