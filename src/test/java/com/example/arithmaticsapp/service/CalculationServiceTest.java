package com.example.arithmaticsapp.service;

import com.example.arithmaticsapp.operationdto.MulAddDto;
import com.example.arithmaticsapp.operationdto.AddDto;
import com.example.arithmaticsapp.operationdto.DivideDto;
import com.example.arithmaticsapp.operationdto.MultiplyDto;
import com.example.arithmaticsapp.entity.Operation;
import com.example.arithmaticsapp.entity.OperationType;
import com.example.arithmaticsapp.repositories.OperationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CalculationServiceTest {


    @InjectMocks
    private CalculationService calculationService;
    @Mock
    private OperationRepository operationRepository;


    @Test
    void addition() {
        AddDto dto = new AddDto();
        dto.setNums(List.of(1,2,3,4,5));
        double expected = 15.0;
        double actual = calculationService.addition(dto).getResult();
        assertEquals(expected, actual);
    }

    @Test
    void multiplication() {
        MultiplyDto dto = new MultiplyDto();
        dto.setNums(List.of(10,2,3));
        Operation operation = calculationService.multiplication(dto);
        double expected = 60.0;
        double actual = operation.getResult();
        assertEquals(expected, actual);
    }

    @Test
    void addMultiply() {
        MulAddDto dto = new MulAddDto();
        dto.setNum1(1);
        dto.setNum2(2);
        dto.setNum3(3);
        Operation operation = calculationService.multiplyAdd(dto);
        double expected = 5.0;
        double actual = operation.getResult();
        assertEquals(expected, actual);
    }

    @Test
    void division() {
        DivideDto dto = new DivideDto();
        dto.setNum1(10);
        dto.setNum2(2);
        Operation operation = calculationService.division(dto);
        double expected = 5.0;
        double actual = operation.getResult();
        assertEquals(expected, actual);
    }

}