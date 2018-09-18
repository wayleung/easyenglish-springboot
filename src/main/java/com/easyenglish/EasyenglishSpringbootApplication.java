package com.easyenglish;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication
//spring boot 会默认加载org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration这个类，而DataSourceAutoConfiguration类使用了@Configuration注解向spring注入了dataSource bean，又因为项目（eureka-server模块和短信模块）中并没有关于dataSource相关的配置信息，所以当spring创建dataSource bean时因缺少相关的信息就会报错。
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("com.easyenglish.dao")
public class EasyenglishSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyenglishSpringbootApplication.class, args);
    }
}
