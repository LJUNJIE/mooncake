package com.moon.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xjl on 2019/6/13.
 */
@Configuration
public class RabbitmqConfig {

    @Resource
    private RabbitTemplate rabbitTemplate;

    /**
     * 定义一个hello的队列
     * Queue 可以有4个参数
     *      1.队列名
     *      2.durable       持久化消息队列 ,rabbitmq重启的时候不需要创建新的队列 默认true
     *      3.auto-delete   表示消息队列没有在使用时将被自动删除 默认是false
     *      4.exclusive     表示该消息队列是否只在当前connection生效,默认是false
     */
    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }

    //声明队列
    @Bean
    public Queue polnoQueue() {
        return new Queue("polno.queue", true); // true表示持久化该队列
    }

    @Bean
    public Queue queue2() {
        return new Queue("hello.queue2", true);
    }

    //声明交互器
    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }

    //绑定
    @Bean
    public Binding binding1() {
        return BindingBuilder.bind(polnoQueue()).to(topicExchange()).with("key.1");
    }

    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(queue2()).to(topicExchange()).with("key.#");
    }


    @PostConstruct
    public void initRabbitTemplate() {
        // 设置生产者消息确认
//        rabbitTemplate.setConfirmCallback(new RabbitConfirmCallback());
    }

    /**
     * 申明队列
     *
     * @return
     */
    @Bean
    public Queue queue() {
        Map<String, Object> arguments = new HashMap<>(4);
        // 申明死信交换器
        arguments.put("x-dead-letter-exchange", "exchange-dlx");
        return new Queue("queue-rabbit-springboot-advance", true, false, false, arguments);
    }

    /**
     * 没有路由到的消息将进入此队列
     *
     * @return
     */
    @Bean
    public Queue unRouteQueue() {
        return new Queue("queue-unroute");
    }

    /**
     * 死信队列
     *
     * @return
     */
    @Bean
    public Queue dlxQueue() {
        return new Queue("dlx-queue");
    }

    /**
     * 申明交换器
     *
     * @return
     */
    @Bean
    public Exchange exchange() {
        Map<String, Object> arguments = new HashMap<>(4);
        // 当发往exchange-rabbit-springboot-advance的消息,routingKey和bindingKey没有匹配上时，将会由exchange-unroute交换器进行处理
        arguments.put("alternate-exchange", "exchange-unroute");
        return new DirectExchange("exchange-rabbit-springboot-advance", true, false, arguments);
    }

    @Bean
    public FanoutExchange unRouteExchange() {
        // 此处的交换器的名字要和 exchange() 方法中 alternate-exchange 参数的值一致
        return new FanoutExchange("exchange-unroute");
    }

    /**
     * 申明死信交换器
     *
     * @return
     */
    @Bean
    public FanoutExchange dlxExchange() {
        return new FanoutExchange("exchange-dlx");
    }

    /**
     * 申明绑定
     *
     * @return
     */
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(exchange()).with("product").noargs();
    }

    @Bean
    public Binding unRouteBinding() {
        return BindingBuilder.bind(unRouteQueue()).to(unRouteExchange());
    }

    @Bean
    public Binding dlxBinding() {
        return BindingBuilder.bind(dlxQueue()).to(dlxExchange());
    }

}