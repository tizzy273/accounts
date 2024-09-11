package com.assignment.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * DTO for error.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDto {
    private String message;
}
