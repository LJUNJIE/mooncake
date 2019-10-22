package com.moon.product.service.impl;

import com.moon.product.dto.TbProductInfoDto;
import com.moon.product.entity.TbProductInfo;
import com.moon.product.mapper.TbProductInfoMapper;
import com.moon.product.service.ITbProductInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xjl
 * @since 2019-10-15
 */
@Service
public class TbProductInfoServiceImpl extends ServiceImpl<TbProductInfoMapper, TbProductInfo> implements ITbProductInfoService {

    @Autowired
    TbProductInfoMapper tbProductInfoMapper;

    @Override
    public void reduce(TbProductInfoDto productInfoDto) {

        TbProductInfo productInfo = tbProductInfoMapper.selectById(productInfoDto.getId());
        int total = productInfo.getNum();
        int buyOut = productInfoDto.getNum();
        productInfo.setNum(total-buyOut);
        tbProductInfoMapper.updateById(productInfo);

    }
}
