package com.ashraf.rdbcwebflux.service;

import com.ashraf.rdbcwebflux.entity.ScheduleTime;
import com.ashraf.rdbcwebflux.repository.ScheduleTimeRepository;
import com.ashraf.rdbcwebflux.request.ScheduleTimeRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleTimeRepository scheduleTimeRepository;

    @Override
    public Flux<ScheduleTime> getAllSchedule() {

        return scheduleTimeRepository.findScheduleTimeByOrderByScheduledHour()
                .map(scheduleTime -> {
                    log.info("ScheduleServiceImpl:: getAllSchedule:: scheduleTime: {}", scheduleTime.toString());
                    return scheduleTime;
                });
    }

    @Override
    public Mono<ScheduleTime> updateSchedule(ScheduleTimeRequest scheduleTimeRequest) {
        return scheduleTimeRepository.findByScheduledHour(scheduleTimeRequest.getScheduledHour())
                .map(scheduleTime -> {
                    scheduleTime.setJobAvailable(scheduleTimeRequest.getJobAvailable());
                    log.info("ScheduleServiceImpl:: updateSchedule:: scheduleTime: {}", scheduleTime.toString());
                    return scheduleTime;
                })
                .flatMap(scheduleTimeRepository::save);
    }
}
