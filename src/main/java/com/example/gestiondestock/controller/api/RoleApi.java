package com.example.gestiondestock.controller.api;

import com.example.gestiondestock.dto.RoleDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.example.gestiondestock.utils.Constants.APP_ROOT;

public interface RoleApi {
    @PostMapping(value = APP_ROOT + "/role/create", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    RoleDto createRole(@RequestBody RoleDto dto);

    @GetMapping(value = APP_ROOT + "/role/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    RoleDto findByIdRole(@PathVariable Integer id);

//    @PutMapping(value = APP_ROOT + "/role/update/{id}")
//    Optional<RoleDto> updateRole(@RequestBody RoleDto dto, @PathVariable Integer id);

    @DeleteMapping(value = APP_ROOT +"/role/delete/{id}")
    void deleteRole(@PathVariable Integer id);
}
