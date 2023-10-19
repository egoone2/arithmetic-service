package com.example.arithmaticsapp.entity.response;

import com.example.arithmaticsapp.entity.OperationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultResponse {

    private Double result;
    private OperationType operationType;

}
