/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BlankCpx.cpx.services;

import com.BlankCpx.cpx.models.Roles;
import com.BlankCpx.cpx.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alexm
 */
@Service
public class RoleServices {
    
    @Autowired
    private RoleRepository roleRepository;
    

}
