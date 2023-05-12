/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BlankCpx.cpx.controllers;

import com.BlankCpx.cpx.exceptions.ResourceNotFoundException;
import com.BlankCpx.cpx.models.Roles;
import com.BlankCpx.cpx.models.Users;
import com.BlankCpx.cpx.repositories.RoleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author alexm
 */
@Controller
public class RoleController {
    
    @Autowired
    private RoleRepository roleRepository;
    
        @GetMapping("/roles")
    public String viewRoles(Model model) {
        model.addAttribute("content", "roles");
        model.addAttribute("isActiveDashboard", "false");
        model.addAttribute("isActiveUsers", "false");
        model.addAttribute("isActiveRoles", "true");
        model.addAttribute("isActivePermissions", "false");
        List<Roles> roles = roleRepository.findAll();
        model.addAttribute("roles", roles);

        return "home";
    }
    
    
        @GetMapping("role/edit/{id}")
    public String showUpdatePermission(@PathVariable Long id, Model model) {

        Roles existingRole = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Permission not found with id: " + id));
        model.addAttribute("role", existingRole);
        model.addAttribute("content", "role_form");
       model.addAttribute("isActiveDashboard", "false");
        model.addAttribute("isActiveUsers", "false");
        model.addAttribute("isActiveRoles", "true");
        model.addAttribute("isActivePermissions", "false");

        return "/home"; 
    }
    
    
        @PostMapping("role/edit/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute("role") Roles role, Model model) {
        Roles existingRole = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

        existingRole.setName(role.getName());
        existingRole.setDescription(role.getDescription());


        roleRepository.save(existingRole);
        List<Roles> roles = roleRepository.findAll();
        model.addAttribute("roles", roles);

        model.addAttribute("content", "roles");
        model.addAttribute("isActiveDashboard", "false");
        model.addAttribute("isActiveUsers", "false");
        model.addAttribute("isActiveRoles", "true");
        model.addAttribute("isActivePermissions", "false");

        return "home";
    }
    
    
    // Delete a user
    @GetMapping("role/delete/{id}")
    public String deleteUser(@PathVariable Long id, Model model) {

        System.out.println("Si entraa");
        Roles existingRole = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        roleRepository.delete(existingRole);

        // Agregar atributos al modelo
      model.addAttribute("content", "roles");
        model.addAttribute("isActiveDashboard", "false");
        model.addAttribute("isActiveUsers", "false");
        model.addAttribute("isActiveRoles", "true");
        model.addAttribute("isActivePermissions", "false");
        List<Roles> roles = roleRepository.findAll();
        model.addAttribute("roles", roles);

        // Retornar la misma vista
        return "/home";
    }

    
}
