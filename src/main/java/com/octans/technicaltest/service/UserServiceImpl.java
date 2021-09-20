package com.octans.technicaltest.service;

import com.octans.technicaltest.controller.dto.UserDto;
import com.octans.technicaltest.repository.UserRepositoryAdapter;
import com.octans.technicaltest.repository.dao.UserData;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepositoryAdapter userRepositoryAdapter;

    @Autowired
    public UserServiceImpl(UserRepositoryAdapter userRepositoryAdapter) {
        this.userRepositoryAdapter = userRepositoryAdapter;
    }

    @Override
    public List<UserDto> getByName(String searchString) {
        return userRepositoryAdapter.getUsersByName(searchString).stream().map(userData ->
                        UserDto.builder()
                                .id(userData.getId())
                                .name(userData.getName())
                                .idRol(userData.getIdRol())
                                .isActive("S".equals(userData.getActive()))
                                .build())
                .collect(Collectors.toList());
    }

    @Override
    public UserDto create(UserDto userDto) {
        if (userRepositoryAdapter.existByName(userDto.getName())) {
            return UserDto.builder().errorMessage("El usuario ya existe").build();
        } else {
            UserData userDataR = new UserData(userDto.getIdRol(), userDto.getName(), userDto.isActive() ? "S" : "N");
            UserData userData = userRepositoryAdapter.saveUser(userDataR);
            return UserDto.builder()
                    .id(userData.getId())
                    .name(userData.getName())
                    .idRol(userData.getIdRol())
                    .isActive("S".equals(userData.getActive()))
                    .build();
        }
    }

    @Override
    public boolean delete(int id) {
        return !userRepositoryAdapter.deleteUser(id);
    }

    @Override
    public UserDto update(UserDto userDto, int id) {
        if (userRepositoryAdapter.existById(id)) {
            UserData userDataR = new UserData(id, userDto.getIdRol(), userDto.getName(), userDto.isActive() ? "S" : "N");
            UserData userData = userRepositoryAdapter.saveUser(userDataR);
            return UserDto.builder()
                    .id(userData.getId())
                    .name(userData.getName())
                    .idRol(userData.getIdRol())
                    .isActive("S".equals(userData.getActive()))
                    .build();
        } else {
            return UserDto.builder()
                    .errorMessage("El usuario no existe")
                    .build();
        }
    }
}
