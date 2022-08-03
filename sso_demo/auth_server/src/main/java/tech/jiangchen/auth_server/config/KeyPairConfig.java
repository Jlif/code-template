package tech.jiangchen.auth_server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.rsa.crypto.KeyStoreKeyFactory;

import java.security.KeyPair;

@Configuration
public class KeyPairConfig {

    /**
     * keytool -importkeystore -srckeystore shy_debug.jks -destkeystore shy_debug.jks -deststoretype pkcs12
     */

    @Bean
    public KeyPair keyPair() throws Exception {
        ClassPathResource ksFile = new ClassPathResource("shy_debug.jks");//文件名
        KeyStoreKeyFactory ksFactory = new KeyStoreKeyFactory(ksFile, "jiangchen".toCharArray());  //第二个参数就是生成时候的密码
        return ksFactory.getKeyPair("shy_debug.jks");
    }
}
