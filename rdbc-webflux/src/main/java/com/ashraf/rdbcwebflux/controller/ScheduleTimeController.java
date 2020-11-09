package com.ashraf.rdbcwebflux.controller;

import com.ashraf.rdbcwebflux.api.ApiService;
import com.ashraf.rdbcwebflux.entity.ScheduleTime;
import com.ashraf.rdbcwebflux.request.ScheduleTimeRequest;
import com.ashraf.rdbcwebflux.service.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class ScheduleTimeController {

    private final ScheduleService scheduleService;
    private final ApiService apiService;

    @GetMapping("/getAllSchedule")
    public Flux<ScheduleTime> getAllSchedule(){
        return apiService.getAllScheduleTime();
    }

    @PostMapping("/updateSchedule")
    public Mono<ScheduleTime> updateSchedule(@RequestBody ScheduleTimeRequest scheduleTimeRequest){
        return scheduleService.updateSchedule(scheduleTimeRequest);
    }



}
