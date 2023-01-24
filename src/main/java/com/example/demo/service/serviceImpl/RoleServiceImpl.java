package com.example.demo.service.serviceImpl;

import com.example.demo.dao.RoleRepository;
import com.example.demo.entity.Role;
import com.example.demo.service.serviceInt.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

}
