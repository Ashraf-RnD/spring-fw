/*
 * Md Ashraful Alam
 * 10/9/20, 1:45 AM
 */

package com.ashraful.sqsspringcloud.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SqsConsumer {
    @SqsListener(value = "http://localhost:7576/queue/event-queue", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void processMessage(String message) {
        log.info("Received message {}", message);
    }
}
