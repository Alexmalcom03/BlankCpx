/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BlankCpx.cpx.repositories;

import com.BlankCpx.cpx.models.Roles;
import com.BlankCpx.cpx.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author alexm
 */
public interface RoleRepository extends JpaRepository<Roles, Long> {
    
}
