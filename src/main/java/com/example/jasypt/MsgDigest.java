package com.example.jasypt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Slf4j
public class MsgDigest {

    public void myHash(String password){
        String encryptedPw;
        MessageDigest messageDigest;

        try {
            // MD2, MD4, MD5, SHA-1, SHA-256, SHA-512
            messageDigest = MessageDigest.getInstance("SHA-512");

            byte[] bytes = password.getBytes(Charset.forName("UTF-8")); // String to byte
            messageDigest.update(bytes);
            encryptedPw = Base64.getEncoder().encodeToString(messageDigest.digest()); // byte to String

            log.info("BEFORE : {}", password);
            log.info("AFTER :: {}", encryptedPw);

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}