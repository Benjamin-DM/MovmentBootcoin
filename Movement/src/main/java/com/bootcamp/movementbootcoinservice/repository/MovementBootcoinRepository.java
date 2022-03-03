package com.bootcamp.movementbootcoinservice.repository;

import com.bootcamp.movementbootcoinservice.model.MovementEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementBootcoinRepository extends ReactiveMongoRepository<MovementEntity, String> {

   // Mono<MovementBootcoin> findByPhoneNumber(String phoneNumber);

}