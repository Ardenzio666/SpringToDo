package com.example.ToDo.controllers.api;

import com.example.ToDo.dto.CategoryDto;
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

//localhost:8081/categories/create
//localhost:8081/categories/update
//localhost:8081/categories/all
//localhost:8081/categories/todos/{id:.+} getAllTodoByCategoriesId
//localhost:8081/categories/todos/today/{userId:.+} getAllTodoByCategoriesForToday
//localhost:8081/categories/users/{id} getAllCategoriesByUserId
//localhost:8081/categories/{id:.+}
//localhost:8081/categories/delete/{id:.+}

@Tag(name = "Categories API", description = "API for managing categories and related todos")
public interface CategoryApi {

    @Operation(summary = "Create category", description = "Creates a new category")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "The newly created category")
    })
    @PostMapping(value = APP_ROOT + "/categories/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CategoryDto> createCategory(
            @Parameter(description = "Category DTO", required = true) @RequestBody CategoryDto categoryDto
    );

    @Operation(summary = "Update category", description = "Updates an existing category")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "The updated category")
    })
    @PatchMapping(value = APP_ROOT + "/categories/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CategoryDto> updateCategory(
            @Parameter(description = "Category DTO", required = true) @RequestBody CategoryDto categoryDto
    );

    @Operation(summary = "Get all categories", description = "Returns a list of all categories")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of categories")
    })
    @GetMapping(value = APP_ROOT + "/categories/all", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<CategoryDto>> getAllCategories();

    @Operation(summary = "Get todos by category ID", description = "Returns a list of todos for the specified category ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of todos")
    })
    @GetMapping(value = APP_ROOT + "/categories/todos/{id:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<TodoDto>> getAllTodoByCategoriesId(
            @Parameter(description = "Category ID", required = true) @PathVariable("id") Long id
    );

    @Operation(summary = "Get today's todos by user ID", description = "Returns a list of today's todos for the specified user ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of today's todos")
    })
    @GetMapping(value = APP_ROOT + "/categories/todos/today/{userId:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<TodoDto>> getAllTodoByCategoriesForToday(
            @Parameter(description = "User ID", required = true) @PathVariable("userId") Long userId
    );

    @Operation(summary = "Get categories by user ID", description = "Returns a list of categories for the specified user ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of categories")
    })
    @GetMapping(value = APP_ROOT + "/categories/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<CategoryDto>> getAllCategoriesByUserId(
            @Parameter(description = "User ID", required = true) @PathVariable("id") Long id
    );

    @Operation(summary = "Get category details", description = "Returns details of the specified category")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "The category details"),
            @ApiResponse(responseCode = "404", description = "Category not found")
    })
    @GetMapping(value = APP_ROOT + "/categories/{id:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CategoryDto> getCategory(
            @Parameter(description = "The category ID", required = true) @PathVariable("id") Long id
    );

    @Operation(summary = "Delete category", description = "Deletes the specified category")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "The category was deleted"),
            @ApiResponse(responseCode = "404", description = "Category not found")
    })
    @DeleteMapping(value = APP_ROOT + "/categories/delete/{id:.+}")
    ResponseEntity<Void> deleteCategory(
            @Parameter(description = "The category ID", required = true) @PathVariable("id") Long id
    );
}
