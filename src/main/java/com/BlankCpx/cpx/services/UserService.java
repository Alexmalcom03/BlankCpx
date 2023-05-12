/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BlankCpx.cpx.services;

import com.BlankCpx.cpx.models.Users;
import com.BlankCpx.cpx.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author alexm
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public Users getUserByUsername(String username) {
        return userRepository.findByName(username);
    }

    public Users getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Users createUser(Users user) {
        // guardar el usuario en la base de datos
        return userRepository.save(user);
    }

}
