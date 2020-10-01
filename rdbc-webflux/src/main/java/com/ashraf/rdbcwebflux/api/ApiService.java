/*
 * Md Ashraful Alam
 * 9/27/20, 4:08 PM
 */

package com.ashraf.rdbcwebflux.api;

import com.ashraf.rdbcwebflux.entity.ScheduleTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class ApiService {

    private final WebClient webClient;

    public Flux<ScheduleTime> getAllScheduleTime(){
        return webClient.get()
                .uri("/getAllSchedule")
                .retrieve()
                .bodyToFlux(ScheduleTime.class);
    }
}
