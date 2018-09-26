package com.easyenglish.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Auther: Way Leung wayleung13@163.com
 * @Date: 9/21/2018 16:43
 * @Description:
 */
@Configuration
//@EnableWebSecurity
@Order(2)
public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyAdminDetailService myAdminDetailService;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(myAdminDetailService).passwordEncoder(new MyPasswordEncoder());
//        不能new出来 会注入失败
        //auth.userDetailsService(new MyUserDetailsService()).passwordEncoder(new MyPasswordEncoder());
    }


    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/admin/**").formLogin()//  定义当需要用户登录时候，转到的登录页面。
                .loginPage("/admin/login.html")   //// 设置登录页面
//                .loginProcessingUrl("/admin/adminLogin")  // 自定义的登录接口
                .defaultSuccessUrl("/admin/adminLogin")  // 自定义的登录接口
                .and()

                .authorizeRequests() // 定义哪些URL需要被保护、哪些不需要被保护
                .antMatchers("/user/login.html", "/user/authCode/**", "/admin/login.html", "/admin/authCode/**").permitAll()
                .anyRequest()// 任何请求,登录后可以访问
                .authenticated()
                // logout
                .and().logout().logoutUrl("/admin/adminLogout")
                .logoutSuccessUrl("/admin/login.html").deleteCookies().and()
                .csrf().disable()// 关闭csrf防护

        ;


    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //设置静态资源不要拦截
//        web.ignoring().antMatchers("/js/**","/css/**","/images/**");
        web.ignoring().antMatchers("/admin/assets/**","/user/css/**","/user/js/**","/user/fonts/**","/user/images/**","/user/header.html","/user/footer.html","/user/authCode","/admin/authCode");
    }

}
