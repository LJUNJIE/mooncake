package com.moon.order.service.impl;

import com.moon.order.base.OrderConstants;
import com.moon.order.dto.TbOrderDto;
import com.moon.order.entity.TbOrderDetail;
import com.moon.order.entity.TbOrderInfo;
import com.moon.order.feign.IProductClient;
import com.moon.order.mapper.TbOrderDetailMapper;
import com.moon.order.mapper.TbOrderInfoMapper;
import com.moon.order.mq.Producer;
import com.moon.order.service.ITbOrderInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.moon.product.dto.TbProductInfoDto;
import org.apache.commons.lang3.SerializationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xjl
 * @since 2019-10-15
 */
@Service
public class TbOrderInfoServiceImpl extends ServiceImpl<TbOrderInfoMapper, TbOrderInfo> implements ITbOrderInfoService {

    @Autowired
    IProductClient productClient;
    @Autowired
    TbOrderInfoMapper orderInfoMapper;
    @Autowired
    TbOrderDetailMapper orderDetailMapper;
    @Autowired
    Producer producer;


    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class,propagation=Propagation.REQUIRED)
    public void addOrder(TbOrderDto orderDto) throws Exception {
        // 总价
        Double sumMoney = 0d;

        // 去产品库存
        for (TbProductInfoDto product : orderDto.getProducts()) {
            TbProductInfoDto productInfoDto = new TbProductInfoDto();
            productInfoDto.setId(product.getId());
            productInfoDto.setNum(product.getNum());
            // 推送消息到产品平台
            producer.send(productInfoDto);
            sumMoney+=product.getPrice();
        }

        // 生成订单
        TbOrderInfo orderInfo = new TbOrderInfo();
        orderInfo.setCreateTime(new Date());
        orderInfo.setUpdateTime(new Date());
        orderInfo.setCusId(orderDto.getCusId());
        orderInfo.setCusAddress(orderDto.getCusAddress());
        orderInfo.setOrdStatus(OrderConstants.VALID_ORDER);
        orderInfo.setPayStatus(OrderConstants.UN_PAY);
        orderInfo.setSumPrice(sumMoney);
        orderInfoMapper.insert(orderInfo);

        // 生成订单详情表
        for (TbProductInfoDto product : orderDto.getProducts()) {
            TbOrderDetail orderDetail = new TbOrderDetail();
            orderDetail.setOrderId(Long.valueOf(orderInfo.getId()));
            orderDetail.setProductId(product.getId());
            orderDetail.setProductNum(product.getNum());
            orderDetailMapper.insert(orderDetail);
        }

    }
}
