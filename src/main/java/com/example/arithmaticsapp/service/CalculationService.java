package com.example.arithmaticsapp.service;

import com.example.arithmaticsapp.exceptions.ZeroDivisionException;
import com.example.arithmaticsapp.operationdto.MulAddDto;
import com.example.arithmaticsapp.operationdto.AddDto;
import com.example.arithmaticsapp.operationdto.DivideDto;
import com.example.arithmaticsapp.operationdto.MultiplyDto;
import com.example.arithmaticsapp.entity.Operation;
import com.example.arithmaticsapp.entity.OperationType;
import com.example.arithmaticsapp.repositories.OperationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CalculationService {

    private final OperationRepository repository;

    @Transactional
    public Operation addition(AddDto dto) {
        Operation operation = getOperation(OperationType.ADDITION);
        int sum = 0;
        List<Integer> nums = dto.getNums();
        for (Integer num : nums) {
            sum += num;
        }
        double result = sum * 1.0;
        operation.setResult(result);
        repository.save(operation);
        return operation;
    }

    private Operation getOperation(OperationType operationType) {
        Operation operation = new Operation();
        operation.setTime(LocalDateTime.now());
        operation.setOperationType(operationType);
        return operation;
    }

    @Transactional
    public Operation multiplication(MultiplyDto dto) {
        Operation operation = getOperation(OperationType.MULTIPLICATION);
        int sum = 1;
        List<Integer> nums = dto.getNums();
        for (Integer num : nums) {
            sum *= num;
        }
        double result = sum * 1.0;
        operation.setResult(result);
        repository.save(operation);
        return operation;
    }

    @Transactional
    public Operation multiplyAdd(MulAddDto dto) {
        Operation operation = getOperation(OperationType.MULTIPLY_ADD);
        double result = dto.getNum1() * dto.getNum2() + dto.getNum3() * 1.0;
        operation.setResult(result);
        repository.save(operation);
        return operation;
    }

    @Transactional
    public Operation division(DivideDto dto) {
        if (dto.getNum2() == 0) {
            throw new ZeroDivisionException("Zero division");
        }
        Operation operation = getOperation(OperationType.DIVISION);
        double result = dto.getNum1() * 1.0 / dto.getNum2();
        operation.setResult(result);
        repository.save(operation);
        return operation;
    }
}
