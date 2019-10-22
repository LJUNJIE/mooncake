package com.moon.product.web;


import com.baomidou.mybatisplus.plugins.Page;
import com.moon.common.model.PageReq;
import com.moon.common.model.ResultData;
import com.moon.product.dto.TbProductInfoDto;
import com.moon.product.entity.TbProductInfo;
import com.moon.product.service.ITbProductInfoService;
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
@RequestMapping("/product")
public class TbProductInfoController {
    @Autowired
    ITbProductInfoService tbProductInfoService;

    @RequestMapping("/productPage")
    @ResponseBody
    @ApiOperation(value="productPage", notes="商品页面" ,httpMethod="POST")
    public ResultData productPage(@RequestBody PageReq pageReq) {
        Page<TbProductInfo> users = tbProductInfoService.selectPage(new Page<>(1, 10));
        return new ResultData(0,users);
    }

    @RequestMapping("/addProduct")
    @ResponseBody
    @ApiOperation(value="addProduct", notes="新增商品" ,httpMethod="POST")
    public ResultData addProduct(@RequestBody TbProductInfo tbProductInfo) {
        tbProductInfoService.insert(tbProductInfo);
        return new ResultData(0,"新增成功");
    }


    @RequestMapping("/delProduct")
    @ResponseBody
    @ApiOperation(value="delProduct", notes="删除商品" ,httpMethod="POST")
    public ResultData delProduct(@RequestBody TbProductInfo tbProductInfo) {
        tbProductInfoService.deleteById(tbProductInfo.getId());
        return new ResultData(0,"删除成功");
    }


    @RequestMapping("/editProduct")
    @ResponseBody
    @ApiOperation(value="editProduct", notes="修改商品" ,httpMethod="POST")
    public ResultData editProduct(@RequestBody TbProductInfo tbProductInfo) {
        tbProductInfoService.updateAllColumnById(tbProductInfo);
        return new ResultData(0,"修改成功");
    }

    @RequestMapping("/reduce")
    @ResponseBody
    @ApiOperation(value="reduce", notes="减少库存" ,httpMethod="POST")
    public ResultData reduce(@RequestBody TbProductInfoDto tbProductInfoDto) {
        tbProductInfoService.reduce(tbProductInfoDto);
        return new ResultData(0,"修改成功");
    }


}
