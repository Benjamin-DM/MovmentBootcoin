package com.bootcamp.movementbootcoinservice.service;

import com.bootcamp.movementbootcoinservice.model.MovementEntity;
import com.hanqunfeng.reactive.redis.cache.aop.ReactiveRedisCacheEvict;
import com.hanqunfeng.reactive.redis.cache.aop.ReactiveRedisCachePut;
import com.hanqunfeng.reactive.redis.cache.aop.ReactiveRedisCacheable;
import com.hanqunfeng.reactive.redis.cache.aop.ReactiveRedisCaching;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MoveementServiceRed extends IMovementBootcoinService{

    static String CACHE_NAME = "movements";

    @ReactiveRedisCacheable(cacheName = CACHE_NAME, key = "'findAll'")
    Flux<MovementEntity> findAll();

    @ReactiveRedisCacheable(cacheName = CACHE_NAME, key = "'findOneById_' + #id")
    Mono<MovementEntity> findById(String id);

    @ReactiveRedisCacheEvict(cacheName = CACHE_NAME, allEntries = true)
    Mono<MovementEntity> create(MovementEntity movement);

    @ReactiveRedisCaching(
            evict = {@ReactiveRedisCacheEvict(cacheName = CACHE_NAME, key = "findAll"),},
            put = {
                    @ReactiveRedisCachePut(cacheName = CACHE_NAME, key = "'findOneById_' + #bootcoin.id"),
            }
    )
    Mono<MovementEntity> update(MovementEntity movement);

    @ReactiveRedisCacheEvict(cacheName = CACHE_NAME, key = "'findById_' + #id")
    Mono<Void> delete(String id);
}

