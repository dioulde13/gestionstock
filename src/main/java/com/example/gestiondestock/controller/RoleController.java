package com.example.gestiondestock.controller;

import com.example.gestiondestock.controller.api.RoleApi;
import com.example.gestiondestock.dto.RoleDto;
import com.example.gestiondestock.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RoleController implements RoleApi {
    private RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }

    @Override
    public RoleDto createRole(RoleDto dto) {
        return roleService.createRole(dto);
    }

    @Override
    public RoleDto findByIdRole(Integer id) {
        return roleService.findByIdRole(id);
    }

//    @Override
//    public Optional<RoleDto> updateRole(RoleDto dto, Integer id) {
//        return roleService.updateRole(dto, id);
//    }

    @Override
    public void deleteRole(Integer id) {
      roleService.deleteRole(id);
    }
}
