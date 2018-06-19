package com.example.esdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类的实现描述：TODO 类实现描述
 *
 * @author sunyajun 2018/6/19 11:11
 */
@RestController
@RequestMapping("/es")
public class ArticleController {

    @Autowired
    private ArticleSearchRepository er;

    //增加
    @RequestMapping("/add")
    public String add(){

        Article employee=new Article();
        employee.setId(1L);
        employee.setContent("article1");
        employee.setTitle("article1");
        er.save(employee);

        System.err.println("add a obj");

        return "success";
    }

    //删除
    @RequestMapping("/delete")
    public String delete(){
        Article article = new Article();
        article.setId(1L);
        er.delete(article);

        return "success";
    }

    //局部更新
    @RequestMapping("/update")
    public String update(){

        Article employee=er.queryById(1L);
        employee.setTitle("artivle_update_1");
        er.save(employee);

        System.err.println("update a obj");

        return "success";
    }

    //查询
    @RequestMapping("/query")
    public Article query(){

        Article accountInfo=er.queryById(1L);
        System.err.println(accountInfo);

        return accountInfo;
    }
}
