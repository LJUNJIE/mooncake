package com.moon.systemweb.service.impl;

import com.moon.systemapi.entity.SysLogInfo;
import com.moon.systemweb.mapper.SysLogInfoMapper;
import com.moon.systemweb.service.ISysLogInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统日志表 服务实现类
 * </p>
 *
 * @author xjl
 * @since 2019-09-26
 */
@Service
public class SysLogInfoServiceImpl extends ServiceImpl<SysLogInfoMapper, SysLogInfo> implements ISysLogInfoService {

}
