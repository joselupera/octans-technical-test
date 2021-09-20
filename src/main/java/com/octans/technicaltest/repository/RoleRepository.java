package com.octans.technicaltest.repository;

import com.octans.technicaltest.repository.dao.RoleData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleData, Integer> {
}
