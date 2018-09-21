package com.easyenglish.security;

import com.easyenglish.dto.User;
import com.easyenglish.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Auther: Way Leung wayleung13@163.com
 * @Date: 9/21/2018 10:22
 * @Description:
 */


@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userFound = userService.selectByUsername(username);

//        if(userFound!=null){
            org.springframework.security.core.userdetails.User user =  new org.springframework.security.core.userdetails.User(username,new MyPasswordEncoder().encode(userFound.getPassword()), AuthorityUtils.commaSeparatedStringToAuthorityList(userFound.getRole()));
            System.out.println(user);
            return user;
//        }else{
//            return null;
//        }

    }
}
