package com.lewis.security.brower;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/9/19.
 */
@Component
public class MyUserDetailsService implements UserDetailsService {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名查找用户信息
        System.out.println("登陆用户名："+username);
        String encodePassword = passwordEncoder.encode("123456");
        System.out.println("数据库密码是："+encodePassword);
        return new User(username, encodePassword, true,true,true,true,AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
