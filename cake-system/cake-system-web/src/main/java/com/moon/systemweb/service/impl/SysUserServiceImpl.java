package com.moon.systemweb.service.impl;

import com.moon.systemapi.entity.SysUser;
import com.moon.systemweb.mapper.SysUserMapper;
import com.moon.systemweb.service.ISysUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author xjl
 * @since 2019-09-25
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

}
