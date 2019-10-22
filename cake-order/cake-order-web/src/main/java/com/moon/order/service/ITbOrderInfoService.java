package com.moon.order.service;

import com.moon.order.dto.TbOrderDto;
import com.moon.order.entity.TbOrderInfo;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xjl
 * @since 2019-10-15
 */
public interface ITbOrderInfoService extends IService<TbOrderInfo> {

    void addOrder(TbOrderDto orderDto) throws Exception;
}
