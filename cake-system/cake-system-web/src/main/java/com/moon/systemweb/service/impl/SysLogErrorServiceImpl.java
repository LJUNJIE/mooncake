package com.moon.systemweb.service.impl;

import com.moon.systemapi.entity.SysLogError;
import com.moon.systemweb.mapper.SysLogErrorMapper;
import com.moon.systemweb.service.ISysLogErrorService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统错误日志表 服务实现类
 * </p>
 *
 * @author xjl
 * @since 2019-09-26
 */
@Service
public class SysLogErrorServiceImpl extends ServiceImpl<SysLogErrorMapper, SysLogError> implements ISysLogErrorService {

}
