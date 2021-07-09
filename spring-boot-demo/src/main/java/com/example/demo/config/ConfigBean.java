package com.example.demo.config;

import com.example.demo.bean.DemoBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jiangchen
 * @date 2021/07/09
 */
@Configuration
public class ConfigBean {

    public ConfigBean() {
        System.out.println("ConfigBean 实例化");
    }

    @Bean
    public DemoBean demoBean() {
        return new DemoBean("dGhpcyBpcyBhIGV4YW1wbGU=");
    }
}
