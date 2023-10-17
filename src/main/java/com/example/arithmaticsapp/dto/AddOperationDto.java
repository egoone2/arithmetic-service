package com.example.arithmaticsapp.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AddOperationDto {
    @NotEmpty(message = "List should contain at least two numbers")
    private List<Integer> nums;

}
