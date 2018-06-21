package com.example.esdemo.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 类的实现描述：TODO 类实现描述
 *
 * @author sunyajun 2018/6/21 16:31
 */
@Component
public class HelloConsumer {
    @JmsListener(destination = "${queue}")
    public void receive(String msg) {
        System.out.println("监听器收到msg:" + msg);
    }

}
