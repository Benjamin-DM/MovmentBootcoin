package com.bootcamp.movementbootcoinservice.service;


import com.bootcamp.movementbootcoinservice.model.MovementEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IMovementBootcoinService {

     Flux<MovementEntity> findAll();

     Mono<MovementEntity> save(MovementEntity client);

     Mono<Void> delete(String id);

     Mono<MovementEntity> create(MovementEntity movement);

     Mono<MovementEntity> update(MovementEntity product);

     Mono<MovementEntity> findById(String id);

}
