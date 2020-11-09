package com.ashraf.rdbcwebflux.repository;

import com.ashraf.rdbcwebflux.entity.ScheduleTime;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ScheduleTimeRepository extends ReactiveCrudRepository<ScheduleTime,String> {
    Flux<ScheduleTime> findScheduleTimeByOrderByScheduledHour();
    Mono<ScheduleTime> findByScheduledHour(String scheduleHour);
}
