package com.moon.systemweb.controller;

import com.moon.common.model.PageReq;
import com.moon.common.model.ResultData;
import com.moon.systemweb.mq.Producer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping("/mq")
    @ResponseBody
    @ApiOperation(value="mq", notes="mq" ,httpMethod="POST")
    public ResultData mq(@RequestBody PageReq pageReq) {
        // 交换机，交换机对应的Key
        producer.send("topicExchange","key.1","草拟吗");
        return new ResultData(0,"11111");
    }
}
