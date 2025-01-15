package com.example.ToDo.controllers.api;

import com.example.ToDo.dto.TodoDto;
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

@Tag(name = "Todos API", description = "API for managing Todos")
public interface TodoApi {

    @Operation(summary = "Create Todo", description = "Creates a new Todo")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "The newly created Todo")
    })
    @PostMapping(value = APP_ROOT + "/todos/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<TodoDto> createTodo(
            @Parameter(description = "Todo DTO", required = true) @RequestBody TodoDto todoDto
    );

    @Operation(summary = "Update Todo", description = "Updates an existing Todo")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "The updated Todo")
    })
    @PatchMapping(value = APP_ROOT + "/todos/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<TodoDto> updateTodo(
            @Parameter(description = "Todo DTO", required = true) @RequestBody TodoDto todoDto
    );

    @Operation(summary = "Get all Todos", description = "Returns a list of all Todos")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of Todos")
    })
    @GetMapping(value = APP_ROOT + "/todos/all", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<TodoDto>> getAllTodos();

    @Operation(summary = "Get Todo by ID", description = "Returns the details of a specific Todo by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "The requested Todo"),
            @ApiResponse(responseCode = "404", description = "Todo not found")
    })
    @GetMapping(value = APP_ROOT + "/todos/{todoId:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<TodoDto> getTodo(
            @Parameter(description = "The Todo ID", required = true) @PathVariable("todoId") Long todoId
    );

    @Operation(summary = "Delete Todo", description = "Deletes a Todo by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "The Todo was deleted"),
            @ApiResponse(responseCode = "404", description = "Todo not found")
    })
    @DeleteMapping(value = APP_ROOT + "/todos/delete/{id:.+}")
    ResponseEntity<Void> deleteTodo(
            @Parameter(description = "The Todo ID", required = true) @PathVariable("id") Long id
    );
}
