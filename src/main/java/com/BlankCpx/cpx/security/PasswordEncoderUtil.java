/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BlankCpx.cpx.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author alexm
 */
@Configuration
public class PasswordEncoderUtil {
    
    private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    
    
    public static String encodePassword(String password) {
        return encoder.encode(password);
    }
 
    public static boolean matches(String password, String encodedPassword) {
        return encoder.matches(password, encodedPassword);
    }

    
}
