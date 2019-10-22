package com.moon.ops.service.impl;

import com.moon.ops.entity.SysApiLog;
import com.moon.ops.mapper.SysApiLogMapper;
import com.moon.ops.service.ISysApiLogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 接口日志表 服务实现类
 * </p>
 *
 * @author xjl
 * @since 2019-10-14
 */
@Service
public class SysApiLogServiceImpl extends ServiceImpl<SysApiLogMapper, SysApiLog> implements ISysApiLogService {

}
