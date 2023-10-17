package com.example.arithmaticsapp.repositories;

import com.example.arithmaticsapp.entity.Operation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepository extends CrudRepository<Operation, Long> {

}
