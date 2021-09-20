package com.octans.technicaltest.repository;

import com.octans.technicaltest.repository.RoleRepository;
import com.octans.technicaltest.repository.dao.RoleData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleRepositoryAdapter {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleRepositoryAdapter(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<RoleData> getRoles() {
        return roleRepository.findAll();
    }
}
