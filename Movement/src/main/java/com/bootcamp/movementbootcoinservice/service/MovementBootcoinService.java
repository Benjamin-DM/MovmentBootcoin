package com.bootcamp.movementbootcoinservice.service;


import com.bootcamp.movementbootcoinservice.model.MovementEntity;
import com.bootcamp.movementbootcoinservice.repository.MovementBootcoinRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
@AllArgsConstructor
//@ConditionalOnProperty(name = "cache.enabled", havingValue = "false")
public class MovementBootcoinService implements IMovementBootcoinService {

    //Clorox
    @Autowired
    private MovementBootcoinRepository repository;


    @Override
    public Flux<MovementEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<MovementEntity> save(MovementEntity currency) {
        return  repository.save(currency);
    }

    @Override
    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }

    @Override
    public Mono<MovementEntity> update(String id, MovementEntity product) {
        return repository.findById(id).flatMap(newProduct -> {
            product.setId(newProduct.getId());
            product.setCreateDate(LocalDate.now());
            return repository.save(product);
        }).switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<MovementEntity> findById(String id) {
        return repository.findById(id);
    }

}
