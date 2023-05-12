/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BlankCpx.cpx.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexm
 */
@Entity
@Table(name = "permission_modules")
public class PermissionModules {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id")
    private PermissionModules module;
    
    @OneToMany(mappedBy = "module", cascade = CascadeType.ALL)
    private List<PermissionModules> children = new ArrayList<>();
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "module_type_id")
    private PermissionModuleTypes type;
    
    @OneToMany(mappedBy = "permissionModule", cascade = CascadeType.ALL)
    private List<Permissions> permissions = new ArrayList<>();

    public PermissionModules(String name, PermissionModules module, PermissionModuleTypes type) {
        this.name = name;
        this.module = module;
        this.type = type;
    }

    public PermissionModules() {
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

    public PermissionModules getModule() {
        return module;
    }

    public void setModule(PermissionModules module) {
        this.module = module;
    }

    public List<PermissionModules> getChildren() {
        return children;
    }

    public void setChildren(List<PermissionModules> children) {
        this.children = children;
    }

    public PermissionModuleTypes getType() {
        return type;
    }

    public void setType(PermissionModuleTypes type) {
        this.type = type;
    }

    public List<Permissions> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permissions> permissions) {
        this.permissions = permissions;
    }



    
    
}
