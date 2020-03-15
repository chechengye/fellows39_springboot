package com.weichuang.fellows39_springboot.service.impl;

import com.weichuang.fellows39_springboot.pojo.Book;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl {

    @RabbitListener(queues = "qingmeng.news")
    public void receive(Book book){
        System.out.println("收到消息: " + book);
    }
}
