package com.example.arithmaticsapp.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "Operations")
@Getter
@Setter
@ToString(of = {"operationType", "result", "time"})
@NoArgsConstructor
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "operation_type")
    private OperationType operationType;
    @Column(name = "result")
    private Double result;
    @Column(name = "when_operated")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime time;
}
