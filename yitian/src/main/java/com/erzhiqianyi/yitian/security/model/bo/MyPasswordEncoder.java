package com.erzhiqianyi.yitian.security.model.bo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

@Component
public class MyPasswordEncoder implements PasswordEncoder {

    @Value("${app.password.encoder.secret}")
    private String secret;

    @Value("${app.password.encoder.iteration}")
    private Integer iteration;

    @Value("${app.password.encoder.length}")
    private Integer keyLength;

    @Value("${app.password.encoder.algorithm}")
    private String  algorithm;

    @Override
    public String encode(CharSequence charSequence) {
        try {
            byte[] result = SecretKeyFactory.getInstance(algorithm)
                    .generateSecret(new PBEKeySpec(charSequence.toString().toCharArray(), secret.getBytes(), iteration, keyLength))
                    .getEncoded();
            return Base64.getEncoder().encodeToString(result);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return encode(charSequence).equals(s);
    }
}
