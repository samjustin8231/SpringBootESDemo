package com.example.esdemo.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * 类的实现描述：TODO 类实现描述
 *
 * @author sunyajun 2018/6/21 16:30
 */
@Component
@EnableScheduling
public class HelloProducer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue queue;

    @Scheduled(fixedDelay = 5000)
    public void send() {
        jmsMessagingTemplate.convertAndSend(queue, "测试消息队列" + System.currentTimeMillis());
    }
}
