package com.moon.common.constants;

public  class MqConstants {

    /**
     * 用户系统exchange名
     */
    public static final String MQ_EXCHANGE_USER = "user.topic.exchange";

    /**
     * 发送红包routing key
     */
    public static final String ROUTING_KEY_POST_REDPACKET = "post.redpacket";
    //String ROUTING_KEY_POST_REDPACKET = "post.#";
    /**
     * 死信队列：
     */
    public static final String deadRoutingKey = "dead_routing_key";

    public static final String deadExchangeName = "dead_exchange";
}
