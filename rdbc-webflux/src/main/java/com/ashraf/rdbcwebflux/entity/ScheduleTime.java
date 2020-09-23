package com.ashraf.rdbcwebflux.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("bkash_to_npsb_scheduled_time")
public class ScheduleTime {
    @Id
    @Column("scheduled_hour")
    private String scheduledHour;
    @Column("job_available")
    private Boolean jobAvailable;
}
