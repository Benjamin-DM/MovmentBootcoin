package com.bootcamp.movementbootcoinservice.service;


import com.bootcamp.movementbootcoinservice.model.MovementEntity;
import com.bootcamp.movementbootcoinservice.repository.MovementBootcoinRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;


@Slf4j
@RequiredArgsConstructor
@Service
public class MovementBootcoinService implements MoveementServiceRed {
    private final KafkaTemplate<String, MovementEntity> kafkaTemplate;
    private static final String TOPIC_NAME = "demo";
    private final MovementBootcoinRepository repository;


    @Override
    public Mono<MovementEntity> save(MovementEntity client) {
        return null;
    }

    @Override
    public Flux<MovementEntity> findAll() {
        return null;
    }

    @Override
    public Mono<MovementEntity> findById(String id) {
        return null;
    }

    @Override
    public Mono<MovementEntity> create(MovementEntity movement) {
        return repository.insert(movement)
                .map(this::sendToKafka);
    }

    @Override
    public Mono<MovementEntity> update(MovementEntity movement) {
        return repository.save(movement);
    }

    @Override
    public Mono<Void> delete(String id) {
        return null;
    }

    public MovementEntity sendToKafka(MovementEntity movement) {
        kafkaTemplate.send(TOPIC_NAME, movement.getNumTransactionPayment(), movement)
                .addCallback(result -> {
                    var resultNonNull = Objects.requireNonNull(result);
                    log.info("response: {}", resultNonNull.getProducerRecord());
                }, Throwable::printStackTrace);
        return movement;
    }
}
