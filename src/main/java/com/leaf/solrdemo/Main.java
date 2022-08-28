package com.leaf.solrdemo;

import org.apache.tomcat.util.codec.binary.Base64;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

/**
 * @author YeYaqiao
 */
public class Main {
    public static void main(String[] args) {
        // 密码
        String password = "123456";

        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");

            final Random random = new SecureRandom();
            byte[] salt = new byte[32];
            random.nextBytes(salt);

            digest.reset();
            digest.update(salt);
            byte[] btPass = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            digest.reset();
            btPass = digest.digest(btPass);

            System.out.println(Base64.encodeBase64String(btPass) + " " + Base64.encodeBase64String(salt));
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Unknown algorithm: " + e.getMessage());
        }
    }

}
