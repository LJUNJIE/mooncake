package com.moon.systemweb.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.moon.systemapi.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author xjl
 * @since 2019-09-25
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

}
