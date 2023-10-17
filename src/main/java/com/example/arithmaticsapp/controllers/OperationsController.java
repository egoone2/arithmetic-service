package com.example.arithmaticsapp.controllers;

import com.example.arithmaticsapp.dto.AddMulOperationDto;
import com.example.arithmaticsapp.dto.AddOperationDto;
import com.example.arithmaticsapp.dto.DivideOperationDto;
import com.example.arithmaticsapp.dto.MultiplyOperationDto;
import com.example.arithmaticsapp.entity.Operation;
import com.example.arithmaticsapp.entity.OperationType;
import com.example.arithmaticsapp.entity.ResultResponse;
import com.example.arithmaticsapp.service.CalculationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class OperationsController {

    private final CalculationService calculationService;

    @PostMapping("/add")
    public ResultResponse add(@RequestBody @Valid AddOperationDto dto) {
        Operation addition = calculationService.addition(dto);
        return new ResultResponse(addition.getResult(), OperationType.ADDITION);
    }

    @PostMapping("/multiply")
    public ResultResponse multiply(@RequestBody @Valid MultiplyOperationDto dto) {
        Operation multiplication = calculationService.multiplication(dto);
        return new ResultResponse(multiplication.getResult(), OperationType.MULTIPLICATION);
    }

    @PostMapping("/add-multiply")
    public ResultResponse addThenMultiply(@RequestBody @Valid AddMulOperationDto dto) {
        Operation addMultiply = calculationService.addMultiply(dto);
        return new ResultResponse(addMultiply.getResult(), OperationType.MULTIPLY_ADD);
    }

    @PostMapping("/divide")
    public ResultResponse divide(@RequestBody @Valid DivideOperationDto dto) {
        Operation division = calculationService.division(dto);
        return new ResultResponse(division.getResult(), OperationType.DIVISION);
    }



}
