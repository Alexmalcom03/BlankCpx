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
@Table(name = "mainmenu_mainmenus")
public class MainMenu {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String icon;
    private Long menu_position;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mainmenu_status_id")
    private MainMenuStatuses mainMenuStatus;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "view_name_id")
    private MainMenuViewNames mainMenuViewName;
 
     @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mainmenu_id")
    private MainMenu mainmenu_id;

    @OneToMany(mappedBy = "mainmenu_id", cascade = CascadeType.ALL)
    private List<MainMenu> subMenus = new ArrayList<>();

    public MainMenu(String name, String description, String icon, Long menu_position, MainMenuStatuses mainMenuStatus, MainMenuViewNames mainMenuViewName, MainMenu mainmenu_id) {
        this.name = name;
        this.description = description;
        this.icon = icon;
        this.menu_position = menu_position;
        this.mainMenuStatus = mainMenuStatus;
        this.mainMenuViewName = mainMenuViewName;
        this.mainmenu_id = mainmenu_id;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Long getMenu_position() {
        return menu_position;
    }

    public void setMenu_position(Long menu_position) {
        this.menu_position = menu_position;
    }

    public MainMenuStatuses getMainMenuStatus() {
        return mainMenuStatus;
    }

    public void setMainMenuStatus(MainMenuStatuses mainMenuStatus) {
        this.mainMenuStatus = mainMenuStatus;
    }

    public MainMenuViewNames getMainMenuViewName() {
        return mainMenuViewName;
    }

    public void setMainMenuViewName(MainMenuViewNames mainMenuViewName) {
        this.mainMenuViewName = mainMenuViewName;
    }

    public MainMenu getMainmenu_id() {
        return mainmenu_id;
    }

    public void setMainmenu_id(MainMenu mainmenu_id) {
        this.mainmenu_id = mainmenu_id;
    }

    public List<MainMenu> getSubMenus() {
        return subMenus;
    }

    public void setSubMenus(List<MainMenu> subMenus) {
        this.subMenus = subMenus;
    }
    
}
