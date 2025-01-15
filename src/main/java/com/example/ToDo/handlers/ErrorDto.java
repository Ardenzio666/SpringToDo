package com.example.ToDo.handlers;

import com.example.ToDo.exceptions.ErrorCodes;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Represents the details of an error, including error code, message, and related input fields")
public class ErrorDto {

    @Schema(description = "The HTTP status code associated with the error", example = "400", required = true)
    private Integer httpCode;

    @Schema(description = "The specific error code for the application", required = true)
    private ErrorCodes code;

    @Schema(description = "A detailed error message", example = "Invalid input provided")
    private String message;

    @Schema(description = "The input fields related to the error, if any", example = "[\"field1\", \"field2\"]")
    private List<String> errors = new ArrayList<>();
}
