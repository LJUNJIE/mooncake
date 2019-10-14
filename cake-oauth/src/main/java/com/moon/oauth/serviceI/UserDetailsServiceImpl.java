package com.moon.oauth.serviceI;

import com.moon.oauth.feign.SystemService;
import com.moon.oauth.model.UserVoDetail;
import com.moon.systemapi.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author Pan Weilong
 * @date 2019/7/9 15:57
 * @description: 接口.
 */
@Component("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private SystemService systemService;
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        SysUser sysUser = systemService.getUserByName(name);

        return new UserVoDetail(Long.valueOf(sysUser.getId()),sysUser.getName(),sysUser.getPassword());
    }
}