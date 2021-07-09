package com.example.demo.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author jiangchen
 * @date 2021/07/09
 */
@Component
public class PasswordDecodePostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof PostProcessorInterface) {
            String encodePassword = ((PostProcessorInterface) bean).getEncodeString();
            String password = decode(encodePassword);
            ((PostProcessorInterface) bean).setDecode(password);
            System.out.println("postProcessBeforeInitialization...");
        }
        return bean;
    }

    private String decode(String encodePassword) {
        return Arrays.toString(Base64Utils.decode(encodePassword.getBytes(StandardCharsets.UTF_8)));
    }

}
