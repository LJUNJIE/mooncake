package com.moon.common.config;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;

/**
 * 生产者消息确认
 *
 * @author huan.fu
 * @date 2018/11/5 - 13:55
 */
//public class RabbitConfirmCallback implements RabbitTemplate.ConfirmCallback {
//
//    @Override
//    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
//        System.out.println("消息唯一标识："+correlationData);
//        System.out.println("确认结果："+ack);
//        System.out.println("失败原因："+cause);
//    }
//}

public class RabbitConfirmCallback  {


}