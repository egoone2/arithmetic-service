package com.example.arithmaticsapp.operationdto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Schema(description = "DTO for addition operation")
public class AddDto {

    @Schema(description = "List of terms")
    @NotEmpty(message = "List should contain at least two numbers")
    @Size(min = 2, message = "List should contain at least two numbers")
    private List<Integer> nums;

}
