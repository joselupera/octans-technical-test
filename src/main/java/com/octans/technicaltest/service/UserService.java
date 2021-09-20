package com.octans.technicaltest.service;

import com.octans.technicaltest.controller.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getByName(String name);

    UserDto create(UserDto searchString);

    boolean delete(int id);

    UserDto update(UserDto userDto, int id);
}
