package com.octans.technicaltest.controller.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class RoleDTO {
    private int id;
    private String name;
}
