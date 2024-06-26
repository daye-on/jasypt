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

        encryptor.setProvider(new BouncyCastleProvider());
        encryptor.setPoolSize(2); // 암호화 요청의 pool 크기 (권장:2)
        encryptor.setPassword(password); // 암호화 키
        //encryptor.setAlgorithm("PBEWithMD5AndDES"); // 사용할 알고리즘
        encryptor.setAlgorithm("PBEWithSHA256And128BitAES-CBC-BC");

        String value = "Hello, world!";

        // 암호화
        String encValue = encryptor.encrypt(value);
        log.info("Encrypted -> ENC({})", encValue);

        // 복호화
        String decValue = encryptor.decrypt(encValue);
        log.info("Decrypted -> {}", decValue);

        return encryptor;
    }
}
