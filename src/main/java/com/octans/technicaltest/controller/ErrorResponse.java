package com.octans.technicaltest.controller;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class ErrorResponse {
    private String errorMessage;
}
