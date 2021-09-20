package com.octans.technicaltest.repository;

import com.octans.technicaltest.repository.dao.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserData, Integer> {

    List<UserData> findUserDataByNameContaining(String searchString);

    boolean existsByNameEquals(String name);

}
