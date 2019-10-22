package com.moon.order.mq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.util.UUID;

@Component
public class Producer implements RabbitTemplate.ConfirmCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 给队列发送消息
     */
    public void send(Object object)  {

        JSONObject jsonObj = (JSONObject) JSON.toJSON(object);
        String data = jsonObj.toJSONString();
        System.out.println("producer发送内容 : " + data);
        //CorrelationData correlation= new CorrelationData(UUID.randomUUID().toString());
        //创建消费对象，并指定全局唯一ID(这里使用UUID，也可以根据业务规则生成，只要保证全局唯一即可)
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setMessageId(UUID.randomUUID().toString());
        messageProperties.setContentType("text/plain");
        messageProperties.setContentEncoding("utf-8");
        Message message = new Message(data.getBytes(), messageProperties);
        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(messageProperties.getMessageId());
        // 先存个值到redis
        this.rabbitTemplate.setConfirmCallback(this);
        this.rabbitTemplate.setMandatory(true);

        this.rabbitTemplate.convertAndSend("topicExchange","toProduct",message,correlationData);

    }

    // 生产消息确认机制 生产者往服务器端发送消息的时候 采用应答机制

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        String correlationId = correlationData.getId(); //id 都是相同的哦  全局ID
        System.out.println("消息id:" + correlationData.getId());
        if (ack) { //消息发送成功
            System.out.println("消息发送确认成功");
        } else {
            //重试机制
            String data = (String) redisTemplate.opsForValue().get(correlationId);
            send(data);
            System.out.println("消息发送确认失败:" + cause);
        }
    }
}