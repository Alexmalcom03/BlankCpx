/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BlankCpx.cpx.controllers;

import com.BlankCpx.cpx.exceptions.ResourceNotFoundException;
import com.BlankCpx.cpx.models.Users;
import com.BlankCpx.cpx.repositories.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alexm
 */
@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    DashboardController dashboardController;

    @GetMapping("/users")
    public String viewUsers(Model model) {
        model.addAttribute("content", "users");
        model.addAttribute("isActiveDashboard", "false");
        model.addAttribute("isActiveUsers", "true");
        List<Users> users = userRepository.findAll();
        model.addAttribute("users", users);

        return "home";
    }

// Get a user by id
    @GetMapping("/{id}")
    public String getUserById(@PathVariable Long id, Model model) {
        Users user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        model.addAttribute("user", user);
        return "user_details"; // La vista se llama user_details.html
    }

// Create a new user
    @GetMapping("/new")
    public String showCreateUserForm(Model model) {
        model.addAttribute("user", new Users());
        return "user_form"; // La vista se llama user_form.html
    }

    @PostMapping("/new")
    public String createUser(@ModelAttribute("user") Users user, Model model) {
        Users savedUser = userRepository.save(user);
        return "redirect:/users/" + savedUser.getId();
    }

    // Update a user
    @GetMapping("/users/edit/{id}")
    public String showUpdateUserForm(@PathVariable Long id, Model model) {

        Users existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        model.addAttribute("user", existingUser);
        model.addAttribute("content", "user_form");
        model.addAttribute("isActiveDashboard", "false");
        model.addAttribute("isActiveUsers", "true");

        return "/home"; // La vista se llama user_form.html
    }

    @PostMapping("users/edit/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute("user") Users user, Model model) {
        Users existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

        existingUser.setName(user.getName());
        existingUser.setPaternalSurname(user.getPaternalSurname());
        existingUser.setMaternalSurname(user.getMaternalSurname());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setToken(user.getToken());
        existingUser.setPermissionUsers(user.getPermissionUsers());
        existingUser.setRol(user.getRol());

        userRepository.save(existingUser);
        List<Users> users = userRepository.findAll();
        model.addAttribute("users", users);

        model.addAttribute("content", "users");
        model.addAttribute("isActiveDashboard", "false");
        model.addAttribute("isActiveUsers", "true");

        return "home";
    }

// Delete a user
    @GetMapping("users/delete/{id}")
    public String deleteUser(@PathVariable Long id, Model model) {

        System.out.println("Si entraa");
        Users existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        userRepository.delete(existingUser);

        // Agregar atributos al modelo
        model.addAttribute("content", "users");
        model.addAttribute("isActiveDashboard", "false");
        model.addAttribute("isActiveUsers", "true");
        List<Users> users = userRepository.findAll();
        model.addAttribute("users", users);

        // Retornar la misma vista
        return "/home";
    }



}
