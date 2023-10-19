package com.example.arithmaticsapp.operationdto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(description = "DTO for division operation")
public class DivideDto {

    @Schema(description = "First number, dividend")
    @NotNull(message = "Number can not be null")
    private Integer num1;
    @Schema(description = "Second number, divisor")
    @NotNull(message = "Number can not be null")
    private Integer num2;

}
