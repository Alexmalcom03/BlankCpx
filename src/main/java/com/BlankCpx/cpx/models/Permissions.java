/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BlankCpx.cpx.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 *
 * @author alexm
 */
@Entity
@Table(name = "permission_permissions")
public class Permissions {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToMany(mappedBy = "permission")
    private List<PermissionUser> permissionUsers;
    
    @OneToMany(mappedBy = "permission")
    private List<PermissionRole> permissionRole;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "function_id")
    private PermissionFunctions permissionFunction;

     @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id")
    private PermissionModules permissionModule;

    public Permissions(List<PermissionUser> permissionUsers, List<PermissionRole> permissionRole, PermissionFunctions permissionFunction, PermissionModules permissionModule) {
        this.permissionUsers = permissionUsers;
        this.permissionRole = permissionRole;
        this.permissionFunction = permissionFunction;
        this.permissionModule = permissionModule;
    }

    public Permissions() {
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<PermissionUser> getPermissionUsers() {
        return permissionUsers;
    }

    public void setPermissionUsers(List<PermissionUser> permissionUsers) {
        this.permissionUsers = permissionUsers;
    }

    public List<PermissionRole> getPermissionRole() {
        return permissionRole;
    }

    public void setPermissionRole(List<PermissionRole> permissionRole) {
        this.permissionRole = permissionRole;
    }

    public PermissionFunctions getPermissionFunction() {
        return permissionFunction;
    }

    public void setPermissionFunction(PermissionFunctions permissionFunction) {
        this.permissionFunction = permissionFunction;
    }

    public PermissionModules getPermissionModule() {
        return permissionModule;
    }

    public void setPermissionModule(PermissionModules permissionModule) {
        this.permissionModule = permissionModule;
    }


    
    
    
}
