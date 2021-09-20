package com.octans.technicaltest.repository;

import com.octans.technicaltest.repository.dao.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryAdapter {

    UserRepository userRepository;

    @Autowired
    public UserRepositoryAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserData> getUsersByName(String searchString) {
        return userRepository.findUserDataByNameContaining(searchString);
    }

    public UserData saveUser(UserData userData) {
        return userRepository.save(userData);
    }

    public boolean existByName(String name) {
        return userRepository.existsByNameEquals(name);
    }

    public boolean existById(int id) {
        return userRepository.existsById(id);
    }

    public boolean deleteUser(int id) {
        userRepository.deleteById(id);
        return userRepository.existsById(id);
    }
}
