/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BlankCpx.cpx.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexm
 */
@Entity
@Table(name = "permission_module_types")
public class PermissionModuleTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    
     @OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
    private List<PermissionModules> modules = new ArrayList<>();

    public PermissionModuleTypes(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public PermissionModuleTypes() {
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PermissionModules> getModules() {
        return modules;
    }

    public void setModules(List<PermissionModules> modules) {
        this.modules = modules;
    }
    
    
    
    
}
