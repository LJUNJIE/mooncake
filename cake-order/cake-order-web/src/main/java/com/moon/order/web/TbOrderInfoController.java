package com.moon.order.web;


import com.baomidou.mybatisplus.plugins.Page;
import com.moon.common.model.PageReq;
import com.moon.common.model.ResultData;
import com.moon.order.dto.TbOrderDto;
import com.moon.order.entity.TbOrderInfo;
import com.moon.order.service.ITbOrderInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xjl
 * @since 2019-10-15
 */
@Controller
@RequestMapping("/order")
public class TbOrderInfoController {

    @Autowired
    ITbOrderInfoService tbOrderInfoService;

    @RequestMapping("/orderPage")
    @ResponseBody
    @ApiOperation(value="orderPage", notes="订单页面" ,httpMethod="POST")
    public ResultData orderPage(@RequestBody PageReq pageReq) {
        Page<TbOrderInfo> users = tbOrderInfoService.selectPage(new Page<>(1, 10));
        return new ResultData(0,users);
    }

    @RequestMapping("/addOrder")
    @ResponseBody
    @ApiOperation(value="addOrder", notes="新增订单" ,httpMethod="POST")
    public ResultData addOrder(@RequestBody TbOrderDto tbOrderDto) throws Exception {
        tbOrderInfoService.addOrder(tbOrderDto);
        return new ResultData(0,"新增成功");
    }


    @RequestMapping("/delOrder")
    @ResponseBody
    @ApiOperation(value="delOrder", notes="删除订单" ,httpMethod="POST")
    public ResultData delOrder(@RequestBody TbOrderInfo TbOrderInfo) {
        tbOrderInfoService.deleteById(TbOrderInfo.getId());
        return new ResultData(0,"删除成功");
    }


    @RequestMapping("/editOrder")
    @ResponseBody
    @ApiOperation(value="editOrder", notes="修改订单" ,httpMethod="POST")
    public ResultData editOrder(@RequestBody TbOrderInfo TbOrderInfo) {
        tbOrderInfoService.updateAllColumnById(TbOrderInfo);
        return new ResultData(0,"修改成功");
    }
}
