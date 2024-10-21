package com.example.gestiondestock.services;

import com.example.gestiondestock.dto.RoleDto;
import com.example.gestiondestock.model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    RoleDto createRole(RoleDto dto);
    List<Role> listAllRole();
    RoleDto findByIdRole(Integer id);
//    Optional<RoleDto> updateRole(RoleDto dto, Integer id);
    void deleteRole(Integer id);
}
