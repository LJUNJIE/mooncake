package com.moon.product.mq;


import com.alibaba.fastjson.JSON;
import com.moon.product.entity.TbProductInfo;
import com.moon.product.mapper.TbProductInfoMapper;
import com.rabbitmq.client.Channel;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import com.moon.product.dto.TbProductInfoDto;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class Comsumer {
    private Logger log = LoggerFactory.getLogger(Comsumer.class);

    @Autowired
    TbProductInfoMapper tbProductInfoMapper;
    @Autowired
    RedisTemplate redisTemplate;

    @RabbitListener(queues = "product.queue")
    public void process(String msg,Channel channel, Message message) throws IOException {
        try {
            /**
             * 发送消息之前，根据消息全局ID去数据库中查询该条消息是否已经消费过，如果已经消费过，则不再进行消费。
             */

            // 获取消息Id
            String messageId = message.getMessageProperties().getMessageId();
            if (StringUtils.isBlank(messageId)) {
                System.out.println("获取消费ID为空！");
                return;
            }

            // 从全局redis获取，若存在，就是已经消费过
            Object object = redisTemplate.opsForValue().get(messageId);
            if (null == object) {
                msg = new String(message.getBody(), StandardCharsets.UTF_8);
                TbProductInfoDto productInfoDto = JSON.parseObject(msg, TbProductInfoDto.class);
                TbProductInfo productInfo = tbProductInfoMapper.selectById(productInfoDto.getId());
                int total = productInfo.getNum();
                int buyOut = productInfoDto.getNum();
                productInfo.setNum(total-buyOut);
                tbProductInfoMapper.updateById(productInfo);
                if (true) {
                    System.out.println("收到消息 data:"+productInfoDto.toString()+"消费ID:"+messageId);
                    // 手动签收消息,通知mq服务器端删除该消息
                    channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
                }
                redisTemplate.opsForValue().set(messageId,msg);
            }

        } catch (Exception e) {
            e.printStackTrace();
            // // 丢弃该消息
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
        }
    }

}