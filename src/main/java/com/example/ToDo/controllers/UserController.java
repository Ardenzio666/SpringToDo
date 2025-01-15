package com.example.ToDo.controllers;

import com.example.ToDo.controllers.api.UserApi;
import com.example.ToDo.dto.UserDto;
import com.example.ToDo.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController implements UserApi {

    @Autowired
    private UserService userService;

    @Override
    @Operation(summary = "Create User", description = "Creates a new user")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "The newly created user"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public ResponseEntity<UserDto> createUser(
            @Parameter(description = "User DTO", required = true) UserDto user) {
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @Override
    @Operation(summary = "Update User", description = "Updates an existing user")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "The updated user"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity<UserDto> updateUser(
            @Parameter(description = "User ID", required = true) Long id,
            @Parameter(description = "User DTO", required = true) UserDto user) {
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @Override
    @Operation(summary = "Get All Users", description = "Retrieves a list of all users")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of users")
    })
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @Override
    @Operation(summary = "Get User by ID", description = "Retrieves a user by their ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "The requested user"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity<UserDto> getUser(
            @Parameter(description = "User ID", required = true) Long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @Override
    @Operation(summary = "Delete User", description = "Deletes a user by their ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "User successfully deleted"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity<Void> deleteUser(
            @Parameter(description = "User ID", required = true) Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
