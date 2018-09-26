package com.easyenglish.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Auther: Way Leung wayleung13@163.com
 * @Date: 9/20/2018 17:08
 * @Description:
 */
@Configuration
//因为WebSecurityConfigurer只能一个 所以要有顺序 否则报错
@Order(1)
//@EnableWebSecurity
public class UserSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(myUserDetailsService).passwordEncoder(new MyPasswordEncoder());
//        不能new出来 会注入失败
        //auth.userDetailsService(new MyUserDetailsService()).passwordEncoder(new MyPasswordEncoder());
    }


    protected void configure(HttpSecurity http) throws Exception{
//        http.mvcMatcher("/admin/**").formLogin()//  定义当需要用户登录时候，转到的登录页面。
//                .loginPage("/admin/login.html")   //// 设置登录页面
//                .loginProcessingUrl("/admin/adminLogin")  // 自定义的登录接口
//                .and()
//
//                .authorizeRequests() // 定义哪些URL需要被保护、哪些不需要被保护
//                .antMatchers("/user/login.html","/user/authCode/**","/admin/login.html","/admin/authCode/**").permitAll()
//                .anyRequest()// 任何请求,登录后可以访问
//                .authenticated()
//                .and()
//                .csrf().disable();// 关闭csrf防护

        http.antMatcher("/user/**").formLogin()//  定义当需要用户登录时候，转到的登录页面。
                .loginPage("/user/login.html")   //// 设置登录页面
                .loginProcessingUrl("/user/userLogin")  // 自定义的登录接口
//                .defaultSuccessUrl("/user/userLogin")  // 自定义的登录接口
                .and()

                .authorizeRequests() // 定义哪些URL需要被保护、哪些不需要被保护
                .antMatchers("/user/login.html", "/user/authCode/**", "/admin/login.html", "/admin/authCode/**").permitAll()
                .anyRequest()// 任何请求,登录后可以访问
                .authenticated()
                // logout
                .and().logout().logoutUrl("/user/userLogout")
                .logoutSuccessUrl("/user/login.html").deleteCookies().and()
                .csrf().disable()// 关闭csrf防护

        ;


//                .mvcMatcher("/admin/**").formLogin()//  定义当需要用户登录时候，转到的登录页面。
//                .loginPage("/admin/login.html")   //// 设置登录页面
//                .loginProcessingUrl("/admin/adminLogin")  // 自定义的登录接口
//                .and()
//
//                .authorizeRequests() // 定义哪些URL需要被保护、哪些不需要被保护
//                .antMatchers("/user/login.html","/user/authCode/**","/admin/login.html","/admin/authCode/**").permitAll()
//                .anyRequest()// 任何请求,登录后可以访问
//                .authenticated()
//                .and()
//                .csrf().disable()// 关闭csrf防护
//                .mvcMatcher("/admin/**").formLogin()//  定义当需要用户登录时候，转到的登录页面。
//                .loginPage("/admin/login.html")   //// 设置登录页面
//                .loginProcessingUrl("/admin/userLogin")  // 自定义的登录接口
//                .and()
//                .authorizeRequests() // 定义哪些URL需要被保护、哪些不需要被保护
//                .antMatchers("/admin/login.html","/admin/authCode/**").permitAll()
//                .anyRequest()// 任何请求,登录后可以访问
//                .authenticated()
//                .and()
//                .csrf().disable()// 关闭csrf防护
                ;
    }










    @Override
    public void configure(WebSecurity web) throws Exception {
        //设置静态资源不要拦截
//        web.ignoring().antMatchers("/js/**","/css/**","/images/**");
        web.ignoring().antMatchers("/admin/assets/**","/user/css/**","/user/js/**","/user/fonts/**","/user/images/**","/user/header.html","/user/footer.html","/user/authCode","/admin/authCode");
    }
}
