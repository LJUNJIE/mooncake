package com.moon.order.feign;

import com.moon.product.dto.TbProductInfoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "product-service")
public interface IProductClient {
    @RequestMapping(value = "/product/reduce",method = RequestMethod.POST)
    void reduce(@RequestBody TbProductInfoDto tbProductInfoDto);
}