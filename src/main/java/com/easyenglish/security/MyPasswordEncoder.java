package com.easyenglish.security;

import com.easyenglish.utils.md5.MD5Util;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Auther: Way Leung wayleung13@163.com
 * @Date: 9/21/2018 10:54
 * @Description:
 */
public class MyPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence arg0) {
        return arg0.toString();
    }

    @Override
    public boolean matches(CharSequence arg0, String arg1) {
        boolean verify = MD5Util.verify(arg0.toString(), arg1);
        return  verify;
    }

}

