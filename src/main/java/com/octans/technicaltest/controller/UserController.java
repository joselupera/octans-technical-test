package com.octans.technicaltest.controller;

import com.octans.technicaltest.controller.dto.UserDto;
import com.octans.technicaltest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String healthCheck() {
        return "Status: Ok!";
    }

    @GetMapping(value = "users")
    public ResponseEntity getUsers(@RequestParam(value = "name") String searchString) {
        try {
            List<UserDto> users = userService.getByName(searchString);
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            ErrorResponse errorResponse = ErrorResponse.builder().errorMessage(e.getMessage()).build();
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "users")
    public ResponseEntity createUser(@RequestBody UserDto userDto) {
        try {
            UserDto user = userService.create(userDto);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            ErrorResponse errorResponse = ErrorResponse.builder().errorMessage(e.getMessage()).build();
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "users/{id}")
    public ResponseEntity updateUser(@PathVariable int id, @RequestBody UserDto userDto) {
        try {
            UserDto user = userService.update(userDto, id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            ErrorResponse errorResponse = ErrorResponse.builder().errorMessage(e.getMessage()).build();
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "users/{id}")
    public ResponseEntity deleteUser(@PathVariable int id) {
        try {
            boolean userDelete = userService.delete(id);
            return new ResponseEntity<>(userDelete, HttpStatus.OK);
        } catch (Exception e) {
            ErrorResponse errorResponse = ErrorResponse.builder().errorMessage(e.getMessage()).build();
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }
}
