package com.octans.technicaltest.controller.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class UserDto {
    private int id;
    private String name;
    private int idRol;
    private boolean isActive;
    private String errorMessage;
}
