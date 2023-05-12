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
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author alexm
 */
@Controller
public class DashboardController {



    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("content", "dashboard");
        model.addAttribute("isActiveDashboard", "true");
        model.addAttribute("isActiveUsers", "false");
        return "home";
    }


    
    

    

}
