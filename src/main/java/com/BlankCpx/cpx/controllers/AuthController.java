/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BlankCpx.cpx.controllers;

import com.BlankCpx.cpx.models.Users;
import com.BlankCpx.cpx.security.PasswordEncoderUtil;
import com.BlankCpx.cpx.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author alexm
 */
@Controller
public class AuthController {

    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam("email") String email,
            @RequestParam("password") String password,
            HttpSession session) {

        Users dbUser = userService.getUserByEmail(email);
        if (dbUser != null && passwordEncoder.matches(password, dbUser.getPassword())) {
            session.setAttribute("user", dbUser);
            return new ModelAndView(new RedirectView("/dashboard"));
        } else {
            return new ModelAndView(new RedirectView("/login"));
        }
    }

    @PostMapping("/register")
    public ModelAndView register(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("name") String name,
            @RequestParam("paternalSurname") String paternalSurname,
            @RequestParam("maternalSurname") String maternalSurname,
            HttpSession session) {

        Users user = new Users();
        user.setName(name);
        user.setPaternalSurname(paternalSurname);
        user.setMaternalSurname(maternalSurname);
        user.setEmail(email);
        user.setPassword(password);
        user.setToken("");

        Users dbUser = userService.getUserByEmail(email);

        if (dbUser == null) {
            userService.createUser(user);
            session.setAttribute("user", dbUser);
            return new ModelAndView(new RedirectView("/dashboard"));
        } else {
            return new ModelAndView("/register", "error", "Credenciales inválidas");
        }
    }

}
