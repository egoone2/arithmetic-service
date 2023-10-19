package com.example.arithmaticsapp.controllers;

import com.example.arithmaticsapp.entity.Operation;
import com.example.arithmaticsapp.entity.OperationType;
import com.example.arithmaticsapp.entity.response.ResultResponse;
import com.example.arithmaticsapp.operationdto.AddDto;
import com.example.arithmaticsapp.operationdto.DivideDto;
import com.example.arithmaticsapp.operationdto.MulAddDto;
import com.example.arithmaticsapp.operationdto.MultiplyDto;
import com.example.arithmaticsapp.service.CalculationService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Operations")
public class OperationsController {

    private final CalculationService calculationService;

    @PostMapping("/add")
    @io.swagger.v3.oas.annotations.Operation(summary = "Addition operation")
    public ResultResponse add(@RequestBody @Valid @Parameter(description = "Addition data") AddDto dto) {
        Operation addition = calculationService.addition(dto);
        log.info(addition.toString());
        return new ResultResponse(addition.getResult(), OperationType.ADDITION);
    }

    @PostMapping("/multiply")
    @io.swagger.v3.oas.annotations.Operation(summary = "Multiplication operation")
    public ResultResponse multiply(@RequestBody @Valid @Parameter(description = "Multiplication data") MultiplyDto dto) {
        Operation multiplication = calculationService.multiplication(dto);
        log.info(multiplication.toString());
        return new ResultResponse(multiplication.getResult(), OperationType.MULTIPLICATION);
    }

    @PostMapping("/multiply-add")
    @io.swagger.v3.oas.annotations.Operation(summary = "Multiply then add operation (3rd in list)")
    public ResultResponse multiplyThenAdd(@RequestBody @Valid @Parameter(description = "3rd operation data") MulAddDto dto) {
        Operation multiplyAdd = calculationService.multiplyAdd(dto);
        log.info(multiplyAdd.toString());
        return new ResultResponse(multiplyAdd.getResult(), OperationType.MULTIPLY_ADD);
    }

    @PostMapping("/divide")
    @io.swagger.v3.oas.annotations.Operation(summary = "Division operation")
    public ResultResponse divide(@RequestBody @Valid @Parameter(description = "Division data") DivideDto dto) {
        Operation division = calculationService.division(dto);
        log.info(division.toString());
        return new ResultResponse(division.getResult(), OperationType.DIVISION);
    }


}
