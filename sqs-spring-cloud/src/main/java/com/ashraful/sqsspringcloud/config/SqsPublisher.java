/*
 * Md Ashraful Alam
 * 10/9/20, 1:50 AM
 */

package com.ashraful.sqsspringcloud.config;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SqsPublisher {
    private final QueueMessagingTemplate queueMessagingTemplate;

    public <T> void send(String queueName, T tClazz) {
        queueMessagingTemplate.convertAndSend(queueName, tClazz);
    }

}
