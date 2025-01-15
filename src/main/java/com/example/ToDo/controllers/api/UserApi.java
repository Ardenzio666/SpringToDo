package com.example.ToDo.controllers.api;

import com.example.ToDo.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.ToDo.utils.Constants.APP_ROOT;

@Tag(name = "Users API", description = "API for managing users")
public interface UserApi {

    @Operation(summary = "Create user", description = "Creates a new user")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "The newly created user")
    })
    @PostMapping(value = APP_ROOT + "/users/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserDto> createUser(
            @Parameter(description = "User DTO", required = true) @RequestBody UserDto user
    );

    @Operation(summary = "Update user", description = "Updates an existing user")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "The updated user"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @PatchMapping(value = APP_ROOT + "/users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserDto> updateUser(
            @Parameter(description = "User ID", required = true) @PathVariable("id") Long id,
            @Parameter(description = "User DTO", required = true) @RequestBody UserDto user
    );

    @Operation(summary = "Get all users", description = "Returns a list of all users")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of users")
    })
    @GetMapping(value = APP_ROOT + "/users/all", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<UserDto>> getAllUsers();

    @Operation(summary = "Get user by ID", description = "Returns details of a user by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "The user"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @GetMapping(value = APP_ROOT + "/users/{id:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserDto> getUser(
            @Parameter(description = "User ID", required = true) @PathVariable("id") Long id
    );

    @Operation(summary = "Delete user", description = "Deletes a user by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "The user was deleted"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @DeleteMapping(value = APP_ROOT + "/users/delete/{id:.+}")
    ResponseEntity<Void> deleteUser(
            @Parameter(description = "User ID", required = true) @PathVariable("id") Long id
    );
}
