/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BlankCpx.cpx.controllers;

import com.BlankCpx.cpx.exceptions.ResourceNotFoundException;
import com.BlankCpx.cpx.models.PermissionFunctions;
import com.BlankCpx.cpx.repositories.PermissionFunctionsRepository;
import com.BlankCpx.cpx.services.PermissionFunctionsService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author alexm
 */
@Controller
public class PermissionsFunctionsController {

    
    @Autowired
    private PermissionFunctionsRepository permissionRepository;

    @GetMapping("/permissions")
    public String getAllPermissionFunctions(Model model) {
          model.addAttribute("content", "permissions");
        model.addAttribute("isActiveDashboard", "false");
        model.addAttribute("isActiveUsers", "false");
        model.addAttribute("isActiveRoles", "false");
        model.addAttribute("isActivePermissions", "true");
        List<PermissionFunctions> permissions = permissionRepository.findAll();
        model.addAttribute("permissions", permissions);
        return "home" ;
    }



 
}
