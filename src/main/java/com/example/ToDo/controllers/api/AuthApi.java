package com.example.ToDo.controllers.api;

import com.example.ToDo.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.example.ToDo.utils.Constants.APP_ROOT;

//localhost:8081/auth/login POST login

@Tag(name = "Authentication API", description = "Handles user authentication operations")
public interface AuthApi {

    @Operation(
            summary = "Login user",
            description = "Authenticates a user and returns their details",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "The connected user",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = UserDto.class)
                            )
                    )
            }
    )
    @PostMapping(value = APP_ROOT + "/auth/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserDto> loginUser(
            @RequestBody UserDto user
    );
}
