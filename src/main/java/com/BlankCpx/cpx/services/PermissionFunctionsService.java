/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BlankCpx.cpx.services;

import com.BlankCpx.cpx.models.PermissionFunctions;
import com.BlankCpx.cpx.repositories.PermissionFunctionsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alexm
 */
@Service
public class PermissionFunctionsService {
    
       @Autowired
    private PermissionFunctionsRepository permissionFunctionsRepository;

    public List<PermissionFunctions> getAllPermissionFunctions() {
        return permissionFunctionsRepository.findAll();
    }

    public Optional<PermissionFunctions> getPermissionFunctionById(Long id) {
        return permissionFunctionsRepository.findById(id);
    }

    public PermissionFunctions createPermissionFunction(PermissionFunctions permissionFunction) {
        return permissionFunctionsRepository.save(permissionFunction);
    }

    public void deletePermissionFunction(Long id) {
        permissionFunctionsRepository.deleteById(id);
    }
}
