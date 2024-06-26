package com.example.jasypt;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@EnableEncryptableProperties
public class JasyptConfig {

    @Value("${jasypt.encryptor.password}") // VM Option
    private String password;

    @Bean("jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();

        encryptor.setPassword(password);
        encryptor.setAlgorithm("PBEWithMD5AndDES");
        encryptor.setPoolSize(1);
        encryptor.setProvider(new BouncyCastleProvider());

        // 암호화 확인
        String value = "Hello, world!";
        String valueEnc = encryptor.encrypt(value);
        log.info("Result : '{}' -> '{}'", value, valueEnc);

        return encryptor;
    }
}
