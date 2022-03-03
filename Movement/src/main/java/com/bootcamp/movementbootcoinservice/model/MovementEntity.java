package com.bootcamp.movementbootcoinservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "MovementBootcoin")
@ToString
public class MovementEntity implements Serializable{
    @Id
    private String id;
    private String typeMovement;
    private Double amount;
    private String modePayment;
    private String numTransactionPayment;
    private String status;
    @CreatedDate
    private LocalDate createDate;
}
