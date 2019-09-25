package com.moon.systemweb.controller;

import com.moon.common.model.ResultData;
import com.moon.systemweb.mq.Producer;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value="mq调用Controller")
public class RabbitMqController {

    @Autowired
    private Producer producer;

    /**
     * 保单认领行为
     * @param polno
     * @return
     */
    @GetMapping(value = "/cliamPolno")
    public ResultData getReport2(@RequestParam String polno) {
        // 交换机，交换机对应的Key
//        producer.send("topicExchange","key.1","草拟吗");
//        rabbitProducer.send();

        return new ResultData(0,polno);
    }
}
