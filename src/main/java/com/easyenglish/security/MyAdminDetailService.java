package com.easyenglish.security;

import com.easyenglish.dto.Admin;
import com.easyenglish.dto.User;
import com.easyenglish.service.AdminService;
import com.easyenglish.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @Auther: Way Leung wayleung13@163.com
 * @Date: 9/21/2018 16:47
 * @Description:
 */
@Component
public class MyAdminDetailService implements UserDetailsService {
    @Autowired
    private AdminService adminService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminService.selectByUsername(username);

//        if(userFound!=null){
        org.springframework.security.core.userdetails.User user =  new org.springframework.security.core.userdetails.User(username,new MyPasswordEncoder().encode(admin.getPassword()), AuthorityUtils.commaSeparatedStringToAuthorityList(admin.getRole()));
        System.out.println(user);
        return user;
//        }else{
//            return null;
//        }

    }
}
