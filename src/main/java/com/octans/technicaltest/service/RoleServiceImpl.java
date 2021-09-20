package com.octans.technicaltest.service;

import com.octans.technicaltest.controller.dto.RoleDTO;
import com.octans.technicaltest.repository.RoleRepositoryAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepositoryAdapter roleRepositoryAdapter;

    @Autowired
    public RoleServiceImpl(RoleRepositoryAdapter roleRepositoryAdapter) {
        this.roleRepositoryAdapter = roleRepositoryAdapter;
    }

    @Override
    public List<RoleDTO> getRoles() {
        return roleRepositoryAdapter.getRoles().stream()
                .map(roleData -> RoleDTO.builder().id(roleData.getId()).name(roleData.getName()).build())
                .collect(Collectors.toList());
    }
}
