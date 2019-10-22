package com.moon.reportweb.mq;


import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Comsumer {
    private Logger log = LoggerFactory.getLogger(Comsumer.class);


    @RabbitListener(queues = "product.queue")
    public void processMessage1(String msg,Channel channel, Message message) {
        try {
            System.out.println("收到polno.queue队列的"+msg);
            //告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了 否则消息服务器以为这条消息没处理掉 后续还会在发
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            Thread.sleep(20000);
            System.out.println("polno.queue:"+msg);
        } catch (IOException e) {
            e.printStackTrace();
            //丢弃这条消息
            //channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
            System.out.println("receiver fail"+msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = "hello.queue2")
    public void processMessage2(String msg,Channel channel, Message message) {
        try {
            //告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了 否则消息服务器以为这条消息没处理掉 后续还会在发
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            Thread.sleep(10000);

            System.out.println("hello.queue2:"+msg);
        } catch (IOException e) {
            e.printStackTrace();
            //丢弃这条消息
            //channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
            System.out.println("receiver fail");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}