package com.ashraf.rdbcwebflux.service;

import com.ashraf.rdbcwebflux.entity.ScheduleTime;
import com.ashraf.rdbcwebflux.request.ScheduleTimeRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ScheduleService {
    Flux<ScheduleTime> getAllSchedule();
    Mono<ScheduleTime> updateSchedule(ScheduleTimeRequest scheduleTimeRequest);
}
