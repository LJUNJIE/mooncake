package com.moon.product.service;

import com.moon.product.dto.TbProductInfoDto;
import com.moon.product.entity.TbProductInfo;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xjl
 * @since 2019-10-15
 */
public interface ITbProductInfoService extends IService<TbProductInfo> {

    void reduce(TbProductInfoDto productInfoDto);
}
