package com.ashraf.rdbcwebflux.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScheduleTimeRequest {
    private String scheduledHour;
    private Boolean jobAvailable;
}
