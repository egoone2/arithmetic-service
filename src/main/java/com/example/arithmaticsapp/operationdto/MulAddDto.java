package com.example.arithmaticsapp.operationdto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(description = "DTO for multiply then add operation")
public class MulAddDto {
    @Schema(description = "First number, multiplier")
    @NotNull(message = "Number can not be null")
    private Integer num1;
    @Schema(description = "Second number, multiplier")
    @NotNull(message = "Number can not be null")
    private Integer num2;
    @Schema(description = "First number, addendum")
    @NotNull(message = "Number can not be null")
    private Integer num3;

}
