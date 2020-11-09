/*
 * Md Ashraful Alam
 * 10/9/20, 1:45 AM
 */

package com.ashraful.sqsspringcloud.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SqsConsumer {
    @SqsListener("http://localhost:4566/000000000000/event-queue")
    public void processMessage(String message){
        log.info("Received message {}", message);
    }
    
}
