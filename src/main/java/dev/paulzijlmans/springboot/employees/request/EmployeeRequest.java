package dev.paulzijlmans.springboot.employees.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EmployeeRequest(
        @NotBlank(message = "First name is mandatory") @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters") String firstName,
        @NotBlank(message = "Last name is mandatory") @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters") String lastName,
        @NotBlank(message = "Email is mandatory") @Email(message = "Please provide a valid email address") String email) {
}
