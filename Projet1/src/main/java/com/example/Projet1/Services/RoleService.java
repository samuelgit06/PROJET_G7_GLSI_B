package com.example.Projet1.Services;

import com.example.Projet1.Models.Role;
import com.example.Projet1.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> showRoles(){
        return roleRepository.findAll();
    }

    public void saveRole(Role role){
        roleRepository.save(role);
    }

    public Role showOneRole(int id){
        return roleRepository.findById(id).get();
    }

    public void deleteRole(int id){
        roleRepository.deleteById(id);
    }
}

